package com.example.videogamesbacklog.Model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import static org.junit.jupiter.api.Assertions.*;

public class VideogameTest {

    Videogame videogame;

    @Before
    public void setUp(){
        videogame = new Videogame();
    }

    @Test
    public void getId() {
        Long idValue = 4L;
        videogame.setId(idValue);
        assertEquals(idValue,videogame.getId());
    }

}