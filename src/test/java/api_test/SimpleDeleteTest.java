package api_test;

import Testing.TestNgMavenTest;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleDeleteTest {

    private static final Logger LOGGER= LogManager.getLogger(TestNgMavenTest.class);
    @Test
    public void deleteSingleUserRecord(){
        RestAssured.baseURI="https://reqres.in/api/users";
        RequestSpecification httpRequest=RestAssured.given();

        Response response=httpRequest.request(Method.DELETE,"/2");

        LOGGER.debug("Response status code :"+response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(),204);

        LOGGER.debug("Response body is : "+response.getBody().asString());



    }
}
