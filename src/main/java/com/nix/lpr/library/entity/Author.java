package com.nix.lpr.library.entity;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

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
