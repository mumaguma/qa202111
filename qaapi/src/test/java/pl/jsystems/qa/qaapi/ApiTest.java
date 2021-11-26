package pl.jsystems.qa.qaapi;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.jsystems.qa.qaapi.author.model.Author;
import pl.jsystems.qa.qaapi.author.service.AuthorService;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static org.hamcrest.Matchers.*;

public class ApiTest {

    AuthorService authorService;

    @BeforeEach
    public void setUp() {
        authorService = new AuthorService();
    }

    @Test
    public void firstApiTest() {
        RestAssured
                .given()
                .get("https://fakerestapi.azurewebsites.net/api/v1/Activities")
                .then()
                .assertThat()
                .statusCode(200)
                .body("[0].id", equalTo(1))
                .body("[0].title", equalTo("Activity 1"))
                .body("[0].dueDate", startsWith("2021-11"))
                .body("[0].completed", is(false));
    }

    @Test
    public void apiTest() {

        List<Author> author = RestAssured
                .given()
                .get("https://fakerestapi.azurewebsites.net/api/v1/Authors")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath()
                .getList("", Author.class);

        assertThat(author.get(0).getId()).isEqualTo(1);
        assertThat(author.get(0).getIdBook()).isEqualTo(1);
    }


    @Test
    public void authorByIdTest() {

//        Author author = RestAssured
//                .given()
//                .get("https://fakerestapi.azurewebsites.net/api/v1/Authors/{id}", 1)
//                .then()
//                .assertThat()
//                .statusCode(200)
//                .extract()
//                .body()
//                .jsonPath()
//                .getObject("", Author.class);

        Response response = RestAssured
                .given()
                .get("https://fakerestapi.azurewebsites.net/api/v1/Authors/{id}", 1)
                .andReturn();


        Author author = response
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath()
                .getObject("", Author.class);

        assertThat(response.getStatusCode()).isEqualTo(200);

        assertThat(author.getId()).isEqualTo(1);
        assertThat(author.getIdBook()).isEqualTo(1);
    }

    @Test
    public void authorById2Test() {

//        Response response = RestAssured
//                .given()
//                .get("https://fakerestapi.azurewebsites.net/api/v1/Authors/{id}", 1)
//                .andReturn();
//
//
//        Author author = response
//                .then()
//                .assertThat()
//                .statusCode(200)
//                .extract()
//                .body()
//                .jsonPath()
//                .getObject("", Author.class);


        final Response response = authorService.getAuthorByIdResponse(1);
        assertThat(response.getStatusCode()).isEqualTo(200);

        final Author author = authorService.getAuthorById(response);

        assertThat(author.getId()).isEqualTo(1);
        assertThat(author.getIdBook()).isEqualTo(1);
    }

    @Test
    public void authorsById2Test() {

        final Response response = authorService.getAuthorsResponse();
        assertThat(response.getStatusCode()).isEqualTo(200);

        final List<Author> author = authorService.getAuthors(response);

        assertThat(author.get(0).getId()).isEqualTo(1);
        assertThat(author.get(0).getIdBook()).isEqualTo(1);
    }


}
