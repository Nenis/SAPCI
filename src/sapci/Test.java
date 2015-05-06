package sapci;

import jpl.*;

public class Test {
	 
	  public static void main(String[] args) {
		Query q;
		q= new Query("consult('mantenimiento.pl')");
		System.err.println(q.hasSolution());
		
	   Consulta consult = new Consulta();

	  if (consult.isArea("emergencias") == true){
		System.out.println('1');
	    System.out.println(consult.getAreas("P"));
	    System.out.println('2');
	    System.out.println(consult.getPadecimientos("gonorrea4","A"));
	    System.out.println('3');
	    System.out.println(consult.getPadecimientosArea("emergencias"));
	    System.out.println('4');
	    System.out.println(consult.getAreaPadecimiento("gonorreaaa1"));
	    System.out.println('5');
	    System.out.println(consult.getDoctores());
	    System.out.println('6');
	    System.out.println(consult.isDoctor("jimenez"));
	    System.out.println('7');
	    System.out.println(consult.getAreaDoctor("jimeneee"));
	    System.out.println('8');
	    System.out.println(consult.getCantidadDoctor("andres"));
	    System.out.println('9');
	    System.out.println(consult.getDoctoresArea("emergencias"));
	    System.out.println("10");
	    System.out.println(consult.isPaciente("andres"));
	    System.out.println("11");
	    System.out.println(consult.getDatosPaciente("1"));
	    System.out.println("12");
	    
	    
	   }
	    
	  }
	}
/*System.err.println(q.hasSolution());
q = new Query("area(X)");
String result;
if(q.hasSolution() == true){
	result = q.oneSolution().toString();
	System.out.println(result);
}
public boolean isArea(){
	Query q1;
	Query q2;
	q1 = new Query("consult('mantenimiento.pl')");
	q2 = new Query("area(X)");
	System.out.println("llegue");
	if(q2.hasSolution() == true){
		System.out.println("llegue");
		return true;

	}
		
	else{
		return false;				
	}
}

Variable X = new Variable();

Query q1;
q1 = new Query("area(X)");
Hashtable solution = q1.oneSolution();
System.out.println(solution);
String resultado = solution.toString();
System.out.println(resultado);
Term t =(Term) solution.get("X");
String areaEncontrada = t.toString();
System.out.println(areaEncontrada);

*/
// tell('progra.pl'), write(:-dynamic paciente/1), nl, listing(paciente/1), told.