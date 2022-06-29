import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestCase_Web {
    public static void main(String[] args) {

        System.setProperty(
                "webdriver.chrome.driver", "src/main/resources/chromedriver"
        );
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

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

    }
}
