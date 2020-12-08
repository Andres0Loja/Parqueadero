package ec.ups.edu.appdis.g1.parqueadero.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ec.ups.edu.appdis.g1.parqueadero.modelo.Cliente;
import ec.ups.edu.appdis.g1.parqueadero.negocio.GestionTicketONRemoto;

import javax.naming.Context;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.awt.event.ActionEvent;


import javax.naming.InitialContext;


public class VentanaCliente {

	private JFrame frame;
	private JTextField txtNombre;
	private JTextField txtDNI;
	private JTextField txtEmail;

	private GestionTicketONRemoto on;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCliente window = new VentanaCliente();
					window.referenciarONCliente();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaCliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(10, 11, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(66, 8, 86, 20);
		frame.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("DNI");
		lblNewLabel_1.setBounds(10, 36, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtDNI = new JTextField();
		txtDNI.setBounds(66, 39, 86, 20);
		frame.getContentPane().add(txtDNI);
		txtDNI.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setBounds(10, 61, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		txtEmail = new JTextField();
		txtEmail.setText("");
		txtEmail.setBounds(66, 70, 86, 20);
		frame.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarCliente();
			}
		});
		btnNewButton.setBounds(66, 101, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}

	protected void guardarCliente() {
		Cliente c=new Cliente();
		c.setDni(txtDNI.getText());
		c.setEmail(txtEmail.getText());
		c.setNombre(txtNombre.getText());
		c.setTipoDocumento(1);
		
		try {
			on.registrarCliente(c);
			System.out.print("Guardado OK");
			System.out.print(on.getClientesTipo1());
		} catch (Exception e) {
			System.out.print("Error al guardar");
			e.printStackTrace();
		}
	}
	
	public void referenciarONCliente() throws Exception {
		try {
			final Hashtable<String, Comparable> jndiProperties = new Hashtable<String, Comparable>();
			jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY,
					"org.wildfly.naming.client.WildFlyInitialContextFactory");
			jndiProperties.put("jboss.naming.client.ejb.context", true);

			jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
			jndiProperties.put(Context.SECURITY_PRINCIPAL, "pepe");
			jndiProperties.put(Context.SECURITY_CREDENTIALS, "pepe");

			final Context context = new InitialContext(jndiProperties);

			final String lookupName = "ejb:/parqueadero/GestionTicketON!ec.ups.edu.appdis.g1.parqueadero.negocio.GestionTicketONRemoto";

			this.on = (GestionTicketONRemoto) context.lookup(lookupName);

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

}
