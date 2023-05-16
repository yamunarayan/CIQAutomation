import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

public class WebDriverImpl implements WebDriverMethods{


    @Override
    public void enterText(WebElement ele, String text) {
        try {
            ele.sendKeys(text);
        }
        catch (NoSuchElementException exception){
            System.out.println("No such element was found");
        }
        catch (StaleElementReferenceException exception){
            System.out.println("stale element reference exception-->element wouldn't have been attached to DOM");
        }
        catch (Exception e){
            System.out.println("unknown exception occurred");
        }
    }

    @Override
    public void click(WebElement ele) {
        try {
            ele.click();
        }
        catch (NoSuchElementException exception){
            System.out.println("No such element was found");
        }
        catch (StaleElementReferenceException exception){
            System.out.println("stale element reference exception-->element wouldn't have been attached to DOM");
        }
        catch (Exception e){
            System.out.println("unknown exception occurred");
        }
    }
}
