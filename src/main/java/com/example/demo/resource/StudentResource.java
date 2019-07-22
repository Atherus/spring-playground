package com.example.demo.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.StudentEntity;
import com.example.demo.service.StudentService;

@RequestMapping(value = "/student")
@RestController
public class StudentResource {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<StudentEntity> findAll() {
        return studentService.findAllStudents();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public StudentEntity findOne(@PathVariable(value = "id") Long id) {
        return studentService.findOneStudent(id);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public StudentEntity save(@RequestBody @Valid StudentEntity studentEntity) {
        return studentService.saveEntity(studentEntity);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public StudentEntity update(@PathVariable(value = "id") Long id, @RequestBody @Valid StudentEntity studentEntity) {
        return studentService.updateEntity(id, studentEntity);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") Long id) {
        studentService.deleteEntity(id);
    }
}
