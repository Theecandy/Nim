package jeu.nim.controleur;

import jeu.nim.modele.Tas;
import jeu.nim.vue.Ihm;

public class ControleurJeu {

    private final Tas lesTas;
    private final Ihm ihm;

    public ControleurJeu(Ihm ihm, Tas lesTas) {
        this.ihm = ihm;
        this.lesTas = lesTas;
        ihm.setControleurJeu(this);

    }

    public Ihm getIhm() {
        return ihm;
    }

    public Tas getLesTas() {
        return lesTas;
    }

    public void commencerJeu() {
        playTurn(1,State.PRINT);
    }


    private void playTurn(int player,State state){
        if(state == State.PRINT) affichage();

        if(player == 1) ihm.send("C'est a votre tour de jouer un coup : "+getIhm().getConstructeur().getJoueur1().getPlayerName());
        if(player == 2) ihm.send("C'est a votre tour de jouer un coup : "+getIhm().getConstructeur().getJoueur2().getPlayerName());
        String input = getIhm().readInput();
        String[] inputArray = input.split(" ");
        try{
            int integer = Integer.valueOf(inputArray[0]); //0 = Tas

            Integer allumettes = Integer.valueOf(inputArray[1]);

            if(integer > lesTas.getTasArray().size() || integer < getLesTas().getTasArray().size()){
                getIhm().send("Tas n'éxiste pas! ("+getLesTas().getTasArray().size()+")");
                playTurn(player,State.NON_EXIST);
                return;
            }
            if(allumettes > getIhm().getConstructeur().getCoup().getMax() && getIhm().getConstructeur().getCoup().getMax() != 0){
                ihm.send("Vous pouvez seulement retirer "+getIhm().getConstructeur().getCoup().getMax());
                playTurn(player,State.MAX);
                return;

            }

            if(getLesTas().getTasArray().get(integer) == 0){
                ihm.send("Tas vide!");
                playTurn(player, State.VIDE);
                return;
            }

            if(allumettes > getLesTas().getTasArray().get(integer)){
                getIhm().send("Vous pouvez seulement retirer "+lesTas.getTasArray().get(integer) + " allumettes" + " du tas " +integer);
                playTurn(player,State.NOT_ALLOWED);
                return;
            }

            int past=getLesTas().getTasArray().get(integer);
            int newInt = past-allumettes;

            ihm.getConstructeur().getCoup().subsAllumettes(past,newInt,integer,allumettes,State.PRINT);


        }catch (NumberFormatException e){

        }
        catch ( ArrayIndexOutOfBoundsException boundsException){
            ihm.send("Tas vide, veuillez réessayer avec un autre.");
        }

        playTurn(player,State.PRINT);

    }
    private void gagner(){

    }

    private String getSpaces(int space){
        String spaces = "";
        while (space > 0){
            spaces = " " + spaces;
            space--;
        }
        return spaces;
    }

    private void affichage(){
        int toSub = 1;
        for(Integer integer : getLesTas().getTasArray()){

            String tasAffichage = "";

            int difference = getLesTas().getDifference();

            difference = difference - toSub+1;

            int in = 0;
            String spaces = getSpaces(difference);
            toSub++;
            while (in < getLesTas().getTasArray().get(integer)){

                tasAffichage = spaces + tasAffichage + "|";
                in++;
                //getIhm().send("L"+spaces+"L");
                spaces = "";
            }


            getIhm().send(tasAffichage);

        }
    }

    public enum State {
        MAX,
        NON_EXIST,
        NOT_ALLOWED,
        PRINT,
        VIDE
    }
}
