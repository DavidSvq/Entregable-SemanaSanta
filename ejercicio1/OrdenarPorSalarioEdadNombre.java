package ejercicio1;

import java.util.Comparator;

/**
 * Clase específica que implementa la interfaz Comparator y sobreescribe
 * su método compare. Concretamente ordenando primero por salario, después
 * por edad y por último el nombre.
 */
public class OrdenarPorSalarioEdadNombre implements Comparator<Empleado> {
	/***
	 * Mismas consideranciones para el tipo de dato double. Ver clase 
	 * OrdenarPorSalarioYEdad. Después aplico 2 if en caso que la comparación
	 * anterior dictamine que son iguales.
	 */
	@Override
	public int compare(Empleado e1, Empleado e2) {
		int comparacion = Double.compare(e1.getSalario(), e2.getSalario());
		if(comparacion == 0) {
			comparacion = e1.getEdad() - e2.getEdad();
			if(comparacion == 0) {
				comparacion = e1.compareTo(e2);
			}
		}
		return comparacion;
	}

}
