package page.objects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumEx1PageObjectWriteDraft {
    protected static final String GOOGLE_URL = "https://google.com";
    protected WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//*[contains(@class,'Layout-m__compose--3KGCi')]")
    private WebElement Write;
    @FindBy(xpath = "//*[@class='composeYabbles']")
    private WebElement Adressat;
    @FindBy(xpath = "//*[@name='subject']")
    private WebElement Thema;
    @FindBy(xpath = "//*[@title='Напишите что-нибудь']")
    private WebElement Text;
    @FindBy(xpath = "//*[contains(@class,ControlButtons__root--3tqjs)]")
    private WebElement Krest;
    @FindBy(xpath = "//a[@href='#draft']")
    private WebElement DraftsLetter;
    public SeleniumEx1PageObjectWriteDraft(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void Write(){
        wait.until(ExpectedConditions.visibilityOf(Write)).click();
    }
    public void Letter(final String adresat,final String ThemaLetter,final String TextLetter){
        wait.until(ExpectedConditions.visibilityOf(Adressat)).sendKeys(adresat+ Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOf(Thema)).sendKeys(ThemaLetter+Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOf(Text)).sendKeys(TextLetter);
    }
    public void Drafts(){
        wait.until(ExpectedConditions.visibilityOf(Krest)).click();
        wait.until(ExpectedConditions.visibilityOf(DraftsLetter)).click();
    }
}
