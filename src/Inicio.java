/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import jpl.*;

/**
 *
 * @author silvia
 */
public class Inicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        VentanaPrincipal ventana = new VentanaPrincipal();
        ventana.setVisible(true);
        Query q;
	q= new Query("consult('mantenimiento.pl')");
	System.err.println(q.hasSolution());

	/*Consulta consult = new Consulta();

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
          }*/
    }

}
