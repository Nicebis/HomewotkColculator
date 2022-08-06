package StepMethod;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import page.objects.Ex1.SeleniumEx1PageObjectVxod;
import page.objects.Ex1.SeleniumEx1PageObjectWriteDraft;
import page.objects.Ex1.SeleniumEx1PageOtpravkaAndExit;
import page.objects.Ex1.SeleniumEx1PageProverki;
import page.objects.Ex2.SeleniumPageObjectEx2Elements;
import page.objects.Ex2.SeleniumPageObjectEx2Proverka;

import static org.testng.Assert.assertTrue;

public class StepMethod2 {
    private WebDriver driver;
    private SeleniumEx1PageObjectVxod Vxod;
    private SeleniumEx1PageOtpravkaAndExit Sent;
    private SeleniumPageObjectEx2Elements Elements;
    private SeleniumPageObjectEx2Proverka Proverka;
    private SeleniumEx1PageObjectWriteDraft Letter;
    public StepMethod2(WebDriver driver){
        this.driver=driver;
        this.Vxod= new SeleniumEx1PageObjectVxod(driver);
        this.Elements = new SeleniumPageObjectEx2Elements(driver);
        this.Proverka = new SeleniumPageObjectEx2Proverka(driver);
        this.Sent = new SeleniumEx1PageOtpravkaAndExit(driver);
        this.Letter = new SeleniumEx1PageObjectWriteDraft(driver);
    }
    public void VxodVAkk(final String email,final String password,final String poisk){
        Vxod.VxodAkkaunt(poisk);
        Vxod.EmailVvod(email);
        Vxod.PasswordVvod(password);
        assertTrue(driver.getCurrentUrl().contains("mail.yandex.ru"));
    }
    public void SentLetter(final String adresat,final String LetterTema,final String LetterText){
        Letter.Write();
        Letter.Letter(adresat, LetterTema, LetterText);
        Letter.Drafts();
        Sent.ProverkaSentLetter();
        Assert.assertEquals(Proverka.TestTema(),LetterTema);
    }
    public void FolderTest(final String adresat,final String LetterTema,final String LetterText){
        Elements.FolderTest();
        assertTrue(driver.findElement(By.xpath("//*[contains(@class,'mail-MessageSnippet-Item')]")).isDisplayed());
        Assert.assertEquals(Proverka.TestAdresat(),adresat);
        Assert.assertEquals(Proverka.TestTema(),LetterTema);
        Assert.assertEquals(Proverka.TestText(),LetterText);
    }
}
