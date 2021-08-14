package Demo;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static  io.restassured.RestAssured.*;
public class putTest {
	
	@SuppressWarnings("unchecked")
	@Test
	public void testPut() {
		JSONObject request=new JSONObject();
		
		request.put("firstName","Kiran");
		request.put("lastname", "Kumar");
		baseURI="http://localhost:3000/";
		basePath="users/10";
		
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(request.toJSONString())
		.when()
			.put()
		.then()
			.statusCode(200)
			.log().all();
			
			
			
			
			
			
			
			
			
			
	}
}
