package page.objects.Ex1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumEx1PageOtpravkaAndExit {
    protected static final String GOOGLE_URL = "https://google.com";
    protected WebDriver driver;
    private WebDriverWait wait;
    @FindBy(xpath = "[contains(@class,js-message-snippet-sender')]")
    private WebElement VxodLetter;
    @FindBy(xpath = "//*[contains(@class,'Button2_pin_circle-circle')]")
    private WebElement Otpravka;
    @FindBy(xpath = "//a[@href='#sent']")
    private WebElement SentLetter;
    @FindBy(xpath = "//img[@class='user-pic__image']")
    private WebElement IconVixod;
    @FindBy(xpath = "//*[@class='legouser__menu-item_action_exit']")
    private WebElement Vixod;

    public SeleniumEx1PageOtpravkaAndExit(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void OtpravkaLetter(){
        wait.until(ExpectedConditions.visibilityOf(VxodLetter)).click();
        wait.until(ExpectedConditions.visibilityOf(Otpravka)).click();
    }
    public void ProverkaSentLetter(){
        wait.until(ExpectedConditions.visibilityOf(SentLetter)).click();
    }
    public void Exit(){
        wait.until(ExpectedConditions.visibilityOf(IconVixod)).click();
        wait.until(ExpectedConditions.visibilityOf(Vixod)).click();
    }
    public void LetterSent(){
        wait.until(ExpectedConditions.visibilityOf(Otpravka)).click();
    }
}
