package com.example.demo.domain.genre.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.Set;

@Entity
@Getter
@Table(name = "genre", schema = "demo")
public class Genre {
    @Id
    @Column(name="genre_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int Id;
    @Column(name="genre_name")
    private String Name;
    @Column(name="genre_key")
    private String Key;

}
