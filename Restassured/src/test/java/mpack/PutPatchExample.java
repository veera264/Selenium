package mpack;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;
public class PutPatchExample {
	
	@Test
	public void testput() {
		JSONObject 	request=new JSONObject();
		request.put("name","veera");
		request.put("job","TL2");
		baseURI="https://reqres.in";
		given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			put("api/users/2").
		then().
			statusCode(200).log().all();
	}
	@Test
	public void testpatch() {
		JSONObject 	request=new JSONObject();
		request.put("name","veera");
		request.put("job","TL2");
		baseURI="https://reqres.in";
		given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			patch("api/users/2").
		then().
			statusCode(200).log().all();
	}
	@Test
	public void TestDelete() {
		baseURI="https://reqres.in/";
		when().delete("api/users/2").then().statusCode(204).log().all();
	}
}
