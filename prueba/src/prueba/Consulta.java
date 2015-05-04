package prueba;

import java.util.ArrayList;
import jpl.*;
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
	public ArrayList<String> getAreas(){
		ArrayList<String> arregloAreas = new ArrayList<String>();
		
		Query q;
		
		q = new Query ("area(X)");
		
		while (q.hasMoreSolutions()){
			Hashtable solution = q.nextSolution();
			Term t =  (Term) solution.get("X");
			String areaEncontrada = t.toString();
			arregloAreas.add(areaEncontrada);
		}
		return arregloAreas;
		
	}
	
	// Padecimientos del ebais
	public ArrayList<String> getPadecimientos(){
		Query q;
		q = new Query ("padecimiento(X,_)");
		ArrayList<String> arregloPadecimientos = new ArrayList<String>();
		
		Hashtable[] solutions = q.allSolutions();
		
		for ( int i=0 ; i < solutions.length ; i++ ) { 
			Term t = (Term)solutions[i].get("X"); 
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
		
		q = new Query("padecimiento(" + padecimiento +",X)");
		Hashtable solution = q.oneSolution();
		Term t = (Term) solution.get("X");
		String result = t.toString();
				
		return result;
	}
	
	
	
	
	
	
}
