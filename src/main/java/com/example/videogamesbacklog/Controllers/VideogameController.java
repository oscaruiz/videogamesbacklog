package com.example.videogamesbacklog.Controllers;

import com.example.videogamesbacklog.Services.VideogameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class VideogameController {

    @Autowired
    private VideogameService videogameService;
}