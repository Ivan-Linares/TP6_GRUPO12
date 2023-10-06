package Main;

import negocio.PersonaNegocio;
import negocioImpl.PersonaNegocioImpl;
import presentacion.controlador.Controlador;
import presentacion.vista.VentanaPrincipal;

public class Principal {

	public static void main(String[] args) 
	{
		VentanaPrincipal vista = new VentanaPrincipal();
		PersonaNegocio negocio = new PersonaNegocioImpl();
		Controlador controlador = new Controlador(vista, negocio);
		controlador.inicializar();
	}

}
