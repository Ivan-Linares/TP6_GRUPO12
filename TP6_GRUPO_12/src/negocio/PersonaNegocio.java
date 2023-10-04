package negocio;

import java.util.ArrayList;
import entidad.Persona;

public interface PersonaNegocio {
	
	public boolean insertar(Persona persona);
	public boolean modificar(Persona persona);
	public boolean eliminar(Persona persona);
	public ArrayList<Persona>listar();
	public boolean PersonaRegistrada(int id);
	
}
