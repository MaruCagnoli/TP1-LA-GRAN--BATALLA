package utnTeam.clases;

import utnTeam.interfaces.Beber;

public class BeberVikingoImpl  implements Beber {


    public BeberVikingoImpl(){


    }
    public int beber(int fortaleza){
        int alcoholEnSangre = (int)(Math.random() *(20-5)+5);
        int balance = alcoholEnSangre + fortaleza;



        return balance;
    }


}
