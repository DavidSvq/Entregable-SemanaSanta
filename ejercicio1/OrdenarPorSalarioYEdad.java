package ejercicio1;

import java.util.Comparator;

/**
 * Clase específica que implementa la interfaz Comparator y sobreescribe
 * su método compare. Concretamente teniendo en cuenta el salario y la edad
 * respectivamente.
 */
public class OrdenarPorSalarioYEdad implements Comparator<Empleado> {
	/**
	 * Consideración especial: Al trabajar con decimales, es bastante conveniente
	 * por no decir necesario(más abajo encontraras una alternativa que se me ocurrio
	 * una vez estaba repasando y comentando el código), usar la clase Double y su 
	 * método compare, ya personalizado para datos del tipo double. El principal 
	 * problema es el casteo a int (tipo de dato con el que trabaja el método compare 
	 * y la sobreescritura no permite cambiarlo), da igual cuando se realizara ya que 
	 * en algún momento se pierden datos, por ejemplo: 5,25 y 5,70 serían iguales, es 
	 * decir devolvería 0 cuando no es así. 
	 * Otra opción que se me ocurre, más rocambolesca, sería multiplicar por 100 (o 10, 
	 * pero es más probable que el primer decimal sea 0) y entonces ordenar 52 y 57 ó 
	 * 525 y 570. Pero me resulta mas elegante y precisa, igualmente, usar el compare 
	 * de la clase Double, ya que la igualdad en caso contrario se establece en el múltiplo
	 * de 10 (100, 1000, 10000, etc...) que se use.
	 */
	@Override
	public int compare(Empleado e1, Empleado e2) {
		int comparacion = Double.compare(e1.getSalario(), e2.getSalario());
		if(comparacion == 0) {
			comparacion = e1.getEdad() - e2.getEdad();
		}
		return comparacion;
	}

}
