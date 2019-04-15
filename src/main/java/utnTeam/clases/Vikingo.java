package utnTeam.clases;

import utnTeam.interfaces.Beber;
import utnTeam.interfaces.Orinar;

import java.util.Objects;

public class Vikingo extends Humano {

    private int fortaleza;

    public Vikingo (int id, String nombre, int edad, int peso, Orinar o, Beber b, int bebedorProf){
        super(id, nombre, edad, peso, o, b);
        this.fortaleza = bebedorProf;

    }

    public int getFortaleza() {
        return this.fortaleza;
    }

    public void setFortaleza(int bebedorProfesional) {
        this.fortaleza = bebedorProfesional;
    }

    @Override
    public String toString() {
        return "Vikingo" + " " + super.toString() +
                "fortaleza=" + fortaleza +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vikingo vikingo = (Vikingo) o;
        return Objects.equals(fortaleza, vikingo.fortaleza);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fortaleza);
    }
}
