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
        return videogameRepository.save(videogame);
    }

    @Override
    public Optional<Videogame> findById(Long id) {
        return videogameRepository.findById(id);
    }

    @Override
    public boolean delete(Long id) {
        videogameRepository.deleteById(id);
        return true;
    }

    @Override
    public Videogame update(Long id, Videogame videogameParam) {
        Optional<Videogame> videogame = videogameRepository.findById(id);
        if(videogame.isPresent()){
            Videogame tmp = videogame.get();
            if (videogameParam.getPlatform() != null) {
                tmp.setPlatform(videogameParam.getPlatform());
            }
            if (videogameParam.getTitle() != null) {
                tmp.setTitle(videogameParam.getTitle());
            }

            if (videogameParam.getYearOfRelease() != null) {
                tmp.setYearOfRelease(videogameParam.getYearOfRelease());
            }

            return create(tmp);
        }
        return null; //TO-DO IMPROVE
    }

    @Override
    public List<Videogame> getAllVideogames() {
        List<Videogame> allVideogames = new ArrayList<>();
        Iterable<Videogame> videogames = videogameRepository.findAll();
        for (Videogame videogame : videogames) {
            allVideogames.add(videogame);
        }
        return allVideogames;
    }
}
