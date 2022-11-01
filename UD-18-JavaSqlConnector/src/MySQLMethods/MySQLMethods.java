package MySQLMethods;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;
import java.util.logging.Level;
import javax.swing.JOptionPane;

public class MySQLMethods {

	public MySQLMethods() {
	}
	
	public Connection createConexion() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion=DriverManager.getConnection("jdbc:mysql://192.168.1.105:3306?useTimezone=true&serverTimezone=UTC","remote","Ivan7442@");
			System.out.println("Server Connected");
			return conexion;
		}catch(SQLException | ClassNotFoundException ex) {
			System.out.println("No se ha podido conectar con mi base de datos");
			System.out.println(ex);
			return null;
		}
	}
	
	//-------------------------------------------------CERRAR CONEXION---------------------------------------------------------------------
	//Cierra la conexion
	public void closeConnection(Connection conexion) {
		try {
			conexion.close();
			JOptionPane.showMessageDialog(null,"Se ha finalizado al conexión con el servidor");
		}catch(SQLException ex) {
			Logger.getLogger(MySQLMethods.class.getName()).log(Level.SEVERE,null,ex);
		}
	}
	
	//-------------------------------------------------CREAR BASE DE DATOS-------------------------------------------------------------------
	//crea una base de datos
	public void createDB(Connection conexion,String name) {
		try {
			String Query = "CREATE DATABASE "+name;
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			//closeConnection(conexion);
			JOptionPane.showMessageDialog(null, "Se ha creado la base de datos "+name+" de forma exitosa");			
		}catch(SQLException ex) {
			Logger.getLogger(MySQLMethods.class.getName()).log(Level.SEVERE,null,ex);
		}
	}
	
	//-------------------------------------------------CREAR TABLAS---------------------------------------------------------------------
	//Crea la tabla del ejemplo de las diapos de teoria
	public static void createTable(Connection conexion,String db, String name) {
		try {
			String Querydb = "USE " +db+";";
			Statement stdb= conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "CREATE TABLE " + name+"(ID INT PRIMARY KEY AUTO_INCREMENT, Nombre VARCHAR(50), Apellido VARCHAR(50), Edad VARCHAR(3), Sexo VARCHAR(1))";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			System.out.println("Tabla creada");
			}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando tabla.");
		}
		
	}
	
	
		//-------------------------------------------------INTRODUCIR DATOS------------------------------------------------------------------
	public static void insertData(Connection conexion,String db, String table_name, String name, String lastname, String age, String gender) {
		try {
			String Querydb = "USE "+db+";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "INSERT INTO "+table_name+"  (Nombre, Apellido, Edad, Sexo) VALUE("
					+"\""+name+"\", "
					+"\""+lastname+"\", "
					+"\""+age+"\", "
					+"\""+gender+"\");";
			
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			
			System.out.println("Datos almacenados correctamente");
			
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
		}
	}
	
	
	
	//-------------------------------------------------VER DATOS---------------------------------------------------------------------
	public static void getValues(Connection conexion,String db, String table_name) {
		try {
			String Querydb = "USE "+db+";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "SELECT * FROM "+table_name;
			Statement st= conexion.createStatement();
			java.sql.ResultSet resultSet;
			resultSet = st.executeQuery(Query);
			
			while (resultSet.next()) {
				System.out.println("ID: " + resultSet.getString("ID")+" "+"Nombre: "+ resultSet.getString("Nombre")+" "+"Apellido: "+resultSet.getString("Apellido")+" "+"Edad: "+resultSet.getString("Edad")+" "+"Sexo: "+resultSet.getString("Sexo"));
			}
		
			
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
		}
	}
	
	//-------------------------------------------------ELIMINAR REGISTROS--------------------------------------------------------------------
	public void deleteRecord(Connection conexion,String db, String table_name, String ID) {
		try {
			String Querydb = "USE "+db+";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "DELETE FROM "+table_name+" WHERE ID = \""+ID+"\"";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			System.out.println("Se ha eliminado el registro correctamente");
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null,"Error borrando el registro especificado");
		}
	}
	
	
}