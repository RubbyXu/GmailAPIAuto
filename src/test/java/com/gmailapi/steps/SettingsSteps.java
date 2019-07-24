package com.gmailapi.steps;

import com.gmailapi.actions.Settings;
import cucumber.api.java.en.Then;

public class SettingsSteps {
    @Then("^I should see \"([^\"]*)\" is true$")
    public void iShouldSeeIsTrue(String enableAutoReply) throws Throwable {
        new Settings().verifyEnableAutoReply(enableAutoReply);
    }
}