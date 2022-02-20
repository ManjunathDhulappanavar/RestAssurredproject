package com.RestAssuredTest;

import static io.restassured.RestAssured.*;  //impo //make static because we can use methods directly
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.matcher.RestAssuredMatchers.*;

import static org.hamcrest.Matchers.*;


import static io.restassured.RestAssured.baseURI;

public class RestAsssuredTestNgGET {  ///we can use jason path finder for reading jason(google)
    @Test
    public void test_1(){

        // configuration is also important here for run the testNG (RestAssured is achieved using testNG framework)
        //url used here for hitting end point available for practice  , we can use any endpoints directly  url=https://reqres.in/api/users?page=2


       //RestAssured.get("https://reqres.in/api/users?page=2");
        Response response =get("https://reqres.in/api/users?page=2");  //using directly get method because in mport we use static

        System.out.println(response.getStatusCode()+"/n"+response.getTime());

           System.out.println(response.getBody().asString());
               System.out.println(response.getStatusLine());

        int statusCode= response.getStatusCode();
        Assert.assertEquals(statusCode,200);
    }

    //these code taken from official website of rest assured git

    @Test
    public void test_2(){
        baseURI="https://reqres.in/api";  //impo
                 given()
                .get("/users?page=2")
                .then().statusCode(200)
                         .body("data[1].id",equalTo(8))
                         .log().all();
    }
    @Test
    public void test_3(){
        baseURI="https://reqres.in/api";  //impo
        given()
                .get("/users?page=2")
                .then().statusCode(200)
                .body("data[4].first_name",equalTo("George"))   //4 is index number  present in the json ,, index 4 of json id
                .body("data.first_name",hasItems("George","Rachel"))
                .log().all();
    }
}
