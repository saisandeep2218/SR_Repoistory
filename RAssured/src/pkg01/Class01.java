package pkg01;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Class01 extends Class02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
        //given will have query parameters, Headers, body
		//when  will have http , resource
		//then  asserts and log
		
		String response = 
				 given().queryParam("key", "qaclick123").body(Class02.addplace())
				.when().post("maps/api/place/add/json")
				.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP")).extract().asString();
		
		 
		JsonPath js = new JsonPath(response);
		js.getString("place_id");

		System.out.println(response);
		System.out.println(js.getString("place_id"));
	}

}
