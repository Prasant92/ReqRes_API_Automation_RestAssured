package com.CoreAPICode;

import configReader.ConfigPropertiesReader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class CoreClass {

    RequestSpecBuilder reqspecbuild = null;
    RequestSpecification reqspec = null;
    static Response resp;

    ConfigPropertiesReader configPropertiesReader;

    public void buildRequestResponseSpecs_SingleUser() {
        configPropertiesReader = new ConfigPropertiesReader();
        reqspecbuild = new RequestSpecBuilder().
                setBaseUri(configPropertiesReader.getBaseURI()).
                setContentType(ContentType.JSON).
                log(LogDetail.ALL);
        reqspec = reqspecbuild.build();
    }

    public void validateResponseStatusCode(int statusCode) {
        int respCode = resp.getStatusCode();
        System.out.println("The response code is " + respCode);
        Assert.assertEquals(respCode, statusCode, "Codes don't match");
    }

    public void validateResponseContentType(String contentType) {
        String respContentType = resp.getContentType();
        System.out.println("The response content type is " + respContentType);
        Assert.assertEquals(respContentType, contentType, "Content types don't match");
    }

    public void validateResponseStatusMessage(String statusMessage) {
        String respStatusMessage = resp.getStatusLine().toUpperCase().substring(13);
        System.out.println("The response status message is " + respStatusMessage);
        Assert.assertEquals(respStatusMessage, statusMessage, "Content types don't match");
    }

    public long retrieveResponseTime() {
        System.out.println("The response time is " + resp.getTime());
        return resp.getTimeIn(TimeUnit.SECONDS);
    }
}
