package saucademoTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

public class saucademoTest {
    public static WebDriver driver;

    @BeforeAll
    public static void setup () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void authorizationTest (){
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        assertTrue(driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).isDisplayed());
    }

    @Test
    public void purchaseTest (){
        authorizationTest();
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();

        driver.findElement(By.id("shopping_cart_container")).click();

        driver.findElement(By.id("checkout")).click();

        driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys("UserFirstName");
        driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys("UserLastName");
        driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys("111111");

        driver.findElement(By.id("continue")).click();

        driver.findElement(By.id("finish")).click();
        assertTrue(driver.findElement(By.id("checkout_complete_container")).isDisplayed());
    }

    @AfterAll
    public static void finish (){
        driver.quit();
    }
}
