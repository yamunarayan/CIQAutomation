package org.ciq.utils;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class WebDriverMethods implements DriverActions, ElementActions {

    WebDriver driver;

    public WebDriverMethods(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public void enterText(WebElement ele, String text) {
        try {
            ele.sendKeys(text);
        } catch (NoSuchElementException exception) {
            System.out.println(ele+" No such element was found");
        } catch (StaleElementReferenceException exception) {
            System.out.println(ele+" stale element reference exception-->element wouldn't have been attached to DOM");
        } catch (Exception e) {
            System.out.println(ele+" unknown exception occurred");
        }
    }

    @Override
    public void enterText(WebElement ele, String text, Keys keys) {
        try {
            ele.sendKeys(text,keys.ALT);
        } catch (NoSuchElementException exception) {
            System.out.println(ele+" No such element was found");
        } catch (StaleElementReferenceException exception) {
            System.out.println(ele+" stale element reference exception-->element wouldn't have been attached to DOM");
        } catch (Exception e) {
            System.out.println(ele+" unknown exception occurred");
        }
    }

    @Override
    public void click(WebElement ele) {
        try {
            ele.click();
        } catch (NoSuchElementException exception) {
            System.out.println(ele+" No such element was found");
        } catch (StaleElementReferenceException exception) {
            System.out.println(ele+" stale element reference exception-->element wouldn't have been attached to DOM");
        }
    }

    @Override
    public WebElement locateElement(String locator, String value) {

        try {
            switch (locator) {
                case "xpath":
                    return driver.findElement(By.xpath(value));
                case "id":
                    return driver.findElement(By.id(value));
                case "class":
                    return driver.findElement(By.className(value));
                case "linktext":
                    return driver.findElement(By.linkText(value));
                case "partiallinktext":
                    return driver.findElement(By.partialLinkText(value));
                case "css":
                    return driver.findElement(By.cssSelector(value));
                default:
                    throw new RuntimeException("invalid locator selection");
            }
        } catch (NoSuchElementException exception) {
            System.out.println(exception.getCause() + "element can't be found");
        } catch (StaleElementReferenceException exception) {
            System.out.println("stale element reference exception" + exception.getCause());
        } catch (Exception exception) {
            System.out.println("element can't be found");
        }
        return null;
    }

    @Override
    public List<WebElement> locateElements(String locator, String value) {
        try {
            switch (locator) {
                case "xpath":
                    return driver.findElements(By.xpath(value));
                case "id":
                    return driver.findElements(By.id(value));
                case "class":
                    return driver.findElements(By.className(value));
                case "linktext":
                    return driver.findElements(By.linkText(value));
                case "css":
                    return driver.findElements(By.cssSelector(value));
                default:
                    throw new RuntimeException("invalid locator selection");
            }
        } catch (NoSuchElementException exception) {
            System.out.println(exception.getCause() + "element can't be found");
        } catch (StaleElementReferenceException exception) {
            System.out.println("stale element reference exception" + exception.getCause());
        } catch (Exception exception) {
            System.out.println("element can't be found");
        }
        return null;
    }

    @Override
    public WebElement locateElementByXpath(String value) {
        try {
            return driver.findElement(By.xpath(value));
        } catch (NoSuchElementException exception) {
            System.out.println(exception.getCause() + "element can't be found");
        } catch (StaleElementReferenceException exception) {
            System.out.println("stale element reference exception" + exception.getCause());
        } catch (Exception exception) {
            System.out.println("element can't be found");
        }
        return null;
    }

    @Override
    public WebElement locateElementById(String id) {
        try {
            return driver.findElement(By.id(id));
        } catch (NoSuchElementException exception) {
            System.out.println(exception.getCause() + "element can't be found");
        } catch (StaleElementReferenceException exception) {
            System.out.println("stale element reference exception" + exception.getCause());
        } catch (Exception exception) {
            System.out.println("element can't be found");
        }
        return null;
    }

    @Override
    public WebElement locateElementByClass(String classValue) {
        try {
            return driver.findElement(By.cssSelector(classValue));
        } catch (NoSuchElementException exception) {
            System.out.println(exception.getCause() + "element can't be found");
        } catch (StaleElementReferenceException exception) {
            System.out.println("stale element reference exception" + exception.getCause());
        } catch (Exception exception) {
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
        select.selectByVisibleText(text);
    }

    @Override
    public WebElement waitForElementTobeClickable(String locator) {
        FluentWait<WebDriver> webDriverWait = new WebDriverWait(driver,
                Duration.ofSeconds(Integer.parseInt(ConfigLoader.getConfigValue("webDriverWait")))).ignoring(StaleElementReferenceException.class);
        return webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
    }

    @Override
    public WebElement waitForElementVisibility(String locator) {
        FluentWait<WebDriver> webDriverWait = new WebDriverWait(driver,
                Duration.ofSeconds(Integer.parseInt(ConfigLoader.getConfigValue("webDriverWait")))).ignoring(StaleElementReferenceException.class);
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    @Override
    public List<WebElement> waitForElementsVisibility(String locator) {
        FluentWait<WebDriver> webDriverWait = new WebDriverWait(driver,
                Duration.ofSeconds(Integer.parseInt(ConfigLoader.getConfigValue("webDriverWait")))).ignoring(StaleElementReferenceException.class);
        return webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator)));
    }

    @Override
    public void openNextTabNavigateToUrl(String url){
        try{
            ((JavascriptExecutor)driver).executeScript("window.open()");
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(tabs.size()-1));
            driver.navigate().to(url);
        }
        catch (Exception e){
            System.out.println("Exception has occurred..");
        }

    }

    public void scrollDown(int x, int y){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy("+x+","+y+")", "");
    }

    public void scrollToView(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",element);
    }

    public void switchToChildWindow(String windowName){
        Set<String> windowHandles = driver.getWindowHandles();
        for(String handle : windowHandles){
            driver.switchTo().window(handle);
            if(driver.getTitle().contains(windowName)){

            }
        }
    }

    public String getParentWindow(){
        String parentWindow = driver.getWindowHandle();
        return parentWindow;
    }

    public void switchToWindow(String parent){
        driver.switchTo().window(parent);
    }

    public String getTitle(){
        String title=driver.getTitle();
        return title;
    }

    public void performAction(WebElement locator, String keyaction){
        Actions action= new Actions(driver);
        action.sendKeys(keyaction).perform();
    }

    public String getAttribute(String locator, String attribute) {
        String attributeValue = locateElementByXpath(locator).getAttribute(attribute);
        return attributeValue;
    }

    public void switchToFrame(String frameid){
        driver.switchTo().frame(frameid);
    }

    public void waitforElementToLoad(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    public String[] regexUsingSpace(String text){
       String[] splittedArray = text.split("\s");
       return splittedArray;
    }

    public String dateConversion(String inputDate){
        SimpleDateFormat inputDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date;
        try{
        date=inputDateFormat.parse(inputDate);
         }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        SimpleDateFormat outputDateFormat = new SimpleDateFormat("MMMM d, yyyy");
        return outputDateFormat.format(date);
    }

    public String getLoggedInUserName(String locator){
        String loggedInUserName = driver.findElement(By.xpath(locator)).getText();
                return loggedInUserName;
    }

    public String getCurrentUrl(){
        String currentUrl = driver.getCurrentUrl();
        return currentUrl;
    }

    public void explicitWait(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(element));

    }

}
