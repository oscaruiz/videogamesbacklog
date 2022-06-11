package com.example.videogamesbacklog.Services;

import com.example.videogamesbacklog.Repository.VideogameRepository;
import com.example.videogamesbacklog.Model.Videogame;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VideogameServiceImpl implements VideogameService{

    private static final Logger logger = LogManager.getLogger(VideogameServiceImpl.class);
    private final VideogameRepository videogameRepository;

    public VideogameServiceImpl(VideogameRepository videogameRepository) {
        this.videogameRepository = videogameRepository;
    }

    @Override
    public Videogame create(Videogame videogame) {
        logger.info("Created videogame to the database: {}", videogame);
        return videogameRepository.save(videogame);
    }

    @Override
    public Optional<Videogame> findById(Long id) {
        logger.info("Find videogame with id: {}", id);
        return videogameRepository.findById(id);
    }

    @Override
    public boolean delete(Long id) {
        logger.info("Delete product with id: {}", id);
        videogameRepository.deleteById(id);
        return true;
    }

    @Override
    public Videogame update(Long id, Videogame videogameParam) {
        logger.info("Update videogame: {}", videogameParam);
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
        return null;
    }

    @Override
    public List<Videogame> getAllVideogames() {
        logger.info("Find all videogames");
        return videogameRepository.findAll();
    }
}
