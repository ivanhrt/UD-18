package Ex4;

import java.sql.Connection;

import MySQLMethods.MySQLMethods;

public class Ex4MainApp {

	public static void main(String[] args) {
		Ex4Methods met = new Ex4Methods();
		MySQLMethods metSql = new MySQLMethods();
		Connection conexion = metSql.createConexion();;
		metSql.createDB(conexion, "Ejercicio4_UD18");
		met.createTablePeliculasEjercicio4(conexion,"Ejercicio4_UD18","Peliculas");
		met.createTableSalasEjercicio4(conexion,"Ejercicio4_UD18","Salas");
		met.insertDataPeliculasEjercicio4(conexion,"Ejercicio4_UD18", "Peliculas", "Pelicula1",16);
		met.insertDataPeliculasEjercicio4(conexion,"Ejercicio4_UD18", "Peliculas", "Pelicula2",14);
		met.insertDataPeliculasEjercicio4(conexion,"Ejercicio4_UD18", "Peliculas", "Pelicula3",18);
		met.insertDataSalasEjercicio4(conexion,"Ejercicio4_UD18", "Salas", "Sala1",1);
		met.insertDataSalasEjercicio4(conexion,"Ejercicio4_UD18", "Salas", "Sala2",1);
		met.insertDataSalasEjercicio4(conexion,"Ejercicio4_UD18", "Salas", "Sala3",2);
		System.out.println("Datos Peliculas");
		met.getValuesPeliculasEjercicio4(conexion,"Ejercicio4_UD18","Peliculas");
		System.out.println("Datos Salas");
		met.getValuesSalasEjercicio4(conexion,"Ejercicio4_UD18","Salas");
		met.deleteRecordDepartamentosEjercicio4(conexion, "Ejercicio4_UD18", "Peliculas", 2);
		metSql.closeConnection(conexion);
	}

}
