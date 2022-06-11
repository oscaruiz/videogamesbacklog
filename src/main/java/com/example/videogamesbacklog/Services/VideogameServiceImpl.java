package com.example.videogamesbacklog.Services;

import com.example.videogamesbacklog.Repository.VideogameRepository;
import com.example.videogamesbacklog.Model.Videogame;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VideogameServiceImpl implements VideogameService{

    private final VideogameRepository videogameRepository;

    public VideogameServiceImpl(VideogameRepository videogameRepository) {
        this.videogameRepository = videogameRepository;
    }

    @Override
    public Videogame create(Videogame videogame) {
        return this.videogameRepository.save(videogame);
    }

    @Override
    public Optional<Videogame> findById(Long id) {
        return this.videogameRepository.findById(id);
    }

    @Override
    public boolean delete(Long id) {
        this.videogameRepository.deleteById(id);
        return true;
    }

    @Override
    public Videogame update(Long id, Videogame videogame) {
        return null;
    }

    @Override
    public List<Videogame> getAllVideogames() {
        List<Videogame> allVideogames = new ArrayList<>();
        Iterable<Videogame> videogames = this.videogameRepository.findAll();
        for (Videogame videogame : videogames) {
            allVideogames.add(videogame);
        }
        return allVideogames;
    }
}
