import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.AbstractButton;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuiReciclaje extends JFrame {

ArrayList <Residuo> listaResiduos= new ArrayList<>();
DefaultListModel Residuomodelo = new DefaultListModel<>();	
DefaultListModel AcumuladoModelo = new DefaultListModel<>();

	private static final long serialVersionUID = 1L;
	private JTextField textEstudiante;
	private JTextField textKilos;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiReciclaje frame = new GuiReciclaje();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GuiReciclaje() {

		Residuomodelo.addElement("PET");
        Residuomodelo.addElement("Carton");
        Residuomodelo.addElement("Aluminio");


        
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 612, 404);
		getContentPane().setLayout(null);

		JList listResiduo = new JList();
		listResiduo.setBounds(60, 106, 121, 145);
		listResiduo.setModel(Residuomodelo);
		getContentPane().add(listResiduo);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 612, 404);
		getContentPane().setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("RESIDUO");
		lblNewLabel.setBounds(87, 84, 44, 12);
		getContentPane().add(lblNewLabel);


		
		JList listAcumulado = new JList();
		listAcumulado.setBounds(302, 106, 274, 87);
		getContentPane().add(listAcumulado);
		listAcumulado.setModel(AcumuladoModelo);
		

		JLabel lblNewLabel_1 = new JLabel("Nombre del estudiante:");
		lblNewLabel_1.setBounds(10, 13, 121, 12);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("TOTAL DE PUNTOS ACUMULADOS");
		lblNewLabel_2.setBounds(336, 69, 168, 12);
		getContentPane().add(lblNewLabel_2);

		textEstudiante = new JTextField();
		textEstudiante.setBounds(136, 10, 96, 18);
		getContentPane().add(textEstudiante);
		textEstudiante.setColumns(10);

		textKilos = new JTextField();
		textKilos.setBounds(146, 38, 96, 18);
		getContentPane().add(textKilos);
		textKilos.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Peso Recolectado en KG:");
		lblNewLabel_5.setBounds(10, 41, 208, 12);
		getContentPane().add(lblNewLabel_5);
		

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JButton btnNewButton = new JButton("Agregar Recolectado");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				String tipo = (String) listResiduo.getSelectedValue(); 
				double peso = Double.parseDouble(textKilos.getText());
				String estudiante = textEstudiante.getText();
				Residuo nuevo = new Residuo(estudiante, tipo, peso);
				listaResiduos.add(nuevo);
				JOptionPane.showMessageDialog(null, "Guardado correctamente");
				textKilos.setText("");
				listResiduo.clearSelection();
			}
			
		});
		menuBar.add(btnNewButton);

		JButton btnCalcular = new JButton("Calcular Puntos");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String estudiante = textEstudiante.getText();
				double PET = 0;
				double Carton = 0;
				double Aluminio = 0;
				int ppet = 25;
				int pAlum = 40;
				int pcart = 15;

				for (Residuo r : listaResiduos) {
					if (r.getEstudiante().equals(estudiante)) {
						if (r.getNombre().equalsIgnoreCase("PET")) {
							PET = PET + r.getPeso();
						} else if (r.getNombre().equalsIgnoreCase("Carton")) {
							Carton = Carton + r.getPeso();
						} else if (r.getNombre().equalsIgnoreCase("Aluminio")) {
							Aluminio = Aluminio + r.getPeso();
						}
					}
				}

				double puntosp = PET * ppet;
				double puntosc = Carton * pcart;
				double puntosa = Aluminio * pAlum;
				double Acumulado = puntosp + puntosc + puntosa;

				AcumuladoModelo.removeAllElements();
				AcumuladoModelo.addElement("PET de puntaje " + puntosp);
				AcumuladoModelo.addElement("Carton de puntaje " + puntosc);
				AcumuladoModelo.addElement("Aluminio de puntaje " + puntosa);
				AcumuladoModelo.addElement("Total acumulado " + Acumulado);
			}
				
		});
		menuBar.add(btnCalcular);

	}

}
