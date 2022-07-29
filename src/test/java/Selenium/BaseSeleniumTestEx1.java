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

import static org.testng.Assert.*;

public class BaseSeleniumTestEx1 {
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
    public void searchBoxPochta() {
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
        Komy.sendKeys("hmlnyryr@yandex.ru"+Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        WebElement Tema = driver.findElement(By.xpath("//*[@name='subject']"));
        Tema.sendKeys("Homework");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        WebElement Letter = driver.findElement(By.xpath("//*[@title='Напишите что-нибудь']"));
        Letter.sendKeys("Selenium Homework3");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        WebElement Krest = driver.findElement(By.xpath("//*[@class='Button2 Button2_view_clear Button2_size_xs ControlButtons__root--3tqjs qa-ControlButton qa-ControlButton_button_close']"));
        Krest.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        WebElement Letter2 = driver.findElement(By.xpath("//a[@href='#draft']"));
        Letter2.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        assertTrue(driver.findElement(By.xpath("//*[@id='recipient-1']")).isDisplayed());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        assertTrue(driver.findElement(By.xpath("//*[text()='hmlnyryr@yandex.ru']")).isDisplayed());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        assertTrue(driver.findElement(By.xpath("//*[@title='Homework']")).isDisplayed());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        assertTrue(driver.findElement(By.xpath("//*[text()='Selenium Homework3']")).isDisplayed());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        WebElement LetterVxod = driver.findElement(By.xpath("//*[@class='mail-MessageSnippet-Item mail-MessageSnippet-Item_sender js-message-snippet-sender']"));
        LetterVxod.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        WebElement Otprav = driver.findElement(By.xpath("//*[@class='Button2 Button2_pin_circle-circle Button2_view_default Button2_size_l']"));
        Otprav.click();
        //WebElement Vhodashi = driver.findElement(By.xpath("//*[@href='#inbox']"));
        //Vhodashi.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        assertTrue(driver.findElement(By.xpath("//*[text()='В папке «Черновики» нет писем']")).isDisplayed());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        WebElement OtpravLetter = driver.findElement(By.xpath("//a[@href='#sent']"));
        OtpravLetter.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        assertTrue(driver.findElement(By.xpath("//*[@title='Homework']")).isDisplayed());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        WebElement Icon = driver.findElement(By.xpath("//img[@class='user-pic__image']"));
        Icon.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        WebElement Vixod = driver.findElement(By.xpath("//*[@class='legouser__menu-item_action_exit']"));
        Vixod.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        assertTrue(driver.findElement(By.xpath("//*[@id='passp:sign-in']")).isDisplayed());


























    }



    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
