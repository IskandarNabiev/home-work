package com.sbrf.reboot.atm.team;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class TeamTest {


    class Player extends Players {
    }

    @Test
    void getCountPlayers() {
        Player firstPlayer = new Player();
        Player secondPlayer = new Player();

        Team<Player> team = new Team<>(new ArrayList<Player>() {{
            add(firstPlayer);
            add(secondPlayer);
        }});

        Assertions.assertEquals(2, team.getCountPlayers());
    }

}