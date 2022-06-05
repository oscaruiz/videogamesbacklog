package com.example.videogamesbacklog.Repository;

import com.example.videogamesbacklog.Model.Videogame;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideogameRepository extends JpaRepository<Videogame,Long> {
}
