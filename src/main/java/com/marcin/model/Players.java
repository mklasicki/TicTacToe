package com.marcin.model;

import java.util.HashMap;

public class Players {

    private HashMap<Integer, Player> players;

    public Players() {
        players = new HashMap<>();
    }




    public void generatePlayers() {



    }


    private String getActivePlayerMark(int turn) {
        if (!players.isEmpty()) {

            if (turn == 1) {
                return players.get(1).getMark();
            }

            if (turn % 2 == 0) {
                return players.get(2).getMark();
            }

            return players.get(1).getMark();
        } else {

            throw new IllegalStateException("No active players found");
        }
    }
}
