package daoImpl;

//import java.beans.Statement;
import java.sql.Statement;

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
	private static final String PersonaRegistrada = "SELECT * FROM personas where DNI=?";
	
	
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
		PreparedStatement st;
		Connection conexion = Conexion.getConexion().getSQLConexion();	
		boolean Modificado = false;
		try {
			st = conexion.prepareStatement(modificar);
			st.setString(1, modificarPersona.getNombre());
			st.setString(2, modificarPersona.getApellido());
			st.setString(3, modificarPersona.getDNI());
			if(st.executeUpdate() > 0) {
				conexion.commit();
				Modificado = true;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return Modificado;
	}

	@Override
	public boolean Eliminar(Persona eliminarPersona) {
		
		PreparedStatement statement;
		Connection con = Conexion.getConexion().getSQLConexion();
		boolean eliminado = false;
		
		try {
			statement = con.prepareStatement(eliminar);
			statement.setString(1, eliminarPersona.getDNI());
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
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(listar);
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


	@Override
	public boolean PersonaRegistrada(int DNI) {
		boolean registrada=false;
		PreparedStatement st;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		try {
			st = conexion.prepareStatement(PersonaRegistrada);
			st.setString(1, String.valueOf(DNI));
			if(st.execute()) {
				registrada=true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return registrada;
	}

}
