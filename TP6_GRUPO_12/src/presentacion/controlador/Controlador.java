package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;


import entidad.Persona;
import negocioImpl.PersonaNegocioImpl;
import negocio.PersonaNegocio;
import presentacion.vista.PanelAgregarPersonas;
import presentacion.vista.PanelEliminarPersona;
import presentacion.vista.PanelListarPersona;
import presentacion.vista.PanelModificarPersona;
import presentacion.vista.VentanaPrincipal;

public class Controlador {
	private PersonaNegocio Pnegocio;
	private VentanaPrincipal ventaprincipal;
	private PanelAgregarPersonas panelAgregar;
	private PanelModificarPersona panelModificar;
	private PanelEliminarPersona panelEliminar;
	private PanelListarPersona panelListar;
	private ArrayList<Persona> lista;
	
	
	public Controlador(VentanaPrincipal ventap, PersonaNegocio pnegocio ) {
		super();
		this.ventaprincipal = ventap;
		this.Pnegocio = pnegocio;
		
		this.panelAgregar = new PanelAgregarPersonas();
		this.panelModificar = new PanelModificarPersona();
		this.panelEliminar = new PanelEliminarPersona();
		this.panelListar = new PanelListarPersona();
		
		//VENTANA Principal
		this.ventaprincipal.getMntmAgregar().addActionListener(a->EventoClickMenu_AbrirPanel_AgregarPersona(a));
		this.ventaprincipal.getMntmModificar().addActionListener(b->EventoClickMenu_AbrirPanel_ModificarPersona(b));
		this.ventaprincipal.getMntmEliminar().addActionListener(c->EventoClickMenu_AbrirPanel_EliminarPersona(c));
		this.ventaprincipal.getMntmListar().addActionListener(d->EventoClickMenu_AbrirPanel_ListarPersona(d));
		
		//PANEL AGREGAR
		//TODO: SOLUCIONAR NULL POINTER
		//this.panelAgregar.getBtnaceptar().addActionListener(a->EventoClick_AgregarPersona(a));

	}

	
	
	private void EventoClick_AgregarPersona(ActionEvent a) {
		
		String Apellido=this.panelAgregar.getTxtapellido().getText();
		String Nombre=this.panelAgregar.getTxtnombre().getText();
		String DNI=this.panelAgregar.getTxtdni().getText();
		
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
	
	
	
	private Object EventoClickMenu_AbrirPanel_ListarPersona(ActionEvent d) {
		this.ventaprincipal.getContentPane().removeAll();
		this.ventaprincipal.getContentPane().add(panelListar);
		this.ventaprincipal.getContentPane().repaint();
		this.ventaprincipal.getContentPane().revalidate();
		return null;
	}
	private Object EventoClickMenu_AbrirPanel_EliminarPersona(ActionEvent c) {
		this.ventaprincipal.getContentPane().removeAll();
		this.ventaprincipal.getContentPane().add(panelEliminar);
		this.ventaprincipal.getContentPane().repaint();
		this.ventaprincipal.getContentPane().revalidate();
		return null;
	}
	private Object EventoClickMenu_AbrirPanel_ModificarPersona(ActionEvent b) {
		this.ventaprincipal.getContentPane().removeAll();
		this.ventaprincipal.getContentPane().add(panelModificar);
		this.ventaprincipal.getContentPane().repaint();
		this.ventaprincipal.getContentPane().revalidate();
		return null;
	}
	private Object EventoClickMenu_AbrirPanel_AgregarPersona(ActionEvent a) {
		this.ventaprincipal.getContentPane().removeAll();
		this.ventaprincipal.getContentPane().add(panelAgregar);
		this.ventaprincipal.getContentPane().repaint();
		this.ventaprincipal.getContentPane().revalidate();
		return null;
	}
	
	public void inicializar()
	{
		this.ventaprincipal.setVisible(true);
	}
}
