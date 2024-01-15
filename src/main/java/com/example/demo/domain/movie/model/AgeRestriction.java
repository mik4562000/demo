package com.example.demo.domain.movie.model;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "parents_guide", schema = "demo")
public class AgeRestriction {
    @Id
    @Column(name="pg_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int Id;
    @Column(name="pg_name")
    private String Name;
    @Column(name="pg_age")
    private int Age;
}
