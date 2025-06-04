package ejercicio1;

import java.util.ArrayList;
import java.util.Scanner;

/***
 * Clase específica que implementa la interfaz FuncionesLista, y se encarga de añadir un objeto
 * de la clase Empleado al ArrayList. Para ello, primero solicita los datos necesarios por teclado
 * guardándolos en variables, para posteriormente usar el método .add() de la clase List, añade un 
 * nuevo objeto a la colección.
 */
public class AgregarEmpleado implements FuncionesLista {

	@Override
	public ArrayList<Empleado> aplicar(ArrayList<Empleado> lista) {
		Scanner tcld = new Scanner(System.in);
		System.out.println("Introduce nombre empleado: ");
		String nombre = tcld.nextLine();
		System.out.println("Introduce edad empleado: ");
		int edad = tcld.nextInt();
		System.out.println("Introduce saldo empleado: ");
		double saldo = tcld.nextDouble();
		lista.add(new Empleado(nombre, edad, saldo));
		return lista;
	}

}
