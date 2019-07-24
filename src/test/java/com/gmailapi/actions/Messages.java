package com.gmailapi.actions;

import org.testng.Assert;
import java.util.ArrayList;

public class Messages {
    public String getFirstMsgId(){
        new GetRequest().performGetOperation("/messages");
        ArrayList<String> messageIdsList = GetRequest.response.path("messages.id");
        return messageIdsList.get(0);
    }

    public void verifyMsgNumbersGreaterThan(int empty){
        Assert.assertTrue(getMsgNumbers()>empty);
    }

    public void verifySendMsgLableIds(String unread, String sent, String inbox){
        ArrayList<String> actualLableIds = new ArrayList<String>();
        actualLableIds.add(unread);
        actualLableIds.add(sent);
        actualLableIds.add(inbox);
        Assert.assertEquals(PostRequest.response.body().path("labelIds"), actualLableIds);
    }

    public void verifySendMsgErrInvalidArgument(){
        ArrayList<String> expectedError = new ArrayList<String>();
        expectedError.add("invalidArgument");
        Assert.assertEquals(PostRequest.response.body().path("error.errors.reason"), expectedError);
    }

    public void verifyMsgNumbersAfterDel(){
        int msgCountBeforeDelete = DeleteRequest.getMsgCountBeforeDelete();
        int msgCountAfterDelete = new GetRequest().
                performGetOperation("/messages").path("resultSizeEstimate");
        Assert.assertEquals(msgCountBeforeDelete - msgCountAfterDelete, 1);
    }

    public int getMsgNumbers(){
        return GetRequest.response.body().path("resultSizeEstimate");
    }
}
