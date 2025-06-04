package ejercicio1;

import java.util.Comparator;

/**
 * Clase específica que implementa la interfaz Comparator y sobreescribe
 * su método compare. Concretamente invirtiendo el orden natural de la 
 * clase de ascendente a descendente.
 */
public class OrdenarPorNombreDescendente implements Comparator<Empleado> {

	/**
	 * Aqui simplemente utilizo el método compareTo ya sobreescrito y le 
	 * añado el simbolo menos para invertir el resultado.
	 */
	@Override
	public int compare(Empleado e1, Empleado e2) {
		return - e1.compareTo(e2);
	}

}
