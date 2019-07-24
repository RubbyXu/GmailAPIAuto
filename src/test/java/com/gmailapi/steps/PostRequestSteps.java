package com.gmailapi.steps;

import com.gmailapi.actions.PostRequest;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class PostRequestSteps {
    private PostRequest postRequest;

    @Given("I send JSON")
    public void iSendJSON() {
        postRequest = new PostRequest();
        postRequest.sendJSON();
    }

    @And("I set JSON request body with encoded data")
    public void iSetJSONRequestBodyWithEncodedData() {
        postRequest.setEncodedRequestBody();
    }

    @And("I set JSON request body to")
    public void iSetJSONRequestBodyTo(DataTable dataTable) {
        postRequest.setRequestBody(dataTable);
    }

    @When("^I perform POST operation for \"([^\"]*)\"$")
    public void iPerformPOSTOperationFor(String urlPath) throws Throwable {
        postRequest.performPostOperation(urlPath);
    }
}
