package com.example.videogamesbacklog.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;



@Data
@Entity
@NoArgsConstructor
public class Videogame {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String platform;
    private String yearofrelease;

    public Videogame(String title, String platform, String yearofrelease){
        this.title=title;
        this.platform=platform;
        this.yearofrelease=yearofrelease;
    }
}