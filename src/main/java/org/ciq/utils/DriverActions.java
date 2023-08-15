package org.ciq.utils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public interface DriverActions {

    void enterText(WebElement ele,String text);
    void enterText(WebElement ele, String text, Keys keys);
    void click(WebElement ele);

    WebElement locateElement(String locator, String value);

    List<WebElement> locateElements(String locator, String value);

    WebElement locateElementByXpath(String value);

    WebElement locateElementById(String id);

    WebElement locateElementByClass(String classValue);

    void selectDropDownByIndex(WebElement element, int index);

    void selectDropDownByValue(WebElement element, String value);

    void selectDropDownByText(WebElement element, String text);

    WebElement waitForElementTobeClickable(String element);
    WebElement waitForElementVisibility(String locator);

    List<WebElement> waitForElementsVisibility(String locator);

    void openNextTabNavigateToUrl(String url);




}
