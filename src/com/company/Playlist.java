package com.company;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Playlist {
    private String playlistName;
    private LinkedList<Song> songs;

    // Constructor

    public Playlist(String name) {
        this.playlistName = name;
        this.songs = new LinkedList<Song>();
    }

    // Getters

    public String getPlaylistName() {
        return playlistName;
    }
    public LinkedList<Song> getSongs() {
        return songs;
    }

    // Methods
    public static void startPlaylist(Playlist playlist) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Song> songs = playlist.getSongs();
        ListIterator<Song> listIterator = songs.listIterator();
        boolean quit = false;
        boolean goingForward = true;
        String playlistMenu = "Playlist Menu\n" +
                              "press \n" +
                              "0 - quit playlist and return to main menu\n" +
                              "1 - next song\n" +
                              "2 - previous song\n" +
                              "3 - replay track";

        if (songs.getFirst().getName().isEmpty()) {
            System.out.println("No songs in selected playlist...");
        } else {
            Song track = listIterator.next();
            System.out.println("Now Playing --- " + track.getName() + " ---> " + track.getDuration());
        }

        while(!quit) {
            System.out.println(playlistMenu);
            int action = scanner.nextInt();
            switch(action) {
                case 0:
                    System.out.println("Exiting playlist - returning to main menu...");
                    quit = true;
                    break;
                case 1:
                    if (!goingForward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if (listIterator.hasNext()) {
                        Song track = listIterator.next();
                        System.out.println("Now Playing --- " + track.getName() + " ---> " + track.getDuration());
                    } else {
                        System.out.println("End of Playlist");
                        goingForward = false;
                    }
                    break;
                case 2:
                    if (goingForward) {
                        if (listIterator.hasPrevious()) {
                           listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        Song track = listIterator.previous();
                        System.out.println("Now Playing --- " + track.getName() + " ---> " + track.getDuration());
                    } else {
                        System.out.println("Already at beginning of playlist");
                        goingForward = true;
                    }
                    break;
                case 3:
                    if (goingForward) {
                        if (listIterator.hasPrevious()) {
                            Song track = listIterator.previous();
                            System.out.println("Now replaying " + track.getName() + " ---> " + track.getDuration());
                            goingForward = false;
                        } else {
                            System.out.println("Already at beginning of playlist");
                        }
                    } else {
                        if (listIterator.hasNext()) {
                            Song track = listIterator.next();
                            System.out.println("Now replaying " + track.getName() + " ---> " + track.getDuration());
                            goingForward = true;
                        } else {
                            System.out.println("End of Playlist - no more tracks...");
                        }
                    }
                    break;
                default:
                    quit = true;
                    break;
            }
        }

    }
    public void addSongToPlaylist(Song song) {
            if (findSong(song) >= 0) {
                System.out.println("Song is already in playlist...");
            } else {
                songs.add(song);
            }
    }
    public int findSong(Song song) {
        return songs.indexOf(song);
    }
    public static void printSongsInPlaylist(Playlist playlist) {
        ListIterator<Song> songListIterator = playlist.getSongs().listIterator();
        System.out.println("**** " + playlist.getPlaylistName() + " Track List ****");
        int trackNum = 0;
        if (playlist.getSongs().getFirst().getName().isEmpty()) {
            System.out.println(playlist.getPlaylistName() + " has no tracks...");
        } else {
            while(songListIterator.hasNext()) {
                Song track = songListIterator.next();
                System.out.println((trackNum + 1) + ". " + track.getName() + " --- " + track.getDuration());
                trackNum++;
            }
        }

    }
}
