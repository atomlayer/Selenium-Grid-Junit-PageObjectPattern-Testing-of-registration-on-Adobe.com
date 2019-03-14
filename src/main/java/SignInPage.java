import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends PageBase{
    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (id = "adobeid_username")
    private WebElement emailInput;

    @FindBy(id = "adobeid_password")
    private WebElement passInput;

    @FindBy(id="sign_in")
    private WebElement signInButton;

    @FindBy(xpath = "//label[@for=\"adobeid_username\"]")
    private WebElement emailErrorLabel;

    @FindBy(xpath = "//label[@for=\"adobeid_password\"]")
    private WebElement passErrorLabel;

    @FindBy(id="create_account")
    private WebElement createAccountLink;

    public SignInPage typePass(String pass)
    {
        passInput.sendKeys(pass);
        return this;
    }

    public SignInPage typeEmail(String email)
    {
        emailInput.sendKeys(email);
        return this;
    }

    public String getEmailError()
    {
        return emailErrorLabel.getText();
    }

    public String getPassError()
    {
        return passErrorLabel.getText();
    }

    public SignUpPage createNewAccount()
    {
        createAccountLink.click();
        return new SignUpPage(driver);
    }

    public SignInPage signIn()
    {
        signInButton.click();
        return this;
    }
}
