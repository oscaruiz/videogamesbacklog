package com.example.videogamesbacklog.Repository;

import com.example.videogamesbacklog.Model.Videogame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
/**
 * Persistance layer
 */
public interface VideogameRepository extends JpaRepository<Videogame,Long> {
}
