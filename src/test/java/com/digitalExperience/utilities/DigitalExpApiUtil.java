package com.digitalExperience.utilities;

import org.junit.jupiter.api.*;
import static io.restassured.RestAssured.*;

public abstract class DigitalExpApiUtil {

    @BeforeAll
    public static void initialStep(){
        String locationsDev = "ecomm-locations-pbc.dev";
        String locationsStage = "ecomm-locations-pbc.stage";
        baseURI = "http://"+locationsDev+".ashleyretail.com/";
    }

}
