package utnTeam.clases;

import utnTeam.interfaces.Orinar;

public class OrinarEspartanoImpl implements Orinar {



    public OrinarEspartanoImpl(){

    }
    public int orinar(int fortaleza){
        int cargaVejiga = (int)(Math.random()*(12-8)+8);
        int balance = cargaVejiga + fortaleza;

        return balance;
    }



}
