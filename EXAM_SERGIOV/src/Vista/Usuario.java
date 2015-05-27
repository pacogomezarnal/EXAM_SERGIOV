package Vista;

import java.awt.Image;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Modelo.Cadete;
import Modelo.ModeloCadetes;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Usuario extends JPanel {
	private JTextField textNombre;
	private JTextField textId;
	private JTextField textApellidos;
	private JTextField textEdad;
	private JTextField textNacionalidad;
	private ModeloCadetes modeloCadete;
	private String cadete[];
	private Cadete cadetes;

	public Usuario(Principal principal) {
		setBounds(100, 100, 469, 385);
		setLayout(null);
		
		//Label para imagen
		Image imagen = new ImageIcon(this.getClass().getResource("/Sergio.jpg")).getImage();
		JLabel labelImg = new JLabel("");
		labelImg.setBounds(21, 33, 200, 188);
		labelImg.setIcon(new ImageIcon(imagen));
		add(labelImg);
		
		//Creamos un objecto ModeloCadetes
		modeloCadete = new ModeloCadetes();
		
		//Dentro de un array, metemos los datos proporcionados por el metodo Cadete() 
		Iterator<String[]> it =  modeloCadete.Cadete().iterator();
		while(it.hasNext()){
			cadete = it.next();
		}
		
		//Creamos un objecto Cadete
		cadetes = new Cadete((Integer.parseInt(cadete[0])),cadete[1],cadete[2],(Integer.parseInt(cadete[3])),cadete[4],(Integer.parseInt(cadete[5])));
		
		
		//Nombre
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(247, 33, 58, 21);
		add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setEditable(false);
		textNombre.setBounds(247, 57, 130, 20);
		textNombre.setText(cadetes.getNombre());
		add(textNombre);
		textNombre.setColumns(10);
		
		//Id
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(413, 36, 46, 14);
		add(lblId);
		
		textId = new JTextField();
		textId.setEditable(false);
		textId.setBounds(413, 57, 46, 20);
		textId.setText(String.valueOf(cadetes.getId()));
		add(textId);
		textId.setColumns(10);
		
		
		//Apellidos
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(247, 111, 81, 14);
		add(lblApellidos);
		
		textApellidos = new JTextField();
		textApellidos.setEditable(false);
		textApellidos.setBounds(247, 136, 130, 20);
		textApellidos.setText(cadetes.getApellidos());
		add(textApellidos);
		textApellidos.setColumns(10);
		
		//Edad
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(247, 178, 46, 14);
		add(lblEdad);
		
		textEdad = new JTextField();
		textEdad.setEditable(false);
		textEdad.setBounds(247, 203, 130, 20);
		textEdad.setText(String.valueOf(cadetes.getEdad()));
		add(textEdad);
		textEdad.setColumns(10);
		
		//Nacionalidad
		JLabel lblNacionalidad = new JLabel("Nacionalidad");
		lblNacionalidad.setBounds(247, 250, 130, 14);
		add(lblNacionalidad);
		
		textNacionalidad = new JTextField();
		textNacionalidad.setEditable(false);
		textNacionalidad.setBounds(247, 275, 130, 20);
		textNacionalidad.setText(cadetes.getNacionalidad());
		add(textNacionalidad);
		textNacionalidad.setColumns(10);
		
		//Boton Siguiente
		JButton btnSiguiente = new JButton("Siguiente >>");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				principal.ponerEquipo();
			}
		});
		btnSiguiente.setBounds(332, 333, 127, 23);
		add(btnSiguiente);

	}
	
		
}
