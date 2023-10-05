package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.ListModel;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.annotation.processing.Completion;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.event.ListDataListener;

import daoImpl.PersonaDaoImpl;
import entidad.Persona;
import javax.swing.JTable;

public class PanelEliminarPersona extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnEliminar;
	private JList<Persona> list;

	
	
	public PanelEliminarPersona() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Eliminar Usuarios");
		lblNewLabel.setBounds(0, 0, 450, 14);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(0, 277, 450, 23);
		add(btnEliminar);
		
		list = new JList<Persona>();
		list.setBounds(22, 25, 407, 187);
		add(list);

	}
	

	public String getValueSelected() {
		return list.getSelectedValue().getDNI();
	}


	public void setModelList(ListModel<Persona> model) {
		this.list.setModel(model);
	}
	
	public JButton getBtnEliminar() {
		return btnEliminar;
	}
	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}
}