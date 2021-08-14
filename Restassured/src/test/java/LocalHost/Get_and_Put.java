package LocalHost;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
public class Get_and_Put {
	@Test
	public void testget() {
		baseURI="http://localhost:3000";
		given().get("/users").then().log().all();
	}

	@SuppressWarnings("unchecked")
	@Test	
	public void testpost() {
		JSONObject send=new JSONObject();
		send.put("firstName", "monika");
		send.put("id",5);
		send.put("gender","female");
		baseURI="http://localhost:3000";
		given()
			.contentType(ContentType.JSON).accept(ContentType.JSON).
			body(send.toJSONString()).
		when()
			.post("/users").
		then()
			.statusCode(201);
	}
	@Test
	public void testput() {
		JSONObject send=new JSONObject();
		send.put("firstName", "Ramya");
		send.put("gender","female");
		baseURI="http://localhost:3000";
		given()
			.contentType(ContentType.JSON).accept(ContentType.JSON).
			body(send.toJSONString()).
		when()
			.put("/users/4").
		then()
			.statusCode(200);
	}
	@Test
	public void testpatch() {
		JSONObject send=new JSONObject();
		send.put("firstName", "Manasa");
		send.put("gender","female");
		baseURI="http://localhost:3000";
		given()
			.contentType(ContentType.JSON).accept(ContentType.JSON).
			body(send.toJSONString()).
		when()
			.patch("/users/4").
		then()
			.statusCode(200);
	}
	@Test
	public void testdelect() {
		baseURI="http://localhost:3000";
		given()
		.accept(ContentType.JSON).when()
		.delete("/users/4").then().statusCode(404);
		
		given().get("/users").then().log().all();
		
	}
	
	
	
}
