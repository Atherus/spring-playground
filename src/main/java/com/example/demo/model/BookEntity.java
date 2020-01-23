package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "BOOK")
public class BookEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
}
