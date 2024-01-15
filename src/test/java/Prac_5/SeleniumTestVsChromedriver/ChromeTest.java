package Prac_5.SeleniumTestVsChromedriver;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeTest {
    public static String chromedriver =
            "D:\\PR\\Java\\ForJUnitPrac\\src\\test\\java\\Prac_5\\SeleniumTestVsChromedriver\\chromedriver.exe";

    @Test
    public void testRunChromeAndSearchGB() {
        System.setProperty("webdriver.chrome.driver", chromedriver);
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com/");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("GeekBrains");
        searchBox.submit();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}