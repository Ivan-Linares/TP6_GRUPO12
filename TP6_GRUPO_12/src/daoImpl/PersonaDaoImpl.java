package daoImpl;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.IPersona;
import entidad.Persona;

public class PersonaDaoImpl implements IPersona
{
	private static final String insertar = "INSERT INTO personas(dni, nombre, apellido) VALUES(?, ?, ?)";
	private static final String modificar = "UPDATE personas SET Nombre=?,Apellido=? WHERE Dni=?";
	private static final String eliminar = "DELETE FROM personas WHERE dni = ?";
	private static final String listar = "SELECT * FROM personas";
	
	
	@Override
	public boolean Insertar(Persona nuevaPersona) 
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();	
		boolean EstadoInsert = false;
		
		try
		{
			statement = conexion.prepareStatement(insertar);
			statement.setString(1, nuevaPersona.getDNI());
			statement.setString(2, nuevaPersona.getNombre());
			statement.setString(3, nuevaPersona.getApellido());
			
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				EstadoInsert = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try 
			{
				conexion.rollback();
			} 
			catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
		}
		
		return EstadoInsert;
	}

	@Override
	public boolean Modificar(Persona modificarPersona) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Eliminar(Persona eliminarPersona) {
		
		PreparedStatement statement;
		Connection con = Conexion.getConexion().getSQLConexion();
		boolean eliminado = false;
		
		try {
			statement = con.prepareStatement(eliminar);
			statement.setString(1, eliminarPersona.getApellido());
			if(statement.executeUpdate() > 0) {
				con.commit();
				eliminado = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return eliminado;
		
	}

	@Override
	public ArrayList<Persona> Listar() {
		
		ArrayList<Persona> personas = new ArrayList<Persona>();
		Connection con = Conexion.getConexion().getSQLConexion();
		
		try {
			Statement st = (Statement) con.createStatement();
			ResultSet rs = ((java.sql.Statement) st).executeQuery(listar);
			while(rs.next()) {
				Persona persona = new Persona();
				persona.setDNI(rs.getString("dni"));
				persona.setNombre(rs.getString("nombre"));
				persona.setApellido(rs.getString("apellido"));
				personas.add(persona);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return personas;
		
	}

}
