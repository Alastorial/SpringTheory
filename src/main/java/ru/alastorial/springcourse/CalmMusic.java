package ru.alastorial.springcourse;

public class CalmMusic{

    private CalmMusic () {}

    public static CalmMusic factoryMethod() {
        return new CalmMusic();
    }

    public String getSong() {
        return "Calm music";
    }
}
