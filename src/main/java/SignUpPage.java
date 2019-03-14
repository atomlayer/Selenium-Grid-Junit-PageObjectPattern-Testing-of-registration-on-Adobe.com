import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends PageBase {
    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[@class=\"page-title\"]")
    private WebElement signUpLabel;

    @FindBy(id = "first_name")
    private WebElement firstNameInput;

    @FindBy(id="last_name")
    private WebElement lastNameInput;

    @FindBy(id="email_address")
    private WebElement emailAdressInput;

    private String countrySelect_Id="country";
    private String monthBirthSelect_Id ="month";
    private String dayBirthSelect_Id="day";
    private String yearBirthSelect_Id="year";

    @FindBy(id="create_account")
    private WebElement createAccountButton;

    @FindBy(xpath = "//label[@for=\"names\"]")
    private WebElement firstAndLastNameErrorLabel;

    @FindBy(xpath = "//label[@for=\"email_address\"]")
    private WebElement emailAddressErrorLabel;

    @FindBy(xpath = "//label[@for=\"bday\"]")
    private WebElement birthdayErrorLabel;

    @FindBy(xpath = "//li[@data-validation-rule=\"containsNumberOrSymbol\"]")
    private WebElement passNeedsContainsNumberOrSymbolAlert;

    @FindBy(xpath = "//li[@data-validation-rule=\"hasUpperAndLower\"]")
    private WebElement passNeedsHasUpperAndLowerAlert;

    @FindBy(xpath = "//li[@data-validation-rule=\"minlength\"]")
    private WebElement passNeedsMinLengthAlert;

    public String getSignUpLabel()
    {
        return signUpLabel.getText();
    }

    public SignUpPage typeFirstName(String firstName)
    {
        firstNameInput.sendKeys(firstName);
        return this;
    }

    public SignUpPage typeLastName(String lastName)
    {
        lastNameInput.sendKeys(lastName);
        return this;
    }

    public SignUpPage typeEmailAdress(String email)
    {
        emailAdressInput.sendKeys(email);
        return this;
    }

    public SignUpPage createAccount()
    {
        createAccountButton.click();
        return this;
    }

    public void selectOption(String selector_Id, String option)
    {
        driver.findElement(By.id(selector_Id)).click();
        driver.findElement(By.xpath(String.format("//select[@id=\"%s\"]/option[normalize-space()=\"%s\"]", selector_Id,option)))
               .click();
    }


    public SignUpPage selectCountry(String country)
    {
        selectOption(countrySelect_Id, country);
        return this;
    }

    public SignUpPage selectMonthBirth(String monthBirth)
    {
        selectOption(monthBirthSelect_Id, monthBirth);
        return this;
    }

    public SignUpPage selectDayBirth(int day)
    {
        selectOption(dayBirthSelect_Id, String.valueOf(day));
        return this;
    }

    private SignUpPage selectYearBirth(int year)
    {
        selectOption(yearBirthSelect_Id,String.valueOf(year));
        return this;
    }

    public String getFirstAndLastNameError()
    {
        return firstAndLastNameErrorLabel.getText();
    }

    public String getEmailAddressError()
    {
        return emailAddressErrorLabel.getText();
    }

    public String getBirthdayError()
    {
        return birthdayErrorLabel.getText();
    }

    public Boolean getNumberOrSymbolAlertStatus()
    {
        return Boolean.parseBoolean(passNeedsContainsNumberOrSymbolAlert
                .getAttribute("data-validation-status"));
    }

    public Boolean getUpperAndLowerAlertStatus()
    {
        return Boolean.parseBoolean(passNeedsHasUpperAndLowerAlert
                .getAttribute("data-validation-status"));
    }

    public  Boolean getMinLengthAlertStatus()
    {
        return Boolean.parseBoolean(passNeedsMinLengthAlert
                .getAttribute("data-validation-status"));
    }

}
