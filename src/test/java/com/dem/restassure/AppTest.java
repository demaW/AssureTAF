package com.dem.restassure;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Random;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest {
    final static String URI_JSON = "http://localhost";
    final static int BASE_PORT = 3000;
    final static String PATH_URI = "Cars";
    static ObjectMapper objectMapper;

    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = URI_JSON;
        RestAssured.port = BASE_PORT;
        objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
    }

    @Test
    public void testGet() {
        Car car = RestAssured.get(PATH_URI + "/d").as(Car.class);
        System.out.println(car);
        assertTrue(car.getModel().contentEquals("BMW"));
    }

    @Test
    public void testPost() {
        Car car = new Car("Fiat", "model" + new Random().nextInt(1000));
        String JSONString = null;
        try {
            JSONString = objectMapper.writeValueAsString(car);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        if (JSONString == null)
            assertTrue(false);
        given().contentType(ContentType.JSON).body(JSONString).when().post(PATH_URI);
        Car carReceived = RestAssured.get(PATH_URI + "/" + car.getId()).as(Car.class);
        assertTrue(carReceived.getId().contentEquals(car.getId()));
    }
}
