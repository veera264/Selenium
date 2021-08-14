package soapUI;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import java.io.File;
import java.io.FileInputStream;

import org.testng.annotations.Test;
import org.apache.commons.io.IOUtils;
import io.restassured.http.ContentType;
import net.bytebuddy.implementation.bytecode.assign.Assigner.EqualTypesOnly;

public class SoapXML {
			
	@Test
	public void validateSoapXml() throws Exception {
		File file=new File("./soapRequest/add.xml");
		
		if(file.exists())
			System.out.println("FILE IS THERE");
		FileInputStream fi=new FileInputStream(file);
		String req=IOUtils.toString(fi,"UTF-8");
		baseURI="http://www.dneonline.com";
		given()
		.contentType("text/xml")
		.accept(ContentType.XML)
		.body(req)
		.when().post("/calculator.asmx").then().statusCode(200).log().all()
		.and()
		.body("//AddResult.text()",equalTo("5"));
		
		
		
	}
	
	@Test
	public void xmlsub() throws Exception {
		File file=new File("./soapRequest/sub.xml");
		System.out.println(file.exists());
		FileInputStream fi=new FileInputStream(file);
		String req = IOUtils.toString(fi,"UTF-8");
		
		baseURI="http://www.dneonline.com";
		
		given().contentType("text/xml")
		.accept(ContentType.XML)
		.body(req)
		.when().post("/calculator.asmx").then().statusCode(200);
		
	}

	
}	


