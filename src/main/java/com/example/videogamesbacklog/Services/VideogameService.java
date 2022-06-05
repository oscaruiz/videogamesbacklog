package com.example.videogamesbacklog.Services;

import com.example.videogamesbacklog.Model.Videogame;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface VideogameService {
    Videogame create(Videogame videogame);
    Optional<Videogame> findById(Long id);
    boolean delete(Long id);
    Videogame update(Long id,Videogame videogame);
    List<Videogame> getAllVideogames();
}
