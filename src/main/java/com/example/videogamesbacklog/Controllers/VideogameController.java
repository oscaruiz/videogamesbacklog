package com.example.videogamesbacklog.Controllers;

import com.example.videogamesbacklog.Model.Videogame;
import com.example.videogamesbacklog.Services.VideogameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class VideogameController {
    @Autowired
    private VideogameService videogameService;

    @PostMapping("videogame")
    public ResponseEntity<Videogame> createReport(@RequestBody Videogame videogame){
        return new ResponseEntity<>(this.videogameService.create(videogame), HttpStatus.CREATED);
    }

    @GetMapping("videogame/{id}")
    public ResponseEntity<Videogame> getReport(@PathVariable("id") Long id){
        Optional<Videogame> optionalVideogame = this.videogameService.findById(id);
        if(optionalVideogame.isPresent()){
            return new ResponseEntity<>(optionalVideogame.get(), HttpStatus.OK);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/videogame/{id}")
    public ResponseEntity<Void> deleteReport(@PathVariable("id") Long id){
        this.videogameService.delete(id);
        return ResponseEntity.noContent().build();
        //To Do
        // contemplate when the object is not there
    }

    @GetMapping("/videogame")
    public ResponseEntity<List<Videogame>> getReports(){
        List<Videogame> returnValue;
        returnValue = videogameService.getAllVideogames();
        return new ResponseEntity<>(returnValue,HttpStatus.OK);
    }
}