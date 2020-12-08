package ec.ups.edu.appdis.g1.parqueadero.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;


import ec.ups.edu.appdis.g1.parqueadero.modelo.Cliente;

@Stateless
public class ClienteDAO {
	//
	@Inject
	private Connection con;
	
	@Inject
	private EntityManager em;
	
	private Cliente cliente;
	
	public ClienteDAO() {

	}

	public boolean insertJPA(Cliente entity) throws SQLException {
		em.persist(entity);
		return true;
	}
	
	public boolean insert(Cliente entity) throws SQLException {
		String sql = "Insert INTO cliente (dni, email, nombre, tipodocumento) VALUES(?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, entity.getDni());
		ps.setString(2, entity.getEmail());
		ps.setString(3, entity.getNombre());
		ps.setInt(4, entity.getTipoDocumento());
		ps.executeUpdate();
		ps.close();
		return true;
	}

	public boolean update(Cliente entity) throws SQLException {
		String sql = "Update Cliente (email, nombre, tipoDocumento) VALUES(?,?,?,?) where dni=" + entity.getDni();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, entity.getEmail());
		ps.setString(2, entity.getNombre());
		ps.setInt(3, entity.getTipoDocumento());
		ps.executeUpdate();
		ps.close();
		return true;
	}

	public Cliente read(int id) throws SQLException {
		String sql="SELECT * FROM Cliente WHERE dni=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet result = ps.executeQuery();
		while (result.next()) {
			cliente.setDni(result.getString(1));
			cliente.setEmail(result.getString(2));
			cliente.setNombre(result.getString(3));
			cliente.setTipoDocumento(result.getInt(4));
			return cliente;
		}
		
		return null;
	}

	public boolean delete(int id) throws SQLException {
		String sql = "DELETE FROM Cliente WHERE dni = " + id;
		PreparedStatement ps = con.prepareStatement(sql);
		ps.executeUpdate();
		ps.close();
		return true;
	}
	public List<Cliente> getClientes() {
		String jpql= "Select c from Cliente c where tipoDocumento =?1";
		Query q = em.createQuery(jpql, Cliente.class);
		q.setParameter(1, 1);
		return (List<Cliente>) q.getResultList();
	}
}
