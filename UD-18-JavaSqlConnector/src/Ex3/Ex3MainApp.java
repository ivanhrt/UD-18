package Ex3;

import java.sql.Connection;

import MySQLMethods.MySQLMethods;

public class Ex3MainApp {

	public static void main(String[] args) {

		Ex3Methods met = new Ex3Methods();
		MySQLMethods metSql = new MySQLMethods();
		Connection conexion = metSql.createConexion();
		metSql.createDB(conexion, "Ejercicio3_UD18");
		met.createTableAlmacenesEjercicio3(conexion,"Ejercicio3_UD18","Almacenes");
		met.createTableCajasEjercicio3(conexion,"Ejercicio3_UD18","Cajas");
		met.insertDataAlmacenesEjercicio3(conexion,"Ejercicio3_UD18", "Almacenes", "Localizacion1",1);
		met.insertDataAlmacenesEjercicio3(conexion,"Ejercicio3_UD18", "Almacenes", "Localizacion2",2);
		met.insertDataAlmacenesEjercicio3(conexion,"Ejercicio3_UD18", "Almacenes", "Localizacion3",3);
		met.insertDataCajasEjercicio3(conexion,"Ejercicio3_UD18", "Cajas", "00001", "Caja1",52,1);
		met.insertDataCajasEjercicio3(conexion,"Ejercicio3_UD18", "Cajas", "00002", "Caja2",34,1);
		met.insertDataCajasEjercicio3(conexion,"Ejercicio3_UD18", "Cajas", "00003", "Caja3",15,2);
		System.out.println("Datos Almacenes");
		met.getValuesAlmacenesEjercicio3(conexion,"Ejercicio3_UD18","Almacenes");
		System.out.println("Datos Cajas");
		met.getValuesCajasEjercicio3(conexion,"Ejercicio3_UD18","Cajas");
		met.deleteRecordDepartamentosEjercicio3(conexion, "Ejercicio3_UD18", "Almacenes", 2);
		metSql.closeConnection(conexion);
		
	}

}
