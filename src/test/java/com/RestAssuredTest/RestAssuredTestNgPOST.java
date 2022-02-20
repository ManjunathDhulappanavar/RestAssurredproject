package com.RestAssuredTest;

import static io.restassured.RestAssured.*;  //impo //make static because we can use methods directly

import io.restassured.path.json.mapper.factory.JsonbObjectMapperFactory;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.matcher.RestAssuredMatchers.*;

import static org.hamcrest.Matchers.*;


import static io.restassured.RestAssured.baseURI;

public class RestAssuredTestNgPOST {


    @Test
    public void test_Post(){
         //key value should be as present in the json of post request of below url

        Map<String,Object> map=new HashMap<>();

        map.put("job","teacher");   //convert String to json
                                     //add JSON.simple dependency to pom
        System.out.println(map);

//        baseURI="https://reqres.in/api";  //impo
//        given()
//                .get("/users?page=2")
//                .then().statusCode(200)
//                .body("data[1].id",equalTo(8))
//                .log().all();
    }

}
