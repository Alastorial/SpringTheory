package ru.alastorial.springcourse;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

//@Component
public class RockMusic implements Music{
    List<String> songs = Arrays.asList("rockMusic1", "rockMusic2", "rockMusic3");

    @Override
    public List<String> getSong() {
        return songs;
    }
}
