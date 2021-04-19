package com.smallcase.automation;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;

public class ApiTestCases {
    @Test
    public void validateBooksSchema() {

        RestAssured
                .given()
                .baseUri("https://bookstore.toolsqa.com/BookStore/v1/Books")
                .contentType(ContentType.JSON)
                .when()
                .get()
                .then()
                .assertThat()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("BookSchema.json"));
    }
}
