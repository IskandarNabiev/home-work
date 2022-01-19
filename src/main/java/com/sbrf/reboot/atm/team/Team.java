package com.sbrf.reboot.atm.team;

import lombok.AllArgsConstructor;
import java.util.ArrayList;

@AllArgsConstructor
public class Team<Players> {

    private final ArrayList<Players> players;


    public int getCountPlayers() {
        return players.size();
    }
}
