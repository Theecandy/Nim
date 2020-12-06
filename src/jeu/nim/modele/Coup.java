package jeu.nim.modele;

import jeu.nim.controleur.ControleurJeu;
import jeu.nim.vue.Ihm;

import java.util.ArrayList;

public class Coup {

    private final int max;
    private Ihm ihm;

    public Coup(int max){
        this.max = max;
    }

    public int getMax() {
        return max;
    }

    public void setIhm(Ihm ihm) {
        this.ihm = ihm;
    }

    private Tas getLesTas() {
        return ihm.getConstructeur().getTas();
    }

    public void subsAllumettes(int past, int newInt, Integer integer, int allumettes, ControleurJeu.State state) {

        ArrayList<Integer> lesTas = getLesTas().getTasArray();
        lesTas.set(past, newInt);
    }
}
