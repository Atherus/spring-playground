package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Table(name = StudentEntity.TABLE_NAME)
@Entity
public class StudentEntity {

    public static final String TABLE_NAME = "STUDENT";

    private Long id;
    private String firstName;
    private String surname;
    private String description;
    // Default value for score
    private Double score = 3.0;
    private BookEntity book;

    @Column
    // Must be set identification for entity
    @Id
    // Default autoincrement ID, other possibility is to set sequence generator
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    @Column
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Min(0)
    @Max(5)
    @Column(length = 4000)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static String getTableName() {
        return TABLE_NAME;
    }

    @Column
    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @ManyToOne
    @JoinColumn(name = "BOOK_ID")
    public BookEntity getBook() {
        return book;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }
}
