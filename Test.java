 package demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Test {

	public static void main(String[] args)throws Exception {
		File file=new File("D:\\text.txt");
		BufferedReader read=new BufferedReader(new FileReader(file));
		String line;
		while((line=read.readLine())!=null) {
			line=read.readLine();
			System.out.println(line);
		}
		
		read.close();
	}
	
}
