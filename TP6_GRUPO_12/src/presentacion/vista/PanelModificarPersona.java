package presentacion.vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;

import entidad.Persona;

public class PanelModificarPersona extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField txtDni;
	private JTextField txtApellido;
	private JButton btnModificar;
	private JList<Persona> listPersonas;


	public PanelModificarPersona() {
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Seleccione Persona que desea Modificar");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel, BorderLayout.NORTH);
		
		listPersonas = new JList<Persona>();
		add(listPersonas, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		FlowLayout fl_panel = new FlowLayout(FlowLayout.LEFT, 3, 6);
		panel.setLayout(fl_panel);
		
		txtNombre = new JTextField();
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		panel.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtDni = new JTextField();
		txtDni.setEditable(false);
		panel.add(txtDni);
		txtDni.setColumns(10);
		
		btnModificar = new JButton("Modificar");
		panel.add(btnModificar);

	}
	
	public void setModelList(ListModel<Persona> model) {
		this.listPersonas.setModel(model);
	}
	
	public JButton getBtnModificar() {
		return btnModificar;
	}
	
	public JList<Persona> getListPersonas() {
		return listPersonas;
	}
	
	public void setTxtDni(String txtDni) {
		this.txtDni.setText(txtDni);
	}
	
	public String getDNI() {
		if (!listPersonas.isSelectionEmpty()){
			return listPersonas.getSelectedValue().getDNI();
		}
		else return "";
	}
	
	public void setTxtNombre(String txtNombre) {
		this.txtNombre.setText(txtNombre);
	}
	
	public String getNombre() {
		if (!listPersonas.isSelectionEmpty()) {
			return listPersonas.getSelectedValue().getNombre();
		}
		else return "";
	}
	
	public void setTxtApellido(String txtApellido) {
		this.txtApellido.setText(txtApellido);
	}
	
	public String getApellido() {
		if (!listPersonas.isSelectionEmpty()) {
			return listPersonas.getSelectedValue().getApellido();
		}
		else return "";
	}
	
	public String getTxtDNI() {
		return txtDni.getText();
	}
	
	public String getTxtNombre() {
		return txtNombre.getText();
	}
	
	public String getTxtApellido() {
		return txtApellido.getText();
	}
	
	
	
	
}