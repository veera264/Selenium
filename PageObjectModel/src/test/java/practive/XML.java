package practive;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class XML {
	@Test
	public void test() throws Exception{
		File file=new File("D://gmail.xlsx");
		FileInputStream fi=new FileInputStream(file);
		XSSFWorkbook book=new XSSFWorkbook(fi);
		XSSFSheet sheet = book.createSheet("Veera");
		FileOutputStream fo=new FileOutputStream("D://gmail.xlsx");
		book.write(fo);
		book.close();
		
	}

}
