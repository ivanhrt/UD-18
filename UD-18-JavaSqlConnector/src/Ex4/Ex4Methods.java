package Ex4;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Ex4Methods {

	public Ex4Methods() {

	}

	// -------------------------------------------------CREAR TABLAS EJERCICIO 2
	// UD18--------------------------------------------------------
	public void createTablePeliculasEjercicio4(Connection conexion, String db, String name) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "CREATE TABLE " + name
					+ "(Codigo INT PRIMARY KEY AUTO_INCREMENT, Nombre NVARCHAR(100), CalificacionEdad INT)";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			System.out.println("Tabla creada");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando tabla.");
		}

	}

	public void createTableSalasEjercicio4(Connection conexion, String db, String name) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "CREATE TABLE " + name
					+ "(Codigo INT PRIMARY KEY AUTO_INCREMENT, Nombre NVARCHAR(100), Pelicula INT, FOREIGN KEY (Pelicula) REFERENCES Peliculas(Codigo) ON DELETE SET NULL ON UPDATE CASCADE)";
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
	public void insertDataPeliculasEjercicio4(Connection conexion, String db, String table_name, String nombre,
			int calificacion_edad) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "INSERT INTO " + table_name + "  (Nombre, CalificacionEdad) VALUE(" + "\"" + nombre + "\", "
					+ "\"" + calificacion_edad + "\");";

			Statement st = conexion.createStatement();
			st.executeUpdate(Query);

			System.out.println("Datos almacenados correctamente");

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
		}
	}

	public void insertDataSalasEjercicio4(Connection conexion, String db, String table_name, String nombre,
			int pelicula) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "INSERT INTO " + table_name + "  (Nombre,Pelicula) VALUE(" + "\"" + nombre + "\", " + "\""
					+ pelicula + "\");";

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

	public void getValuesPeliculasEjercicio4(Connection conexion, String db, String table_name) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "SELECT * FROM " + table_name;
			Statement st = conexion.createStatement();
			java.sql.ResultSet resultSet;
			resultSet = st.executeQuery(Query);

			while (resultSet.next()) {
				System.out.println(
						"Codigo: " + resultSet.getString("Codigo") + " " + "Nombre: " + resultSet.getString("Nombre")
								+ " " + "CalificacionEdad: " + resultSet.getString("CalificacionEdad"));
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
		}
	}

	public void getValuesSalasEjercicio4(Connection conexion, String db, String table_name) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "SELECT * FROM " + table_name;
			Statement st = conexion.createStatement();
			java.sql.ResultSet resultSet;
			resultSet = st.executeQuery(Query);
			while (resultSet.next()) {
				System.out.println("Codigo: " + resultSet.getString("Codigo") + " " + "Nombre: "
						+ resultSet.getString("Nombre") + " " + "Pelicula: " + resultSet.getString("Pelicula"));
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
		}
	}

	// -------------------------------------------------ELIMINAR
	// REGISTROS--------------------------------------------------------------------
	public void deleteRecordDepartamentosEjercicio4(Connection conexion, String db, String table_name, int ID) {
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
