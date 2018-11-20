import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Consulta {
	public static void main(String[] args) throws IOException {
		File fichero = new File ("AleatorioEmpleado.dat");
		RandomAccessFile file = new RandomAccessFile (fichero, "r");
		int id, dep ,posicion;
		Double salario;
		char apellido[]= new char[10], aux;
		
		System.out.println("Enter ID: ");
		Scanner read = new Scanner(System.in);
		int input = read.nextInt();

		posicion =0;
		posicion = (input * 36)-36;
		
		
		try {
			file.seek (posicion); // Nos posicionamos en posicion
			id = file.readInt(); // Obtengo identificar de Empleado
			for ( int i =0; i<apellido.length; i++) {
				aux = file.readChar(); // Voy leyendo carácter a carácter el apellido y lo guardo
				apellido[i]=aux; // en el array apellido
			}
			String apellidos = new String (apellido);
			dep = file.readInt(); //Lectura de departamento y salario
			salario = file.readDouble();
			if (id >0) {
				System.out.printf("ID: %s, Apellido: %s, Departamento: %d, Salario: %.2f %n", id,
						 apellidos.trim(), dep, salario);
						 posicion = posicion + 36;
			}
		}
		catch (EOFException e) {
			System.out.println("We couldn't find any user with this ID");
		}
			
		file.close();
		}

}
