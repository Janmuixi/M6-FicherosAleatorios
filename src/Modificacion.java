import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Modificacion {

	public static void main(String[] args) throws IOException {
		
		System.out.println("Escribe tu ID");
		Scanner scan = new Scanner(System.in);
		int idInput = scan.nextInt();
		
		System.out.println("Escribe tu salario");
		scan = new Scanner(System.in);
		int salarioInput = scan.nextInt();	
		
		File fichero = new File ("AleatorioEmpleado.dat");
		RandomAccessFile file = new RandomAccessFile (fichero , "rw");
		int posicion = 0;
		int idFinder = 0;
		char apellido[]= new char[10], aux;
		long puntero = 0;
		while(true) {
			try {
				file.seek(posicion);
				idFinder = file.readInt();
				if (idFinder == idInput) {
					for ( int i =0; i<apellido.length; i++) {
						aux = file.readChar(); // Voy leyendo carácter a carácter el apellido y lo guardo
						apellido[i]=aux; // en el array apellido
					}
					String apellidos = new String (apellido);
					System.out.println(apellidos);
					file.skipBytes(4);
					puntero = file.getFilePointer();
					double salarioOld = file.readDouble();
					System.out.println(salarioOld);
				}
				posicion += 36;
			} catch (EOFException e) {
				break;
			}
			
			file.seek(puntero);
			file.writeDouble(salarioInput);
			System.out.println(salarioInput);
			
		}
		
		
	}

}
