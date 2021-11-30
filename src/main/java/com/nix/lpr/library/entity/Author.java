package com.nix.lpr.library.entity;


import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import lombok.Data;

@Entity
@Table(name = "author")
@Data
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer authorId;
    @NotEmpty(message = "The last name field cannot be null or empty")
    @Column(name = "LAST_NAME", length = 30, nullable = false)
    private String lastName;
    @NotEmpty(message = "The first name field cannot be null or empty")
    @Column(name = "FIRST_NAME", length = 30, nullable = false)
    private String firstName;
    @Column(name = "NICK_NAME", length = 40, nullable = false, unique = true)
    private String nickName;
    @Past(message = "The birth date cannot be the current date")
    @Column(name = "BIRTH_DATE", nullable = false, columnDefinition = "DATE")
    private LocalDate birthDate;
}
