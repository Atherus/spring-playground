package com.example.demo.service;

import java.util.List;

import javax.validation.ValidationException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.StudentEntity;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<StudentEntity> findAllStudents() {
        return studentRepository.findAll();
    }

    public StudentEntity findOneStudent(Long id) {
        // custom findOne to get entity only by its identification, default from JPA needs entire object
        StudentEntity existingStudentEntity = studentRepository.findOneById(id);
        // throw exception if entity is not found (e.g. we send invalid id)
        if (existingStudentEntity == null) {
            throw new ValidationException("Student entity not found");
        }
        return existingStudentEntity;
    }

    public StudentEntity saveEntity(StudentEntity studentEntity) {
        return studentRepository.save(studentEntity);
    }

    public StudentEntity updateEntity(Long id, StudentEntity studentEntity) {
        StudentEntity existingStudentEntity = findOneStudent(id);
        // copy updated values from request to DB entity and then save it with these new values
        // parameters 3rd and more serves as ignoring parameters, we do not want to nullify identification of object -> id=null -> throw exception
        BeanUtils.copyProperties(studentEntity, existingStudentEntity, "id");
        return studentRepository.save(existingStudentEntity);
    }

    public void deleteEntity(Long id) {
        // we do not need return confirmation on delete, or check if object exists by default
        // if needed, then first findOne as in updateEntity and check if is not null, then delete
        // as confirmation you can again call findOne and return true if response is null or false if object still exists
        studentRepository.deleteById(id);
    }
}
