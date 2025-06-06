package apiTests;

import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.equalTo;

public class apiTest {

    @Test
    public void apiGet() {
        RestAssured.get("https://jsonplaceholder.typicode.com/users/1").then().assertThat().statusCode(200).and()
                .contentType("application/json; charset=utf-8").and().body("name", equalTo("Leanne Graham"))
                .body("company.bs", equalTo("harness real-time e-markets"));

    }

    @Test
    public void apiPost() {

        // use "\" to include "" inside string
         
        String jsonString = "{ \"userId\": 1 ,\"title\": \"My blog post title\",\"body\": \"This is the text of my latest blog post.\"}";
        RequestSpecification request = RestAssured.given();
        request.contentType("application/json; charset=utf-8");
        request.baseUri("https://jsonplaceholder.typicode.com/users");
        request.body(jsonString);
        Response response = request.post();
        System.out.println("response:"+ response.getBody().asString());

        ValidatableResponse vR = response.then();
        vR.statusCode(201);

        JsonPath jsonPathEvaluator = response.jsonPath();
        Assert.assertTrue(jsonPathEvaluator.get("id").getClass().toString().contains("Integer"));

    }

}
