package ru.alastorial.springcourse;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//@Component
public class ClassicalMusic implements Music {

    List<String> songs = Arrays.asList("classicalMusic1", "classicalMusic2", "classicalMusic3");

    @Override
    public List<String> getSong() {
        return songs;
    }
}
