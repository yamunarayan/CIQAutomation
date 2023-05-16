package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.time.Duration;

public class UserLogin {


    @Test
    public void test(){
        ChromeDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://demo.automationtesting.in/Register.html");
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("abc");
        driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("last name");



    }
}
