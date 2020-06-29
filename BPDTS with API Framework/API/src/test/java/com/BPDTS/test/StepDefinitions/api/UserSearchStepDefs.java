package com.BPDTS.test.StepDefinitions.api;

import com.BPDTS.test.framework.CommonMethods.APICommonMethods;
import com.BPDTS.test.framework.Helpers.GetResponse;
import com.BPDTS.test.framework.hooks.Screenshot.SetAPI;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

// This class is JUST for calling the methods and assetions, nothing else. The logic will happen at the common methods
public class UserSearchStepDefs {

    private Response response;

    @Given("^user is on the base URI$")
    public void user_is_on_the_base_URI() throws Throwable {
        RestAssured.baseURI=SetAPI.getBaseURL();
    }

    @When("^the user searches with the city \"([^\"]*)\" string$")
    public void the_user_searches_with_the_city_string(String cityName) throws Throwable {
        response = GetResponse.getCityUsers(cityName);
    }

    @Then("^the success code (\\d+) should be displayed to the user along with the Success message and the correct response headers$")
    public void the_success_code_should_be_displayed_to_the_user_along_with_the_Success_message_and_the_correct_response_headers(int code) throws Throwable {
        //Asserting the response code, Success message, response headers
        Assert.assertEquals(APICommonMethods.extractStatusCode(response),code);
        Assert.assertEquals(APICommonMethods.getContentType(response),"Content-Type=application/json");
        Assert.assertEquals(APICommonMethods.getConnection(response),"Connection=keep-alive");

    }

    @When("^the user sends the get request to fetch the instructions$")
    public void the_user_sends_the_get_request_to_fetch_the_instructions() throws Throwable {
        response = GetResponse.getInstructions();

    }

    @Then("^the success code (\\d+) along with the correct response body and the correct response headers should be displayed$")
    public void the_success_code_along_with_the_correct_response_body_and_the_correct_response_headers_should_be_displayed(int code) throws Throwable {
        Assert.assertEquals(APICommonMethods.extractStatusCode(response),code);
        Assert.assertEquals(APICommonMethods.extractStatusCode(response),code);
        Assert.assertEquals(APICommonMethods.getContentType(response),"Content-Type=application/json");
        Assert.assertEquals(APICommonMethods.getConnection(response),"Connection=keep-alive");
    }

    @When("^the user searches with the id \"([^\"]*)\"$")
    public void the_user_searches_with_the_id(String userID) throws Throwable {
        response = GetResponse.searchUserWithID(userID);
    }

    @Then("^the success code (\\d+) along with the matching user record and the correct response headers should be displayed$")
    public void the_success_code_along_with_the_matching_user_record_and_the_correct_response_headers_should_be_displayed(int code) throws Throwable {
        Assert.assertEquals(APICommonMethods.extractStatusCode(response),code);
        Assert.assertEquals(APICommonMethods.extractStatusCode(response),code);
        Assert.assertEquals(APICommonMethods.getContentType(response),"Content-Type=application/json");
        Assert.assertEquals(APICommonMethods.getConnection(response),"Connection=keep-alive");
    }

    @When("^the user sends the get request to fetch all the users$")
    public void the_user_sends_the_get_request_to_fetch_all_the_users() throws Throwable {
        response = GetResponse.getAllUsers();
    }

    @Then("^the success code (\\d+) along with all the available users and the correct response headers should be displayed$")
    public void the_success_code_along_with_all_the_available_users_and_the_correct_response_headers_should_be_displayed(int code) throws Throwable {
        Assert.assertEquals(APICommonMethods.extractStatusCode(response),code);
        Assert.assertEquals(APICommonMethods.extractStatusCode(response),code);
        Assert.assertEquals(APICommonMethods.getContentType(response),"Content-Type=text/html; charset=utf-8");
        Assert.assertEquals(APICommonMethods.getConnection(response),"Connection=keep-alive");
    }

    @Then("^the error code (\\d+) should be displayed to the user along with the error message \"([^\"]*)\" and the correct response headers$")
    public void theErrorCodeShouldBeDisplayedToTheUserAlongWithTheErrorMessageAndTheCorrectResponseHeaders(int code, String errorMessage) throws Throwable {
        Assert.assertEquals(APICommonMethods.extractStatusCode(response),code);
        APICommonMethods.compareMessage(response,errorMessage);
        Assert.assertEquals(APICommonMethods.extractStatusCode(response),code);
        Assert.assertTrue(APICommonMethods.getContentType(response).contains("Content-Type=text/html"));
        Assert.assertEquals(APICommonMethods.getConnection(response),"Connection=keep-alive");
    }


    @Then("^the error code (\\d+) along with the error message \"([^\"]*)\" and the correct response headers should be displayed$")
    public void theErrorCodeAlongWithTheErrorMessageAndTheCorrectResponseHeadersShouldBeDisplayed(int code, String errorMessage) throws Throwable {
        Assert.assertEquals(APICommonMethods.extractStatusCode(response),code);
        APICommonMethods.compareMessage(response,errorMessage);
        Assert.assertEquals(APICommonMethods.extractStatusCode(response),code);
        Assert.assertEquals(APICommonMethods.getContentType(response),"Content-Type=application/json");
        Assert.assertEquals(APICommonMethods.getConnection(response),"Connection=keep-alive");
    }
}
