import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;

public class SignUpPageTest extends PageTestBase{

    SignUpPage signUpPage;

    @Before
    public void SetUp() throws MalformedURLException {
        StartDriver();
        driver.get("https://adobeid-na1.services.adobe.com/renga-idprovider/pages/create_account?client_id=adobedotcom2&callback=https%3A%2F%2Fims-na1.adobelogin.com%2Fims%2Fadobeid%2Fadobedotcom2%2FAdobeID%2Ftoken%3Fredirect_uri%3Dhttps%253A%252F%252Fwww.adobe.com%252Findex2.html%2523from_ims%253Dtrue%2526old_hash%253D%2526api%253Dauthorize%26scope%3Dcreative_cloud%252CAdobeID%252Copenid%252Cgnav%252Cread_organizations%252Cadditional_info.projectedProductContext%252Csao.ACOM_CLOUD_STORAGE%252Csao.stock%252Csao.cce_private%252Cadditional_info.roles&denied_callback=https%3A%2F%2Fims-na1.adobelogin.com%2Fims%2Fdenied%2Fadobedotcom2%3Fredirect_uri%3Dhttps%253A%252F%252Fwww.adobe.com%252Findex2.html%2523from_ims%253Dtrue%2526old_hash%253D%2526api%253Dauthorize%26response_type%3Dtoken&display=web_v2&locale=en_US&relay=ebdb46ab-fa51-4fda-a98f-983a00bc0f83&flow=true&flow_type=token&idp_flow_type=login&remember_me=on&esid=ARCmxqLC65fR2ES0g06NJKRDnc8QfQfJk1GrsoJxoabnDDcmeKTSYh3nXQgSK5K7QnA-n_aKV4IWIVF0faS80nUPvpjEzLQMv4I80aWFdN9lk9b7-coSpUagNcHoD8HkVXuE1wCrBjrk8AqLKfVUZ04&s_account=adbadobenonacdcprod%2Cadbims");
        signUpPage = new SignUpPage(driver);
    }

    @Test
    public void SignUpEmptyDataTest()
    {
        signUpPage.createAccount();
        Assert.assertEquals("Enter your first and last name",signUpPage.getFirstAndLastNameError());
        Assert.assertEquals("Enter a valid email address",signUpPage.getEmailAddressError());
        Assert.assertFalse(signUpPage.getMinLengthAlertStatus());
        Assert.assertFalse(signUpPage.getNumberOrSymbolAlertStatus());
        Assert.assertFalse(signUpPage.getMinLengthAlertStatus());
        Assert.assertEquals("Select your date of birth",signUpPage.getBirthdayError());
    }


}
