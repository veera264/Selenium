package Demo;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class deleteTest {
	@Test
	public void testDelete() {
		baseURI="http://localhost:3000/";
		basePath="users/5";
		when()
			.delete()
		.then()
			.statusCode(200);
		
	}
}
