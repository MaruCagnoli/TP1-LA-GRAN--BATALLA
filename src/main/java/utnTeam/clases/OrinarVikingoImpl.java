package utnTeam.clases;

import utnTeam.interfaces.Orinar;

public class OrinarVikingoImpl implements Orinar {



    public OrinarVikingoImpl(){

    }
    public int orinar(int fortaleza){
        int cargaVejiga = (int)(Math.random() *(40-25)+25);
        int balance = cargaVejiga - fortaleza;


        return balance;
    }




}
