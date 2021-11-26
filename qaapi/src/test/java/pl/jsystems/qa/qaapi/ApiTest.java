package pl.jsystems.qa.qaapi;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static org.hamcrest.Matchers.*;

public class ApiTest {

    @Test
    public void firstApiTest1() {
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

    @Test
    public void apiTest() {
        List<Author> author = RestAssured
                .given()
                .get("http://fakerestapi.azurewebsites.net/api/v1/Authors")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getList("", Author.class);

        Assertions.assertEquals(author.get(0).getId(), 1);
    }

    @Test
    public void authorByIdTest() {
        Author author = RestAssured
                .given()
                .get("http://fakerestapi.azurewebsites.net/api/v1/Authors/{id}", 1)
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getList("", Author.class)
                .get(0);

        Assertions.assertEquals(author.getId(), 1);
        Assertions.assertEquals(author.getIdBook(), 1);
    }

    @Test
    public void authorByIdWithResponseTest() {
        Response response = RestAssured
                .given()
                .get("http://fakerestapi.azurewebsites.net/api/v1/Authors/{id}", 1)
                .andReturn();

        Author author = response
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getObject("", Author.class);

        Assertions.assertEquals(response.statusCode(), 200);

        Assertions.assertEquals(author.getId(), 1);
        Assertions.assertEquals(author.getIdBook(), 1);
    }



}
