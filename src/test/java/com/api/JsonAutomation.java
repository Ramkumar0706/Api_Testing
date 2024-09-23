package com.api;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class JsonAutomation {
	

    private static final String BASE_URL = "http://localhost:3000/employees";

    @Test
    public void createEmployee() {
        String employeeJson = "{\n" +
                "  \"id\": \"100\",\n" +
                "  \"FIRST_NAME\": \"Steven\",\n" +
                "  \"LAST_NAME\": \"King\",\n" +
                "  \"EMAIL\": \"SKING\",\n" +
                "  \"PHONE_NUMBER\": \"515.123.4567\",\n" +
                "  \"HIRE_DATE\": \"1987-06-17\",\n" +
                "  \"SALARY\": 24000,\n" +
                "  \"DEPARTMENT_ID\": 90,\n" +
                "  \"Image\": \"https://www.oracle.com/webfolder/technetwork/jet/Images/dvt/10.png\"\n" +
                "}";

        Response response = given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body(employeeJson)
                .when().post(BASE_URL);

        response.prettyPrint();
        Assert.assertEquals(201, response.statusCode());
    }

    @Test
    public void readEmployee() {
        Response response = given()
                .header("accept", "application/json")
                .when().get(BASE_URL + "/100");

        response.prettyPrint();
        Assert.assertEquals(200, response.statusCode());
    }

    @Test
    public void updateEmployee() {
        String updatedEmployeeJson = "{\n" +
                "  \"id\": \"100\",\n" +
                "  \"FIRST_NAME\": \"Steven Updated\",\n" +
                "  \"LAST_NAME\": \"King\",\n" +
                "  \"EMAIL\": \"SKING\",\n" +
                "  \"PHONE_NUMBER\": \"515.123.4567\",\n" +
                "  \"HIRE_DATE\": \"1987-06-17\",\n" +
                "  \"SALARY\": 24000,\n" +
                "  \"DEPARTMENT_ID\": 90,\n" +
                "  \"Image\": \"https://www.oracle.com/webfolder/technetwork/jet/Images/dvt/10.png\"\n" +
                "}";

        Response response = given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body(updatedEmployeeJson)
                .when().put(BASE_URL + "/100"); 

        response.prettyPrint();
        Assert.assertEquals(200, response.statusCode()); 
    }

    @Test
    public void deleteEmployee() {
        Response response = given()
                .header("accept", "application/json")
                .when().delete(BASE_URL + "/100"); 

        response.prettyPrint();
        Assert.assertEquals(204, response.statusCode()); 
    }
}
