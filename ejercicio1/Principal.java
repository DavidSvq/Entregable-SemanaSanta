package ejercicio1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * Clase Principal que se encarga de contener objetos de la clase Empleado y un menú
 * para operar sobre ellos.
 * 
 * Creación de constantes para eliminar los números mágicos. 
 * Nota: en las clases, como en las que implementan comparator, decidí dejar el cero como 
 * valor, ya que es una clase altamente extendida y generalizada, donde el cero se entiende
 * perfectamente que indica, y este valor no va cambiar. Sin embargo, para la opción salir esta 
 * puede ser implementada en más menús en un futuro, o simplemente querer o necesitar salir con
 * otro número(se cambia el valor de la constante), por lo que sí da más sentido establecer una 
 * constante para ese valor 0 y eliminar así el número mágico.
 * 
 * Creación del Scanner fuera del main y como static, ya que al principio tanto en el main como en 
 * el método static agregarEmpleado lo usaban y ambos eran static, y así evitar posibles conflictos 
 * al crearlo 2 veces. Tras la implementación de la interfaz, ya no se usa en el método static auxiliar,
 * aún así lo dejé ahí colocado.
 * 
 * Control de Excepciones:
 * Recogida de las posibles excepciones que pueden lanzarse durante la ejecución del programa,
 * tanto las personalizadas, validez edad y salario, como las generales por tipo de dato introducido
 * diferente al requerido InputMismatchException o intentar acceder a una posición inexistente
 * IndexOutOfBoundsException(aunque en principio dada la escritura de código, no hay nada que requiera
 * buscar o acceder por indice, una de las propiedades de los ArrayList y aquí ahora mismo no hay nada
 * que puediera lanzar esa excepción, aunque si se añaden funcionalidades que implique manejar índices
 * los ArrayList también las lanzan).Igualmente dejo una línea de código comentada más abajo, por si 
 * quieres probrar esta excepción, para que la descomentes(No olvides volver a comentarla si quieres 
 * que el programa funcione de nuevo correctamente).
 * 
 * Adicionalmente añado un bucle que obliga a pulsar opciones del menú disponibles.
 * 
 * Uso de un switch para las diferentes opciones del menú. Siendo la opción de finalización del programa
 * el 0.
 * 
 * Uso la clase Collections, padre de la clase List, para llamar a su método para ordenar .sort
 * hasta en 4 ocasiones, la primera usando el método sobreescrito compareTo de la interfaz Comparable 
 * en la clase Empleado con el orden natural establecido(por defecto, sin especificar nada por parámetro),
 * y posteriormente junto con los criterios de ordenación de las clases que implementan la interfaz 
 * Comparator y su método compare.
 * 
 * Añadido Extra al Ejercicio: 
 * Contiene un método static que se encarga de aplicar las funciones que queramos tener en nuestro menú sin 
 * tener que tocar código del programa principal(ni en ningún otro lado que no sea la clase que se crea para
 * ello, más allá de ampliar en 1 las opciones del menú) en caso de cambios o nuevas funcionalidades(o podría
 * hacerlo si extraemos toda la lógica de las diferentes opciones del menu y la llevamos a clases que implementen
 * la interfaz FuncionesLista, implementada una vez terminado el ejercicio con lo que solicitaba el enunciado).
 * 
 * Como muestra, añado la opción al menu de modificar datos del empleado, mediante la clase ModificarSalarioEmpleado
 * y así comprobar que la modíficación del salario lanza excepciones y no solo cuando la creación. Esta clase
 * tambien se encargará de realizar la busqueda del empleado que se van a sustituir datos, para este ejercicio
 * no incluí ningún atributo de identificación única, por lo que si hay más de un nombre, puede haber problemas
 * que no habría con un Id (De hecho, te pide el nuevo salario a todos los que tengan el mismo nombre).
 * 
 */
public class Principal {
	//Constantes. Eliminación de números mágicos.
	public static final int MINIMO_EMPLEADOS_EN_LISTA = 2;
	public static final int MAXIMO_DE_OPCIONES = 7;
	public static final int SALIDA = 0;
	
	//Creación del Scanner
	static Scanner tcld = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		ArrayList<Empleado> empleados = new ArrayList<>();
		
		/**
		 * Creación de varios objetos clase Empleado que dejo comentados (por si quieres
		 * probar las opciones de ordenación los descomentes) para que también veas
		 * las opciones de empezar con un ArrayList vacio. Uso del método isEmpty de la 
		 * clase List para mostrar un mensaje en caso que aún este vacia, así como la 
		 * condición que haya al menos 2 empleados que ordenar o en caso contrario un mensaje
		 * de que la operación fue realizada con éxito, para ello uso el método .size() de 
		 * la clase List que devuelve su longitud (Length es para los arrays normales). 
		 * Los 2 últimos empleados creados también generan el lanzamiento de las excepciones 
		 * personalizadas. 
		 */
		/*Empleado emp = new Empleado("David", 25, 2000);
		Empleado emp1 = new Empleado("David", 40, 3000);
		Empleado emp2 = new Empleado("Davinia", 25, 1800.68);
		Empleado emp3 = new Empleado("Pablo", 27, 1800.99);
		Empleado emp4 = new Empleado("Paula", 19, 1900.9);
		Empleado emp5 = new Empleado("Daniel", 45, 1900.02);
		Empleado emp6 = new Empleado("Ana", 19, 2000);
		Empleado emp7 = new Empleado("Alberto", 25, 2000);
		try {
		Empleado emp8 = new Empleado("David", 17, 2000);
		}
		catch(EdadNoValidaException e4) {
			System.out.println(e4);
		}
		try {
			Empleado emp9 = new Empleado("David", 25, -100);
		}
		catch(SalarioNoValidoException e5) {
			System.out.println(e5);
		}
		
		empleados.add(emp);
		empleados.add(emp1);
		empleados.add(emp2);
		empleados.add(emp3);
		empleados.add(emp4);
		empleados.add(emp5);
		empleados.add(emp6);
		empleados.add(emp7);*/
		
		
		int opcionMenu = 0;
		do {
			try {
				do { //Menú opciones
					System.out.println("Pulsa una opción:");
					System.out.println("Pulse 0 para Salir.");
					System.out.println("Pulsa 1 para Agregar un empleado.");
					System.out.println("Pulsa 2 para Listar los empleados.");
					System.out.println("Pulsa 3 para Ordenar por nombre.");
					System.out.println("Pulsa 4 para Ordenar por salario y edad");
					System.out.println("Pulsa 5 para Ordenar por nombre descendente.");
					System.out.println("Pulsa 6 para Ordenar por salario, edad y nombre.");
					System.out.println("Pulsa 7 para Modificar el saldo.");
					opcionMenu = tcld.nextInt();
					tcld.nextLine();
					if(opcionMenu < SALIDA || opcionMenu > MAXIMO_DE_OPCIONES) { //Aviso pulsar opción disponible
						System.out.println("Pulsa una opción disponible.");
					}
				}while(opcionMenu < SALIDA || opcionMenu > MAXIMO_DE_OPCIONES); //Control pulsar opción disponible
				
				//Descomenta la línea inferior para comprobar la excepción IndexOutOfBoundsException.
				//System.out.println(empleados.get(120));
				
				
				switch (opcionMenu) {
				case 1: //Agregar empleado
					empleados = Principal.realizarFuncion(empleados, new AgregarEmpleado());
					break;
				case 2: //Mostrar lista
					if(empleados.isEmpty()) {
						System.out.println("La lista de empleados aún está vacia.");
					}else {
						for (Empleado e : empleados) {
							System.out.println(e);
						}
					}
					break;
				case 3: //Orden natural
					if(empleados.size() < MINIMO_EMPLEADOS_EN_LISTA) {
						System.out.println("De momento no hay suficentes empleados que ordenar.");
					}
					else {
						Collections.sort(empleados);
						System.out.println("Ordenación aplicada con éxito.");
					}
					break;
				case 4: //Orden por salario y edad
					if(empleados.size() < MINIMO_EMPLEADOS_EN_LISTA) {
						System.out.println("De momento no hay suficentes empleados que ordenar.");
					}
					else {
						Collections.sort(empleados, new OrdenarPorSalarioYEdad());
						System.out.println("Ordenación aplicada con éxito.");
					}
					break;
				case 5: // Orden natural descendente
					if(empleados.size() < MINIMO_EMPLEADOS_EN_LISTA) {
						System.out.println("De momento no hay suficentes empleados que ordenar.");
					}
					else {
						Collections.sort(empleados, new OrdenarPorNombreDescendente());
						System.out.println("Ordenación aplicada con éxito.");
					}
					break;
				case 6: //Orden por salario, edad y nombre
					if(empleados.size() < MINIMO_EMPLEADOS_EN_LISTA) {
						System.out.println("De momento no hay suficentes empleados que ordenar.");
					}
					else {
						Collections.sort(empleados, new OrdenarPorSalarioEdadNombre());
						System.out.println("Ordenación aplicada con éxito.");
					}
					break;
				case 7: //Modificar saldo de empleado
					empleados = Principal.realizarFuncion(empleados, new ModificarSaldoEmpleado());
					break;
				}
			} //Capturas de excepciones.
			catch(InputMismatchException e) { 
				System.out.println(e + " Error, el tipo de dato proporcionado no es correcto.");
				/** Aquí primero reseñar la importancia de limpiar el buffer con .nextLine()
				 *  para no entrar en un bucle infinito. Y segundo, si es la primera vez que
				 *  introduces un dato por teclado y pulsas una letra, pidiendo un entero el 
				 *  menú, como la variable opcionMenu se inicializó a 0, se le queda ese valor 
				 *  y sale del bucle pincipal terminando así el programa, de ahí darle cualquier 
				 *  valor diferente a 0, el valor de salida.
				 **/
				opcionMenu = 1;
				tcld.nextLine();
			}catch(IndexOutOfBoundsException e1) {
				System.out.println(e1 + " Error al intentar acceder a la posición indicada.");
				
			}
			catch(EdadNoValidaException e2) {
				System.out.println(e2);
			}
			catch(SalarioNoValidoException e3) {
				System.out.println(e3);
			}
		} while (opcionMenu != SALIDA);

	}

	/**
	 * Método static que originalmente se encargó simplemente de agregar un empleado al ArrayList, pero 
	 * que posteriormente fue reescrito para hacerlo más abstracto y que puediera recibir el arrayList y
	 * la interfaz FuncionesLista, separando así en clases la lógica necesaria para realizar cualquier
	 * proceso con esa lista de empleados. Como comenté anteriormente, aquí sólo se implementa una opción del 
	 * menú, pero podría implementarlas todas o las nuevas si se quisieran añadir por ejemplo, eliminar 
	 * empleado de la lista, o buscar por nombre (aquí se podría sobrecargar el método para que acepte un nombre
	 * o referencia por la que buscar como parametro extra o bien hacer la busqueda dentro de la clase que se va
	 * encargar de ello)PD:Finalmente añadí una clase más al menu con la interfaz mencionada.
	 */	
	private static ArrayList<Empleado> realizarFuncion (ArrayList<Empleado> list, FuncionesLista fl) {
		
		ArrayList<Empleado> lista = new ArrayList<>();
		lista = fl.aplicar(list);
		return lista;
	}
	
	/**
	 * Codigo usado en primera instancia antes de aplicar la interfaz Funciones Lista, ahora el método
	 * agregarEmpleado es la clase AgregarEmpleado, pudiendo agregar cualquier otra función con la 
	 * interfaz sin tener que tocar nada fuera de la clase que se cree para ello.
	 * 
	 * private static ArrayList<Empleado< agregarEmpleado(ArrayList<Empleado> list){
		 * 	System.out.println("Introduce nombre empleado: ");
			String nombre = tcld.nextLine();
			System.out.println("Introduce edad empleado: ");
			int edad = tcld.nextInt();
			System.out.println("Introduce saldo empleado: ");
			double saldo = tcld.nextDouble();
			//tcld.nextLine();
			list.add(new Empleado(nombre, edad, saldo));
			return list;
	}*/

}
