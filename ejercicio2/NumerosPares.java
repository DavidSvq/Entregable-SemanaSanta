package ejercicio2;

import java.util.InputMismatchException;
import java.util.Scanner;

/***
 * Para este ejercicio tuve en cuenta las siguientes consideraciones:
 * 
 * Creación de constantes para eliminar números mágicos.
 * 
 * Uso de 4 variables: 
 * 3 del tipo int, una para el números de pares a imprimir, otra para los pares en sí y la 
 * tercera para establecer un salto de línea por si los n pares a imprimir son muchos (más 
 * estético que funcional, ya que a la lógica del ejercicio no aporta nada). Y un booleano 
 * para controlar que si se produce una excepción se vuelva a solicitar por teclado los n 
 * pares deseados.
 * 
 * Control de Excepciones:
 * Para este ejercicio me valí de excepciones ya existentes en Java. 
 * Alguna que se puede personalizar, es decir indicar el mótivo (no confundir con el mensaje) 
 * por el que se lanza cuando es creada. Concretamente de IllegalArgumentsExcepción, que se encarga
 * de aquellas excepciones que queremos lanzar cuando el tipo de dato es correcto pero no válido 
 * según la lógica del programa. Es decir, por ejemplo, si esperamos una edad y nos introducen un 
 * valor negativo, el dato como tal es correcto puesto que se espera un int y el negativo lo es. 
 * Pero para nuestro programa, y lógica en general con la edad, no se puede tener un valor negativo. 
 * Por tanto es aplicable a datos de tipo correcto, pero que no cumplen nuestra lógica necesaria 
 * para el programa.
 * La segunda excepción usada y ya existente en Java, es justo lo contrario se lanza cuando la clase
 * Scanner recibe un tipo de dato que es incorrecto, por ejemplo se espera un int y se introduce un 
 * double o una letra. Por el contrario que la anterior, no es necesario crear un nuevo throw de ella, 
 * ya que esta es lanzada automáticamente, solo hay que recogerla. Otro consideración importante en 
 * esta excepción es que cuando se lanza, en el buffer queda el tipo de dato no válido que la lanzó,
 * por lo que si la recepción (catch) de esa excepción consiste en volver a solicitar el dato por teclado
 * este siempre se encontrará el tipo de dato incorrecto en el buffer, por ello hay que limpiarlo con
 * un salto de línea.
 * 
 * Otras consideraciones:
 * Para cumplir con el ejemplo mostrado en el ejercicio de como debe verse por pantalla, suprimo el 
 * salto de línea (ln) tras el print en los "sysos". Y añado una condición para que haya un salto de
 * línea cada X pares y otra para la información inicial que precede a los pares.
 * 
 */
public class NumerosPares {
	//Constantes
	public static final int INCREMENTO_DE_INDICADOR = 50;
	public static final int INCREMENTO_DE_PAR = 2;
	public static final int VALOR_INICIAL = 0;
	
	public static void main(String[] args) {
		Scanner tcld = new Scanner(System.in);
		int nVeces = VALOR_INICIAL;
		int pares = VALOR_INICIAL;
		int indicadorSaltoLinea = INCREMENTO_DE_INDICADOR;
		boolean nVecesEsValido = false;
		while(!nVecesEsValido) {
			nVecesEsValido = false;
			try {
				System.out.println("Indica los pares deseados:");
				nVeces = tcld.nextInt();
				if(nVeces <= VALOR_INICIAL) {
					throw new IllegalArgumentException("Error, el número deber ser un entero y positivo.");
				}
				nVecesEsValido = true;
			}
			catch (InputMismatchException e) {
				System.out.println(e + " Error, el número deber ser un entero y positivo.");
				tcld.nextLine();//Limpieza del buffer
			}
			catch (IllegalArgumentException e1) {
				System.out.println(e1);
			}
		}
		for (int i = VALOR_INICIAL; i < nVeces; i++) {
			if(i == VALOR_INICIAL) { //Condición para imprimir sólo en la primera vuelta.
				System.out.print("Los " + nVeces + " números pares son: ");
			}
			pares += INCREMENTO_DE_PAR;
			if (indicadorSaltoLinea < pares) { //Condición para realizar un salto de línea.
				System.out.print("\n");
				indicadorSaltoLinea += INCREMENTO_DE_INDICADOR ;
			}
			System.out.print(pares + " ");
		}
		tcld.close();
	}
}
