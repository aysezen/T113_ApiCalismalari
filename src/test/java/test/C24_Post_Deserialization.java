package test;

import baseUrl.HerokuAppBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import testData.TestDataHerokuapp;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C24_Post_Deserialization extends HerokuAppBaseURL {
    /*
      https://restful-booker.herokuapp.com/booking url'ine asagidaki
      body'ye sahip bir POST request gonderdigimizde donen response'un
      id haric asagidaki gibi oldugunu test edin.

        Request body
   {
        "firstname" : "Ali",
        "lastname" : "Bak",
        "totalprice" : 500,
        "depositpaid" : false,
        "bookingdates" : {
                 "checkin" : "2021-06-01",
                 "checkout" : "2021-06-10"
                          },
        "additionalneeds" : "wi-fi"
    }

       Response Body
       {
       "bookingid":24,
       "booking":{
           "firstname":"Ali",
           "lastname":"Bak",
           "totalprice":500,
           "depositpaid":false,
           "bookingdates":{
               "checkin":"2021-06-01",
               "checkout":"2021-06-10"
           },
           "additionalneeds":"wi-fi"
           }
       }
   */

    @Test
    public void post01(){

        // 1 - Url ve Body hazirla

        specHerokuApp.pathParam("pp1","booking");

        TestDataHerokuapp testDataHerokuApp = new TestDataHerokuapp();

        HashMap <String,Object> reqBody = testDataHerokuApp.reqBodyMap();

        // 2 - Expected Data hazirla

        HashMap <String,Object> expBody = testDataHerokuApp.expBodyMap();

        // 3 - Response 'i kaydet

        Response response = given()
                                .spec(specHerokuApp)
                                .contentType(ContentType.JSON)
                            .when()
                                .body(reqBody)
                                .post("/{pp1}");

        response.prettyPrint();

        // 4 - Assertion

        HashMap <String, Object> resMap = response.as(HashMap.class);

        assertEquals(  ((Map)(expBody.get("booking"))).get("firstname")  ,  ((Map)(resMap.get("booking"))).get("firstname")  );
        assertEquals(  ((Map)(expBody.get("booking"))).get("lastname")   ,  ((Map)(resMap.get("booking"))).get("lastname")   );
        assertEquals(  ((Map)(expBody.get("booking"))).get("totalprice")   ,  ((Map)(resMap.get("booking"))).get("totalprice")   );
        assertEquals(  ((Map)(expBody.get("booking"))).get("depositpaid")   ,  ((Map)(resMap.get("booking"))).get("depositpaid")   );
        assertEquals(  ((Map)(expBody.get("booking"))).get("additionalneeds")   ,  ((Map)(resMap.get("booking"))).get("additionalneeds")   );
        assertEquals(  ((Map)(((Map)(expBody.get("booking"))).get("bookingdates"))).get("checkin")
                      ,((Map)(((Map)(resMap.get("booking"))).get("bookingdates"))).get("checkin")    );
        assertEquals(  ((Map)(((Map)(expBody.get("booking"))).get("bookingdates"))).get("checkout")
                      ,((Map)(((Map)(resMap.get("booking"))).get("bookingdates"))).get("checkout")    );

    }
}
