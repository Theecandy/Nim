package jeu.nim.modele;

import jeu.nim.vue.Ihm;

public class Coup {

    private final int max;
    private Ihm ihm;

    public Coup(int max){
        this.max = max;
    }

    public int getMax() {
        return max;
    }

    public Ihm getIhm() {
        return ihm;
    }

    public void setIhm(Ihm ihm) {
        this.ihm = ihm;
    }

    private Tas getLesTas() {
        return getIhm().getConstructeur().getTas();
    }


    public void subsAllumettes(int past,int newInt,Integer integer, Integer allumettes,String state) {


        getLesTas().getTasArray().replace(integer,past,newInt);
    }
}
