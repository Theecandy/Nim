package jeu.nim;

import jeu.nim.controleur.ConstructeurJeu;
import jeu.nim.controleur.ControleurJeu;

import jeu.nim.modele.Tas;
import jeu.nim.vue.Ihm;

public class Main {

    public static void main(String[] args) {
        Ihm ihm = new Ihm();
        ConstructeurJeu constructeurJeu = new ConstructeurJeu(ihm);
        constructeurJeu.construireJeu("");
        Tas lesTas = constructeurJeu.getTas();
        ControleurJeu controleurJeu = new ControleurJeu(constructeurJeu.getIhm(),lesTas);
        controleurJeu.commencerJeu();
    }

}
