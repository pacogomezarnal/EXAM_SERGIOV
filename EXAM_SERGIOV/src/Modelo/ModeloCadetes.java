package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ModeloCadetes {
		
		//CONSULTAS A LA BASE DE DATOS
		private final static String SELECT_CADETE="SELECT * FROM cadetes WHERE id=33";
		private final static String SELECT_CADETES_EQUIPOS="SELECT * FROM cadetes WHERE equipo=2";
		private final static String COD_ID="id";
		private final static String COD_NOMBRE="nombre";
		private final static String COD_APELLIDOS="apellidos";
		private final static String COD_EDAD="edad";
		private final static String COD_NACIONALIDAD="nacionalidad";
		private final static String COD_EQUIPO="equipo";
		
		//Conexion
		private Connection conexion = null;// maneja la conexió
		private Statement instruccion = null;
		private ResultSet conjuntoResultados = null;
		private ArrayList<String[]> cadetes;
		private ArrayList<String> cadetesEquipos;
		private ArrayList<String[]> datos_Cadetes;


		public ModeloCadetes() {
			//Obtenemos la conexion de datos
			conexion=ConexionDB.getConexion();		
		}
		
		//Metodo para saber los cadetes del equipo 2
		public ArrayList<String> Cadete_Equipos(){
			cadetesEquipos = new ArrayList<String>();
			try{
				instruccion = this.conexion.createStatement();
				conjuntoResultados = instruccion.executeQuery(SELECT_CADETES_EQUIPOS);
				
				while(conjuntoResultados.next()){
					cadetesEquipos.add(conjuntoResultados.getString(COD_NOMBRE));
				}
			}
			catch( SQLException excepcionSql ) 
			{
				excepcionSql.printStackTrace();
			}
			finally{
				try{
					conjuntoResultados.close();
					instruccion.close();
				}
				catch( SQLException excepcionSql ) 
				{
					excepcionSql.printStackTrace();
				}
			}
			
			return cadetesEquipos;
		}
		
		//Metodo para saber los datos, segun el nombre proporcionado
		public ArrayList<String[]> Datos_Cadete(String nombre){
			datos_Cadetes=new ArrayList<String[]>();
			try{
				instruccion = this.conexion.createStatement();
				conjuntoResultados = instruccion.executeQuery("SELECT * FROM cadetes WHERE nombre='"+nombre+"'");
				
				while(conjuntoResultados.next()){
					String[] datos_cadete = new String[6];
					datos_cadete[0]=conjuntoResultados.getString(COD_ID);
					datos_cadete[1]=conjuntoResultados.getString(COD_NOMBRE);
					datos_cadete[2]=conjuntoResultados.getString(COD_APELLIDOS);
					datos_cadete[3]=conjuntoResultados.getString(COD_EDAD);
					datos_cadete[4]=conjuntoResultados.getString(COD_NACIONALIDAD);
					datos_cadete[5]=conjuntoResultados.getString(COD_EQUIPO);
					datos_Cadetes.add(datos_cadete);
				}
			}
			catch( SQLException excepcionSql ) 
			{
				excepcionSql.printStackTrace();
			}
			finally{
				try{
					conjuntoResultados.close();
					instruccion.close();
				}
				catch( SQLException excepcionSql ) 
				{
					excepcionSql.printStackTrace();
				}
			}
			
			return datos_Cadetes;
		}
		
		//Metodo para saber los datos del cadete id:33
		public ArrayList<String[]> Cadete(){
			cadetes=new ArrayList<String[]>();
			try{
				instruccion = this.conexion.createStatement();
				conjuntoResultados = instruccion.executeQuery(SELECT_CADETE);
				
				while(conjuntoResultados.next()){
					String[] cadete = new String[6];
					cadete[0]=conjuntoResultados.getString(COD_ID);
					cadete[1]=conjuntoResultados.getString(COD_NOMBRE);
					cadete[2]=conjuntoResultados.getString(COD_APELLIDOS);
					cadete[3]=conjuntoResultados.getString(COD_EDAD);
					cadete[4]=conjuntoResultados.getString(COD_NACIONALIDAD);
					cadete[5]=conjuntoResultados.getString(COD_EQUIPO);
					cadetes.add(cadete);
				}
			}
			catch( SQLException excepcionSql ) 
			{
				excepcionSql.printStackTrace();
			}
			finally{
				try{
					conjuntoResultados.close();
					instruccion.close();
				}
				catch( SQLException excepcionSql ) 
				{
					excepcionSql.printStackTrace();
				}
			}
			
			return cadetes;
		}

}
