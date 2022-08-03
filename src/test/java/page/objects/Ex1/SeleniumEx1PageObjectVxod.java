package page.objects.Ex1;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumEx1PageObjectVxod {
    protected static final String GOOGLE_URL = "https://google.com";
    protected WebDriver driver;
    private WebDriverWait wait;
    @FindBy(xpath = "//*[@name='q']")
    private WebElement searchBox;
    @FindBy(xpath = "//*[@class='LC20lb MBeuO DKV0Md']")
    private WebElement YandexPochtaVxod;
    @FindBy(xpath = "//*[contains(@class,'Button2_weight_500')]")
    private WebElement VxodAkk;
    @FindBy(xpath = "//*[@class='Textinput-Control']")
    private WebElement EmailBox;
    @FindBy(xpath = "//*[@id='passp:sign-in']")
    private WebElement Dalee;
    @FindBy(xpath = "//*[@id='passp-field-passwd']")
    private WebElement PasswordBox;
    public SeleniumEx1PageObjectVxod(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void open(){
        driver.navigate().to(GOOGLE_URL);
    }
    public void VxodAkkaunt(final String poisk){
        wait.until(ExpectedConditions.visibilityOf(searchBox)).sendKeys(poisk + Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOf(YandexPochtaVxod)).click();
        wait.until(ExpectedConditions.visibilityOf(VxodAkk)).click();
    }
    public void EmailVvod(final String email){
        wait.until(ExpectedConditions.visibilityOf(EmailBox)).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOf(Dalee)).click();
    }
    public void PasswordVvod(final String password){
        wait.until(ExpectedConditions.visibilityOf(PasswordBox)).sendKeys(password+Keys.ENTER);
    }
}
