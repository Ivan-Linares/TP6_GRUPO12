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
	private JTable tPersonas;

	
	
	public PanelEliminarPersona() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Eliminar Usuarios");
		lblNewLabel.setBounds(0, 0, 450, 14);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(0, 277, 450, 23);
		add(btnEliminar);
		
		tPersonas = new JTable();
		tPersonas.setBounds(10, 25, 440, 250);
		add(tPersonas);

	}
	
	
	public JTable gettPersonas() {
		return tPersonas;
	}
	public int getRowstPersonas() {
		return tPersonas.getSelectedRow();
	}

	public String getValueSelected(int fila, int col) {
		return (String) tPersonas.getValueAt(fila, col);
	}

	public void settPersonas(JTable tPersonas) {
		this.tPersonas = tPersonas;
	}


	public JButton getBtnEliminar() {
		return btnEliminar;
	}
	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}
}