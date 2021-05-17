package co.edu.ufps.mvcjsp.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class ConexionMySQL {
	private Connection con;
	private Statement st= null;
	public ConexionMySQL() {
		String host = "queenie.db.elephantsql.com";
		String db = "mnjgxshj";
		
		String url = "jdbc:postgresql://"+host+":5432/"+db;
		String usuario = "mnjgxshj";
		String pass = "lASbUUHHf71SJftWzxSMPUguf-hclhvE";
		
			try {
				Class.forName("org.Postgresql.Driver");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				con = DriverManager.getConnection("url","usuario","pass");
				boolean valid = con.isValid(50000);
				System.out.println(valid ? "TEST OK" : "TEST FAIL");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}


	}
	public ResultSet consultar(String sql) {
		try {
			Statement st= this.con.createStatement();
			ResultSet rs= st.executeQuery(sql);
			/*
			while(rs.next() ) {
				String nombre = rs.getString("nombre");
				String email = rs.getString(1);

			}
			*/
			return rs;
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public void cerrarConexion() {

			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
	
	public static void main(String [] args) {
		ConexionMySQL conexion = new ConexionMySQL();
		
		try {
			Statement st= conexion.con.createStatement();
			ResultSet rs= st.executeQuery("select * from persona");
			
			while(rs.next() ) {
				String nombre = rs.getString("nombre");
				String email = rs.getString(1);

			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		conexion.cerrarConexion();
		
	}
	

}
