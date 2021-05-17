package co.edu.ufps.mvcjsp.services;

import java.sql.ResultSet;
import java.sql.SQLException;

import co.edu.ufps.mvcjsp.beans.Persona;
import co.edu.ufps.mvcjsp.utils.ConexionPostgreSQL;

public class IndexServices {
	

public Persona obtenerPersona (String email) {
		
	ConexionPostgreSQL conexion = new ConexionPostgreSQL();
	String sql= "select * from persona where email ='" + email +"'";
	ResultSet rs= conexion.consultar(sql);
	Persona persona = new Persona();
	try {
		if(rs.next()) {
			persona.setEmail(rs.getString("email"));
			persona.setNombre(rs.getString("nombre"));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

		//persona.setEmail(email);
		//Integer x =email.indexOf(0);
		//Integer y =email.indexOf(".",0);
		//persona.setNombre("Juan - UFPS");
		

		conexion.cerrarConexion();
		return persona;
	}
}
