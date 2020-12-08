package ec.ups.edu.appdis.g1.parqueadero.modelo;

import java.io.Serializable;

public class Vehiculo implements Serializable{
	private String placa;
	private String marca;
	private String color;
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
}
