package Ex5;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Ex5Methods {

	public Ex5Methods() {

	}

	// -------------------------------------------------CREAR TABLAS EJERCICIO
	// UD18--------------------------------------------------------

	public void createTableDespachosEjercicio5(Connection conexion, String db, String name) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "CREATE TABLE " + name + "(Numero INT PRIMARY KEY AUTO_INCREMENT, Capacidad INT)";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			System.out.println("Tabla creada");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando tabla.");
		}

	}

	public void createTableDirectoresEjercicio5(Connection conexion, String db, String name) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "CREATE TABLE " + name
					+ "(Dni VARCHAR(9) PRIMARY KEY, NomApels NVARCHAR(255), DniJefe VARCHAR(8), Despacho INT, FOREIGN KEY (DniJefe) REFERENCES Directores(Dni) ON DELETE SET NULL ON UPDATE CASCADE, FOREIGN KEY (Despacho) REFERENCES Despachos(Numero) ON DELETE SET NULL ON UPDATE CASCADE)";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			System.out.println("Tabla creada");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando tabla.");
		}

	}

	// -------------------------------------------------INTRODUCIR DATOS EJERCICIO 1
	// UD18-----------------------------------------------------
	public void insertDataDespachosEjercicio5(Connection conexion, String db, String table_name, int capacidad) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "INSERT INTO " + table_name + "  (Capacidad) VALUE(" + "\"" + capacidad + "\");";

			Statement st = conexion.createStatement();
			st.executeUpdate(Query);

			System.out.println("Datos almacenados correctamente");

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
		}
	}

	public void insertDataDirectoresEjercicio5(Connection conexion, String db, String table_name, String dni,
			String nom_apels, String dni_jefe, int despacho) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "INSERT INTO " + table_name + "  (Dni,NomApels,DniJefe,Despacho) VALUE(" + "\"" + dni
					+ "\", " + "\"" + nom_apels + "\", " + "\"" + dni_jefe + "\", " + "\"" + despacho + "\");";

			Statement st = conexion.createStatement();
			st.executeUpdate(Query);

			System.out.println("Datos almacenados correctamente");

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
		}
	}

	// -------------------------------------------------VER DATOS EJERCICIO 1
	// UD18-----------------------------------------------------------

	public void getValuesDespachosEjercicio5(Connection conexion, String db, String table_name) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "SELECT * FROM " + table_name;
			Statement st = conexion.createStatement();
			java.sql.ResultSet resultSet;
			resultSet = st.executeQuery(Query);

			while (resultSet.next()) {
				System.out.println("Numero: " + resultSet.getString("Numero") + " " + "Capacidad: "
						+ resultSet.getString("Capacidad"));
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
		}
	}

	public void getValuesDirectoresEjercicio5(Connection conexion, String db, String table_name) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "SELECT * FROM " + table_name;
			Statement st = conexion.createStatement();
			java.sql.ResultSet resultSet;
			resultSet = st.executeQuery(Query);
			while (resultSet.next()) {
				System.out.println("Dni: " + resultSet.getString("Dni") + " " + "NomApels: "
						+ resultSet.getString("NomApels") + " " + "DniJefe: " + resultSet.getString("DniJefe") + " "
						+ "Despacho: " + resultSet.getString("Despacho"));
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
		}
	}

	// -------------------------------------------------ELIMINAR
	// REGISTROS--------------------------------------------------------------------
	public void deleteRecordDespachosEjercicio5(Connection conexion, String db, String table_name, int ID) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "DELETE FROM " + table_name + " WHERE Numero = \"" + ID + "\"";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			System.out.println("Se ha eliminado el registro correctamente");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error borrando el registro especificado");
		}
	}

}
