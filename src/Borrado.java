import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Borrado {

	public static void main(String[] args) throws IOException {
		
		System.out.println("Escribe tu ID");
		Scanner scan = new Scanner(System.in);
		int idInput = scan.nextInt();
		
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
					puntero = file.getFilePointer()-4;
					file.seek(puntero);
					file.writeInt(-1);
					file.writeInt(idInput);
					file.skipBytes(16);
					file.writeInt(0);
					file.writeDouble(0);
					
					
				}
				
				posicion += 36;
				
			} catch (EOFException e) {
				break;
			}
			
			
		}
		file.close();
		
	}


}
