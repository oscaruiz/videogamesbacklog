package com.example.videogamesbacklog.Controllers;

import com.example.videogamesbacklog.Model.Videogame;
import com.example.videogamesbacklog.Services.VideogameService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class VideogameController {

    private final VideogameService videogameService;
    private static final Logger logger = LogManager.getLogger(VideogameController.class);

    public VideogameController(VideogameService videogameService){
        this.videogameService = videogameService;
    }

    /**
     * Creates a new videogame
     * @param videogame the videogame to create.
     * @return  the created videogame.
     */
    @PostMapping("/videogame")
    public ResponseEntity<Videogame> createVideogame(@RequestBody Videogame videogame){
        logger.info("Creating new videogame with title: {}, platform: {}", videogame.getTitle(), videogame.getPlatform());
        return new ResponseEntity<>(this.videogameService.create(videogame), HttpStatus.CREATED);
    }

    /**
     * Returns a videogame with an specified ID
     * @param id
     * @return   200 OK if succesfully found.
     *           404 Not Found if videogame ID is not in the DB.
     */
    @GetMapping("/videogame/{id}")
    public ResponseEntity<Videogame> getVideogame(@PathVariable("id") Long id){
        try{
            Optional<Videogame> optionalVideogame = this.videogameService.findById(id);
            if(optionalVideogame.isPresent()){
                logger.info("Found the videogame with ID {}", id);
                return new ResponseEntity<>(optionalVideogame.get(), HttpStatus.OK);
            }else{
                logger.info("Not found the videogame with ID {}", id);
                return ResponseEntity.notFound().build();
            }
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Deletes the videogame with the specified IF
     * @param id    The if of the videogame to delete.
     * @return  A responseEntity with one of the following status codes:
     *             200 OK if succesful
     *             404 Not Found if videogame ID is not in the DB
     *             500 Internal Error if an error occurs during deletion
     */
    @DeleteMapping("/videogame/{id}")
    public ResponseEntity<?> deleteVideogame(@PathVariable("id") Long id){

        logger.info("Deleting videogame with ID {}", id);

        // Get the existing videogame
        Optional<Videogame> existingVideogame = videogameService.findById(id);

        return existingVideogame.map(v -> {
            if (videogameService.delete(v.getId())) {
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Updates the specified videogame
     * @param id
     * @param videogame
     * @return  The updated videogame if found
     *          404 Not found, if the videogame was not found
     */
    @PutMapping("/videogame/{id}")
    public ResponseEntity<Videogame> updateVideogames(@PathVariable("id") Long id, @RequestBody Videogame videogame){
        Videogame videogameUpdated = videogameService.update(id,videogame);
        if(videogameUpdated == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(videogameUpdated, HttpStatus.OK);
    }

    /**
     * Return all videogames in the database.
     *
     * @return All videogames in the database.
     */
    @GetMapping("/videogame")
    public ResponseEntity<List<Videogame>> getallVideogames(){
        List<Videogame> returnValue;
        returnValue = videogameService.getAllVideogames();
        return new ResponseEntity<>(returnValue,HttpStatus.OK);
    }
}