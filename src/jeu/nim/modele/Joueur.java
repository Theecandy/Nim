package jeu.nim.modele;

import java.util.ArrayList;

public class Joueur {

    private final String name;
    private ArrayList<Joueur> players = new ArrayList<>();

    public Joueur(String name /*TODO: Add highscore*/){
        this.name = name;
        players.add(this);
    }

    public ArrayList<Joueur> getPlayers() {
        return players;
    }

    public String getPlayerName() {
        return name;
    }
}
