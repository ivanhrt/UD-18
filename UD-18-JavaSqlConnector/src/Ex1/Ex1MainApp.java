package Ex1;

import java.sql.Connection;

import MySQLMethods.MySQLMethods;

public class Ex1MainApp {

	public static void main(String[] args) {

		Ex1Methods met = new Ex1Methods();
		MySQLMethods metSql = new MySQLMethods();
		Connection conexion = metSql.createConexion();
		metSql.createDB(conexion, "Ejercicio1_UD18");
		met.createTableFabricantesEjercicio1(conexion,"Ejercicio1","Fabricantes");
		met.createTableArticulosEjercicio1(conexion,"Ejercicio1_UD18","Articulos");
		met.insertDataFabricantesEjercicio1(conexion,"Ejercicio1_UD18", "Fabricantes", "Acer");
		met.insertDataFabricantesEjercicio1(conexion,"Ejercicio1_UD18", "Fabricantes", "Msi");
		met.insertDataFabricantesEjercicio1(conexion,"Ejercicio1_UD18", "Fabricantes", "HP");
		met.insertDataArticulosEjercicio1(conexion,"Ejercicio1_UD18", "Articulos", "Pantalla",250,1);
		met.insertDataArticulosEjercicio1(conexion,"Ejercicio1_UD18", "Articulos", "Targeta gráfica",500,1);
		met.insertDataArticulosEjercicio1(conexion,"Ejercicio1_UD18", "Articulos", "Ram",87,2);
		System.out.println("Datos Fabricantes");
		met.getValuesFabricantesEjercicio1(conexion,"Ejercicio1_UD18","Fabricantes");
		System.out.println("Datos Articulos");
		met.getValuesArticulosEjercicio1(conexion,"Ejercicio1_UD18","Articulos");
		met.deleteRecordFabrcianteEjercicio1(conexion, "Ejercicio1_UD18", "Fabricantes", 2);
		System.out.println("Datos Fabricantes");
		met.getValuesFabricantesEjercicio1(conexion,"Ejercicio1_UD18","Fabricantes");
		System.out.println("Datos Articulos");
		met.getValuesArticulosEjercicio1(conexion,"Ejercicio1_UD18","Articulos");
		metSql.closeConnection(conexion);
		
	}

}
