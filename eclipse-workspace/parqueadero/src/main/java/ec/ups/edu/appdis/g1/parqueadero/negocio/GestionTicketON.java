package ec.ups.edu.appdis.g1.parqueadero.negocio;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.ups.edu.appdis.g1.parqueadero.dao.ClienteDAO;
import ec.ups.edu.appdis.g1.parqueadero.dao.VehiculoDAO;
import ec.ups.edu.appdis.g1.parqueadero.modelo.Cliente;
import ec.ups.edu.appdis.g1.parqueadero.modelo.Ticket;
import ec.ups.edu.appdis.g1.parqueadero.modelo.Vehiculo;

@Stateless
public class GestionTicketON implements GestionTicketONRemoto{
	@Inject
	private ClienteDAO daoCliente;
	@Inject
	private VehiculoDAO daoVehiculo;

	public boolean registrarCliente(Cliente cliente) throws Exception {
		 if (cliente.getDni().length() != 10)
	            throw new Exception("La cedula no cumple con la longitud correcta");
	        try {
	            daoCliente.insertJPA(cliente);
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new Exception("Error al registrar");
	        }
	        return true;
	    }

	public boolean registrarVehiculo(Vehiculo vehiculo) throws Exception {
		if (validarPlaca(vehiculo.getPlaca())) 
			try {
				daoVehiculo.insert(vehiculo);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new Exception("Error al registrar");
			}
		 else 
			throw new Exception("Número de placa incorrecto");
		
		return true;
	}
	private boolean validarPlaca(String placa) {
		if(placa.length()==7)
			return true;
		return false;
	}
	public List<Cliente> getClientesTipo1(){
		return daoCliente.getClientes();
	}
}
