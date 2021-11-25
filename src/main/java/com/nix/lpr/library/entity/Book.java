package com.nix.lpr.library.entity;

import java.time.LocalDateTime;
import javax.persistence.EntityListeners;
import javax.persistence.Version;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "book")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;
    @Column(name = "NAME", length = 40, nullable = false)
    private String name;
    @Column(name = "PUBLISH_YEAR", length = 4, nullable = false)
    private int publishYear;
    @ManyToOne
    @JoinColumn(name = "AUTHOR_ID")
    private Author author;
    @ManyToOne
    @JoinColumn(name = "GENRE_ID")
    private Genre genre;
    @Column(name = "CREATED_AT", nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime createdAt;
    @Column(name = "LAST_MODIFIED")
    @LastModifiedDate
    private LocalDateTime lastModified;
    @Column(name = "MODIFIED_BY")
    @LastModifiedBy
    private String modifiedBy;
    @Column(name = "VERSION")
    @Version
    private Integer version;
}
