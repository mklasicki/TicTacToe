package com.marcin.model;

public class Player {

    private int id;
    private String name;
    private String mark;

    public Player(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getMark() {
        return mark;
    }

    public static String getPlayerNameByMark(String mark, Player[] players) {
        String winnerName = null;

        for(Player player: players) {
            if (player.getMark().equals(mark)){
                winnerName = player.getName();
            }
        }

        return winnerName;
    }
}