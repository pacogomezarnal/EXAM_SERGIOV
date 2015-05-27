package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Modelo.IngresoLaby;

public class Comprobacion extends JPanel {
	private JTextField textId;
	private JTextField textApellido1;
	private JTextField textComprobar;
	private IngresoLaby ingresoLaby;
	private String mensaje;

	public Comprobacion(Principal principal) {
		setBounds(100, 100, 469, 385);
		setLayout(null);
		
		//Id
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(29, 54, 46, 14);
		add(lblId);
		
		textId = new JTextField();
		textId.setBounds(29, 79, 86, 20);
		add(textId);
		textId.setColumns(10);
		
		//Apellido
		JLabel lblerApellido = new JLabel("1er Apellido");
		lblerApellido.setBounds(144, 54, 86, 14);
		add(lblerApellido);
		
		textApellido1 = new JTextField();
		textApellido1.setBounds(144, 79, 120, 20);
		add(textApellido1);
		textApellido1.setColumns(10);
		
		
		//Boton Comprobar
		JButton btnComprobar = new JButton("COMPROBAR");
		btnComprobar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Llamamos al metodo comprobarCod y le proporcionamos los parametros
				ingresoLaby = new IngresoLaby();
				mensaje = ingresoLaby.comprobarCod(Integer.parseInt(textId.getText()), textApellido1.getText());
				textComprobar.setText(mensaje);
			}
		});
		btnComprobar.setBounds(29, 141, 430, 23);
		add(btnComprobar);
		
		//Comprobar
		textComprobar = new JTextField();
		textComprobar.setEditable(false);
		textComprobar.setBounds(29, 193, 430, 20);
		add(textComprobar);
		textComprobar.setColumns(10);
		
		//Boton Atras
		JButton btnAtras = new JButton("<< Atr\u00E1s");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				principal.ponerEquipo();
			}
		});
		btnAtras.setBounds(29, 333, 108, 23);
		add(btnAtras);
		
	}

}
