package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
		this.panelAgregar.getBtnaceptar().addActionListener(a->EventoClick_AgregarPersona(a));

	}

	
	
	private void EventoClick_AgregarPersona(ActionEvent a) {
		
		/*String Apellido=this.panelAgregar.getTxtapellido().getText();
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
		}*/
		
		//GERMAN: REVISAR, el insert funciona pero tira error. Revisar el metodo listar
		
		String mensaje;
		boolean existe = false;
		String nombre = this.panelAgregar.getTxtnombre().getText();
		String apellido = this.panelAgregar.getTxtapellido().getText();
		String dni = this.panelAgregar.getTxtdni().getText();
		if(nombre.trim().isEmpty() 	 || 
		   apellido.trim().isEmpty() ||
		   dni.trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Es necesario completar todos los campos");
			return;
		}
		
		/* Guarda los datos de los textbox en una instancia de Persona, trae todos los datos de la base y los compara para ver si existe */
		Persona nPersona = new Persona(dni, nombre, apellido);
		ArrayList<Persona> list = new ArrayList<Persona>(Pnegocio.listar());
		for(Persona auxPersona : list) {
			if(auxPersona.getDNI().equals(nPersona.getDNI())) {
				existe = true;
			}
		}
		
		if(!existe) {
			/* Sigue en caso de que no exista */
			boolean estado = Pnegocio.insertar(nPersona);
			if(estado==true) {
				mensaje = "Persona Agregada con exito";
				this.panelAgregar.getTxtnombre().setText("");
				this.panelAgregar.getTxtapellido().setText("");
				this.panelAgregar.getTxtdni().setText("");
				}
			else {
				mensaje = "Error al cargar Persona";
				this.panelAgregar.getTxtnombre().setText("");
				this.panelAgregar.getTxtapellido().setText("");
				this.panelAgregar.getTxtdni().setText("");
			};
		}
		else {
			this.panelAgregar.getTxtnombre().setText("");
			this.panelAgregar.getTxtapellido().setText("");
			this.panelAgregar.getTxtdni().setText("");
			mensaje = "El usuario ya existe";
		}
		
		JOptionPane.showMessageDialog(null, mensaje);
		
	}
	private boolean CamposCompletos(String dNI, String apellido, String nombre) {
		String vacio="";
		if(dNI.equals(vacio) || apellido.equals(vacio) || nombre.equals(vacio)) {
			return false;
		}
		return true;
	}
	
	private Object EventoClickMenu_AbrirPanel_ListarPersona(ActionEvent d) {
		
		//GERMAN: REVISAR. Error con los tipos de dato.
		
		this.ventaprincipal.getContentPane().removeAll();
		this.ventaprincipal.getContentPane().add(panelListar);
		this.ventaprincipal.getContentPane().repaint();
		this.ventaprincipal.getContentPane().revalidate();
		ArrayList<Persona> list = new ArrayList<Persona>(Pnegocio.listar());
		DefaultTableModel model = new DefaultTableModel(new Object[] {"dni", "nombre", "apellido"}, 0);
		for (Persona persona : list) {
			model.addRow(new Object[] {persona.getDNI(), persona.getNombre(), persona.getApellido()});
		}
		this.panelListar.getTable().setModel(model);
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
