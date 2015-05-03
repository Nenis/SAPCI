package prueba;

import jpl.*;

public class Test {
	 
	  public static void main(String[] args) {
	    Query q;
	    String prueba = "perro(maria)";
	    q = new Query("consult('foo.pl')");
	    System.err.println(q.hasSolution());
	    q = new Query("perro(a)");
	    System.err.println(q.hasSolution());
	    q = new Query(prueba);
	    System.err.println(q.hasSolution());
	    q = new Query("perro(c)");
	    System.err.println(q.hasSolution());
	    q = new Query("perro(X)");
	    System.err.println(q.hasSolution());
	 
	    while (q.hasMoreElements()) {
	      System.err.println(q.nextElement());
	    }
	  }
	}
