package com.gmailapi.steps;

import com.gmailapi.actions.DeleteRequest;
import cucumber.api.java.en.When;

public class DeleteRequestSteps {

    @When("^I perform DELETE operation for \"([^\"]*)\"$")
    public void iPerformDELETEOperationFor(String urlPath) throws Throwable {
        new DeleteRequest().performDeleteOperation(urlPath);
    }
}
