import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuiReciclaje extends JFrame {
ArrayList <Residuo> listaResiduos= new ArrayList();
DefaultListModel Residuomodelo = new DefaultListModel();
	private static final long serialVersionUID = 1L;
	private JTextField textNombre;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 612, 404);
		getContentPane().setLayout(null);
		
		JList list = new JList();
		list.setBounds(34, 91, 121, 145);
		getContentPane().add(list);
		
		JLabel lblNewLabel = new JLabel("RESIDUO");
		lblNewLabel.setBounds(72, 69, 44, 12);
		getContentPane().add(lblNewLabel);
		
		JList list_1 = new JList();
		list_1.setBounds(302, 106, 274, 87);
		getContentPane().add(list_1);
		
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
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JButton btnNewButton = new JButton("Agregar Recolectado");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
