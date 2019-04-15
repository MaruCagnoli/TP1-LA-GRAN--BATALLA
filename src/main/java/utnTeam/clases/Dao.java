package utnTeam.clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Dao {

    static final String DB_URL = "jdbc:mysql://localhost/batalla_db";
    static final String USER = "root";
    static final String PASSWORD = "root";
    Connection conexion = null;

    public void conectar(){
        try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("INTENTANDO CONEXION.....");
            conexion = DriverManager.getConnection(DB_URL, USER, PASSWORD);

        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("No se puede abrir la base de datos");
        }catch(ClassNotFoundException e){

            System.out.println("Falta la libreria SQL. ");

        }
    }
    public void insertarGanadores(List<Humano> ganadores){
        String nombreGanador = "";
        int bebida;

        try{
            for(Humano participante : ganadores){
                nombreGanador = participante.getNombre();
                bebida = participante.getBebidaEnCuerpo();

                String query = "INSERT INTO ganadores (nombre_ganador, bebida_en_cuerpo) values (?, ?)";
                PreparedStatement prepare = conexion.prepareStatement(query);
                prepare.setString(1, nombreGanador);
                prepare.setInt(2, bebida);
                prepare.execute();
            }
        }catch (SQLException e){
            System.out.println("Veniamos bien, pasaron cosas");
            e.printStackTrace();
        }finally{
            try{
                conexion.close();
            }catch(SQLException e){
                System.out.println("El sistema habría colapsado.");
                e.printStackTrace();
            }
        }
    }
}

/*QUERYS PARA PROBAR BASE DE DATOS*/


/*CREATE DATABASE batalla_db;
 	USE batalla_db;

 	CREATE TABLE ganadores(

 		id_ganador int unsigned AUTO_INCREMENT,
 		nombre_ganador varchar(50),
 		bebida_en_cuerpo int,
 		constraint pk_ganadores primary key(id_ganador)

 		);*/