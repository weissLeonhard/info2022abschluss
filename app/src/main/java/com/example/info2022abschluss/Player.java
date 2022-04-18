package com.example.info2022abschluss;

public class Player {
    private String name1;
    private String winner;
    private String name2;

    //Konstruktor
    public Player(String nm1, String win, String nm2) {
        this.name1 = nm1;
        this.winner = win;
        this.name2 = nm2;
    }
    //GetterSetter

    public String getName1() {
        return name1;
    }

    public void setName1(String name) {
        this.name1 = name;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String Winner) {
        this.winner = winner;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }
    public String toString() {
        return name1 + " " + winner + " " + name2;
    }
}

