package com.digitalExperience.restFullPractices;

import com.digitalExperience.utilities.DigitalExpApiUtil;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class Get_Countries_Codes_CodeType extends DigitalExpApiUtil {

    static Response response;

    @DisplayName("Get countries: IsoNumeric CodeType")
    @Test
    public void getCountriesIsoNumericCodeType() {
        response = given()
                   .accept(ContentType.JSON)
                   .and().pathParam("codeType", "iso-numeric")       // sending path params in {id} format
                   .when()
                   .get("countries/codes/{codeType}");                                     // path param as {id} should be added to endpoint in .GET
        assertEquals(200, response.statusCode());
        System.out.println("Status Code: " + response.statusCode());
        List<String> isoNumList = response.as(List.class);
        System.out.println(isoNumList.size());
        System.out.println(isoNumList.get(0));
        assertEquals("434", isoNumList.get(0));                                         // verifying if response body item-1 equals to "434"
        assertTrue(response.contentType().contains("application/json"));
        response.prettyPrint();
    }

    @DisplayName("Get countries: Iso-Alpha-2 CodeType")
    @Test
    public void getCountriesIsoAlpha2CodeType() {
        response = given()
                .accept(ContentType.JSON)
                .and().pathParam("codeType", "iso-alpha-2")
                .when()
                .get("countries/codes/{codeType}");
        assertEquals(200, response.statusCode());
        System.out.println("Status Code: " + response.statusCode());
        List<String> alpha2List = response.as(List.class);
        System.out.println(alpha2List.size());
        System.out.println(alpha2List.get(0));
        assertEquals("LY", alpha2List.get(0));                                          // verifying if response body item-1 equals to "LY"
        assertTrue(response.contentType().contains("application/json"));
        response.prettyPrint();
    }

    @DisplayName("Get countries: Iso-Alpha-3 CodeType")
    @Test
    public void getCountriesIsoAlpha3CodeType() {
        response = given()
                .accept(ContentType.JSON)
                .and().pathParam("codeType", "iso-alpha-3")
                .when()
                .get("countries/codes/{codeType}");
        assertEquals(200, response.statusCode());
        System.out.println("Status Code: " + response.statusCode());
        List<String> alpha3List = response.as(List.class);
        System.out.println(alpha3List.size());
        System.out.println(alpha3List.get(0));
        assertEquals("LBY", alpha3List.get(0));                                         // verifying if response body item-1 equals to "LBY"
        assertTrue(response.contentType().contains("application/json"));
        response.prettyPrint();
    }

    @DisplayName("Get countries: No-Cache Iso-Alpha-2")
    @Test
    public void getCountriesNoCacheIsoAlpha2() {
        response = given().log().all()
                .accept(ContentType.JSON)
                .and().pathParam("codeType", "iso-alpha-2")
                .and().header("Cache-Control", "no-cache")
                .when()
                .get("countries/codes/{codeType}");
        assertEquals(200, response.statusCode());
        System.out.println("Status Code: " + response.statusCode());
        List<String> noCacheList = response.as(List.class);
        System.out.println(noCacheList.size());
        System.out.println(noCacheList.get(0));
        assertEquals("LY", noCacheList.get(0));                                         // verifying if response body item-1 equals to "LY"
        assertTrue(response.contentType().contains("application/json"));
        response.prettyPrint();
    }

    @DisplayName("Get countries: (Negative Test) Invalid Code-Type")
    @Test
    public void getCountriesInvalidCodeRequest() {
        response = given().log().all()
                .accept(ContentType.JSON)
                .and().pathParam("codeType", "invalid-code-type")
                .when()
                .get("countries/codes/{codeType}");
        assertEquals(404, response.statusCode());
        System.out.println("Status Code: " + response.statusCode());
        assertEquals("0", response.header("Content-Length"));                       // verifying response header "Content-Length" value is "0"

    }
}
