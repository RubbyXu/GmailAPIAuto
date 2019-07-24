package com.gmailapi.steps;

import com.gmailapi.actions.GetRequest;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class GetRequestSteps {
    private GetRequest getRequest;

    @Given("^I perform GET operation for \"([^\"]*)\"$")
    public void iPerformGETOperationFor(String urlPath) throws Throwable {
        new GetRequest().performGetOperation(urlPath);
    }

    @And("I pass query parameter$")
    public void iPassQueryParameter(DataTable dataTable) {
       getRequest = new GetRequest(dataTable);
    }

    @When("^I perform GET operation for \"([^\"]*)\" with parameters$")
    public void iPerformGETOperationForWithParameters(String urlPath) throws Throwable {
        getRequest.performGetOperationWithPrams(urlPath);
    }
}
