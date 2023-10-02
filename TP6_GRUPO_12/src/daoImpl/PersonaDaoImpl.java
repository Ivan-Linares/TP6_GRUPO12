package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import dao.IPersona;
import entidad.Persona;

public class PersonaDaoImpl implements IPersona
{
	private static final String insertar = "INSERT INTO personas(dni, nombre, apellido) VALUES(?, ?, ?)";
	private static final String modificar = "UPDATE personas SET Nombre=?,Apellido=? WHERE Dni=?";
	private static final String eliminar = "DELETE FROM personas WHERE dni = ?";
	private static final String listar = "SELECT * FROM personas";
	
	Connection conexion = Conexion.getConexion().getSQLConexion();
	
	@Override
	public boolean Insertar(Persona nuevaPersona) 
	{
		PreparedStatement statement;
		
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Persona> Listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
