import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.RandomAccessFile;
import java.io.IOException;






public class parteleitura {

	public static void escrita(filme filme1) throws IOException
	{	//função para escrita do objeto em byte
		RandomAccessFile arq;
		arq = new RandomAccessFile("hexa.db","rw");
		long pos1 = arq.getFilePointer();
		byte[] ba;
		arq.seek(pos1);
		pos1=pos1+1;
		ba = filme1.toByteArray();
		arq.writeInt(ba.length);
		arq.write(ba);
		

	}

	public static void leitura(filme filme2) throws IOException	
	{	
		RandomAccessFile arq;
		arq = new RandomAccessFile("hexa.db","rw");
		
		byte[] ba;
		int tam;
		tam = arq.readInt();
		ba = new byte[tam];
		arq.read(ba);
		filme2.fromByteArray(ba);
		
		System.out.println(filme2);
		arq.close();
	}


	public static void main(String[] args) throws IOException {

	
		File arquivoCSV =new File ("c://vfinal.csv");

		RandomAccessFile arq;

		
		int contador=0;
		char [] lapide= {'*'};
		
		try {
				
			Scanner leitor = new Scanner (arquivoCSV);
		
			String linhaarquivo =new  String();
			leitor.nextLine();

			while(leitor.hasNext())
				{
				//split das linhas do csv
				linhaarquivo=leitor.nextLine();
				String[] valores = linhaarquivo.split(";");
				
	 
				System.out.println("\t"+valores[0]+"\t" +valores[1] + "\t"+valores[2]+"\t"+valores[3]+"\t"+ valores[4]);
				float nota = Float.parseFloat(valores[3]);
				
				// adicionando os conteudos no objeto e e escrevendo ele em byte
				//contador=id, valores[1]=titulo 
				// nota= float(nota do filme ) // valores[4]=generos do filme
				contador=contador+1;
				filme filme1=new filme(contador,valores[1],nota,valores[4]);
				
				escrita(filme1);
				//leitura do arquivo em byte no hexa.db
				filme filme2 = new filme();
				leitura(filme2);
			}
		}  
		catch(FileNotFoundException e) { e.printStackTrace();
		
		 
	}
	}
}

