package com.marcin.utils;

import com.marcin.model.Player;

public class PlayerUtil {

    public Player[] createPlayers() {
        Player[] players = new Player[2];
        players[0] = new Player(1,null);
        players[1] = new Player(2,null);
        return players;
    }

    public String getPlayerNameByMark(String mark, Player[] players) {
        String winnerName = null;

        for(Player player: players) {
            if (player.getMark().equals(mark)){
                winnerName = player.getName();
            }
        }

        return winnerName;
    }

    public int getCurrentPlayerIndex(int turn) {
        if (turn == 1) {
            return 0;
        }

        if (turn % 2 == 0) {
            return 1;
        }

        return 0;
    }

}
