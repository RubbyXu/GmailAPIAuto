package com.gmailapi.actions;

import com.gmailapi.prop.PropInstance;
import org.testng.Assert;
import java.util.ArrayList;

public class Users {
    private static final String USER_EMAIL_ADDRESS = "user_email_address";

    public void verifyUserProfileEmail(){
        String str1 = GetRequest.response.body().path("payload.headers.value");
        String str2 = PropInstance.getPropInstance().getProperty(USER_EMAIL_ADDRESS);
        GetRequest.response.body().path("emailAddress").
                equals(PropInstance.getPropInstance().getProperty(USER_EMAIL_ADDRESS));
    }

    public void verifyMessageHeadersEmail(){
        ArrayList<String> msgHeadersValueList = GetRequest.response.body().path("payload.headers.value");
        String userEmailAddress = PropInstance.getPropInstance().getProperty(USER_EMAIL_ADDRESS);
        Assert.assertTrue(msgHeadersValueList.toString().contains(userEmailAddress));
    }
}