package com.digitalExperience.restFullPractices;

import static io.restassured.RestAssured.*;                                                 // importing RestAssured statically not to repeat RestAssured everytime
import static org.junit.jupiter.api.Assertions.*;                                           // importing Assertions statically not to repeat Assertions everytime
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;


public class Get_Countries_ReturnAllCountries {

    static Response response;

    @BeforeAll
    public static void initialStep() {
        baseURI = "http://ecomm-locations-pbc.dev.ashleyretail.com/";                        // assigning Main URL/IP to RestAssured baseURI for re-usability
    }

    @DisplayName("GetAllCountries Enabled is - True")                                        // displays this name in Console
    @Test
    public void countriesValidationEnabledIsTrue() {

                response = given().log().all()                                                        // log().all() method shows all log info in Console
                        .accept(ContentType.JSON)                                             // telling/asking API to return us file in Json format
                        .and().queryParam("enabled", "true")    // sending query param in Key-and-Value format. (We get query params from swagger documentation)
                        .when()                                                               // .and() - is called Syntactic Sugar and has no affect to Code
                        .get(baseURI + "countries");
        System.out.println("Status Code: " + response.statusCode());                          // printing status code into Console
        assertEquals(200, response.statusCode());                                    // verifying status code is 200 as expected
        assertEquals("application/json; charset=utf-8", response.contentType());     // verifying return type is application/json
        assertTrue(response.body().asString().contains("Lithuania"));                         // verifying if response body contains Lithuania
        response.prettyPrint();                                                               // printing response to Console
    }

    @DisplayName("GetAllCountries Enabled is - False")
    @Test
    public void countriesValidationEnableIsFalse() {
        response = given().accept(ContentType.JSON)
                .and().queryParam("enabled", "false")
                .when()
                .get("countries");
        System.out.println("Status Code: " + response.statusCode());
        assertEquals(200, response.statusCode());
        assertEquals("application/json; charset=utf-8", response.contentType());
        assertTrue(response.headers().hasHeaderWithName("Date"));                  // verifying if response header has DATE
        System.out.println(response.header("Content-Type"));                            // printing Content Type's value from response header
        System.out.println(response.header("Date"));                                    // printing DATE's value from response header
        assertTrue(response.body().asString().contains("Libya"));
        response.prettyPrint();
    }

    @DisplayName("GetAllCountries - No Cache")
    @Test
    public void countriesValidationNoCache() {
        response = given().log().all()
                .accept(ContentType.JSON)
                .and().queryParam("enabled", "true")
                .and().header("Cache-Control", "no-cache")              // sending Header params in Key-and-Value format
                .when().get("countries");
        assertEquals(200, response.statusCode());
        assertEquals("application/json; charset=utf-8", response.contentType());
        assertTrue(response.body().asString().contains("Lithuania"));
        System.out.println("Status Code: " + response.statusCode());
        response.prettyPrint();
    }
}

