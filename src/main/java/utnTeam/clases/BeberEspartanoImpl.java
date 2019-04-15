package utnTeam.clases;

import utnTeam.interfaces.Beber;



public class BeberEspartanoImpl implements Beber {


    private int litros;

    public BeberEspartanoImpl(){

    }

    public int beber(int fortaleza){
        int alcoholEnSangre = (int)(Math.random()*(40-25)+25);
        int balance = alcoholEnSangre - fortaleza;


        return balance;
    }


}
