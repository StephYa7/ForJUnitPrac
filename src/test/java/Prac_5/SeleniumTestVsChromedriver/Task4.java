package Prac_5.SeleniumTestVsChromedriver;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task4 {
    @Test
    public void findSeleniumTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium");
        searchBox.submit();
        List<WebElement> searchUrls = driver.findElements(By.cssSelector("div"));
        boolean isFound = false;
        for (WebElement elem : searchUrls) {
            if (elem.getText().contains("https://www.selenium.dev")) {
                isFound = true;
                break;
            }
        }
        assertTrue(isFound);
        driver.quit();
    }
}