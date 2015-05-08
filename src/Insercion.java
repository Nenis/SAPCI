/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kenneth
 */
import jpl.*;
public class Insercion {
    

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
			q=new Query("assert(doctor("+id_paciente+","+fecha+","+doc+"))");
			System.err.println(q.hasSolution());
			q=new Query("tell('mantenimiento.pl'),listing(area/1),listing(padecimiento/2),listing(doctor/3),listing(paciente/7),listing(cita/3),told.");
			System.err.println(q.hasSolution());
			if(q.hasSolution()==true){

				return true;
			}
			return false;
		}
}
