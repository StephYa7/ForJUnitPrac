package Prac_5.SeleniumTestVsChromedriver;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task5 {
    public static String chromedriver =
            "D:\\PR\\Java\\ForJUnitPrac\\src\\test\\java\\Prac_5\\SeleniumTestVsChromedriver\\chromedriver.exe";

    @Test
    public void testRunChromeAndSearchGB() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", chromedriver);
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        WebElement userNameField = driver.findElement(By.name("user-name"));
        userNameField.sendKeys("standard_user");
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.name("login-button"));
        loginButton.submit();

        WebElement productsLabel = driver.findElement(By.className("header_container"));
        WebElement aa = productsLabel.findElement(By.className("title"));
        assertEquals("Products", aa.getText());
    }
}