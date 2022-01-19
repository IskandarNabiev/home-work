package com.sbrf.reboot.atm.cassettes;

import lombok.*;

import java.util.ArrayList;

@AllArgsConstructor
public class Cassette<Banknote> {

    private final ArrayList<Banknote> banknotes;

//    public Cassette(ArrayList<Banknote> banknotes) {
//        this.banknotes = banknotes;
//    }

    public int getCountBanknotes() {
        return banknotes.size();
    }
}
