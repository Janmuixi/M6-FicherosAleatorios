import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Insercion {
	public static void main (String[] args) throws IOException {
		
		System.out.println("Escribe tu ID");
		Scanner scan = new Scanner(System.in);
		int idInput = scan.nextInt();
		
		System.out.println("Escribe tu apellido");
		scan = new Scanner(System.in);
		String apellidoInput = scan.nextLine();
		
		System.out.println("Escribe tu departamento");
		scan = new Scanner(System.in);
		int departamentoInput = scan.nextInt();		
	
		System.out.println("Escribe tu salario");
		scan = new Scanner(System.in);
		double salarioInput = scan.nextDouble();	
		
		File fichero = new File ("AleatorioEmpleado.dat");
		RandomAccessFile file = new RandomAccessFile (fichero , "rw");
		int posicion = 0;
		int idFind = 0;
		while(true) {
			try {
				file.seek(posicion);
				idFind = file.readInt();
				if (idFind == idInput) {
					System.out.println("Id ya existe");
					System.exit(-1);
				}
				posicion += 36;
			} catch (EOFException e) {
				break;
			}
			
		}
		file.writeInt(idInput);
		StringBuffer buffer = new StringBuffer (apellidoInput);
		buffer.setLength(10); // Fijo en 10 caracteres la longitud del apellido
		file.writeChars (buffer.toString());
		file.writeInt(departamentoInput);
		file.writeDouble (salarioInput);
		System.out.println("DONE");
		
		file.close(); // No olvidarse de cerrar el fichero
	}
}
