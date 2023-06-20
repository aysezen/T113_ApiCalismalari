package test;

import baseUrl.JsonPlaceHolderBaseURL;
import io.restassured.response.Response;
import org.codehaus.groovy.control.io.ReaderSource;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C15_BaseUrlJsonPlaceHolder extends JsonPlaceHolderBaseURL {
    //Class icinde 3 Test metodu olusturun ve asagidaki testleri yapin

    /*
        1-  https://jsonplaceholder.typicode.com/posts endpointine bir GET
         request gonderdigimizde donen response’un status code’unun 200 oldugunu
         ve Response’ta 100 kayit oldugunu test edin.
        */

    /*
        2- https://jsonplaceholder.typicode.com/posts/44 endpointine bir GET
            request gonderdigimizde donen response’un status code’unun 200 oldugunu
            ve “title” degerinin “optio dolor molestias sit” oldugunu test edin
         */
    /*
        3- https://jsonplaceholder.typicode.com/posts/50 endpointine bir DELETE
            request gonderdigimizde donen response’un status code’unun 200 oldugunu ve
            response body’sinin null oldugunu test edin
         */
    @Test
    public void get01(){
         /*
        1-  https://jsonplaceholder.typicode.com/posts endpointine bir GET
         request gonderdigimizde donen response’un status code’unun 200 oldugunu
         ve Response’ta 100 kayit oldugunu test edin.
        */

        // 1 - Url hazirla

        specJsonPlace.pathParam("pp1","posts");

        // 2 - Expected Data hazirla

        // 3 - Response'i kaydet

        Response response = given().spec(specJsonPlace).when().get("/{pp1}");
        response.prettyPrint();

    }
    @Test
    public void get02(){

    }
    @Test
    public void delete01(){

    }
}
