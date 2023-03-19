package ru.alastorial.springcourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.w3c.dom.ls.LSOutput;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//@Component
public class MusicPlayer {
    private List<Music> musicList = new ArrayList<>();
    private Music music;
    private String name;
    private int volume;

    public MusicPlayer() {
    }

    // Ioc
//    @Autowired
//    public MusicPlayer(@Qualifier("rockMusic") Music music, @Qualifier("classicalMusic") Music music2) {
    public MusicPlayer(Music music, Music music2) {
        this.musicList = Arrays.asList(music, music2);
    }

    public MusicPlayer(List<Music> musicList) {
        this.musicList = musicList;
    }

    public void setMusicList(List<Music> musicList) {
        this.musicList = musicList;
    }


    public String getName() {
        return name;
    }

    @Value("${musicPlayer.name}")
    public void setName(String name) {
        this.name = name;
    }

    public int getVolume() {
        return volume;
    }
    @Value("${musicPlayer.volume}")
    public void setVolume(int volume) {
        this.volume = volume;
    }


    public void setMusic(Music music) {
        this.music = music;
    }

    public void playMusic(TypeOfMusic type) {
        if (type == TypeOfMusic.ROCK) {
            musicList.stream().filter(m -> m instanceof RockMusic).forEach(m1 -> System.out.println(m1.getSong().get((int) (Math.random() * 100 % 3))));
        } else if (type == TypeOfMusic.CLASSICAL) {
            musicList.stream().filter(m -> m instanceof ClassicalMusic).forEach(m1 -> System.out.println(m1.getSong().get((int) (Math.random() * 100 % 3))));
        }
//        for (Music m : musicList) {
//            if (type == TypeOfMusic.ROCK && m instanceof RockMusic) {
//                System.out.println(m.getSong().get((int) (Math.random() * 100 % 3)));
//            } else if (type == TypeOfMusic.CLASSICAL && m instanceof ClassicalMusic) {
//                System.out.println(m.getSong().get((int) (Math.random() * 100 % 3)));
//            }
//        }


//            System.out.println("PLaying: " + m.getSong());
//        }


//        for (Music m : musicList) {
//            System.out.println("PLaying: " + m.getSong());
//        }
//        if (music != null) {
//            System.out.println("PLaying: " + music.getSong());
//
//        }
    }

    @PostConstruct
    public void doInit() {
        System.out.println("Запуск плеера");
    }

    @PreDestroy
    public void doDestroy() {
        System.out.println("Остановка плеера");
    }

}
