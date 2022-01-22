package api;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

import org.junit.Test;

import core.BaseWebservice;

public class TestesAPI {

	@Test
	public void testGetSingleUser() throws Exception {
		String url = "https://reqres.in/api/users/2";
		
		String response = given()
							.log().all()
						.when()
							.get("https://reqres.in/api/users/2")
						.then().statusCode(200).body(containsString("first_name")).extract().asString();
		
		BaseWebservice.exportarEvidencia(url, response);
	}
	
	@Test
	public void testPostCreate(String name, String job) throws Exception {
		String url = "https://reqres.in/api/users";
		
		String response = given()
							.log().all()
							.contentType("application/json")
							.body("{ \"name\": \"" + name + "\", \"job\": \"" + job + "\" }")
						.when()
							.post("https://reqres.in/api/users")
						.then()
							.log().all()
							.statusCode(201).body(containsString("createdAt")).extract().asString();
		
		BaseWebservice.exportarEvidencia(url, response);
	}
	
}
