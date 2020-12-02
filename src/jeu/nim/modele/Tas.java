package jeu.nim.modele;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Tas {

    private ArrayList<Integer> tasArray = new ArrayList<>();

    private int tas;
    private int difference;

    public int getDifference() {
        return difference;
    }

    public ArrayList<Integer> getTasArray() {
        return tasArray;
    }

    public Tas(int tas){
        this.tas = tas;
        createTas();
        setDifference(getTasArray().get(getTas()) - getTas() + 1);
    }

    public int getTas() {
        return tas;
    }

    public void setTas(int tas) {
        this.tas = tas;
    }

    public void setDifference(int difference){
        this.difference = difference;
    }

    public void createTas(){
        int i = 1;

        while(i <= tas){

            int tasInit = 2*i - 1;

            tasArray.add(tasInit);

            i++;

        }



    }

}
