package com.example.videogamesbacklog.Model;

import lombok.Data;
import javax.persistence.*;



@Data
@Entity
public class Videogame {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String platform;
    private String yearOfRelease;
}