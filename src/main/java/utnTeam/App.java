package utnTeam;


import utnTeam.clases.*;
import java.util.*;
import java.util.stream.Stream;
import utnTeam.interfaces.Beber;
import utnTeam.interfaces.Orinar;
import java.util.stream.Collectors;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class App
{
    public static void main( String[] args )
    {


        List<Humano> ejercitoVikingo = new ArrayList<>();
        Humano guerrero1 = new Vikingo(1,"Ragnar", 46, 80, new OrinarVikingoImpl(), new BeberVikingoImpl(), 12);
        Humano guerrero2 = new Vikingo(2,"Bjorn", 35, 76, new OrinarVikingoImpl(), new BeberVikingoImpl(), 14);
        Humano guerrero3 = new Vikingo(3,"Lagherta", 33, 51, new OrinarVikingoImpl(), new BeberVikingoImpl(), 16);
        Humano guerrero4 = new Vikingo(4,"Helge", 43, 60, new OrinarVikingoImpl(), new BeberVikingoImpl(), 20);
        Humano guerrero5 = new Vikingo(5,"Gerd", 34, 80, new OrinarVikingoImpl(), new BeberVikingoImpl(), 6);
        Humano guerrero6 = new Vikingo(6,"Hans", 44, 89, new OrinarVikingoImpl(), new BeberVikingoImpl(), 9);
        Humano guerrero7 = new Vikingo(7,"Jensen", 66, 90, new OrinarVikingoImpl(), new BeberVikingoImpl(), 7);
        Humano guerrero8 = new Vikingo(8,"Odin", 88, 98, new OrinarVikingoImpl(), new BeberVikingoImpl(), 10);

        Collections.addAll(ejercitoVikingo, guerrero1, guerrero2, guerrero3, guerrero4, guerrero5, guerrero6, guerrero7, guerrero8);

        List<Humano> ejercitoEspartano = new ArrayList<>();
        Humano luchador1 = new Espartano(1,"Aquiles", 66, 89, new OrinarEspartanoImpl(), new BeberEspartanoImpl(),8);
        Humano luchador2 = new Espartano(2,"Adonis", 55, 87, new OrinarEspartanoImpl(), new BeberEspartanoImpl(), 9);
        Humano luchador3 = new Espartano(3,"Basil", 33, 68, new OrinarEspartanoImpl(), new BeberEspartanoImpl(), 6);
        Humano luchador4 = new Espartano(4,"Bemus", 55, 79, new OrinarEspartanoImpl(), new BeberEspartanoImpl(), 15);
        Humano luchador5 = new Espartano(5,"Caesar", 25, 88, new OrinarEspartanoImpl(), new BeberEspartanoImpl(), 12);
        Humano luchador6 = new Espartano(6,"Calix", 56, 89, new OrinarEspartanoImpl(), new BeberEspartanoImpl(), 8);
        Humano luchador7 = new Espartano(7,"Darius", 37, 71, new OrinarEspartanoImpl(), new BeberEspartanoImpl(), 7);
        Humano luchador8 = new Espartano(8,"Eros", 24, 75, new OrinarEspartanoImpl(), new BeberEspartanoImpl(), 9);

        Collections.addAll(ejercitoEspartano, luchador1, luchador2, luchador3, luchador4, luchador5, luchador6, luchador7, luchador8);

        ejercitoVikingo = getOrdenadosPorPeso(ejercitoVikingo);
        System.out.println("EJERCITO VIKINGO: ");
        System.out.println(ejercitoVikingo.toString());
        ejercitoEspartano = getOrdenadosPorPeso(ejercitoEspartano);
        System.out.println("EJERCITO ESPARTANO: ");
        System.out.println(ejercitoEspartano.toString());

        List<Humano> guerrerosGanadores = enfrentamiento(ejercitoVikingo, ejercitoEspartano);
        guerrerosGanadores = getOrdenadosPorBebidaEnCuerpo(guerrerosGanadores);
        System.out.println("ESTOS SON LOS GUERREROS GANADORES");
        System.out.println(guerrerosGanadores.toString());

        Humano tabernero = new Humano(33,"Jose",45,89,new OrinarEspartanoImpl(),new BeberVikingoImpl());
        Humano mejorGuerrero = getPrimerGuerrero(guerrerosGanadores);
        Humano campeonTorneo = dueloWinners(tabernero, mejorGuerrero);
        System.out.println("LUEGO DE UNA GRAN FINAL ENTRE EL TABERNERO Y EL MEJOR GUERRERO... THE WINNER IS...");
        System.out.println(campeonTorneo.toString());
        guerrerosGanadores.add(campeonTorneo);

        Dao daoGanadores = new Dao();
        daoGanadores.conectar();
        daoGanadores.insertarGanadores(guerrerosGanadores);









    }
    private static List<Humano> getOrdenadosPorPeso(List<Humano> ejercito){

        ejercito.sort(Comparator.comparingInt(Humano::getPeso));
        return ejercito;

    }
    private static List<Humano> getOrdenadosPorBebidaEnCuerpo(List<Humano> ganadores){
        ganadores.sort(Comparator.comparingInt(Humano::getBebidaEnCuerpo));
        return ganadores;
    }
    private static Humano getPrimerGuerrero(List<Humano> ejercito){
        Humano guerrero = ejercito.get(0);
        ejercito.remove(ejercito.get(0));
        return guerrero;
    }
    private static Humano duelo(Vikingo vik, Espartano esp){


        vik.setBebidaEnCuerpo((vik.getBebida().beber(vik.getFortaleza())) + (vik.getOrina().orinar((int)(Math.random()*(5-0)+0))));

        esp.setBebidaEnCuerpo((esp.getBebida().beber((int)(Math.random()*(5-0)+0))) + ((esp.getOrina().orinar(esp.getFortaleza()))));

        Humano ganador = new Humano();
        if(vik.getBebidaEnCuerpo() > esp.getBebidaEnCuerpo()){
            ganador = (Vikingo) vik;
        }else if(vik.getBebidaEnCuerpo() < esp.getBebidaEnCuerpo()){
            ganador = (Espartano)esp;
        }else{
            System.out.println("EMPATE");
        }
        return ganador;


    }
    private static List<Humano> enfrentamiento(List<Humano> vikingos, List<Humano> espartanos){
         List<Humano> ganadores = new ArrayList<>();
         Humano guerrero1;
         Humano guerrero2;
         Humano ganador = null;

         while(!(vikingos.isEmpty()) && !(espartanos.isEmpty())){

             System.out.println("NUEVO ENFRENTAMIENTO!!!!!!!!!!!!!");
             guerrero1 = getPrimerGuerrero(vikingos);
             System.out.println("GUERRERO VIKINGO... ADELANTE!!!!");
             System.out.println(guerrero1.toString());
             guerrero2 = getPrimerGuerrero(espartanos);
             System.out.println("GUERRERO ESPARTANO DE UN PASO AL FRENTE!!");
             System.out.println(guerrero2.toString());
             ganador = duelo((Vikingo)guerrero1,(Espartano) guerrero2);
             System.out.println("GANADOR DE ESTA CONTIENDA: ");
             System.out.println(ganador.toString());
             ganadores.add(ganador);
         }

         return ganadores;
    }
    private static Humano dueloWinners(Humano tabernero, Humano guerrero){
        tabernero.setBebidaEnCuerpo((tabernero.getBebida().beber((int)(Math.random()*(10-2)+2))) + (tabernero.getOrina().orinar((int)(Math.random()*(5-0)+0))));

        if(guerrero instanceof Espartano){
          Espartano esp = (Espartano) guerrero;
            esp.setBebidaEnCuerpo((esp.getBebida().beber((int)(Math.random()*(5-0)+0))) + ((esp.getOrina().orinar(esp.getFortaleza()))));
        }else if(guerrero instanceof Vikingo){
            Vikingo vik = (Vikingo) guerrero;
            vik.setBebidaEnCuerpo((vik.getBebida().beber(vik.getFortaleza())) + (vik.getOrina().orinar((int)(Math.random()*(5-0)+0))));
        }
        Humano ganador = new Humano();
        if(tabernero.getBebidaEnCuerpo() > guerrero.getBebidaEnCuerpo()){
            ganador = tabernero;
        }else if(tabernero.getBebidaEnCuerpo() < guerrero.getBebidaEnCuerpo()){
            ganador = guerrero;
        }else{
            System.out.println("EMPATE");
        }
        return ganador;
    }

}


