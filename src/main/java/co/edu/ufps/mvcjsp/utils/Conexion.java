package co.edu.ufps.mvcjsp.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
	private Connection con= null;
	private static Conexion db;
	private PreparedStatement preparedStatement;
	
	
	private static final String host = "localhost";
	private static final String driver = "org.postgresql.Driver";
	private static final String usuario = "postgres";
	private static final String db_name = "USUARIOS";
	private static final String pass = "3LA3PUERTA3OSCURA3";
	private static final String url = "jdbc:postgresql://"+host+":5432/"+db_name;
	public Conexion() {

		
			try {
				Class.forName(driver);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				con = DriverManager.getConnection(url,usuario,pass);
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
	public static Conexion getConexion() {
	if(db == null) {
		db=new Conexion();
	}
	return db;
	}
	public ResultSet query() throws SQLException{
		ResultSet res= preparedStatement.executeQuery();
		return res;
		
	}
	public int execute() throws SQLException{
		int result= preparedStatement.executeUpdate();
		return result;
		
	}
	public void cerrarConexion() {

			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
	
	public Connection getCon() {
		
		return this.con;
	}
	
	public PreparedStatement setPreparedStatement(String sql)throws SQLException{
	this.preparedStatement = con.prepareStatement(sql);
	return this.preparedStatement;
	 
	}
	
	/*public static void main(String [] args) {
		ConexionPostgreSQL conexion = new ConexionPostgreSQL();
		
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
		
	}*/
	

}
