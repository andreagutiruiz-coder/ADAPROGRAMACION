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
DefaultListModel tiposModelo = new DefaultListModel<>();
DefaultListModel AcumuladoModelo = new DefaultListModel<>();
	private static final long serialVersionUID = 1L;
	private JTextField textNombre;
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
		
		tiposModelo.addElement("PET");
        tiposModelo.addElement("Cartón");
        tiposModelo.addElement("Aluminio");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 612, 404);
		getContentPane().setLayout(null);
		
		JList listResiduo = new JList();
		listResiduo.setBounds(34, 91, 121, 145);
		getContentPane().add(listResiduo);
		listResiduo.setModel(tiposModelo);
		
		JLabel lblNewLabel = new JLabel("RESIDUO");
		lblNewLabel.setBounds(72, 69, 44, 12);
		getContentPane().add(lblNewLabel);
		
		JList listAcumulado = new JList();
		listAcumulado.setBounds(302, 106, 274, 87);
		getContentPane().add(listAcumulado);
		listAcumulado.setModel(AcumuladoModelo);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre del estudiante:");
		lblNewLabel_1.setBounds(10, 25, 121, 12);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("TOTAL DE PUNTOS ACUMULADOS");
		lblNewLabel_2.setBounds(336, 69, 168, 12);
		getContentPane().add(lblNewLabel_2);
		
		textNombre = new JTextField();
		textNombre.setBounds(136, 22, 96, 18);
		getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		textKilos = new JTextField();
		textKilos.setBounds(136, 268, 96, 18);
		getContentPane().add(textKilos);
		textKilos.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Peso Recolectado en KG:");
		lblNewLabel_3.setBounds(10, 271, 208, 12);
		getContentPane().add(lblNewLabel_3);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JButton btnNewButton = new JButton("Agregar Recolectado");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tipo = (String) listResiduo.getSelectedValue(); 
					double peso = Double.parseDouble(textKilos.getText());
					String estudiante = textNombre.getText();
					Residuo nuevo = new Residuo(tipo, peso, estudiante);
					listaResiduos.add(nuevo);
					JOptionPane.showMessageDialog(null, "Guardado correctamente");
					textNombre.setText("");
					textKilos.setText("");
					listResiduo.clearSelection();
				
			}
			
		});
		menuBar.add(btnNewButton);
		
		JButton btnCalcular = new JButton("Calcular Puntos");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		menuBar.add(btnCalcular);

	}
}
