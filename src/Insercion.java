/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kenneth
 */
import java.util.ArrayList;
import jpl.*;
public class Insercion {
 Consulta consult = new Consulta();  
 Fecha fdate= new Fecha();

	//agregar paciente
	public boolean setPaciente(String id,String nombre,String edad, String genero,String tel,String padecimiento,String nivel){
		Query q;
		q=new Query("assert(paciente("+id+","+nombre+","+edad+","+genero+","+tel+","+padecimiento+","+nivel+"))");
		System.err.println(q.hasSolution());
		q=new Query("tell('mantenimiento.pl'),listing(area/1),listing(padecimiento/2),listing(doctor/3),listing(paciente/7),listing(cita/3),told.");
		System.err.println(q.hasSolution());
		if(q.hasSolution()==true){

			return true;
		}
		return false;
	}

	//agregar area
	public boolean setArea(String area){
		Query q;
		q=new Query("assert(area("+area+"))");
		System.err.println(q.hasSolution());
		q=new Query("tell('mantenimiento.pl'),listing(area/1),listing(padecimiento/2),listing(doctor/3),listing(paciente/7),listing(cita/3),told.");
		System.err.println(q.hasSolution());
		if(q.hasSolution()==true){

			return true;
		}
		return false;

	}
	//agregar padecimiento
	public boolean setPadecimiento(String pade, String area){
		Query q;
		q=new Query("assert(padecimiento("+pade+","+area+"))");
		System.err.println(q.hasSolution());
		q=new Query("tell('mantenimiento.pl'),listing(area/1),listing(padecimiento/2),listing(doctor/3),listing(paciente/7),listing(cita/3),told.");
		System.err.println(q.hasSolution());
		if(q.hasSolution()==true){

			return true;
		}
		return false;

	}

	//agregar doctor
	public boolean setDoctor(String nombre, String area,String can ){
		Query q;
		q=new Query("assert(doctor("+nombre+","+area+","+can+"))");
		System.err.println(q.hasSolution());
		q=new Query("tell('mantenimiento.pl'),listing(area/1),listing(padecimiento/2),listing(doctor/3),listing(paciente/7),listing(cita/3),told.");
		System.err.println(q.hasSolution());
		if(q.hasSolution()==true){

			return true;
		}
		return false;
	}


	//agregar cita
		public boolean setCita(String id_paciente, String doc,java.sql.Date fecha ){
			Query q;
			q=new Query("assert(cita("+id_paciente+","+doc+","+fecha+"))");
			System.err.println(q.hasSolution());
			q=new Query("tell('mantenimiento.pl'),listing(area/1),listing(padecimiento/2),listing(doctor/3),listing(paciente/7),listing(cita/3),told.");
			System.err.println(q.hasSolution());
			if(q.hasSolution()==true){

				return true;
			}
			return false;
		}
                
                
                //determinar cita
                public String determinarCita(java.sql.Date fecha, String id,String pade, String nivel){
                    //asignacion de fechas tentativas
                    java.sql.Date Ft=fecha;
                    if(nivel.equals("bajo")){
                        Ft=fdate.sumarFechasDias(fecha,14);
                        
                    }
                    
                    if(nivel.equals("medio")){
                        Ft=fdate.sumarFechasDias(fecha,2);
                        
                    }
                    if(nivel.equals("alto")){
                        Ft=fecha;
                        
                    }                    
                    
                 ArrayList<String> area= consult.getAreaPadecimiento(pade);
                 ArrayList<String> docs= consult.getDoctoresArea(area.get(0));
                 String docA=" ";
                  int cant=0;
                 //int CanA=0;
                 for(int i=0;i>-1;i++){
                     
                     for(int x=0;x<docs.size();x++){
                        
                        ArrayList<String> cantidadC=consult.getCantidadDoctor(docs.get(x));
                        cant = (java.lang.Integer.parseInt(cantidadC.get(0)));
                        ArrayList<String> cantidadA= consult.getCitasDoc(docs.get(x),Ft.toString());
                        if(cantidadA.size()<cant){
                            docA=docs.get(x);
                           break; 
                        }
                                               
                     }//cierre for docs
                     if(docA!=" "){
                         java.sql.Date FechaD= fdate.sumarFechasDias(Ft,i);
                         setCita(id,docA,FechaD);
                         return "Fecha: "+FechaD.toString()+" Doctor: "+docA+"";
                         
                        
                        }//cierre if
                 }// cierre for dias
                 
                    return "Error";
                }
}
