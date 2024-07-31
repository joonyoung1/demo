package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Member {
    
    @Id
    @GeneratedValue
    @Column(name = "member-id")
    private Long id;

    @Column(name = "member-name")
    private String name;
}
