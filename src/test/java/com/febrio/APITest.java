package com.febrio;

import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.MatcherAssert.assertThat;

public class APITest {
    private static final Logger log = LoggerFactory.getLogger(APITest.class);
    String baseURI = "https://dummyapi.io/data/v1/";

    @Test(groups = {"api"})
    @Epic("Get Test")
    @Story("Get All User Data")
    @Description("This is test for get all user data")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Febrio")

    public void getUserTest() {
        try {
            RestAssured.baseURI = baseURI;
            Response responses = given()
                    .header("app-id", "63a804408eb0cb069b57e43a")
                    .header("User-Agent", "Mozilla/5.0")
                    .header("Accept", "application/json")
                    .get("user");

            responses.then()
                    .log().all()
                    .assertThat().statusCode(200);

//            attachResponse(responses.getBody().asString());
//            attachStatusCode(responses.getStatusCode());
        } catch (Exception e) {
            log.error("e: ", e);
        }
    }

    @Test(groups = {"api"})
    @Epic("Get Test")
    @Story("Get Specific User Data")
    @Description("This is test for get specific user data by user ID")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Febrio")
    public void getSpecificUserTest() {
        RestAssured.baseURI = baseURI;
        Response response = given()
                .header("app-id", "63a804408eb0cb069b57e43a")
                .header("User-Agent", "Mozilla/5.0")
                .header("Accept", "application/json")
                .get("user/60d0fe4f5311236168a109f3");

        System.out.println("\n=== GET SPECIFIC USER TEST ===");
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Body:");
        System.out.println(response.getBody().asPrettyString());
        System.out.println("========================\n");

        response.then()
                .log().all()
                .assertThat().statusCode(200);
    }

    @Test(groups = {"api"})
    @Epic("Post Test")
    @Story("Create New User Data")
    @Description("This is test for create new user data")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Febrio")
    public void createUserTest() {
        RestAssured.baseURI = baseURI;
        String requestBody =
                """
                                {
                                	"firstName" : "Allure",
                                    "lastName" : "User",
                                    "email" : "allure1999@gmail.com"
                                }
                        """;

        Response response = given()
                .header("app-id", "63a804408eb0cb069b57e43a")
                .header("Content-Type", "application/json")
                .header("User-Agent", "Mozilla/5.0")
                .header("Accept", "application/json")
                .body(requestBody)
                .when()
                .post("user/create");

        // Print response to console BEFORE assertions
        System.out.println("\n=== CREATE USER TEST ===");
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Body:");
        System.out.println(response.getBody().asPrettyString());
        System.out.println("========================\n");

        response.then()
                .log().all()
                .assertThat().statusCode(200);

    }

    @Test(groups = {"api"})
    @Epic("Put Test")
    @Story("Update Specific User Data")
    @Description("This is test for update specific user data by ID")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Febrio")
    public void updateUserDataTest() {
        RestAssured.baseURI = baseURI;
        String requestBody =
                """
                          {
                            "firstName" : "Hawkish"
                          }
                        """;
        Response response = given()
                .header("app-id", "63a804408eb0cb069b57e43a")
                .header("Content-Type", "application/json")
                .header("User-Agent", "Mozilla/5.0")
                .header("Accept", "application/json")
                .body(requestBody)
                .when()
                .put("user/60d0fe4f5311236168a109f3");

        System.out.println("\n=== UPDATE USER TEST ===");
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Body:");
        System.out.println(response.getBody().asPrettyString());
        System.out.println("========================\n");

        response.then()
                .log().all()
                .assertThat().statusCode(200);
    }

    @Test(groups = {"api"})
    @Epic("Delete Test")
    @Story("Delete Specific User Data")
    @Description("This is test for delete specific user data by ID")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Febrio")
    public void deleteUserDataTest(){
        try {
            RestAssured.baseURI = baseURI;
            Response response = given()
                    .header("app-id", "63a804408eb0cb069b57e43a")
                    .header("Content-Type", "application/json")
                    .header("User-Agent", "Mozilla/5.0")
                    .header("Accept", "application/json")
                    .when()
                    .delete("user/60d0fe4f5311236168a10a0e");

            response.then()
                    .log().all()
                    .assertThat().statusCode(200);
        } catch (Exception e) {
            log.error("e: ", e);
        }

    }

    @Test(groups = {"api"})
    @Epic("Verification Delete Test")
    @Story("Verification After Delete Specific User Data")
    @Description("This is verification test for delete specific user data by ID")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Febrio")
    public void verificationDelete(){
        try {
            RestAssured.baseURI = baseURI;
            Response responseAfterDelete = given()
                    .header("app-id", "63a804408eb0cb069b57e43a")
                    .header("Content-Type", "application/json")
                    .header("User-Agent", "Mozilla/5.0")
                    .header("Accept", "application/json")
                    .when()
                    .get("user/60d0fe4f5311236168a10a0d");

            responseAfterDelete.then()
                    .log().all()
                    .assertThat().statusCode(404);
        } catch (Exception e) {
            log.error("e: ", e);
        }
    }


    @Attachment(value = "API Response", type = "text/plain")
    private String attachResponse(String response){
        return response;
    }

    @Attachment(value = "Status Code", type = "text/plain")
    private int attachStatusCode(int response){
        return response;
    }
}


