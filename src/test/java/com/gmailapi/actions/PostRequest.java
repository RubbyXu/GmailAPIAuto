package com.gmailapi.actions;

import com.gmailapi.prop.PropInstance;
import com.gmailapi.EmailMessage;
import cucumber.api.DataTable;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import static io.restassured.RestAssured.given;

public class PostRequest {
    private static final String USER_EMAIL_ADDRESS = "user_email_address";
    private static final String TO_EMAIL_ADDRESS = "to_email_address";
    private static final String MESSAGE_SUBJECT = "message_subject";
    private static final String MESSAGE_CONTENT = "message_content";
    private RequestSpecification request;
    public static Response response;

    public void sendJSON(){
        request = given().header("Content-Type", "application/json");
    }

    public void setRequestBody(DataTable dataTable){
        Map<String, String> requestBodyMap = getRequestBodyMap(dataTable);
        if (request != null){
            request = request.body(requestBodyMap);
            return;
        }
        request = given().body(requestBodyMap);
    }

    public void setEncodedRequestBody(){
        if (request != null){
            request = request.body(getEncodedRequestBody());
            return;
        }
        request = given().body(getEncodedRequestBody());
    }

    public Response performPostOperation(String urlPath){
        if (request != null) {
            response = request.when().post(urlPath).then().extract().response();
            return response;
        }
        response = given().when().post(urlPath).then().extract().response();
        return response;
    }

    private Map<String, String> getRequestBodyMap(DataTable dataTable){
        return  dataTable.asMap(String.class, String.class);
    }

    private Map<String, String> getEncodedRequestBody(){
        Properties prop = PropInstance.getPropInstance();
        String fromEMailAddr = prop.getProperty(USER_EMAIL_ADDRESS);
        String toEmailAddr = prop.getProperty(TO_EMAIL_ADDRESS);;
        String msgSubject = prop.getProperty(MESSAGE_SUBJECT);
        String msgContent = prop.getProperty(MESSAGE_CONTENT);

        EmailMessage emailMessage = new EmailMessage(
                fromEMailAddr, toEmailAddr, msgSubject, msgContent);
        String rawData = emailMessage.toString();
        Map<String, String> sendMsgReqBody = new HashMap<String, String>();
        sendMsgReqBody.put("raw", encode(rawData));
        return sendMsgReqBody;
    }

    private String encode(String rawData) {
        return Base64.getUrlEncoder()
                .withoutPadding()
                .encodeToString(rawData.getBytes(StandardCharsets.UTF_8));
    }
}
