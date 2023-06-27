package CodeTEst;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.sessionId;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;

public class AusPostAPi {

    @Test
     public void testPostCode() {

        RequestSpecification request = given().header("auth-key", "d0207c89-4981-4779-aca6-dd6b28d609df").param("q", "Melbourne").
                param("state", "VIC");

        Response response = request.when().get("https://digitalapi.auspost.com.au/postcode/search.json");

        response.prettyPrint();
        response.then().statusCode(is(200));

    }

        @Test
                public void testLocation() {
            RequestSpecification request=given().header("auth-key","d0207c89-4981-4779-aca6-dd6b28d609df").param("q","Melbourne").
                    param("state", "VIC");

            Response response=request.when().get("https://digitalapi.auspost.com.au/postcode/search.json");
           response.then().assertThat().body("localities.locality[0].postcode",equalTo(3002));



//
//            var location = response.jsonPath().getString("localities.locality[0].location");
//            var postcode = response.jsonPath().getString("localities.locality[0].postcode");
//            System.out.println(location);
//            System.out.println(postcode);



           // response.then().assertThat().body(location,equalTo("EAST MELBOURNE"));




        }



//
//         given().header("auth-key","d0207c89-4981-4779-aca6-dd6b28d609df").param("q","Melbourne").
//                   param("state", "VIC").
//                   when().get("https://digitalapi.auspost.com.au/postcode/search.json").
//                   then().assertThat().statusCode(is(200));


}
