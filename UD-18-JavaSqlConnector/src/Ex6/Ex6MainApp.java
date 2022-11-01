package Ex6;

import java.sql.Connection;

import MySQLMethods.MySQLMethods;

public class Ex6MainApp {

	public static void main(String[] args) {
		Ex6Methods met = new Ex6Methods();
		MySQLMethods metSql = new MySQLMethods();
		Connection conexion = metSql.createConexion();;
		metSql.createDB(conexion, "Ejercicio6_UD18");
		met.createTablePiezasEjercicio6(conexion,"Ejercicio6_UD18","Piezas");
		met.createTableProveedoresEjercicio6(conexion,"Ejercicio6_UD18","Proveedores");
		met.createTableSuministraEjercicio6(conexion,"Ejercicio6_UD18","Suministra");
		met.insertDataPiezasEjercicio6(conexion,"Ejercicio6_UD18", "Piezas", "Pieza1");
		met.insertDataPiezasEjercicio6(conexion,"Ejercicio6_UD18", "Piezas", "Pieza2");
		met.insertDataPiezasEjercicio6(conexion,"Ejercicio6_UD18", "Piezas", "Pieza3");
		met.insertDataProveedoresEjercicio6(conexion,"Ejercicio6_UD18", "Proveedores","1111","Proveedor1");
		met.insertDataProveedoresEjercicio6(conexion,"Ejercicio6_UD18", "Proveedores","2222","Proveedor2");
		met.insertDataProveedoresEjercicio6(conexion,"Ejercicio6_UD18", "Proveedores","3333","Proveedor3");
		met.insertDataSuministraEjercicio6(conexion,"Ejercicio6_UD18", "Suministra",1,"1111",10);
		met.insertDataSuministraEjercicio6(conexion,"Ejercicio6_UD18", "Suministra",1,"2222",20);
		met.insertDataSuministraEjercicio6(conexion,"Ejercicio6_UD18", "Suministra",2,"3333",30);
		System.out.println("Datos Piezas");
		met.getValuesPiezasEjercicio6(conexion,"Ejercicio6_UD18","Piezas");
		System.out.println("Datos Proveedores");
		met.getValuesProveedoresEjercicio6(conexion,"Ejercicio6_UD18","Proveedores");
		System.out.println("Datos Suministra");
		met.getValuesSuministraEjercicio6(conexion,"Ejercicio6_UD18","Suministra");
		met.deleteRecordPiezasEjercicio6(conexion, "Ejercicio6_UD18", "Piezas", 2);
		metSql.closeConnection(conexion);

	}

}
