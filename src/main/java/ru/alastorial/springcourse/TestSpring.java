package ru.alastorial.springcourse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.alastorial.springcourse.Prac10.Junior;
import ru.alastorial.springcourse.Prac10.Middle;
import ru.alastorial.springcourse.Prac10.Programmer;
import ru.alastorial.springcourse.Prac10.Senior;

import java.util.Arrays;
import java.util.List;

public class TestSpring {
    public static void main(String[] args) {
        // закинули в контекст все бины из файла applicationContext.xml
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        System.out.println(args[0]);
        Programmer junior = context.getBean("junior", Junior.class);
        Programmer middle = context.getBean("middle", Middle.class);
        Programmer senior = context.getBean("senior", Senior.class);
        for (Programmer p : List.of(junior, middle, senior)) {
            p.doCoding();
        }

//        Music music = context.getBean("rockMusic", Music.class);
//        Music music2 = context.getBean("classicalMusic", Music.class);
//        MusicPlayer musicPlayer = new MusicPlayer(Arrays.asList(music, music2));

//        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
//        System.out.println(musicPlayer.getName());
//        System.out.println(musicPlayer.getVolume());
//
//        musicPlayer.playMusic(TypeOfMusic.ROCK);

        context.close();
    }


}

