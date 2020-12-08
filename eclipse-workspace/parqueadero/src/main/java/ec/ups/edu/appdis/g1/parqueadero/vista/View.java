package ec.ups.edu.appdis.g1.parqueadero.vista;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.ups.edu.appdis.g1.parqueadero.modelo.Cliente;
import ec.ups.edu.appdis.g1.parqueadero.negocio.GestionTicketON;

/**
 * Servlet implementation class View
 */
@WebServlet("/Vista")
public class View extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/*@Inject
	GestionTicketON on;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
			
		response.getWriter().println("Soy Loco");
		Cliente cliente = new Cliente();
		cliente.setDni("0107137416");
		cliente.setNombre("f");
		cliente.setEmail("ds");
		cliente.setTipoDocumento(1);
		
		try {
			on.registrarCliente(cliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/



}
