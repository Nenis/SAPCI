#include <stdio.h>
int main() {
  system("javac -cp jpl.jar Consulta.java VentanaAsignacionCita.java VentanaConsultas.java VentanaMantenimiento.java VentanaPrincipal.java Inicio.java");
  system("./run.sh");
  return 0;
}
