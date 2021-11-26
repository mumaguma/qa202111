package pl.jsystems.qa.qaapi.author.service;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import pl.jsystems.qa.qaapi.author.model.Author;

import java.util.List;

public class AuthorService {

    public Author getAuthorById(int id){
        return getAuthorByIdResponse(id).then().assertThat().statusCode(200).extract().body().jsonPath().getObject("", Author.class);
    }

    public Author getAuthorById(Response response){
        return response.then().assertThat().statusCode(200).extract().body().jsonPath().getObject("", Author.class);
    }

    public Response getAuthorByIdResponse(int i) {
        return RestAssured.given()
                .get("http://fakerestapi.azurewebsites.net/api/v1/Authors/{id}", i)
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
        return
                RestAssured
                        .given()
                        .get("https://fakerestapi.azurewebsites.net/api/v1/Authors")
                        .andReturn();
    }

}
