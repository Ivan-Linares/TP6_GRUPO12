package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.GridLayout;

public class PanelListaPersona extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tablePersonas;


	public PanelListaPersona() {
		setLayout(new GridLayout(1, 0, 0, 0));
		
		tablePersonas = new JTable();
		add(tablePersonas);

	}
}