package com.BPDTS.test.framework.Helpers;


import com.BPDTS.test.framework.ENUMS.APIEndPoints;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class GetResponse {

    static Response response;
    static String url;

    //hit city endpoint and return the results
    public static Response getCityUsers(String city_name) {
        url = APIEndPoints.CITY_NAME.getUrl();
        return response = given().log().all().when().get(url,city_name);
    }

    //hit instruction endpoint and return the results
    public static Response getInstructions(){
        url = APIEndPoints.INSTRUCTIONS.getUrl();
        return response= given().log().all().when().get(url);
    }

    //hit searchuser  endpoint and return the results
    public static Response searchUserWithID(String userID){
        url = APIEndPoints.USER_ID.getUrl();
        return response = given().log().all().when().get(url,userID);
    }

    // retuen all the users
    public static Response getAllUsers(){
        url = APIEndPoints.ALL_USERS.getUrl();
        return response = given().log().all().when().get();
    }
}
