package jeu.nim.vue;

import jeu.nim.controleur.ConstructeurJeu;
import jeu.nim.controleur.ControleurJeu;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Ihm {

    private ConstructeurJeu constructeur;
    private ControleurJeu controleurJeu;

    public ConstructeurJeu getConstructeur() {
        return constructeur;
    }

    public void send(String message){
        System.out.println(message);
    }

    public String readInput(){
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        Scanner scanner = new Scanner(inputStreamReader);

        return scanner.nextLine();
    }

    public int readInt(){
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        Scanner scanner = new Scanner(inputStreamReader);
        return scanner.nextInt();
    }



    public void setConstructeurJeu(ConstructeurJeu constructeurJeu) {
        this.constructeur = constructeurJeu;
    }
    public void setControleurJeu(ControleurJeu controleurJeu) {
        this.controleurJeu = controleurJeu;
    }


}
