package ru.netology.rest;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoTest {
    @Test
    void shouldReturnSendData() {
        given()
                .baseUri("https://postman-echo.com")
                .body("Hello, world!")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo("Hello, world!"))
                .body(matchesJsonSchemaInClasspath("postmanecho.schema.json"));
    }
}
