package test;

import baseUrl.DummyBaseURL;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testData.TestDataDummy;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C23_Get_DeSerialization extends DummyBaseURL {

    /*
    http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET
    request gonderdigimizde donen response’un status code’unun 200,
    content Type’inin application/json ve body’sinin asagidaki gibi
    oldugunu test edin.

    Response Body
    {
    "status":"success",
    "data":{
            "id":3,
            "employee_name":"Ashton Cox",
            "employee_salary":86000,
            "employee_age":66,
            "profile_image":""
            },
    "message":"Successfully! Record has been fetched."
    }
     */

    @Test
    public void get01(){

        // 1 - Url hazirla

        specDummy.pathParams("pp1","api","pp2","v1","pp3","employee","pp4",3);

        // 2 - Expected Data hazirla

        TestDataDummy testDataDummy = new TestDataDummy();

        HashMap<String, Object> expData = testDataDummy.expectedBodyOlusturMap();

        // 3 - Response'i kaydet

        Response response = given().spec(specDummy).when().get("/{pp1}/{pp2}/{pp3}/{pp4}");

        response.prettyPrint();

        // 4 - Assertion

        HashMap<String,Object> respMap = response.as(HashMap.class);

        assertEquals(testDataDummy.basariliStatusCode, response.getStatusCode());
        assertEquals(testDataDummy.contentType, response.getContentType());

        assertEquals(expData.get("status") , respMap.get("status"));
        assertEquals(expData.get("message") , respMap.get("message"));

        assertEquals(  ((Map) (expData.get("data"))).get("id") ,
                       ((Map) (respMap.get("data"))).get("id") );

        assertEquals(  ((Map) (expData.get("data"))).get("employee_name") ,
                       ((Map) (respMap.get("data"))).get("employee_name") );

        assertEquals( ((Map) (expData.get("data"))).get("employee_salary") ,
                      ((Map) (respMap.get("data"))).get("employee_salary")     );

        assertEquals( ((Map) (expData.get("data"))).get("employee_age") ,
                      ((Map) (respMap.get("data"))).get("employee_age")     );

        assertEquals( ((Map) (expData.get("data"))).get("profile_image") ,
                      ((Map) (respMap.get("data"))).get("profile_image")     );

    }


}
