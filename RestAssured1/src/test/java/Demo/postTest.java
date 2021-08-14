package Demo;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class postTest {
		@Test
		public void testPost() {
			JSONObject send=new JSONObject();
			send.put("firstName","sindhu");
			send.put("lastname", "reddy");
			send.put("gender","male");
			
			baseURI="http://localhost:3000/";
			basePath="users";
			given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(send.toJSONString())
			.when()
				.post()
			.then()
				.statusCode(201)
			
				.log().all();
			
		}
}
