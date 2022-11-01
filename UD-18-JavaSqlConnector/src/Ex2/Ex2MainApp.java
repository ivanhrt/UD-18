package Ex2;

import java.sql.Connection;

import MySQLMethods.MySQLMethods;

public class Ex2MainApp {

	public static void main(String[] args) {
		Ex2Methods met = new Ex2Methods();
		MySQLMethods metSql = new MySQLMethods();
		Connection conexion = metSql.createConexion();
		metSql.createDB(conexion, "Ejercicio2_UD18");
		met.createTableDepartamentosEjercicio2(conexion,"Ejercicio2_UD18","Departamentos");
		met.createTableEmpleadosEjercicio2(conexion,"Ejercicio2_UD18","Empleados");
		met.insertDataDepartamentosEjercicio2(conexion,"Ejercicio2_UD18", "Departamentos", "Departamento 1",1000);
		met.insertDataDepartamentosEjercicio2(conexion,"Ejercicio2_UD18", "Departamentos", "Departamento 2",2000);
		met.insertDataDepartamentosEjercicio2(conexion,"Ejercicio2_UD18", "Departamentos", "Departamento 3",3000);
		met.insertDataEmpleadosEjercicio2(conexion,"Ejercicio2_UD18", "Empleados", "11111111A", "Nombre 1","Apellido 1",1);
		met.insertDataEmpleadosEjercicio2(conexion,"Ejercicio2_UD18", "Empleados", "11111111B", "Nombre 2","Apellido 2",1);
		met.insertDataEmpleadosEjercicio2(conexion,"Ejercicio2_UD18", "Empleados", "11111111C", "Nombre 3","Apellido 3",2);
		System.out.println("Datos Departamento");
		met.getValuesDepartamentosEjercicio2(conexion,"Ejercicio2_UD18","Departamentos");
		System.out.println("Datos Articulos");
		met.getValuesEmpleadosEjercicio2(conexion,"Ejercicio2_UD18","Empleados");
		met.deleteRecordDepartamentosEjercicio2(conexion, "Ejercicio2_UD18", "Departamentos", 2);
		metSql.closeConnection(conexion);
	}

}
