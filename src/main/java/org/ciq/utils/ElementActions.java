package org.ciq.utils;

import org.openqa.selenium.WebElement;

import java.util.List;

public interface ElementActions {

    WebElement locateElement(String locator, String value);

    List<WebElement> locateElements(String locator, String value);

    WebElement locateElementByXpath(String value);

    WebElement locateElementById(String id);

    WebElement locateElementByClass(String classValue);

    void selectDropDownByIndex(WebElement element, int index);

    void selectDropDownByValue(WebElement element, String value);

    void selectDropDownByText(WebElement element, String text);

}
