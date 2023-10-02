package entidad;

public class Persona 
{
	private String DNI;
	private String Nombre;
	private String Apellido;
	
	public Persona(){}
	
	public Persona(String DNI, String Nombre, String Apellido)
	{
		this.DNI = DNI;
		this.Nombre = Nombre;
		this.Apellido = Apellido;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	@Override
	public String toString() {
		return Nombre + " " + Apellido + " " + DNI;
	}
}
