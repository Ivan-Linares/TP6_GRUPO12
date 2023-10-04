package presentacion.vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import entidad.Persona;

public class PanelEliminarPersona extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JList<Persona> listPersonas;
	private JButton btnEliminar;
	
	public PanelEliminarPersona() {
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Eliminar Usuarios");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel, BorderLayout.NORTH);
		
		listPersonas = new JList<Persona>();
		add(listPersonas, BorderLayout.CENTER);
		
		btnEliminar = new JButton("Eliminar");
		add(btnEliminar, BorderLayout.SOUTH);

	}

}