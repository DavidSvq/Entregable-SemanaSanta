package ejercicio1;

import java.util.ArrayList;
import java.util.Scanner;

public class ModificarSaldoEmpleado implements FuncionesLista {
	/***
	 * Clase específica que implementa la interfaz FuncionesLista, y se encarga de modificar el salario
	 * de un objeto de la clase Empleado. Para ello, primero solicita por teclado la condición de búsqueda
	 * para posteriormente realizarla y proceder a solicitar el nuevo salario por teclado.
	 * Finalmente aplicamos el setSalario para guardar el nuevo dato.
	 */
	@Override
	public ArrayList<Empleado> aplicar(ArrayList<Empleado> lista) {
		Scanner tcld = new Scanner(System.in);
		boolean empleadoEncontrado = false;
		double nuevoSaldo = 0;
		System.out.println("Introduce el nombre del empleado: ");
		String nombreAux = tcld.nextLine();
		for (Empleado empleado : lista) {
			if(empleado.getNombre().equalsIgnoreCase(nombreAux)) {
				System.out.println("Introduce el nuevo saldo: ");
				nuevoSaldo = tcld.nextDouble();
				empleado.setSalario(nuevoSaldo);
				empleadoEncontrado = true;
			}
		}
		if (!empleadoEncontrado) {
			System.out.println("Empleado no encontrado.");
		}
		return lista;
	}

}
