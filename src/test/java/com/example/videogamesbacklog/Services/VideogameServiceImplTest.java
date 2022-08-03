package com.example.videogamesbacklog.Services;

import com.example.videogamesbacklog.Model.Videogame;
import com.example.videogamesbacklog.Repository.VideogameRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class VideogameServiceImplTest {
    VideogameServiceImpl videogameService;
    @Mock
    VideogameRepository videogameRepository;

    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
        videogameService = new VideogameServiceImpl(videogameRepository);
    }

    @Test
    public void getAllVideogames() throws Exception {
        Videogame videogame = new Videogame();

        List<Videogame> videogames = videogameService.getAllVideogames();
        assertEquals(videogames.size(),0);
    }
}