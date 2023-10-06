package presentacion.vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


	public class VentanaPrincipal extends JFrame {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private JPanel contentPane;
		private JMenuBar menuBar;
		private JMenu mnPersona;
		private JMenuItem mntmAgregar;
		private JMenuItem mntmModificar;
		private JMenuItem mntmEliminar;
		private JMenuItem mntmListar;


		public VentanaPrincipal() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 556, 391);
			
			menuBar = new JMenuBar();
			setJMenuBar(menuBar);
			
			mnPersona = new JMenu("Persona");
			menuBar.add(mnPersona);
			
			mntmAgregar = new JMenuItem("Agregar");
			mntmAgregar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					PanelAgregarPersonas nuevo = new PanelAgregarPersonas();
					nuevo.setVisible(true);
				}
			});
			mnPersona.add(mntmAgregar);
			
			mntmModificar = new JMenuItem("Modificar");
			mnPersona.add(mntmModificar);
			
			mntmEliminar = new JMenuItem("Eliminar");
			mnPersona.add(mntmEliminar);
			
			mntmListar = new JMenuItem("Listar");
			mnPersona.add(mntmListar);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(new BorderLayout(0, 0));
			setContentPane(contentPane);
		}


		public JMenu getMnPersona() {
			return mnPersona;
		}


		public void setMnPersona(JMenu mnPersona) {
			this.mnPersona = mnPersona;
		}


		public JMenuItem getMntmAgregar() {
			return mntmAgregar;
		}


		public void setMntmAgregar(JMenuItem mntmAgregar) {
			this.mntmAgregar = mntmAgregar;
		}


		public JMenuItem getMntmModificar() {
			return mntmModificar;
		}


		public void setMntmModificar(JMenuItem mntmModificar) {
			this.mntmModificar = mntmModificar;
		}


		public JMenuItem getMntmEliminar() {
			return mntmEliminar;
		}


		public void setMntmEliminar(JMenuItem mntmEliminar) {
			this.mntmEliminar = mntmEliminar;
		}


		public JMenuItem getMntmListar() {
			return mntmListar;
		}


		public void setMntmListar(JMenuItem mntmListar) {
			this.mntmListar = mntmListar;
		}
		
		
}
