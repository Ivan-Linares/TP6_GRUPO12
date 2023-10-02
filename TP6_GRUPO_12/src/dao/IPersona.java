package dao;

import java.util.List;

import entidad.Persona;

public interface IPersona 
{
	public boolean Insertar(Persona nuevaPersona);
	public boolean Modificar(Persona modificarPersona);
	public boolean Eliminar(Persona eliminarPersona);
	public List<Persona> Listar();
}
