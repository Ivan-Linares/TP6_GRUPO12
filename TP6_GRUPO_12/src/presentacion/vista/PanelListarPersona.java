package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PanelListarPersona extends JPanel {

	private JTable table;

	/**
	 * Create the panel.
	 */
	public PanelListarPersona() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 37, 467, 222);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);

	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

}
