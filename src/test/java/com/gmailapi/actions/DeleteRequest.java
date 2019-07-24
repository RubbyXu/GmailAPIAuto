package com.gmailapi.actions;

import com.gmailapi.steps.MessagesSteps;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class DeleteRequest {
    public static Response response;
    private static int msgCountBeforeDelete;

    public Response performDeleteOperation(String urlPath){
        String id = new MessagesSteps().theFirstMessageIdFromMessagesListAsPathParameter();
        setMsgCountBeforeDel();
        response =
                given().
                        pathParam("id", id).
                when().
                        delete("/messages/{id}").
                then().
                        extract().response();
        return response;
    }

    public static int getMsgCountBeforeDelete() {
        return msgCountBeforeDelete;
    }

    public void setMsgCountBeforeDel() {
        this.msgCountBeforeDelete = new Messages().getMsgNumbers();
    }
}
