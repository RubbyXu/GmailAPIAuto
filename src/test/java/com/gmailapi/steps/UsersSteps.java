package com.gmailapi.steps;

import com.gmailapi.actions.*;
import cucumber.api.java.en.Then;

public class UsersSteps {
    @Then("^I should see user email address is in user profile$")
    public void iShouldSeeUserEmailAddressAsDefinedInPropertyFile() {
        new Users().verifyUserProfileEmail();
    }

    @Then("^I should see user email address is in message headers$")
    public void iShouldSeeUserEmailAddressIsInValueOfHeaders() {
        new Users().verifyMessageHeadersEmail();
    }
}
