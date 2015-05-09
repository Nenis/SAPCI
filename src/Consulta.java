
import java.awt.List;
import java.util.ArrayList;

import jpl.*;

import java.util.Hashtable;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
	
	
        
        //
        public ArrayList<String> getPadecimientos(){
            Query q;
		
            q = new Query ("padecimiento(X,_)");
                Hashtable[] solutions = q.allSolutions();
                
                ArrayList<String> arregloPadecimientos = new ArrayList<String>();	
		for(int i = 0; i< solutions.length; i++){
                    Term t = (Term)solutions[i].get("X");
                    arregloPadecimientos.add(t.toString());
		
		}
		
		
		return arregloPadecimientos;
        }

	
	// Padecimientos de alguna area
	public ArrayList<String> getPadecimientosArea(String area){
		Query q;
		
		q = new Query ("padecimiento(X," + area + ")");
                Hashtable[] solutions = q.allSolutions();
                
                ArrayList<String> arregloPadecimientos = new ArrayList<String>();	
		for(int i = 0; i< solutions.length; i++){
                    Term t = (Term)solutions[i].get("X");
                    arregloPadecimientos.add(t.toString());
		
		
		}
		
		return arregloPadecimientos;
	}
        
        // Padecimientos de alguna area
	public ArrayList<String> getAreaPadecimiento(String pade){
		Query q;
		
		q = new Query ("padecimiento(" + pade + ",X)");
                Hashtable[] solutions = q.allSolutions();
                
                ArrayList<String> arregloPadecimientos = new ArrayList<String>();	
		for(int i = 0; i< solutions.length; i++){
                    Term t = (Term)solutions[i].get("X");
                    arregloPadecimientos.add(t.toString());
		
		
		}
		
		return arregloPadecimientos;
	}
	
	
	// Retorna el area de un padecimiento
	public ArrayList<String> getAreas(){
            Query q;
		q = new Query ("area(X)");
                Hashtable[] solutions = q.allSolutions();
                
                ArrayList<String> arregloAreas = new ArrayList<String>();
		for(int i = 0; i< solutions.length; i++){
                    Term t = (Term)solutions[i].get("X");
                    arregloAreas.add(t.toString());
		}
		
		
		return arregloAreas;
        }
	
	
	
	// Verifica si existe el padecimiento
	public boolean isPadecimiento(String padecimiento){
		Query q;
		
		q =  new Query("padecimiento(" + padecimiento + ",_)");
		
		return q.hasSolution();
	}
        // Verifica si el doctor existe
	public boolean isDoctor(String doctor){
		Query q;
		
		q = new Query ("doctor("+ doctor + ",_,_)");
		
		return q.hasSolution();
	}
	
	// Obtiene el area de un doctor
	public ArrayList<String> getDoctores(){
		Query q;
		

		q = new Query ("doctor(X,_,_)");
                Hashtable[] solutions = q.allSolutions();
                
                ArrayList<String> arregloDoc = new ArrayList<String>();	
		for(int i = 0; i< solutions.length; i++){
                    Term t = (Term)solutions[i].get("X");
                    arregloDoc.add(t.toString());
		
		}
		
		return arregloDoc;
		
		
	}
        
        // Obtiene el area de un doctor de un area especifica
	public ArrayList<String> getDoctoresArea(String area){
		Query q;
		

		q = new Query ("doctor(X,"+area+",_)");
                Hashtable[] solutions = q.allSolutions();
                
                ArrayList<String> arregloDoc = new ArrayList<String>();	
		for(int i = 0; i< solutions.length; i++){
                    Term t = (Term)solutions[i].get("X");
                    arregloDoc.add(t.toString());
		
		}
		
		return arregloDoc;
		
		
	}
	
	// Retorna la cantidad de personas que atiende un doctor
	public String getCantidadDoctor(String nom){
		Query q;
		q = new Query("doctor("+nom+",_,X)");
                Hashtable solution=q.oneSolution();
                Term t= (Term)solution.get("X");
		String can= t.toString();
		return can;

	}
        
        // Retorna la cantidad de citas asignadad
	public ArrayList<String> getCitasDoc(String nom, String fecha){
		Query q;
		q = new Query("cita(X,"+nom+","+fecha+")");
                Hashtable[] solutions = q.allSolutions();
               System.out.println(solutions.toString());
                ArrayList<String> arregloCant = new ArrayList<String>();	
	
		for(int i = 0; i< solutions.length; i++){
                    Term t = (Term)solutions[i].get("X");
                    arregloCant.add(t.toString());
		
		
		}
		System.out.println(nom+fecha);
		return arregloCant;

	}
        // Existe paciente
	public boolean isPaciente(String idPaciente){
		Query q;
		
		q = new Query("paciente(" + idPaciente + ",_,_,_,_,_,_)");
		
		return q.hasSolution();
	}
	
	
	// Retorna todos los doctores del ebais
	public void getDoctoresInter(String nombre, String area, String cantidad){
		Query q;
		q= new Query("consult('mantenimiento.pl')");
          
                System.err.println(q.hasSolution());
                
                String[] fila = new String[3];
                q = new Query ("doctor("+nombre+","+area+","+cantidad+")");
                    Hashtable[] solutions = q.allSolutions();
                    String [] Columnas = {"Doctor","Area de trabajo","Pacientes al dia"};
                    DefaultTableModel modelo = new DefaultTableModel(null,Columnas);
                    String n;
                    String a;
                    String c;
            if(solutions.length !=  0){    
                for ( int i=0 ; i < solutions.length ; i++ ) {    
                    if(nombre == "Doctores"){
                        n = solutions[i].get("Doctores").toString();
                    }
                    else{
                        n = nombre;
                    }
                    if(area == "Areas"){
                        a = solutions[i].get("Areas").toString();
                    }
                    else{
                        a = area;
                    }
                    if(cantidad == "Pacientes"){
                        c = solutions[i].get("Pacientes").toString();
                    }
                    else{
                        c = cantidad;
                    }
                    
                    fila[0]= n;
                    fila[1] = a;
                    fila[2]= c;
                    modelo.addRow(fila);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Los datos que desea consultar no se encuentran registrados en el sistema");
            }
                    
             
                VentanaConsultas.Tabla.setModel(modelo);
	}
        // Retorna una lista con las areas
	public void getAreasInter(){
		
		Query q;
		q= new Query("consult('mantenimiento.pl')");
                System.err.println(q.hasSolution());
                String[] fila = new String[1];
		q = new Query ("area(X)");
                Hashtable[] solutions = q.allSolutions();
                String [] Columnas = {"Areas disponibles"};
                DefaultTableModel modelo = new DefaultTableModel(null,Columnas);
            if(solutions.length != 0){    
		for ( int i=0 ; i < solutions.length ; i++ ){
                    Term t = (Term)solutions[i].get("X");
                    fila[0] = t.toString();
                    modelo.addRow(fila);
		}
            }
            else{
                JOptionPane.showMessageDialog(null, "Los datos que desea consultar no se encuentran registrados en el sistema");
            }
                VentanaConsultas.Tabla.setModel(modelo);
	}
	
	// Padecimientos del ebais
	public void getPadecimientosInter(String nombre, String area){
		Query q;
                q= new Query("consult('mantenimiento.pl')");
                System.err.println(q.hasSolution());
                
                 String[] fila = new String[2];


                String [] Columnas = {"Padecimientos","Area del padecimiento"};
		DefaultTableModel modelo = new DefaultTableModel(null,Columnas);
                
         
                q = new Query("padecimiento("+nombre+","+area+")");
                
                    Hashtable[] solutions = q.allSolutions();
                    String n;
                    String a;
            if(solutions.length != 0){    
                for ( int i=0 ; i < solutions.length ; i++ ) {    
                    if(nombre == "Padecimientos"){
                        n = solutions[i].get("Padecimientos").toString();
                    }
                    else{
                        n = nombre;
                    }
                    if(area == "Areas"){
                        a = solutions[i].get("Areas").toString();
                    }
                    else{
                        a = area;
                    }
         
      
                    fila[0]= n;
                    fila[1] = a;
                    modelo.addRow(fila);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Los datos que desea consultar no se encuentran registrados en el sistema");
            }
            VentanaConsultas.Tabla.setModel(modelo);

	}
	
	
	
	
	// Obtiene los doctores por area
	public ArrayList<String> getDoctoresAreaInter(String area){
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
        
	
	
	
	public void getDatosPacienteInter(String identificacion, String nombre, String edad, String genero, String telefono, String padecimiento,String nivel){
                    Query q;
                    q= new Query("consult('mantenimiento.pl')");
                    System.err.println(q.hasSolution());

                    String[] fila = new String[8];
                    q = new Query("paciente("+identificacion+","+nombre+","+edad+","+genero+","+telefono+","+padecimiento+","+nivel+")");
                    System.out.println(q.toString());
                    Hashtable[] solution = q.allSolutions();
                    String []  Columnas = {"Identificacion","Nombre","Edad","Genero","Telefono","Padecimiento","Nivel","Fecha de cita"};
                    DefaultTableModel modelo = new DefaultTableModel(null,Columnas);
  
                    String id;
                    String name;
                    String ed;
                    String gen;
                    String tel;
                    String pad;
                    String niv = null;
                    String fecha;

  
  
                    System.out.println(solution.length);
                    if (solution.length != 0){
                        for (int i = 0; i < solution.length; i++)
                        {
                            if("Identificaciones".equals(identificacion)){
                                id = solution[i].get("Identificaciones").toString();
                            }
                             else{
                                  id = identificacion;
                            }
                             if("Nombres".equals(nombre)){
                                    name = solution[i].get("Nombres").toString();
                            }
                            else{
                            name = nombre;
                            }
                            if("Edades".equals(edad)){
                                ed = solution[i].get("Edades").toString();
                             }
                            else{
                                ed = edad;
                            }
                            if("Generos".equals(genero)){
                                gen = solution[i].get("Generos").toString();
                            }
                            else{
                                gen = genero;
                            }
                            if("Telefonos".equals(telefono)){
                                tel = solution[i].get("Telefonos").toString();
                            }
                            else{
                                tel = telefono;
                            }
                            if("Padecimientos".equals(padecimiento)){
                                pad = solution[i].get("Padecimientos").toString();
                            }
                            else{
                                pad = padecimiento;
                            }
                            if("bajo".equals(nivel)){
                                niv = "bajo";
                             }
                            if("medio".equals(nivel)){
                                niv = "medio";
                            }
                            if("alto".equals(nivel)){
                                niv = "alto";
                            }
                            if("Todos".equals(nivel)){
                            niv = solution[i].get("Todos").toString();
                            }
                            q = new Query("cita("+id+",_,X)");
                            Term t = (Term)q.oneSolution().get("X");
                        
                            fecha = t.toString();
                            System.out.println(fecha);

                            fila[0] = id;
                            fila[1] = name;
                            fila[2] = ed;
                            fila[3] = gen;
                            fila[4] = tel;
                            fila[5] = pad;
                            fila[6] = niv;
                            fila[7] = fecha;
    
                            modelo.addRow(fila);
                        }
                    }    
                    else{
                        JOptionPane.showMessageDialog(null, "Los datos que desea consultar no se encuentran registrados en el sistema");
                    }
                VentanaConsultas.Tabla.setModel(modelo);
  }
        
        
        	// Obtiene el area de un doctor
	public ArrayList<String> getIdentificacion(){
		Query q;
		q = new Query ("paciente(X,_,_,_,_,_,_)");
                Hashtable[] solutions = q.allSolutions();
                
                ArrayList<String> arregloIdentificacion = new ArrayList<String>();	

		for(int i = 0; i< solutions.length; i++){
                    Term t = (Term)solutions[i].get("X");
                    arregloIdentificacion.add(t.toString());

		}
		
		return arregloIdentificacion;
		
	}
        
        
        public ArrayList<String> getNombrePaciente(){
		Query q;
		q = new Query ("paciente(_,X,_,_,_,_,_)");
                Hashtable[] solutions = q.allSolutions();

                
                ArrayList<String> arregloNombre = new ArrayList<String>();	
		for(int i = 0; i< solutions.length; i++){
                    Term t = (Term)solutions[i].get("X");
                    arregloNombre.add(t.toString());
		
		}
		
		
		return arregloNombre;
	}
        

 
        public ArrayList<String> getTelefono(){
		Query q;
		q = new Query ("paciente(_,_,_,_,X,_,_)");

                Hashtable[] solutions = q.allSolutions();
                
                ArrayList<String> arregloIdentificacion = new ArrayList<String>();	
		
		for(int i = 0; i< solutions.length; i++){
                    Term t = (Term)solutions[i].get("X");
                    arregloIdentificacion.add(t.toString());
		
		}
		
		return arregloIdentificacion;
	}
        
        public void getDatosCitaInter(String identificacion, String doctor, String fecha){
            Query q;
                q= new Query("consult('mantenimiento.pl')");
                System.err.println(q.hasSolution());
                
                 String[] fila = new String[3];


                String [] Columnas = {"Identificacion Paciente","Doctor","Fecha"};
		DefaultTableModel modelo = new DefaultTableModel(null,Columnas);
                
                q = new Query("cita("+identificacion+","+doctor+","+fecha+")");
            
                Hashtable[] solutions = q.allSolutions();
                String id;
                String dc;
                String fe;
                
            if(solutions.length != 0){    
                for ( int i=0 ; i < solutions.length ; i++ ) {    
                    if(identificacion == "Identificaciones"){
                        id = solutions[i].get("Identificaciones").toString();
                    }
                    else{
                        id = identificacion;
                    }
                    if(doctor == "Doctores"){
                        dc = solutions[i].get("Doctores").toString();
                    }
                    else{
                        dc = doctor;
                    }
                    if(fecha == "Fechas"){
                        fe = solutions[i].get("Fechas").toString();
                    }
                    else{
                       fe = fecha;
                    }
                    fe = fe.replace("-","");
                    fe = fe.replace(")","");
                     fe = fe.replace("(","");
                    fila[0] = id;
                    fila[1] = dc;
                    fila[2] = fe;
                    
                    modelo.addRow(fila);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Los datos que desea consultar no se encuentran registrados en el sistema");
            }
            VentanaConsultas.Tabla.setModel(modelo);

	}
        
            public ArrayList<String> getFechasCita(){
		Query q;
		q = new Query ("cita(_,_,X)");

                Hashtable[] solutions = q.allSolutions();
                
                ArrayList<String> arregloIdentificacion = new ArrayList<String>();	

		for(int i = 0; i< solutions.length; i++){
                    Term t = (Term)solutions[i].get("X");
                    
                     ArrayList<String> lista = new ArrayList<String>();
                     
                    String fecha = t.toString();    

                    
                
                    arregloIdentificacion.add(fecha.toString());
		
		}
		
		return arregloIdentificacion;
	}
            
}
        
        
 


	
	
	
	
	

