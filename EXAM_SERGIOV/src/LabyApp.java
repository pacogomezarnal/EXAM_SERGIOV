import Modelo.ConexionDB;
import Vista.Principal;


public class LabyApp {

	public static void main(String[] args) {
		//Realizamos la conexión a la base de datos
		ConexionDB conexion;
		conexion=ConexionDB.getInstance("localhost", "thelaby", "root", "");
		
		//Comprobamos si se ha conectado correctamente
		if(conexion.connectDB()){
			System.out.println("Se ha conectado");
		}else{
			System.out.println("No se ha conectado");
		}
		
		//Lanzamos el jFrame
		Principal principal = new Principal();
		principal.setVisible(true);

	}

}
