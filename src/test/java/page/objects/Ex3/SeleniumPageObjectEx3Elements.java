package page.objects.Ex3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumPageObjectEx3Elements {
    protected static final String GOOGLE_URL = "https://google.com";
    protected WebDriver driver;
    private WebDriverWait wait;
    @FindBy(xpath = "//*[@href='#tabs/relevant']")
    private WebElement VxodLetter;
    @FindBy(xpath = "//*[contains(@class,'Layout-m__sync--1YGpp')]")
    private WebElement Reload;
    @FindBy(xpath = "//*[contains(@class,'_nb-checkbox-normal-flag')]")
    private WebElement Galka;
    @FindBy(xpath = "//*[contains(@title,'Удалить')]")
    private WebElement Delete;
    @FindBy(xpath = "//*[@href='#trash']")
    private WebElement Trash;
    public SeleniumPageObjectEx3Elements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void VxodLetter(){
        wait.until(ExpectedConditions.visibilityOf(VxodLetter)).click();
        wait.until(ExpectedConditions.visibilityOf(Reload)).click();
    }
    public void Trash(){
        wait.until(ExpectedConditions.visibilityOf(Galka)).click();
        wait.until(ExpectedConditions.visibilityOf(Delete)).click();
        wait.until(ExpectedConditions.visibilityOf(Trash)).click();
    }
}
