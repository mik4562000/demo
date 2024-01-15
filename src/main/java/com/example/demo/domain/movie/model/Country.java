package com.example.demo.domain.movie.model;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "country", schema = "demo")
public class Country {
    @Id
    @Column(name="country_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int Id;
    @Column(name="country_name")
    private String Name;
}
