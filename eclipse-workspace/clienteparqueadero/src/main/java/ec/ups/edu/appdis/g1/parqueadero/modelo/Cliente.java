package ec.ups.edu.appdis.g1.parqueadero.modelo;

import java.io.Serializable;

public class Cliente implements Serializable{
	private static final long serialVersionUID=1L;
	private String dni;
	private int tipoDocumento;
	private String nombre;
	private String email;
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public int getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(int tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
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
	@Override
	public String toString() {
		return "Cliente [dni=" + dni + ", tipoDocumento=" + tipoDocumento + ", nombre=" + nombre + ", email=" + email
				+ "]";
	}
	
}
