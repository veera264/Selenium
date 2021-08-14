package Demo;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class demoGet {
	
	@Test(priority=1)
	public void testStatus() {
		when()
			.get("https://jsonplaceholder.typicode.com/posts/5")
		.then()
			.statusCode(200)
			.log().all();
	}
	//log response
	@Test(priority=2)
	public void logresponce() {
		when()
			.get("http://localhost:3000/users")
		.then()
			.statusCode(200)
			.body("[2].firstName",equalTo("lokesh"));
		
	}
	@Test
	public void Mullogresponce() {
		when()
			.get("http://localhost:3000/users")
		.then()
			.body("firstName",hasItems("veera","lokesh","Kiran"));
		
	}
	@Test
	public void testParamAndHeaders() {
		given()
			.param("MyName","veera")
			.header("Myhead","Indian");
		when()
			.get("http://localhost:3000/users")
		.then()
			.statusCode(200);
		
	}
	
	
}
