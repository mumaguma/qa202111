package pl.jsystems.qa.qaapi;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

import static org.hamcrest.Matchers.*;

public class ApiTest {

    @Test
    public void firstApiTest() {
        ValidatableResponse response = RestAssured
                .given()
                .get("https://fakerestapi.azurewebsites.net/api/v1/Activities")
                .then()
                .assertThat()
                .statusCode(200)
                .body("[0].id", equalTo(1))
                .body("[0].title", equalTo("Activity 1"))
                .body("[0].dueDate", startsWith("2021-11"))
                .body("[0].completed", is(false));

        Object firstArrayElement = response.extract().jsonPath().get("[0].");
        Assertions.assertEquals(((LinkedHashMap) firstArrayElement).size(), 4);
    }
}
