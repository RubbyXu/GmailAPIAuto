package com.gmailapi.runner;

import com.gmailapi.prop.PropInstance;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.BeforeSuite;
import java.util.Properties;
import static io.restassured.RestAssured.*;

@CucumberOptions(features="src/main/resources/features", glue="com.gmailapi/steps")
public class TestGmailAPI extends AbstractTestNGCucumberTests {
    private static final String ACCESS_TOKEN = "access_token";
    private static final String BASE_URI = "base_uri";
    private Properties prop;

    @BeforeSuite
    public void setUpSuite() {
        prop = PropInstance.getPropInstance();
        String accessToken = prop.getProperty(ACCESS_TOKEN);
        authentication = oauth2(accessToken);
        baseURI = prop.getProperty(BASE_URI);
    }
}
