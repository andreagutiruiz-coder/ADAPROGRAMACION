import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuiReciclaje extends JFrame {
	ArrayList<Residuo> listaResiduos = new ArrayList();
	DefaultListModel<Residuo> Residuomodelo = new DefaultListModel();
	DefaultListModel AcumuladoModelo = new DefaultListModel<>();
	private static final long serialVersionUID = 1L;
	private JTextField textEstudiante;
	private JTextField textNombre;
	private JTextField textPeso;
	

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
		list.setBounds(34, 149, 121, 145);
		list.setModel(Residuomodelo);
		getContentPane().add(list);

		JLabel lblNewLabel = new JLabel("RESIDUO");
		lblNewLabel.setBounds(68, 107, 44, 12);
		getContentPane().add(lblNewLabel);

		JList list_1 = new JList();
		list_1.setBounds(302, 106, 274, 87);
		list_1.setModel(AcumuladoModelo);
		getContentPane().add(list_1);

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
		
		textNombre = new JTextField();
		textNombre.setBounds(136, 35, 96, 18);
		getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		textPeso = new JTextField();
		textPeso.setBounds(136, 66, 96, 18);
		getContentPane().add(textPeso);
		textPeso.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Nombre");
		lblNewLabel_3.setBounds(34, 38, 44, 12);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("peso");
		lblNewLabel_4.setBounds(34, 69, 44, 12);
		getContentPane().add(lblNewLabel_4);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JButton btnNewButton = new JButton("Agregar Recolectado");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String estudiante =textEstudiante.getText();
				String Nombre= textNombre.getText();
				double Peso =Double.parseDouble(textPeso.getText());
				Residuo nuevo=new Residuo(estudiante,Nombre,Peso);
			listaResiduos.add(nuevo);
			muestraelementos();
			
			
			}
		});
		menuBar.add(btnNewButton);

		JButton btnCalcular = new JButton("Calcular Puntos");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String estudiante =textEstudiante.getText();
				String Nombre= textNombre.getText();
				double PET = 0;
				double Carton = 0;
				double Aluminio = 0;
				double puntosp=0;
				double puntosc=0;
				double puntosa=0;
				double Acumulado=0;
                int ppet =25;
                int pAlum=40;
                int pcart=15;
				for (Residuo r : listaResiduos) {
					 if (r.getEstudiante().equals(estudiante)) {
				    if (r.getNombre().equalsIgnoreCase("PET")) {
				        PET = PET +r.getPeso();
				        puntosp= PET*ppet;
				       
				    } else if (r.getNombre().equalsIgnoreCase("Carton")) {
				        Carton=Carton + r.getPeso();
				        puntosc= Carton*pcart;
				        
				       
				    } else if (r.getNombre().equalsIgnoreCase("Aluminio")) {
				        Aluminio=Aluminio + r.getPeso();
				        puntosa= Aluminio*pAlum;
				        
				    }
				    Acumulado=puntosp+puntosc+puntosa;
				}
				    	 
					 AcumuladoModelo.removeAllElements();
					 AcumuladoModelo.addElement("PET de puntaje "+puntosp);
					 AcumuladoModelo.addElement("Carton de puntaje "+puntosc);
					 AcumuladoModelo.addElement("Aluminio de puntaje "+puntosa);
					AcumuladoModelo.addElement("totalacumulado "+Acumulado);
			}
				}
		});
		menuBar.add(btnCalcular);

	}
public void muestraelementos() {
	Residuomodelo.removeAllElements();
	for(Residuo i:listaResiduos) {
		Residuomodelo.addElement(i);
		}
}
}