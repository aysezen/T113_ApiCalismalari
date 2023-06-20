package test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class C13_Get_SoftAssertIleExpectedDataTesti {
     /*
    http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
    gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.

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

    String url = "http://dummy.restapiexample.com/api/v1/employee/3";

    // 2 - Expected Data hazirla

    /*
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
    JSONObject data = new JSONObject();

    data.put("id",3);
    data.put("employee_name","Ashton Cox");
    data.put("employee_salary",86000);
    data.put("employee_age",66);
    data.put("profile_image","");

    JSONObject expData = new JSONObject();

    expData.put("status","success");
    expData.put("data",data);
    expData.put("message","Successfully! Record has been fetched.");

    // 3 - Response'i kaydet

        Response response = given().when().get(url);

        response.prettyPrint();

    // 4 - Assertion

        SoftAssert softAssert = new SoftAssert();

        JsonPath respJP = response.jsonPath();

        softAssert.assertEquals(respJP.get("status"), expData.get("status"));
        softAssert.assertEquals(respJP.get("message"), expData.get("message"));
        softAssert.assertEquals(respJP.get("data.id"), expData.getJSONObject("data").get("id"));
        softAssert.assertEquals(respJP.get("data.employee_name"), expData.getJSONObject("data").get("employee_name"));
        softAssert.assertEquals(respJP.get("data.employee_salary"), expData.getJSONObject("data").get("employee_salary"));
        softAssert.assertEquals(respJP.get("data.employee_age"), expData.getJSONObject("data").get("employee_age"));
        softAssert.assertEquals(respJP.get("data.profile_image"), expData.getJSONObject("data").get("profile_image"));

        softAssert.assertAll();
    }
}
