package Demo;

import org.testng.annotations.Test;

public class check {
	
	@Test
	public void path() {
		
		String s=System.getProperty("user.dir");
		System.out.println(s);
	}
}
