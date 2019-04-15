package utnTeam.clases;

import utnTeam.interfaces.Beber;
import utnTeam.interfaces.Orinar;

import java.util.Objects;

public class Espartano extends Humano {

    int fortaleza;

    public Espartano(int id, String nombre, int edad, int peso, Orinar o, Beber b, int toleranciaE){
        super(id, nombre, edad, peso, o, b);
        this.fortaleza = toleranciaE;
    }

    public int getFortaleza() {
        return this.fortaleza;
    }

    public void setFortaleza(int toleranciaExtra) {
        this.fortaleza = toleranciaExtra;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Espartano espartano = (Espartano) o;
        return Objects.equals(fortaleza, espartano.fortaleza);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fortaleza);
    }

    @Override
    public String toString() {
        return "Espartano{" + super.toString() +
                "toleranciaExtra=" + this.fortaleza +
                '}';
    }
}
