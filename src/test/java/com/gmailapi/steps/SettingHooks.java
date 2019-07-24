package com.gmailapi.steps;

import com.gmailapi.prop.PropInstance;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
import java.util.Properties;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class SettingHooks {
    private static final String ENABLE_AUTO_REPLY = "enable_auto_reply";
    private static final String RESPONSE_SUBJECT = "response_subject";
    private static final String RESPONSE_BODY_PLAIN_TEXT = "response_body_plain_text";
    private static final String RESPONSE_BODY_HTML = "response_body_html";
    private static final String RESTRICT_TO_CONTACTS = "restrict_to_contacts";
    private static final String RESTRICT_TO_DOMAIN = "restrict_to_domain";
    private static final String DURATION_TIME = "duration_time";

    @Before("@VacationSetting")
    public void setUpUsersSettings(){
        enableVacationAutoReply();
    }

    @After("@VacationSetting")
    public void tearDownUsersSettings(){
        JSONObject requestParams = new JSONObject();
        requestParams.put("enableAutoReply", "false");
        given().
                header("Content-Type", "application/json").
                body(requestParams.toString()).
                when().
                put("/settings/vacation").
                then().
                statusCode(HttpStatus.SC_OK);
    }

    private void enableVacationAutoReply(){
        Properties prop = PropInstance.getPropInstance();
        JSONObject requestParams = new JSONObject();
        requestParams.put("enableAutoReply", Boolean.valueOf(prop.getProperty(ENABLE_AUTO_REPLY)));
        requestParams.put("responseSubject", prop.getProperty(RESPONSE_SUBJECT));
        requestParams.put("responseBodyPlainText", prop.getProperty(RESPONSE_BODY_PLAIN_TEXT));
        requestParams.put("responseBodyHtml", prop.getProperty(RESPONSE_BODY_HTML));
        requestParams.put("restrictToContacts", Boolean.valueOf(prop.getProperty(RESTRICT_TO_CONTACTS)));
        requestParams.put("restrictToDomain", Boolean.valueOf(prop.getProperty(RESTRICT_TO_DOMAIN)));
        long startTime = System.currentTimeMillis();
        long endTime = startTime + Long.valueOf(prop.getProperty(DURATION_TIME));
        requestParams.put("startTime", startTime);
        requestParams.put("endTime", endTime);
        given().
                header("Content-Type", "application/json").
                body(requestParams.toString()).
                when().
                put("/settings/vacation").
                then().
                statusCode(HttpStatus.SC_OK).
                body("enableAutoReply", equalTo(true));
    }
}
