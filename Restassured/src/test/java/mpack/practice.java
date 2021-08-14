package mpack;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
public class practice {
	@Test
	public void testget() {
		baseURI="http://localhost:3000/";
		given().get("/users")
		.then().statusCode(200).body("[1].firstName",equalTo("manoj")).log().all();
	}
	@Test
	public void testpost() {
		baseURI="http://localhost:3000";
		JSONObject send=new JSONObject();
		send.put("firstName","sai");
		send.put("gender","male");
		
		given().
		contentType(ContentType.JSON).accept(ContentType.JSON)
		.body(send.toJSONString()).
		when()
			.post("/users")
		.then()
			.statusCode(201).log().all();
		
	}
	@Test
	public void testput21() {
		
		JSONObject update=new JSONObject();
		update.put("firstName","Kumar");
		baseURI="http://localhost:3000";
		given().contentType(ContentType.JSON).accept(ContentType.JSON)
		.body(update.toJSONString())
		.when().put("/users/8")
		.then().statusCode(200).log().all();
	}
	@Test
public void testpatch() {
		
		JSONObject update=new JSONObject();
		update.put("firstName","lokesh");
		update.put("gender","male");
		baseURI="http://localhost:3000";
		given().contentType(ContentType.JSON).accept(ContentType.JSON)
		.body(update.toJSONString())
		.when().patch("/users/3")
		.then().statusCode(200).log().all();
	}
	@Test
public void testdelete() {
		baseURI="http://localhost:3000";

		when().delete("/users/4");
	}
	

}
