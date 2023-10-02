package negocioImpl;
import java.util.ArrayList;

import dao.IPersona;
import daoImpl.PersonaDaoImpl;
import entidad.Persona;
import negocio.PersonaNegocio;

public class PersonaNegocioImpl implements PersonaNegocio {
	
	IPersona personaDao = new PersonaDaoImpl();

	@Override
	public boolean insertar(Persona persona) {
		boolean estado = false;
		estado = personaDao.Insertar(persona);
		return estado;
	}

	@Override
	public boolean eliminar(Persona persona) {
		boolean estado = false;
		estado = personaDao.Eliminar(persona);
		return estado;
	}

	@Override
	public ArrayList<Persona>listar() {
		return personaDao.Listar();
	}

	@Override
	public boolean modificar(Persona persona) {
		// TODO Auto-generated method stub
		return false;
	}

}

