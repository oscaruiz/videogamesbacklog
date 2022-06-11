package com.example.videogamesbacklog.Services;

import com.example.videogamesbacklog.Model.Videogame;

import java.util.List;
import java.util.Optional;


public interface VideogameService {
    /**
     * Creates the specified videogame to the database.
     * @param videogame
     * @return  The created videogame.
     */
    Videogame create(Videogame videogame);

    /**
     * Returns the videogame with the specified id.
     * @param id
     * @return  The requested videogame if found.
     */
    Optional<Videogame> findById(Long id);

    /**
     * Deletes the videogame with the specified id.
     * @param id
     */
    boolean delete(Long id);

    /**
     * Updates the specified videogame, identified with its id.
     * @param id
     * @param videogame
     * @return  The updated product if it was there.
     */
    Videogame update(Long id,Videogame videogame);

    /**
     * Returns all videogames in the database.
     *
     * @return  All videogames in the database.
     */
    List<Videogame> getAllVideogames();
}
