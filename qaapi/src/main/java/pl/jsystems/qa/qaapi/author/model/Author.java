package pl.jsystems.qa.qaapi.author.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Author {
    @JsonProperty(value = "id", required = true)
    public long id;
    @JsonProperty(value = "idBook", required = true)
    public long idBook;
    @JsonProperty(value = "firstName", required = true)
    public String firstName;
    @JsonProperty(value = "lastName", required = true)
    public String lastName;

    public long getId() {
        return id;
    }

    public long getIdBook() {
        return idBook;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }



}
