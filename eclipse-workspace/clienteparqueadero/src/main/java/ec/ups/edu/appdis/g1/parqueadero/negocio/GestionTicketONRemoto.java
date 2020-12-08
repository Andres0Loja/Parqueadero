package ec.ups.edu.appdis.g1.parqueadero.negocio;

import java.util.List;

import ec.ups.edu.appdis.g1.parqueadero.modelo.Cliente;
import ec.ups.edu.appdis.g1.parqueadero.modelo.Vehiculo;

public interface GestionTicketONRemoto {

	public boolean registrarCliente(Cliente cliente) throws Exception;
	public boolean registrarVehiculo(Vehiculo vehiculo) throws Exception;
	public List<Cliente> getClientesTipo1();
	}
