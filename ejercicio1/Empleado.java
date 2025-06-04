package ejercicio1;

/**
 * Clase Empleado, contiene los atributos requeridos en el ejercicio, así como la implementación
 * de la interfaz comparable, declarando al sobreescribirse el "orden natural" para esta clase.
 */
public class Empleado implements Comparable<Empleado> {
	//Constantes. Eliminación de números mágicos.
	public static final int EDAD_MINIMA_TRABAJO = 18;
	public static final double SALARIO_MINIMO = 0;
	
	
	/*Atributos*/
	private String nombre;
	private int edad;
	private double salario;
	
	/**
	 * Constructor requerido en el ejercicio, con todos los atributos, además se lanzan las excepciones
	 * requeridas para la edad y el salario. Se ponen al principio por si son lanzadas no se haya realizado
	 * nada en el constructor.
	 * */
	public Empleado(String nombre, int edad, double salario) {
		if(edad < EDAD_MINIMA_TRABAJO) {
			throw new EdadNoValidaException("Edad incorrecta, el empleado debe ser mayor de edad.");
		}
		if(salario < SALARIO_MINIMO) {
			throw new SalarioNoValidoException("Cantidad incorrecta, la cantidad debe ser positiva.");
		}
		this.nombre = nombre;
		this.edad = edad;
		this.salario = salario;
	}
	
	/**
	 * Getters and Setters. Especial consideración en los set de edad y salario, ya que también lanzan, 
	 * dado el caso, las excepciones con ambos atributos.
	 * */
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		if(edad < EDAD_MINIMA_TRABAJO) {
			throw new EdadNoValidaException("Edad incorrecta, el empleado debe ser mayor de edad.");
			
		}
		this.edad = edad;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		if(salario < SALARIO_MINIMO) {
			throw new SalarioNoValidoException("Cantidad incorrecta, la cantidad debe ser positiva.");
		}
		this.salario = salario;
	}

	/*toString sobreescrito*/
	@Override
	public String toString() {
		return "[Nombre: " + nombre + " Edad: " + edad + " Salario: " + salario + "]";
	}
	/**
	 * Sobreescritura  de método compareTo para establecer el orden natural por el atributo nombre.
	 */
	@Override
	public int compareTo(Empleado e) {
		return nombre.compareTo(e.getNombre());
	}

}
