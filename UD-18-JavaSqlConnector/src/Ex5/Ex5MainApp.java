package Ex5;

import MySQLMethods.MySQLMethods;
import java.sql.Connection;

public class Ex5MainApp {

	public static void main(String[] args) {

		Ex5Methods met = new Ex5Methods();
		MySQLMethods metSql = new MySQLMethods();
		Connection conexion = metSql.createConexion();;
		metSql.createDB(conexion, "Ejercicio5_UD18");
		met.createTableDespachosEjercicio5(conexion,"Ejercicio5_UD18","Despachos");
		met.createTableDirectoresEjercicio5(conexion,"Ejercicio5_UD18","Directores");
		met.insertDataDespachosEjercicio5(conexion,"Ejercicio5_UD18", "Despachos", 4);
		met.insertDataDespachosEjercicio5(conexion,"Ejercicio5_UD18", "Despachos", 6);
		met.insertDataDespachosEjercicio5(conexion,"Ejercicio5_UD18", "Despachos", 10);
		met.insertDataDirectoresEjercicio5(conexion,"Ejercicio5_UD18", "Directores", "12345678G", "Director1",null,1);
		met.insertDataDirectoresEjercicio5(conexion,"Ejercicio5_UD18", "Directores", "98745654K", "Director2","12345678G",1);
		met.insertDataDirectoresEjercicio5(conexion,"Ejercicio5_UD18", "Directores", "98653247T", "Director3","98745654K",2);
		System.out.println("Datos Despachos");
		met.getValuesDespachosEjercicio5(conexion,"Ejercicio5_UD18","Peliculas");
		System.out.println("Datos Directores");
		met.getValuesDirectoresEjercicio5(conexion,"Ejercicio5_UD18","Salas");
		met.deleteRecordDespachosEjercicio5(conexion, "Ejercicio5_UD18", "Peliculas", 2);
		metSql.closeConnection(conexion);
	}

}
