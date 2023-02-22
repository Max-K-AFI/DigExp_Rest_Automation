package com.digitalExperience.restFullPractices;

import com.digitalExperience.utilities.DigitalExpApiUtil;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Get_Countries_CountryCode extends DigitalExpApiUtil {

    static Response response;

    @DisplayName("Get countries: by 2 digit ISO Code")
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

}
