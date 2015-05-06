package sapci;

import java.util.ArrayList;
import java.lang.System;

import jpl.*;
import jpl.Integer;

import java.util.Hashtable;

public class Consulta {
	
	// Evalua si existe una area
	public boolean isArea(String area){
		Query q;
		q = new Query("area(" + area + ")");
		if(q.hasSolution() == true){
			return true;	
		}
		else{
			return false;				
		}
	}
	
	// Retorna una lista con las areas
	public ArrayList<String> getAreas(String area){
		ArrayList<String> arregloAreas = new ArrayList<String>();
		
		Query q;
		q= new Query("consult('mantenimiento.pl')");
		
		q = new Query ("area("+ area+")");
		while (q.hasMoreSolutions()){
			Hashtable solution = q.nextSolution();
			Term t =  (Term) solution.get(area);
			String areaEncontrada = t.toString();
			arregloAreas.add(areaEncontrada);
		}
		
		
		return arregloAreas;
		
	}
	
	// Padecimientos del ebais
	public ArrayList<String> getPadecimientos(String nombre, String area){
		Query q;
		// if nombre es N y area es A .getText equals con table
		q = new Query ("padecimiento("+nombre+","+area+")");
		ArrayList<String> arregloPadecimientos = new ArrayList<String>();
		
		Hashtable[] solutions = q.allSolutions();
		
		for ( int i=0 ; i < solutions.length ; i++ ) { 
			Term t = (Term)solutions[i].get(area); 
			String padecimientoEncontrado = t.toString();
			arregloPadecimientos.add(padecimientoEncontrado);
		}
		
		return arregloPadecimientos;
	}
	
	// Padecimientos de alguna area
	public ArrayList<String> getPadecimientosArea(String area){
		Query q;
		
		q = new Query ("padecimiento(X," + area + ")");
		ArrayList<String> arregloPadecimientos = new ArrayList<String>();
		
		while (q.hasMoreSolutions()){
			Hashtable solution = q.nextSolution();
			Term t = (Term) solution.get("X");
			String padecimientoEncontrado = t.toString();
			arregloPadecimientos.add(padecimientoEncontrado);
		}
		
		return arregloPadecimientos;
	}
	
	// Retorna el area de un padecimiento
	public String getAreaPadecimiento(String padecimiento){
		Query q;
		
		if (isPadecimiento(padecimiento)){
			q = new Query("padecimiento(" + padecimiento +",X)");
			Hashtable solution = q.oneSolution();
			Term t = (Term) solution.get("X");
			String result = t.toString();
					
			return result;
		}
		else {
			return "No existe";
		}
	
	}
	
	// Verifica si existe el padecimiento
	public boolean isPadecimiento(String padecimiento){
		Query q;
		
		q =  new Query("padecimiento(" + padecimiento + ",_)");
		
		return q.hasSolution();
	}
	
	
	// Retorna todos los doctores del ebais
	public ArrayList<String> getDoctores(){
		
		Query q;
		
		q = new Query("doctor(X,_,_)");
		
		ArrayList<String> arregloDoctores = new ArrayList<String>();
		Hashtable[] solutions = q.allSolutions();
		
		for ( int i=0 ; i < solutions.length ; i++ ) { 
			Term t = (Term)solutions[i].get("X"); 
			String doctorEncontrado = t.toString();
			arregloDoctores.add(doctorEncontrado);
		}
		
		return arregloDoctores;
		
	}
	
	
	// Verifica si el doctor existe
	public boolean isDoctor(String doctor){
		Query q;
		
		q = new Query ("doctor("+ doctor + ",_,_)");
		
		return q.hasSolution();
	}
	
	// Obtiene el area de un doctor
	public String getAreaDoctor(String doctor){
		Query q;
		
		if (isDoctor(doctor)){
			q = new Query("doctor("+ doctor + ",X,_)");
			
			Hashtable solution = q.oneSolution();
			Term t = (Term) solution.get("X");
			String result = t.toString();
			
			return result;
		}
		else{
			return "No existe";
		}
		
	}
	
	// Retorna la cantidad de personas que atiende un doctor
	public int getCantidadDoctor(String doctor){
		Query q;
		
		if (isDoctor(doctor)){
			q = new Query("doctor("+ doctor + ",_,X)");
			
			Hashtable solution = q.oneSolution();
			Term t = (Term) solution.get("X");
			int result = java.lang.Integer.parseInt(t.toString());
			
			return result;
		}
		else{
			return  0;
		}
	}	
	
	// Obtiene los doctores por area
	public ArrayList<String> getDoctoresArea(String area){
		Query q;

		q = new Query ("doctor(X," + area + ",_)");
		ArrayList<String> arregloDoctores = new ArrayList<String>();
		
		while (q.hasMoreSolutions()){
			Hashtable solution = q.nextSolution();
			Term t = (Term) solution.get("X");
			String doctorEncontrado = t.toString();
			arregloDoctores.add(doctorEncontrado);
		}
		
		return arregloDoctores;
	}
	
	// Existe paciente
	public boolean isPaciente(String idPaciente){
		Query q;
		
		q = new Query("paciente(" + idPaciente + ",_,_,_,_,_,_)");
		
		return q.hasSolution();
	}
	
	// Datos del paciente
	public ArrayList<String> getDatosPaciente(String idPaciente){
		Query q;

		ArrayList<String> arregloDatos = new ArrayList<String>();
		
		q = new Query("paciente("+idPaciente+",N,E,G,T,P,NI)");
		System.out.println(q.toString());
		
		Hashtable solution;
		Term t;
		String result;
		
		solution = q.oneSolution();
		t = (Term)solution.get("N");
		result = t.toString();
		arregloDatos.add(result);
		solution = q.oneSolution();
		t = (Term) solution.get("E");
		result = t.toString();
		arregloDatos.add(result);
		solution = q.oneSolution();
		t = (Term) solution.get("G");
		result = t.toString();
		arregloDatos.add(result);
		solution = q.oneSolution();
		t = (Term) solution.get("T");
		result = t.toString();
		arregloDatos.add(result);
		solution = q.oneSolution();
		t = (Term) solution.get("P");
		result = t.toString();
		arregloDatos.add(result);
		solution = q.oneSolution();
		t = (Term) solution.get("NI");
		result = t.toString();
		arregloDatos.add(result);
		
		
		return arregloDatos;
		
	}
	
	
}
	
	
	
	
	

