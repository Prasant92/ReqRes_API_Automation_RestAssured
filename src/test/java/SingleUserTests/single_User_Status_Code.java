package SingleUserTests;

import com.CoreAPICode.GET_Single_User;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class single_User_Status_Code {

    GET_Single_User get_single_user = new GET_Single_User();

    @BeforeTest
    public void setUp() {
        get_single_user.buildRequestResponseSpecs_SingleUser();
        get_single_user.processRequest_SingleUser(2);
    }

    @Test()
    public void validateStatusCodeForSingleUserGETCall() {
        get_single_user.validateResponseStatusCode(200);
    }

    @Parameters("responseTime")
    @Test(dependsOnMethods = {"validateStatusCodeForSingleUserGETCall"})
    public void validateResponseTimeForSingleUserGETCall(float responseTime) {
        if(get_single_user.retrieveResponseTime() <= responseTime) {
            System.out.println("The response time " + get_single_user.retrieveResponseTime() + " is lesser than "
                + responseTime);
        }
    }

    @Parameters("contentType")
    @Test(dependsOnMethods = {"validateResponseTimeForSingleUserGETCall"})
    public void validateResponseContentTypeForSingleUserGETCall(String contentType) {
        get_single_user.validateResponseContentType(contentType);
    }

    @Parameters("statusMessage")
    @Test(dependsOnMethods = {"validateResponseContentTypeForSingleUserGETCall"})
    public void validateResponseStatusMessageForSingleUserGETCall(String statusMessage) {
        get_single_user.validateResponseStatusMessage(statusMessage);
    }
}
