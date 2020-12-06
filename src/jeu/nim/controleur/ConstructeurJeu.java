package jeu.nim.controleur;

import jeu.nim.modele.Coup;
import jeu.nim.modele.Joueur;
import jeu.nim.modele.Tas;
import jeu.nim.vue.Ihm;

public class ConstructeurJeu{

    private Ihm ihm;
    private Tas tas;
    private Coup coup;
    private Joueur player1;
    private Joueur player2;

    public Joueur getJoueur1() {
        return player1;
    }

    public void setJoueur1(Joueur player1) {
        this.player1 = player1;
    }

    public Joueur getJoueur2() {
        return player2;
    }

    public void setJoueur2(Joueur player2) {
        this.player2 = player2;
    }

    public Coup getCoup() {
        return coup;
    }

    public void setCoup(Coup coup) {
        this.coup = coup;
        this.coup.setIhm(ihm);
    }

    public ConstructeurJeu(Ihm ihm) {
        this.ihm = ihm;
        ihm.setConstructeurJeu(this);
    }

    public Ihm getIhm() {
        return ihm;
    }

    /**
     * construit le jeu
     */
    public void construireJeu(String toRestart) {

        if(toRestart == ""){
            construireJeu("tas");
        }
        //LES TAS
        if(toRestart == "tas") {
            try {
                ihm.send("Nombre de Tas?");
                int input = ihm.readInt();

                if (input == 0) {
                    ihm.send("Veuillez entrez un nombre valide (null)");
                    construireJeu("tas");
                }

                if (input <= 0) {
                    ihm.send("Veuillez entrer un nombre supérieur ou égale à 1");
                    construireJeu("tas");
                }

                tas = new Tas(input);
                construireJeu("allumettes");

            } catch (NumberFormatException e) {
                ihm.send("Veuillez entrez un nombre valide");
                construireJeu("tas");
            }
        }
        //MAX allumettes

        if(toRestart == "allumettes") {
            try {
                ihm.send("Nombre max d'allumettes?");

                //DEBUG: ihm.send(String.valueOf(tas.getTas())); To see if Tas is still saved after error.

                int input = ihm.readInt();

                if (input == 0) {
                    ihm.send("Veuillez entrez un nombre valide (null)");
                    construireJeu("allumettes");
                }

                if (input <= 0) {
                    ihm.send("Veuillez entrer un nombre égale ou supérieur à 0");
                    construireJeu("allumettes");
                }

                coup = new Coup(input);

                construireJeu("player");

            } catch (NumberFormatException e) {
                ihm.send("Veuillez entrez un nombre valide");
                construireJeu("allumettes");
            }
        }

        if(toRestart == "player"){

            ihm.send("Joueur 1?");
            String p1 = ihm.readInput();

            ihm.send("Joueur 2?");
            String p2 = ihm.readInput();

            player1 = new Joueur(p1);
            player2 = new Joueur(p2);

        }

    }

    public Tas getTas() {
        return tas;
    }
    private void setTas(Tas tas){
        this.tas = tas;
    }
}
