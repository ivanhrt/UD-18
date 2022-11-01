package Ex3;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Ex3Methods {

	public Ex3Methods() {

	}

	// -------------------------------------------------CREAR TABLAS EJERCICIO 2
	// UD18--------------------------------------------------------
	public void createTableAlmacenesEjercicio3(Connection conexion, String db, String name) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "CREATE TABLE " + name
					+ "(Codigo INT PRIMARY KEY AUTO_INCREMENT, Lugar NVARCHAR(100), Capacidad INT)";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			System.out.println("Tabla creada");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando tabla.");
		}

	}

	public void createTableCajasEjercicio3(Connection conexion, String db, String name) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "CREATE TABLE " + name
					+ "(NumReferencia CHAR(5) PRIMARY KEY, Contenido NVARCHAR(100), Valor INT, Almacen INT, FOREIGN KEY (Almacen) REFERENCES Almacenes(Codigo) ON DELETE SET NULL ON UPDATE CASCADE)";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			System.out.println("Tabla creada");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando tabla.");
		}

	}

//-------------------------------------------------INTRODUCIR DATOS EJERCICIO 1 UD18-----------------------------------------------------
	public void insertDataAlmacenesEjercicio3(Connection conexion, String db, String table_name, String lugar,
			int capacidad) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "INSERT INTO " + table_name + "  (Lugar, Capacidad) VALUE(" + "\"" + lugar + "\", " + "\""
					+ capacidad + "\");";

			Statement st = conexion.createStatement();
			st.executeUpdate(Query);

			System.out.println("Datos almacenados correctamente");

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
		}
	}

	public void insertDataCajasEjercicio3(Connection conexion, String db, String table_name, String num_referencia,
			String contenido, int valor, int codigo) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "INSERT INTO " + table_name + "  (NumReferencia,Contenido,Valor,Almacen) VALUE(" + "\""
					+ num_referencia + "\", " + "\"" + contenido + "\", " + "\"" + valor + "\", " + "\"" + codigo
					+ "\");";

			Statement st = conexion.createStatement();
			st.executeUpdate(Query);

			System.out.println("Datos almacenados correctamente");

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
		}
	}

//-------------------------------------------------VER DATOS EJERCICIO 1 UD18-----------------------------------------------------------

	public void getValuesAlmacenesEjercicio3(Connection conexion, String db, String table_name) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "SELECT * FROM " + table_name;
			Statement st = conexion.createStatement();
			java.sql.ResultSet resultSet;
			resultSet = st.executeQuery(Query);

			while (resultSet.next()) {
				System.out.println("Codigo: " + resultSet.getString("Codigo") + " " + "Lugar: "
						+ resultSet.getString("Lugar") + " " + "Capacidad: " + resultSet.getString("Capacidad"));
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
		}
	}

	public void getValuesCajasEjercicio3(Connection conexion, String db, String table_name) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "SELECT * FROM " + table_name;
			Statement st = conexion.createStatement();
			java.sql.ResultSet resultSet;
			resultSet = st.executeQuery(Query);
			while (resultSet.next()) {
				System.out.println("NumReferencia: " + resultSet.getString("NumReferencia") + " " + "Contenido: "
						+ resultSet.getString("Contenido") + " " + "Valor: " + resultSet.getString("Valor") + " "
						+ "Almacen: " + resultSet.getString("Almacen"));
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
		}
	}

//-------------------------------------------------ELIMINAR REGISTROS--------------------------------------------------------------------
	public void deleteRecordDepartamentosEjercicio3(Connection conexion, String db, String table_name, int ID) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "DELETE FROM " + table_name + " WHERE Codigo = \"" + ID + "\"";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			System.out.println("Se ha eliminado el registro correctamente");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error borrando el registro especificado");
		}
	}

}
