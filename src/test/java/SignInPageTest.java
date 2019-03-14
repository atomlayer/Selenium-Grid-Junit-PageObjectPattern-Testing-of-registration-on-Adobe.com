import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class SignInPageTest extends PageTestBase{

    SignInPage signInPage;

    @Before
    public void SetUp()
    {
        StartDriver();
        driver.get("https://adobeid-na1.services.adobe.com/renga-idprovider/pages/login?callback=https%3A%2F%2Fims-na1.adobelogin.com%2Fims%2Fadobeid%2Fadobedotcom2%2FAdobeID%2Ftoken%3Fredirect_uri%3Dhttps%253A%252F%252Fwww.adobe.com%252Findex2.html%2523from_ims%253Dtrue%2526old_hash%253D%2526api%253Dauthorize&client_id=adobedotcom2&scope=creative_cloud%2CAdobeID%2Copenid%2Cgnav%2Cread_organizations%2Cadditional_info.projectedProductContext%2Csao.ACOM_CLOUD_STORAGE%2Csao.stock%2Csao.cce_private%2Cadditional_info.roles&denied_callback=https%3A%2F%2Fims-na1.adobelogin.com%2Fims%2Fdenied%2Fadobedotcom2%3Fredirect_uri%3Dhttps%253A%252F%252Fwww.adobe.com%252Findex2.html%2523from_ims%253Dtrue%2526old_hash%253D%2526api%253Dauthorize%26response_type%3Dtoken&display=web_v2&relay=ebdb46ab-fa51-4fda-a98f-983a00bc0f83&locale=en_US&flow_type=token&idp_flow_type=login");
        signInPage =new SignInPage(driver);
    }

    @Test
    public void SignUnEmptyDataTest()
    {
        signInPage.signIn();
        Assert.assertEquals("Enter your email",signInPage.getEmailError());
        Assert.assertEquals("Enter your password",signInPage.getPassError());
    }

    @Test
    public void SignInShortPassTest()
    {
        signInPage.typePass("dfh12")
                .signIn();
        Assert.assertEquals("The password is too short", signInPage.getPassError());
    }

}
