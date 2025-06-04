package ejercicio1;


/**
 * Creación de la Clase que controla la válidez de lo datos del salario, hereda de 
 * IllegalArgumentExcepcion (Clase ya existente en Java que se usa para el mismo fin).
 * Más detalles en la clase EdadNoValidaException.
 */
@SuppressWarnings("serial")
public class SalarioNoValidoException extends IllegalArgumentException {

	/*Constructor*/
	public SalarioNoValidoException(String message) {
		super(message);
	}
}
