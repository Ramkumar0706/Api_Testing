package com.api;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class PetStoreAutomation {
	
	
	  @Test
	    public void user1(){
	        Response response = given()
	                .header("accept","application/json")
	                .header("Content-Type","application/json")
	                .body("{\n" +
	                        "  \"id\": 2,\n" +
	                        "  \"username\": \"Ramkumar\",\n" +
	                        "  \"firstName\": \"string\",\n" +
	                        "  \"lastName\": \"string\",\n" +
	                        "  \"email\": \"string\",\n" +
	                        "  \"password\": \"ramkumar\",\n" +
	                        "  \"phone\": \"877875767\",\n" +
	                        "  \"userStatus\": 0\n" +
	                        "}\n").when().post("https://petstore.swagger.io/v2/user");
	        response.prettyPrint();
	        response.then().statusCode(200);
	        Assert.assertEquals(response.statusCode(),200);
	    }
	    @Test
	    public void createWithArray(){
	        Response response = given()
	                .header("accept","application/json")
	                .header("Content-Type","application/json")
	                .body("[\n" +
	                        "  {\n" +
	                        "    \"id\": 1,\n" +
	                        "    \"username\": \"Ramkumar\",\n" +
	                        "    \"firstName\": \"string\",\n" +
	                        "    \"lastName\": \"string\",\n" +
	                        "    \"email\": \"string\",\n" +
	                        "    \"password\": \"harshal\",\n" +
	                        "    \"phone\": \"string\",\n" +
	                        "    \"userStatus\": 0\n" +
	                        "  },\n" +
	                        "{\n" +
	                        "    \"id\": 3,\n" +
	                        "    \"username\": \"rohit\",\n" +
	                        "    \"firstName\": \"string\",\n" +
	                        "    \"lastName\": \"string\",\n" +
	                        "    \"email\": \"string\",\n" +
	                        "    \"password\": \"rohit\",\n" +
	                        "    \"phone\": \"string\",\n" +
	                        "    \"userStatus\": 0\n" +
	                        "  }\n" +
	                        "]")
	                .when().post("https://petstore.swagger.io/v2/user/createWithArray\n");
	        response.prettyPrint();
	        response.then().statusCode(200);
	        Assert.assertEquals(response.statusCode(),200);

	    }
	    @Test
	    public void logout(){
	        Response response = given()
	                .header("accept","application/json")
	                .when()
	                .get("https://petstore.swagger.io/v2/user/logout\n");
	        response.prettyPrint();
	        response.then().statusCode(200);
	        Assert.assertEquals(response.statusCode(),200);
	    }
	    @Test
	    public void login(){
	        Response response = given()
	                .header("accept","application/json")
	                .when()
	                .queryParam("username","Ramkumar")
	                .queryParam("password","Ramkumar")
	                .get("https://petstore.swagger.io/v2/user/login?username=nitish&password=nitish");
	        response.prettyPrint();
	        response.then().statusCode(200);
	        Assert.assertEquals(response.statusCode(),200);
	    }
	    @Test
	    public void deleteUser() {
	        Response response = given()
	                .header("accept", "application/json")
	                .when()
	                .delete("https://petstore.swagger.io/v2/user/rohit");
	        response.prettyPrint();
	        response.then().statusCode(200);
	        Assert.assertEquals(response.statusCode(), 200);
	    }
	    @Test
	    public void updatedUser() {
	        Response response = given()
	                .header("Content-Type","application/json")
	                .header("accept", "application/json")
	                .queryParam("username", "Ramkumar")
	                .body("{\n" +
	                        "  \"id\": 2,\n" +
	                        "  \"username\": \"nitish\",\n" +
	                        "  \"firstName\": \"string\",\n" +
	                        "  \"lastName\": \"string\",\n" +
	                        "  \"email\": \"string\",\n" +
	                        "  \"password\": \"Ramkumar\",\n" +
	                        "  \"phone\": \"6766735767\",\n" +
	                        "  \"userStatus\": 0\n" +
	                        "}")
	                .when()
	                .put("https://petstore.swagger.io/v2/user/nitish\n");
	        response.prettyPrint();
	        response.then().statusCode(200);
	        Assert.assertEquals(response.statusCode(), 200);
	    }
	    @Test
	    public void getUserByUsername(){
	        Response response = given()
	                .header("accept", "application/json")
	                .when()
	                .get("https://petstore.swagger.io/v2/user/nitish\n");
	        response.prettyPrint();
	        response.then().statusCode(200);
	        Assert.assertEquals(response.statusCode(), 200);
	    }
	    @Test
	    public void creatUserWithGivenInputArray(){
	        Response response = given()
	                .header("accept","application/json")
	                .header("Content-Type","application/json")
	                .body("[\n" +
	                        "  {\n" +
	                        "    \"id\": 4,\n" +
	                        "    \"username\": \"Ramkumar\",\n" +
	                        "    \"firstName\": \"string\",\n" +
	                        "    \"lastName\": \"string\",\n" +
	                        "    \"email\": \"string\",\n" +
	                        "    \"password\": \"Ramkumar\",\n" +
	                        "    \"phone\": \"string\",\n" +
	                        "    \"userStatus\": 0\n" +
	                        "  },\n" +
	                        "{\n" +
	                        "    \"id\": 5,\n" +
	                        "    \"username\": \"Ramkumar\",\n" +
	                        "    \"firstName\": \"string\",\n" +
	                        "    \"lastName\": \"string\",\n" +
	                        "    \"email\": \"string\",\n" +
	                        "    \"password\": \"Ramkumar\",\n" +
	                        "    \"phone\": \"string\",\n" +
	                        "    \"userStatus\": 0\n" +
	                        "  }\n" +
	                        "]")
	                .when().post("https://petstore.swagger.io/v2/user/createWithArray\n");
	        response.prettyPrint();
	        response.then().statusCode(200);
	        Assert.assertEquals(response.statusCode(),200);
	    }

	    @Test
	    public void petInventoriesByStatus(){
	        Response response = given()
	                .header("accept","application/json")
	                .when()
	                .get("https://petstore.swagger.io/v2/store/inventory\n");
	        response.prettyPrint();
	        response.then().statusCode(200);
	        Assert.assertEquals(response.statusCode(),200);
	    }
	    @Test
	    public void orderForPet(){
	        Response response = given()
	                .header("accept","application/json")
	                .header("Content-Type","application/json")
	                .body("\"id\": 1,\n" +
	                        "  \"petId\": 1,\n" +
	                        "  \"quantity\": 10,\n" +
	                        "  \"shipDate\": \"2024-08-12T08:53:58.525+0000\",\n" +
	                        "  \"status\": \"placed\",\n" +
	                        "  \"complete\": true")
	                .when()
	                .post("https://petstore.swagger.io/v2/store/order\n");
	        response.prettyPrint();
	    }
	    @Test
	    public void findOrderById(){
	        Response response = given()
	                .header("accept","application/json")
	                .when()
	                .get("https://petstore.swagger.io/v2/store/order/1\n");
	        response.prettyPrint();
	        response.then().statusCode(200);
	        Assert.assertEquals(response.statusCode(),200);
	    }
	    @Test
	    public void deleteOrderByID(){
	        Response response = given()
	                .header("accept","application/json")
	                .when()
	                .delete("https://petstore.swagger.io/v2/store/order/1\n");
	        response.prettyPrint();
	        response.then().statusCode(200);
	        Assert.assertEquals(response.statusCode(),200);
	    }

	    @Test
	    public void addNewPet(){
	        Response response = given()
	                .header("accept","application/json")
	                .header("Content-Type","application/json")
	                .body("{\n" +
	                        "  \"id\": 2,\n" +
	                        "  \"category\": {\n" +
	                        "    \"id\": 2,\n" +
	                        "    \"name\": \"cat\"\n" +
	                        "  },\n" +
	                        "  \"name\": \"doggie\",\n" +
	                        "  \"photoUrls\": [\n" +
	                        "    \"string\"\n" +
	                        "  ],\n" +
	                        "  \"tags\": [\n" +
	                        "    {\n" +
	                        "      \"id\": 0,\n" +
	                        "      \"name\": \"string\"\n" +
	                        "    }\n" +
	                        "  ],\n" +
	                        "  \"status\": \"available\"\n" +
	                        "}")
	                .when()
	                .post("https://petstore.swagger.io/v2/pet\n");
	        response.prettyPrint();
	        response.then().statusCode(200);
	        Assert.assertEquals(response.statusCode(),200);

	    }

	    @Test
	    public void updateExistingPet(){
	        Response response = given()
	                .header("accept","application/json")
	                .header("Content-Type","application/json")
	                .body("{\n" +
	                        "  \"id\": 2,\n" +
	                        "  \"category\": {\n" +
	                        "    \"id\": 2,\n" +
	                        "    \"name\": \"cat\"\n" +
	                        "  },\n" +
	                        "  \"name\": \"doggie\",\n" +
	                        "  \"photoUrls\": [\n" +
	                        "    \"string\"\n" +
	                        "  ],\n" +
	                        "  \"tags\": [\n" +
	                        "    {\n" +
	                        "      \"id\": 0,\n" +
	                        "      \"name\": \"string\"\n" +
	                        "    }\n" +
	                        "  ],\n" +
	                        "  \"status\": \"available\"\n" +
	                        "}")
	                .when()
	                .put("https://petstore.swagger.io/v2/pet\n");
	        response.prettyPrint();
	        response.then().statusCode(200);
	        Assert.assertEquals(response.statusCode(),200);

	    }
	    @Test
	    public void petByStatus(){
	        Response response = given()
	                .header("accept","application/json")
	                .when()
	                .get("https://petstore.swagger.io/v2/pet/findByStatus?status=available\n");
	        response.prettyPrint();
	        response.then().statusCode(200);
	        Assert.assertEquals(response.statusCode(),200);
	    }
	    @Test
	    public void petByID(){
	        Response response = given()
	                .header("accept","application/json")
	                .when()
	                .get("https://petstore.swagger.io/v2/pet/2\n");
	        response.prettyPrint();
	        response.then().statusCode(200);
	        Assert.assertEquals(response.statusCode(),200);
	    }
	    @Test
	    public void updatePetFormData(){
	        Response response = given()
	                .header("accept","application/json")
	                .header("Content-Type","application/x-www-form-urlencoded")
	                .body("name=shera&status=pending")
	                .when()
	                .post("https://petstore.swagger.io/v2/pet/1\n");
	        response.prettyPrint();
	        response.then().statusCode(200);
	        Assert.assertEquals(response.statusCode(),200);
	    }
	    @Test
	    public void deletePet(){
	        Response response = given()
	                .header("accept","application/json")
	                .when()
	                .delete("https://petstore.swagger.io/v2/pet/1");
	        response.prettyPrint();
	        response.then().statusCode(200);
	        Assert.assertEquals(response.statusCode(),200);
	    }

}
