package com.example.videogamesbacklog.Repository;

import com.example.videogamesbacklog.Model.Videogame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface VideogameRepository extends JpaRepository<Videogame,Long> {
}
