package com.nix.lpr.library.entity;


import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "author")
@Data
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer authorId;
    @Column(name = "LAST_NAME", length = 30, nullable = false)
    private String lastName;
    @Column(name = "FIRST_NAME", length = 30, nullable = false)
    private String firstName;
    @Column(name = "NICK_NAME", length = 40)
    private String nickName;
    @Column(name = "BIRTH_DATE", nullable = false, columnDefinition = "DATE")
    private LocalDate birthDate;
}
