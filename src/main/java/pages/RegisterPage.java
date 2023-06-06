package pages;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utils.ElementActionsImpl;
import utils.WebDriverImpl;

public class RegisterPage {

    public WebDriver driver;
    public ElementActionsImpl elementActions;
    public WebDriverImpl webDriverImpl;



    public RegisterPage(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,15), this);
        elementActions=new ElementActionsImpl(driver);
        webDriverImpl=new WebDriverImpl(driver);
    }

    @FindBy(xpath = "//input[@type='text']")
    private WebElement firstName;

    @FindBy(xpath = "(//input[@type='text'])[2]")
    private WebElement lastName;

    @Step("entering first name")
    public void enterFirstName() {
        webDriverImpl.enterText(firstName,"first name");
    }

    @Step("entering last name")
    public void enterLastName() {
        webDriverImpl.enterText(lastName,"first name");

    }
}
