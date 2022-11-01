package Ex2;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Ex2Methods {
	
	public Ex2Methods() {
		
	}

	public void createTableDepartamentosEjercicio2(Connection conexion, String db, String name) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "CREATE TABLE " + name
					+ "(Codigo INT PRIMARY KEY AUTO_INCREMENT, Nombre NVARCHAR(100), Presupuesto INT)";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			System.out.println("Tabla creada");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando tabla.");
		}

	}

	public void createTableEmpleadosEjercicio2(Connection conexion, String db, String name) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "CREATE TABLE " + name
					+ "(Dni VARCHAR(9) PRIMARY KEY, Nombre NVARCHAR(100), Apellidos NVARCHAR(255), Departamento INT, FOREIGN KEY (Departamento) REFERENCES Departamentos(Codigo) ON DELETE SET NULL ON UPDATE CASCADE)";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			System.out.println("Tabla creada");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando tabla.");
		}

	}

//-------------------------------------------------INTRODUCIR DATOS EJERCICIO 2 UD18-----------------------------------------------------
	public void insertDataDepartamentosEjercicio2(Connection conexion, String db, String table_name, String name,
			int presupuesto) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "INSERT INTO " + table_name + "  (Nombre, Presupuesto) VALUE(" + "\"" + name + "\", " + "\""
					+ presupuesto + "\");";

			Statement st = conexion.createStatement();
			st.executeUpdate(Query);

			System.out.println("Datos almacenados correctamente");

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
		}
	}

	public void insertDataEmpleadosEjercicio2(Connection conexion, String db, String table_name, String dni,
			String name, String apellido, int id) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "INSERT INTO " + table_name + "  (Dni,Nombre,Apellidos,Departamento) VALUE(" + "\"" + dni
					+ "\", " + "\"" + name + "\", " + "\"" + apellido + "\", " + "\"" + id + "\");";

			Statement st = conexion.createStatement();
			st.executeUpdate(Query);

			System.out.println("Datos almacenados correctamente");

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
		}
	}

//-------------------------------------------------VER DATOS EJERCICIO 2 UD18-----------------------------------------------------------

	public void getValuesDepartamentosEjercicio2(Connection conexion, String db, String table_name) {
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
						+ resultSet.getString("Nombre") + " " + "Presupuesto: " + resultSet.getString("Presupuesto"));
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
		}
	}

	public void getValuesEmpleadosEjercicio2(Connection conexion, String db, String table_name) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "SELECT * FROM " + table_name;
			Statement st = conexion.createStatement();
			java.sql.ResultSet resultSet;
			resultSet = st.executeQuery(Query);
			while (resultSet.next()) {
				System.out.println("Dni: " + resultSet.getString("Dni") + " " + "Nombre: "
						+ resultSet.getString("Nombre") + " " + "Apellidos: " + resultSet.getString("Apellidos") + " "
						+ "Departamento: " + resultSet.getString("Departamento"));
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
		}
	}

//-------------------------------------------------ELIMINAR REGISTROS--------------------------------------------------------------------
	public void deleteRecordDepartamentosEjercicio2(Connection conexion, String db, String table_name, int ID) {
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
