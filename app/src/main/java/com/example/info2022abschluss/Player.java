package com.example.info2022abschluss;

public class Player {
    private String name;
    private Integer gamesPlayed;
    private Integer gamesWon;

    //Konstruktor
    public Player(String nm, Integer gP, Integer gW) {
        this.name = nm;
        this.gamesPlayed = gP;
        this.gamesWon = gW;
    }
    //GetterSetter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(Integer gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public Integer getGamesWon() {
        return gamesWon;
    }

    public void setGamesWon(Integer gamesWon) {
        this.gamesWon = gamesWon;
    }
    public String toString() {
        return name + " " + gamesPlayed + " " + gamesWon;
    }
}

