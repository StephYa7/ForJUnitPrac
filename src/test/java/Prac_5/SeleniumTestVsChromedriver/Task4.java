package Prac_5.SeleniumTestVsChromedriver;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task4 {
    public static String chromedriver =
            "D:\\PR\\Java\\ForJUnitPrac\\src\\test\\java\\Prac_5\\SeleniumTestVsChromedriver\\chromedriver.exe";

    @Test
    public void testRunChromeAndSearchGB() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", chromedriver);
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com/");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium");
        searchBox.submit();
        WebElement selenium = driver.
                findElement(By.partialLinkText("https://www.selenium.dev"));
        selenium.isEnabled();
        assertEquals(true, selenium.isEnabled());
    }
}