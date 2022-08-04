package page.objects.Ex2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumPageObjectEx2Elements {
    protected static final String GOOGLE_URL = "https://google.com";
    protected WebDriver driver;
    private WebDriverWait wait;
    @FindBy(xpath = "//*[contains(@class,'qa-LeftColumn-FolderExpander')]")
    WebElement Folders;
    @FindBy(xpath = "//*[@href='#folder/8']")
    WebElement FolderTest;
    public SeleniumPageObjectEx2Elements (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void FolderTest(){
        wait.until(ExpectedConditions.visibilityOf(Folders)).click();
        wait.until(ExpectedConditions.visibilityOf(FolderTest)).getText();
    }

}
