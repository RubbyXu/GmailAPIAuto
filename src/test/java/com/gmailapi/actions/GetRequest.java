package com.gmailapi.actions;

import com.gmailapi.steps.MessagesSteps;
import cucumber.api.DataTable;
import io.restassured.response.Response;
import java.util.Map;
import static io.restassured.RestAssured.given;

public class GetRequest {
    private DataTable dataTable;
    public static Response response;

    public GetRequest(){
        super();
    }

    public GetRequest(DataTable dataTable){
        this.dataTable = dataTable;
    }

    public Response performGetOperation(String urlPath){
        response = given().get(urlPath).then().extract().response();
        return response;
    }

    public Response performGetOperationWithPrams(String urlPath){
        String id = new MessagesSteps().theFirstMessageIdFromMessagesListAsPathParameter();
        Map<String, String> queryParamMap = getQueryParamMap(dataTable);
        String formatValue = queryParamMap.get("format");
        response =
            given().
                    queryParam("format", formatValue).
                    pathParam("id", id).
            when().
                    get("/messages/{id}").
            then().
                    extract().response();
        return response;
    }

    private Map<String, String> getQueryParamMap(DataTable dataTable){
        return dataTable.asMap(String.class, String.class);
    }
}