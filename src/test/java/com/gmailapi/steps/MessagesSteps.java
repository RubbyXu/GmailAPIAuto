package com.gmailapi.steps;


import com.gmailapi.actions.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class MessagesSteps {
    @Then("^The number of messages should be greater than (\\d+)$")
    public void theNumberOfMessagesShouldBeGreaterThan(int empty) {
        new Messages().verifyMsgNumbersGreaterThan(empty);
    }

    @Given("^The first message id from messages list as path parameter$")
    public String theFirstMessageIdFromMessagesListAsPathParameter() {
        return new Messages().getFirstMsgId();
    }

    @Then("^I should see \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\" in labelIds$")
    public void iShouldSeeAndInLabelIds(String unread, String sent, String inbox) throws Throwable {
        new Messages().verifySendMsgLableIds(unread, sent, inbox);
    }

    @Then("^I should see error reason as \"([^\"]*)\"$")
    public void iShouldSeeErrorReasonAs(String arg0) throws Throwable {
        new Messages().verifySendMsgErrInvalidArgument();
    }

    @And("^The number of messages should be one less than before deleting$")
    public void theNumberOfMessagesShouldBeOneLessThanBeforeDeleting() {
        new Messages().verifyMsgNumbersAfterDel();
    }
}
