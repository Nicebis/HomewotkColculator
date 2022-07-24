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

import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BaseSeleniumTest {
    private static final String GOOGLE_URL = "https://google.com";
    private WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
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
    public void searchBoxPochta() {
        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys("yandex.ru почта" + Keys.ENTER);
        WebElement Vxod = driver.findElement(By.xpath("//*[@class='LC20lb MBeuO DKV0Md']"));
        Vxod.click();
        WebElement Vxod2 = driver.findElement(By.xpath("//*[@class='control button2 button2_view_classic button2_size_mail-big button2_theme_mail-white button2_type_link HeadBanner-Button HeadBanner-Button-Enter with-shadow']"));
        Vxod2.click();
        WebElement EmailBox = driver.findElement(By.xpath("//*[@class='Textinput-Control']"));
        EmailBox.sendKeys("gimitrygimotrov@yandex.ru");
        WebElement Knopka = driver.findElement(By.xpath("//*[@id='passp:sign-in']"));
        Knopka.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        WebElement TextBoxPassword = driver.findElement(By.xpath("//*[@id='passp-field-passwd']"));
        TextBoxPassword.sendKeys("Io87v5Ni"+Keys.ENTER);
        assertTrue(driver.getCurrentUrl().contains("mail.yandex.ru"));
        WebElement Napisat = driver.findElement(By.xpath("//*[@class='Button2 Button2_type_link Button2_view_action Button2_size_m Layout-m__compose--3KGCi qa-LeftColumn-ComposeButton ComposeButton-m__root--3ijKP']"));
        Napisat.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        WebElement Komy = driver.findElement(By.xpath("//*[@class='composeYabbles']"));
        Komy.sendKeys("levelup_homework"+Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        WebElement Tema = driver.findElement(By.xpath("//*[@name='subject']"));
        Tema.sendKeys("Homework");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        WebElement Letter = driver.findElement(By.xpath("//*[@title='Напишите что-нибудь']"));
        Letter.sendKeys("Selenium Homework3");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        WebElement Letter2 = driver.findElement(By.xpath("//*[@class='Folder-m__link--2z6Y5 qa-LeftColumn-FolderLink')]"));
        Letter2.click();
        assertTrue(driver.findElement(By.xpath("//*[@class='mail-MessageSnippet-Item mail-MessageSnippet-Item_sender js-message-snippet-sender']")).isDisplayed());










    }



    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
