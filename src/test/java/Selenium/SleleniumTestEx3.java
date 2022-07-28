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

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class SleleniumTestEx3 {
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
        driver.manage().window().maximize();
    }
    @Test
    public void Korzina(){
        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys("yandex.ru почта" + Keys.ENTER);
        WebElement Vxod = driver.findElement(By.xpath("//*[@class='LC20lb MBeuO DKV0Md']"));
        Vxod.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        //WebElement Vxod2 = driver.findElement(By.xpath("//*[@class='control button2 button2_view_classic button2_size_mail-big button2_theme_mail-white button2_type_link HeadBanner-Button HeadBanner-Button-Enter with-shadow']"));
        //Vxod2.click();
        WebElement VxodZapas = driver.findElement(By.xpath("//*[contains(@class,'Button2_weight_500')]"));
        VxodZapas.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
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
        Komy.sendKeys("gimitrygimotrov@yandex.ru"+Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        WebElement Tema = driver.findElement(By.xpath("//*[@name='subject']"));
        Tema.sendKeys("Homework");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        WebElement Letter = driver.findElement(By.xpath("//*[@title='Напишите что-нибудь']"));
        Letter.sendKeys("Selenium Homework3");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        WebElement Otprav = driver.findElement(By.xpath("//*[@class='Button2 Button2_pin_circle-circle Button2_view_default Button2_size_l']"));
        Otprav.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        WebElement Vxodashie = driver.findElement(By.xpath("//*[@href='#tabs/relevant']"));
        Vxodashie.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        WebElement Reload = driver.findElement(By.xpath("//*[contains(@class,'Layout-m__sync--1YGpp')]"));
        Reload.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        assertTrue(driver.findElement(By.xpath("//*[@class='mail-MessageSnippet-Item_dateText']")).isDisplayed());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        assertTrue(driver.findElement(By.xpath("//*[text()='Gimitry Gimotrov']")).isDisplayed());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        assertTrue(driver.findElement(By.xpath("//*[@title='Homework']")).isDisplayed());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        assertTrue(driver.findElement(By.xpath("//*[text()='Selenium Homework3']")).isDisplayed());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));


    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
