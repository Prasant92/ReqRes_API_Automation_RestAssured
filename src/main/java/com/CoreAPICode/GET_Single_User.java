package com.CoreAPICode;

import configReader.ConfigPropertiesReader;
import io.restassured.RestAssured;

public class GET_Single_User extends CoreClass{

    public void processRequest_SingleUser(int user_ID) {
        configPropertiesReader = new ConfigPropertiesReader();
        resp = RestAssured.given(reqspec).
                pathParam("userID", user_ID).
                when().
                get(configPropertiesReader.getUsersPathParam() + "/{userID}").
                then().
                extract().
                response();
    }
}
