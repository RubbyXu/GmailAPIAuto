package com.gmailapi.actions;

import org.testng.Assert;

public class Settings {
    public void verifyEnableAutoReply(String enableAutoReply){
        Assert.assertEquals(GetRequest.response.body().path(enableAutoReply), Boolean.valueOf(true));
    }
}
