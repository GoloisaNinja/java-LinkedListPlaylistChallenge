package com.company;

public class Song {
    private String name;
    private String duration;

    // Constructor
    public Song(String name, String duration) {
        this.name = name;
        this.duration = duration;
    }

    // Getters

    public String getName() {
        return this.name;
    }
    public String getDuration() {
        return this.duration;
    }

    // Method

    public static Song createSong(String name, String duration) {
        Song newSong = new Song(name, duration);
        return newSong;
    }
}
