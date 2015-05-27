package Vista;

import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Modelo.Cadete;
import Modelo.ModeloCadetes;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Equipo extends JPanel {
	private JTextField textNombre;
	private JTextField textId;
	private JTextField textApellido1;
	private JTextField textApellido2;
	private JTextField textNacionalidad;
	private ModeloCadetes modeloCadetes;
	private String[]datos_cadete;
	private Cadete cadete;

	public Equipo(Principal principal) {
		setBounds(100, 100, 469, 385);
		setLayout(null);
		
		//Equipo
		JLabel lblEquipo = new JLabel("Equipo");
		lblEquipo.setBounds(27, 38, 55, 14);
		add(lblEquipo);
		
		
		//ComboBox
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(27, 63, 114, 20);
		
		//Creamos el objeto ModeloCadetes
		modeloCadetes = new ModeloCadetes();
		
		//Llenamos el comboBox
		Iterator<String> it = modeloCadetes.Cadete_Equipos().iterator();
		while(it.hasNext()){
			comboBox.addItem((String)it.next());
		}
		add(comboBox);
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Nos guardamos en un array los daots proporcionados por Datos_Cadete()
				Iterator<String[]> it_Datos_Cadete =  modeloCadetes.Datos_Cadete((String)comboBox.getSelectedItem()).iterator();
				while(it_Datos_Cadete.hasNext()){
					datos_cadete = it_Datos_Cadete.next();
				}
				
				//Generamos un objecto Cadete
				cadete = new Cadete((Integer.parseInt(datos_cadete[0])),datos_cadete[1],datos_cadete[2],(Integer.parseInt(datos_cadete[3])),datos_cadete[4],(Integer.parseInt(datos_cadete[5])));
				
				//Ponemos y cogemos los campos Que necesitamos
				textNombre.setText(cadete.getNombre());
				textId.setText(String.valueOf(cadete.getId()));
				textNacionalidad.setText(cadete.getNacionalidad());
				textApellido1.setText(primer_Apellido());
				textApellido2.setText(segundo_Apellido());

			}
		});
		
		
		//Nombre
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(166, 38, 67, 14);
		add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setEditable(false);
		textNombre.setBounds(166, 63, 143, 20);
		add(textNombre);
		textNombre.setColumns(10);
		
		//Id
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(333, 38, 46, 14);
		add(lblId);
		
		textId = new JTextField();
		textId.setEditable(false);
		textId.setBounds(333, 63, 104, 20);
		add(textId);
		textId.setColumns(10);
		
		//1er Apellido
		JLabel lblerApellido = new JLabel("1er Apellido");
		lblerApellido.setBounds(166, 99, 78, 14);
		add(lblerApellido);
		
		textApellido1 = new JTextField();
		textApellido1.setEditable(false);
		textApellido1.setBounds(166, 124, 143, 20);
		add(textApellido1);
		textApellido1.setColumns(10);
		
		//2º Apellido
		JLabel lblApellido = new JLabel("2\u00BA Apellido");
		lblApellido.setBounds(166, 161, 67, 14);
		add(lblApellido);
		
		textApellido2 = new JTextField();
		textApellido2.setEditable(false);
		textApellido2.setBounds(166, 186, 143, 20);
		add(textApellido2);
		textApellido2.setColumns(10);
		
		//Nacionalidad
		JLabel lblNacionalidad = new JLabel("Nacionalidad");
		lblNacionalidad.setBounds(166, 228, 86, 14);
		add(lblNacionalidad);
		
		textNacionalidad = new JTextField();
		textNacionalidad.setEditable(false);
		textNacionalidad.setBounds(166, 253, 143, 20);
		add(textNacionalidad);
		textNacionalidad.setColumns(10);
		
		//Boton Atras
		JButton btnAtras = new JButton("<< Atr\u00E1s");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				principal.ponerUsuario();
			}
		});
		btnAtras.setBounds(27, 326, 114, 23);
		add(btnAtras);
		
		//Boton Siguiente
		JButton btnSiguiente = new JButton("Siguiente >>");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				principal.ponerComprobacion();
			}
		});
		btnSiguiente.setBounds(333, 326, 104, 23);
		add(btnSiguiente);
		
		

	}
	
	//Métodos para separar Apellidos
	public String primer_Apellido(){
		String[] primerApellido;
		
		primerApellido = cadete.getApellidos().split(" ");
		
		return primerApellido[0];
	}
	
	public String segundo_Apellido(){
		String[] primerApellido;
		
		primerApellido = cadete.getApellidos().split(" ");
		
		return primerApellido[1];
	}
}
