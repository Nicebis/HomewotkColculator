package page.objects.Ex2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SeleniumPageObjectEx2Proverka {
    @FindBy(xpath = "//*[@title='HomeworkТест']")
    private WebElement SentLetter;
    @FindBy(xpath = "//*[contains(@class,'mail-MessageSnippet-Item')]")
    private WebElement FolderTestLetter;
    @FindBy(xpath = "//*[text()='Gimitry Gimotrov']")
    private WebElement

}
