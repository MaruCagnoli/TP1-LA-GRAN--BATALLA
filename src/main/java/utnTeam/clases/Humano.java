package utnTeam.clases;

import utnTeam.interfaces.Beber;
import utnTeam.interfaces.Orinar;

import java.util.Objects;


public class Humano {

    private int id;
    private String nombre;
    private int edad;
    private int peso;
    private Orinar orina;
    private Beber bebida;
    private int bebidaEnCuerpo;

    public Humano(){
        this.id = 0;
        this.nombre = "";
        this.edad = 0;
        this.peso = 0;
        this.orina = null;
        this.bebida = null;
        this.bebidaEnCuerpo = 0;
    }

    public Humano(int id, String nombre, int edad, int peso, Orinar o, Beber b){

        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.orina = o;
        this.bebida = b;
        this.bebidaEnCuerpo = 0;

    }

    public int getBebidaEnCuerpo() {
        return bebidaEnCuerpo;
    }

    public void setBebidaEnCuerpo(int bebidaEnCuerpo) {
        this.bebidaEnCuerpo = bebidaEnCuerpo;
    }

    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getPeso() {
        return this.peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public Orinar getOrina() {
        return orina;
    }

    public void setOrina(Orinar orina) {
        this.orina = orina;
    }

    public Beber getBebida() {
        return bebida;
    }

    public void setBebida(Beber bebida) {
        this.bebida = bebida;
    }

    @Override
    public String toString() {
        return "Humano{" + "id=" + id +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", peso=" + peso + "bebida en cuerpo: " + bebidaEnCuerpo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Humano humano = (Humano) o;
        return Objects.equals(id, humano.id) &&
                Objects.equals(nombre, humano.nombre) &&
                Objects.equals(edad, humano.edad) &&
                Objects.equals(peso, humano.peso) &&
                Objects.equals(orina, humano.orina) &&
                Objects.equals(bebida, humano.bebida);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, edad, peso, orina, bebida);
    }

}
