package co.edu.ufps.mvcjsp.beans;

import java.io.Serializable;

public class Persona implements Serializable{
	private String nombre;
	private String email;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


}
