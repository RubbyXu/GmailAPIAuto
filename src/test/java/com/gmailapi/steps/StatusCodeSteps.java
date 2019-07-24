package com.gmailapi.steps;

import com.gmailapi.actions.StatusCode;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class StatusCodeSteps {
    @And("^Get Request return status code should be (\\d+)$")
    public void getRequestReturnStatusCodeShouldBe(int statusCode) {
        new StatusCode().verifyGetStatusCode(statusCode);
    }

    @And("^Post Request return status code should be (\\d+)$")
    public void postRequestReturnStatusCodeShouldBe(int statusCode) {
        new StatusCode().verifyPostStatusCode(statusCode);
    }

    @Then("^Delete Request return status code should be (\\d+)$")
    public void deleteRequestReturnStatusCodeShouldBe(int statusCode) {
        new StatusCode().verifyDeleteStatusCode(statusCode);
    }
}