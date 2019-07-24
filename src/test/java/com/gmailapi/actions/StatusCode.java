package com.gmailapi.actions;

import org.testng.Assert;

public class StatusCode {
    public void verifyGetStatusCode(int statusCode){
        Assert.assertEquals(GetRequest.response.statusCode(), statusCode);
    }

    public void verifyPostStatusCode(int statusCode){
        Assert.assertEquals(PostRequest.response.statusCode(), statusCode);
    }

    public void verifyDeleteStatusCode(int statusCode){
        Assert.assertEquals(DeleteRequest.response.statusCode(), statusCode);
    }
}
