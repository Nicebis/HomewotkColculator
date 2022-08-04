package page.objects.Ex2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumPageObjectEx2Proverka {

    protected static final String GOOGLE_URL = "https://google.com";
    protected WebDriver driver;
    private WebDriverWait wait;
    @FindBy(xpath = "//*[@title='HomeworkТест']")
    private WebElement SentLetter;
    @FindBy(xpath = "//*[contains(@class,'mail-MessageSnippet-Item')]")
    private WebElement FolderTestLetter;
    @FindBy(xpath = "//*[text()='Gimitry Gimotrov']")
    private WebElement Adresat;
    @FindBy(xpath = "//*[@title='HomeworkТест']")
    private WebElement Thema;
    @FindBy(xpath = "//*[@title='Homework']")
    private WebElement Thema2;
    @FindBy(xpath = "//*[text()='Selenium Homework3']")
    private WebElement TextLetter;
    @FindBy(xpath="//*[contains(text(),'Письма из этой папки автоматически удаляются')]")
    private WebElement TrashFind;
    //@FindBy(xpath="//*[@class='mail-MessageSnippet-Item_dateText']")
    //private WebElement LetterHave;
    public SeleniumPageObjectEx2Proverka (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public String SentLetterFind (){
       return wait.until(ExpectedConditions.visibilityOf(SentLetter)).getText();
    }
    public String FolderTestLetterAdresat(){
        return wait.until(ExpectedConditions.visibilityOf(Adresat)).getText();
    }
    public String FolderTestLetterThema(){
        return wait.until(ExpectedConditions.visibilityOf(Thema2)).getText();
    }
    public String FolderTestLetterText(){
        return wait.until(ExpectedConditions.visibilityOf(TextLetter)).getText();
    }
    public String TrashFolder(){
        return wait.until(ExpectedConditions.visibilityOf(TrashFind)).getText();
    }


}
