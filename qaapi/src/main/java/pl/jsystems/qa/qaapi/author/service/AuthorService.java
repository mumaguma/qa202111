package pl.jsystems.qa.qaapi.author.service;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import pl.jsystems.qa.qaapi.author.model.Author;
import pl.jsystems.qa.qaapi.author.spec.AzureSpecification;

import java.util.List;

public class AuthorService {

    private static final String AUTHORS = "/Authors";
    private static final String AUTHORS_BY_ID = "/Authors/{id}";

    public Author getAuthorById(int id) {
        return getAuthorByIdResponse(id)
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath()
                .getObject("", Author.class);
    }


    public Author getAuthorById(Response response) {
        return response
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath()
                .getObject("", Author.class);
    }

    public Response getAuthorByIdResponse(int id) {
        return RestAssured
                .given()
                .spec(AzureSpecification.azureSpec())
//                .get("https://fakerestapi.azurewebsites.net//Authors/{id}", id)
                .get(AUTHORS_BY_ID, id)
                .andReturn();
    }

    public List<Author> getAuthors() {
        return getAuthorsResponse()
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath()
                .getList("", Author.class);
    }


    public List<Author> getAuthors(Response response) {
        return response
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath()
                .getList("", Author.class);
    }

    public Response getAuthorsResponse() {
        return RestAssured
                .given()
                .spec(AzureSpecification.azureSpec())
//                        .get("https://fakerestapi.azurewebsites.net/api/v1/Authors")
                .get(AUTHORS)
                .andReturn();
    }


}
