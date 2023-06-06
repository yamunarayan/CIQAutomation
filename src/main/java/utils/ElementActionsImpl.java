package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ElementActionsImpl implements ElementActions{


    WebDriver driver;

    public ElementActionsImpl(WebDriver driver){
        this.driver=driver;
    }

    @Override
    public WebElement locateElement(String locator, String value) {

        try{
            switch (locator){
                case "xpath": return driver.findElement(By.xpath(value));
                case "id": return driver.findElement(By.id(value));
                case "class": return driver.findElement(By.className(value));
                case "linktext": return driver.findElement(By.linkText(value));
                case "css": return driver.findElement(By.cssSelector(value));
                default: throw new RuntimeException("invalid locator selection");
            }
        }
        catch (NoSuchElementException exception){
            System.out.println(exception.getCause()+"element can't be found");
        }
        catch (StaleElementReferenceException exception){
            System.out.println("stale element reference exception"+exception.getCause());
        }
        catch (Exception exception){
            System.out.println("element can't be found");
        }
        return null;
    }

    @Override
    public List<WebElement> locateElements(String locator, String value) {
        try{
            switch (locator){
                case "xpath": return driver.findElements(By.xpath(value));
                case "id": return driver.findElements(By.id(value));
                case "class": return driver.findElements(By.className(value));
                case "linktext": return driver.findElements(By.linkText(value));
                case "css": return driver.findElements(By.cssSelector(value));
                default: throw new RuntimeException("invalid locator selection");
            }
        }
        catch (NoSuchElementException exception){
            System.out.println(exception.getCause()+"element can't be found");
        }
        catch (StaleElementReferenceException exception){
            System.out.println("stale element reference exception"+exception.getCause());
        }
        catch (Exception exception){
            System.out.println("element can't be found");
        }
        return null;
    }

    @Override
    public WebElement locateElementByXpath(String value) {
        try{
               return driver.findElement(By.xpath(value));
        }
        catch (NoSuchElementException exception){
            System.out.println(exception.getCause()+"element can't be found");
        }
        catch (StaleElementReferenceException exception){
            System.out.println("stale element reference exception"+exception.getCause());
        }
        catch (Exception exception){
            System.out.println("element can't be found");
        }
        return null;
    }

    @Override
    public WebElement locateElementById(String id) {
        try{
            return driver.findElement(By.id(id));
        }
        catch (NoSuchElementException exception){
            System.out.println(exception.getCause()+"element can't be found");
        }
        catch (StaleElementReferenceException exception){
            System.out.println("stale element reference exception"+exception.getCause());
        }
        catch (Exception exception){
            System.out.println("element can't be found");
        }
        return null;
    }

    @Override
    public WebElement locateElementByClass(String classValue) {
        try{
            return driver.findElement(By.cssSelector(classValue));
        }
        catch (NoSuchElementException exception){
            System.out.println(exception.getCause()+"element can't be found");
        }
        catch (StaleElementReferenceException exception){
            System.out.println("stale element reference exception"+exception.getCause());
        }
        catch (Exception exception){
            System.out.println("element can't be found");
        }
        return null;
    }

    @Override
    public void selectDropDownByIndex(WebElement element, int index) {
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    @Override
    public void selectDropDownByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    @Override
    public void selectDropDownByText(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByValue(text);
    }
}
