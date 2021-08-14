package mpack;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class GET {
	@Test
	public void test() {
		
		Response responce=get("https://reqres.in/api/users?page=2");
		int code=responce.getStatusCode();
		System.out.println(responce.getBody().asString());
		System.out.println(responce.statusLine());
		System.out.println(responce.getHeader("content-type"));
		Assert.assertEquals(code,200);
	}
	@Test
	public void test2() {
		baseURI="https://reqres.in/api";
		given().
			get("/users?page=2").
		then().
			statusCode(200).
			body("data[1].id",equalTo(8)).log().all();
	}
	
	
}
