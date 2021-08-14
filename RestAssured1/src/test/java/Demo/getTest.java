package Demo;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class getTest {
	@Test
	public void Get_Request() {
		
		given()
		.when()
			.get("http://demoqa.com/utilities/weather/city/Hyderabad")
		.then()
			.statusCode(200)
			.assertThat().body("City",equalTo("Hyderabad"))
			.header("Content-Type","application/json; charset=utf-8")
			.log().all();
		
	}
}
