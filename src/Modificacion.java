import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Modificacion {

	public static void main(String[] args) throws FileNotFoundException {
		
		System.out.println("Escribe tu ID");
		Scanner scan = new Scanner(System.in);
		int idInput = scan.nextInt();

		System.out.println("Escribe tu salario");
		scan = new Scanner(System.in);
		int salarioInput = scan.nextInt();	
		
		File fichero = new File ("AleatorioEmpleado.dat");
		RandomAccessFile file = new RandomAccessFile (fichero , "rw");
	}

}
