package serelizationAndDeserilization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class test implements Serializable
{
	int a=10,b=20;
}

public class Serilization_Deserilization {
		public static void main(String[] args) throws Exception {
			
			test t1=new test();
			
			//Serialization
			FileOutputStream fo=new FileOutputStream("test.txt");
			ObjectOutputStream oos=new ObjectOutputStream(fo);
			oos.writeObject(t1);
			
			//Deserilization
			
			FileInputStream fi=new FileInputStream("test.txt");
			ObjectInputStream ois=new ObjectInputStream(fi);
			test t2=(test) ois.readObject();
			System.out.println(t2.a+" "+t2.b);
			
		}
}
