package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BaseSeleniumTest {
    private static final String GOOGLE_URL = "https://google.com";
    private WebDriver driver;

    @BeforeSuite
    public void beforeSuite(){
    WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.navigate().to(GOOGLE_URL);
    }

    @Test
    public void PochtaTest() {
       WebElement pochta = driver.findElement(By.xpath("//*[@class='gb_d']"));
       pochta.click();
       assertTrue(driver.getTitle().contains("Gmail"));


    }
    @Test
    public void searchBoxPochta(){
        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys("e.mail.ru" + Keys.ENTER);
        WebElement Vxod = driver.findElement(By.xpath("//*[@class='LC20lb MBeuO DKV0Md']"));
        Vxod.click();
        WebElement UserName = driver.findElement(By.xpath("//*[@name='username']"));
        UserName.sendKeys("binint");
        WebElement Knopka = driver.findElement(By.xpath("//*[@class='base-0-2-85']"));
        Knopka.click();
        assertTrue(driver.getTitle().contains("Входящие"));




    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
