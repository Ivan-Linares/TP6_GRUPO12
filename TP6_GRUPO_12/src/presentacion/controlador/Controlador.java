package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.sun.accessibility.internal.resources.accessibility;

import entidad.Persona;
import negocioImpl.PersonaNegocioImpl;

public class Controlador {
	private VentanaPrincipal ventaprincipal;
	private PersonaNegocioImpl Pnegocio;
	private ArrayList<Persona> lista;
	
	
	public Controlador(VentanaPrincipal ventap, PersonaNegocioImpl pnegocio) {
		super();
		this.ventaprincipal = ventap;
		this.Pnegocio = pnegocio;
		
		this.ventaprincipal.getbtnAgregar().addActionListener(a->ventanaAgregarPersona(a));
		this.ventaprincipal.getbtnModificar().addActionListener();
		this.ventaprincipal.getbtnEliminar().addActionListener();
		this.ventaprincipal.getbtnListar().addActionListener();
	}
	private void ventanaAgregarPersona(ActionEvent a) {
		String Apellido=txtApellido.gettext();
		String Nombre=txtNombre.gettext();
		String DNI=txtdni.gettext();
		if(CamposCompletos(DNI, Apellido, Nombre)==true) {
			if(!Pnegocio.PersonaRegistrada(Integer.parseInt(DNI))) {
				Persona obj= new Persona();
				obj.setDNI(DNI);
				obj.setApellido(Apellido);
				obj.setNombre(Nombre);
				Pnegocio.insertar(obj);				
			}
			else {
				JOptionPane.showMessageDialog(null, "DNI ya registrado. ");
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Es necesario completar todos los campos. ");
		}
	}
	private boolean CamposCompletos(String dNI, String apellido, String nombre) {
		String vacio="";
		if(dNI.equals(vacio) || apellido.equals(vacio) || nombre.equals(vacio)) {
			return false;
		}
		return true;
	}
}
