package org.ciq.utils;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

    private static DriverFactory driverFactory;
    public static ThreadLocal<WebDriver> tlWebDriver=new ThreadLocal<>();

    private DriverFactory(){

    }

    public static DriverFactory getInstance(){
        if(driverFactory==null) return new DriverFactory();
        else return driverFactory;
    }

    public void setDriver(WebDriver driver){
        tlWebDriver.set(driver);
    }

    public static WebDriver getDriver(){
        return tlWebDriver.get();
    }
}
