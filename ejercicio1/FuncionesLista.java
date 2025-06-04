package ejercicio1;

import java.util.ArrayList;

/***
 * Interfaz que contiene un único método en su contrato, con la finalidad
 * de añadir, modificar o eliminar funciones al menú que opera sobre la lista
 * de empleados.
 * 
 * Devuelve por return y recibe por parámetros un ArrayList de empleados.
 */
public interface FuncionesLista {
	ArrayList<Empleado> aplicar(ArrayList<Empleado> lista);
}
