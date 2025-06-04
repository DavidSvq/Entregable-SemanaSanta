package ejercicio1;


/**
 * Creación de la Clase que controla la válidez de lo datos de la edad, hereda de 
 * IllegalArgumentExcepcion (Clase ya existente en Java que se usa para el mismo fin).
 * De los 4 posibles constructores sólo declara uno para admitir un mensaje.
 * Los otros 2, aparte del constructor vacio, aún no tengo muy claro para que se usan
 * pero creo que es para incluir el tipo de excepción concreta en sí, es decir, cuando 
 * se crea una excepción personalizada, pero realmente se produce por un error
 * más general ya recogido, se pasa también ese error general como información. Por ejemplo,
 * si creas una excepción personalizada sobre el error al buscar un empleado, con el mensaje
 * "Error, empelado no encontrado" , podrías tapar el error general null point exception. 
 * Con el constructor que acepta la causa, podrías registrar tanto la clase personalizada, no
 * se encontró empleado, tanto como la causa real que fue por null. Aún tengo que profundizar
 * más en esto.
 * 
 * @SuppresWarnings() anotación usada para avisar al compilador que ignore ciertos tipos de
 * advertencias. En este caso el Serial, de la clase Serializable que se usa para fragmentar 
 * y mantener la integridad del código al convertirlo en binario ya que facilita su envio.
 * 
 */

@SuppressWarnings("serial")
public class EdadNoValidaException extends IllegalArgumentException {
	
	/*Constructor*/
	public EdadNoValidaException(String message) {
		super(message);
	}		
}
