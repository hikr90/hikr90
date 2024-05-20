package ex4_char_stream;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ex1_FileReader {
	public static void main(String[] args) throws IOException {
		//
		String path = "C:/JAVA1_0713_KTH/fileOutput.txt";
		File f = new File(path);
		FileReader fr = null;
		//
		try {
			//
			fr = new FileReader(f);
			int code = -1;
			//
			while((code=fr.read())!=-1) {
				System.out.print((char)code);
			}
			
		} catch (Exception e) {

		} finally {
			fr.close();
		}
	}
}
