package apiTests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.RestAssured;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import demo.message;

@Epic("Api Testing")
@Feature("Api Testing using Rest Assured")
public class apiTest {

    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description : Verify the get function")
    @Story("Fetch the data from an api")
    @ParameterizedTest
    @CsvSource({ "1,Leanne Graham,harness real-time e-markets",
            "2,Ervin Howell,synergize scalable supply-chains",
            "3,Clementine Bauch,e-enable strategic applications",
    })
    public void apiGet(String id, String name, String bs) {
        RestAssured.get("https://jsonplaceholder.typicode.com/users/" + id).then().assertThat().statusCode(200).and()
                .contentType("application/json; charset=utf-8").and().body("name", equalTo(name))
                .body("company.bs", equalTo(bs));

    }

    @Test
     @Severity(SeverityLevel.CRITICAL)
    @Description("Test Description : Verify the post function")
    @Story("Post the data to an api")
    public void apiPost() {

        // use "\" to include "" inside string

        // String json = "{ \"userId\": 1 ,\"title\": \"My blog post
        // title\",\"body\":\"This is the text of my latest blog post.\"}";

        message json = new message();

        // json.setMessage(
        // "{ \"userId\": 1 ,\"title\": \"My blog post title\",\"body\": \"This is the
        // text of my latest blog post.\"}");

        json.setMessage(1, "My blog post title", "This is the text of my latest blog post.");
        RequestSpecification request = RestAssured.given();
        request.contentType("application/json; charset=utf-8");
        request.baseUri("https://jsonplaceholder.typicode.com/users");
        request.body(json);
        Response response = request.post();
        System.out.println("response:" + response.getBody().asString());

        ValidatableResponse vR = response.then();
        vR.statusCode(201);

        JsonPath jsonPathEvaluator = response.jsonPath();
        assertTrue(jsonPathEvaluator.get("id").getClass().toString().contains("Integer"));

    }

}
