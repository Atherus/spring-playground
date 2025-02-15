package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

    StudentEntity findOneById(Long id);
}
