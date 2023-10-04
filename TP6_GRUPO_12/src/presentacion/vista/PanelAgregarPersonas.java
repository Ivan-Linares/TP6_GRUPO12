package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PanelAgregarPersonas extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtnombre;
	private JTextField txtapellido;
	private JTextField txtdni;
	private JButton btnaceptar;

	public PanelAgregarPersonas() {
		setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(82, 38, 66, 23);
		add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(82, 73, 66, 23);
		add(lblApellido);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(82, 117, 66, 23);
		add(lblDni);
		
		btnaceptar = new JButton("Aceptar");
		btnaceptar.setBounds(82, 169, 112, 32);
		add(btnaceptar);
		
		txtnombre = new JTextField();
		txtnombre.setBounds(158, 38, 131, 23);
		add(txtnombre);
		txtnombre.setColumns(10);
		
		txtapellido = new JTextField();
		txtapellido.setColumns(10);
		txtapellido.setBounds(158, 73, 131, 23);
		add(txtapellido);
		
		txtdni = new JTextField();
		txtdni.setColumns(10);
		txtdni.setBounds(158, 117, 131, 23);
		add(txtdni);

	}

	
	public JButton getBtnaceptar() {
		return btnaceptar;
	}


	public void setBtnaceptar(JButton btnaceptar) {
		this.btnaceptar = btnaceptar;
	}


	public JTextField getTxtnombre() {
		return txtnombre;
	}

	public void setTxtnombre(JTextField txtnombre) {
		this.txtnombre = txtnombre;
	}

	public JTextField getTxtapellido() {
		return txtapellido;
	}

	public void setTxtapellido(JTextField txtapellido) {
		this.txtapellido = txtapellido;
	}

	public JTextField getTxtdni() {
		return txtdni;
	}

	public void setTxtdni(JTextField txtdni) {
		this.txtdni = txtdni;
	}
	
	
}