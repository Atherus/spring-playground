package com.example.demo.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.StudentEntity;
import com.example.demo.service.StudentService;

@RequestMapping(value = "/student")
@RestController
public class StudentResource {

    @Autowired
    private StudentService studentService;

    @PreAuthorize("hasRole('standard_user')")
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<StudentEntity> findAll() {
        return studentService.findAllStudents();
    }

    @PreAuthorize("hasRole('admin')")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public StudentEntity findOne(@PathVariable(value = "id") Long id) {
        return studentService.findOneStudent(id);
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public StudentEntity save(@RequestBody @Valid StudentEntity studentEntity) {
        return studentService.saveEntity(studentEntity);
    }

    @PutMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public StudentEntity update(@PathVariable(value = "id") Long id, @RequestBody @Valid StudentEntity studentEntity) {
        return studentService.updateEntity(id, studentEntity);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        studentService.deleteEntity(id);
    }
}
