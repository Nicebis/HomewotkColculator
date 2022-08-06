package page.objects.Ex1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumEx1PageProverki {
    protected static final String GOOGLE_URL = "https://google.com";
    protected WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//*[@id='recipient-1']")
    private WebElement Letter;
    @FindBy(xpath="//*[text()='hmlnyryr@yandex.ru']")
    private WebElement email;
    @FindBy(xpath = "//*[@title='Homework']")
    private WebElement Thema;
    @FindBy(xpath = "//*[text()='Selenium Homework3']")
    private WebElement Text;
    @FindBy(xpath = "//*[text()='В папке «Черновики» нет писем']")
    private WebElement DraftsOut;
    @FindBy(xpath = "//*[@title='Homework']")
    private WebElement Thema2;
    @FindBy(xpath = "//*[@id='passp:sign-in']")
    private WebElement password;
    public SeleniumEx1PageProverki(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void LetterHave(){
        wait.until(ExpectedConditions.visibilityOf(Letter));
        wait.until(ExpectedConditions.visibilityOf(DraftsOut));
    }
    public void Letter1(){
        wait.until(ExpectedConditions.visibilityOf(email));
        wait.until(ExpectedConditions.visibilityOf(Thema));
        wait.until(ExpectedConditions.visibilityOf(Text));
    }
    public void Letter2(){
        wait.until(ExpectedConditions.visibilityOf(Thema2));
    }
    public void ExitPassword(){
        wait.until(ExpectedConditions.visibilityOf(password));
    }
    public String NotDrafts(){
        return wait.until(ExpectedConditions.visibilityOf(DraftsOut)).getText();
    }
    public void AdresatProverka(){
        wait.until(ExpectedConditions.visibilityOf(email));
    }
    public void TemaProverka(){
        wait.until(ExpectedConditions.visibilityOf(Thema));
    }
    public void TextProverka(){
        wait.until(ExpectedConditions.visibilityOf(Text));
    }

}
