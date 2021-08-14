package mpack;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
public class GetAndPostExample {
	@Test
	public void testget() {
		baseURI="https://reqres.in";
		given().get("api/users?page=2").then().body("data.first_name",hasItems("Michael","George"));
	}
	@SuppressWarnings("unchecked")
	@Test
	public void testPost() {
		Map<String, Object> map=new HashMap<String,Object>();
//		map.put("name","veera");
//		map.put("job", "TL");
//		System.out.println(map);
		
		JSONObject request=new JSONObject(map);
		request.put("name","veera");
		request.put("job", "TL");
		baseURI="https://reqres.in/";
		given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("api/users").
		then().
			statusCode(201).log().all();
	}
}
