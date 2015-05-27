package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;

public class Principal extends JFrame {

	private JPanel contentPane;
	private Usuario usuario = new Usuario(this);
	private Equipo equipo = new Equipo(this);
	private Comprobacion comprobacion = new Comprobacion(this);

	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 489, 405);
		
		this.setTitle("THE LABY");
		this.setResizable(false);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		//Añadimos los JPanel al contentPane
		contentPane.add(usuario,"Usuario");
		contentPane.add(equipo,"Equipo");
		contentPane.add(comprobacion,"Comprobacion");
	}
	
	
	
	
	//Métodos para poder cambiar de Paneles
	public void ponerEquipo(){
		CardLayout c = (CardLayout) contentPane.getLayout();
		c.show(contentPane, "Equipo");
	}
	
	public void ponerComprobacion(){
		CardLayout c = (CardLayout) contentPane.getLayout();
		c.show(contentPane, "Comprobacion");
	}
	
	public void ponerUsuario(){
		CardLayout c = (CardLayout) contentPane.getLayout();
		c.show(contentPane, "Usuario");
	}

}
