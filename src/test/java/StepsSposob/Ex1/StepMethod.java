package StepsSposob.Ex1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import page.objects.Ex1.SeleniumEx1PageObjectVxod;
import page.objects.Ex1.SeleniumEx1PageObjectWriteDraft;
import page.objects.Ex1.SeleniumEx1PageOtpravkaAndExit;
import page.objects.Ex1.SeleniumEx1PageProverki;
import page.objects.Ex2.SeleniumPageObjectEx2Proverka;

import static org.testng.Assert.assertTrue;

public class StepMethod {
    private WebDriver driver;
    private SeleniumEx1PageObjectVxod Vxod;
    private SeleniumEx1PageObjectWriteDraft Draft;
    private SeleniumEx1PageOtpravkaAndExit Exit;
    private SeleniumPageObjectEx2Proverka Proverka2;
    private SeleniumEx1PageProverki Proverki;
    public StepMethod(WebDriver driver){
        this.driver=driver;
        this.Vxod= new SeleniumEx1PageObjectVxod(driver);
        this.Draft= new SeleniumEx1PageObjectWriteDraft(driver);
        this.Exit = new SeleniumEx1PageOtpravkaAndExit(driver);
        this.Proverki = new SeleniumEx1PageProverki(driver);
        this.Proverka2= new SeleniumPageObjectEx2Proverka(driver);
    }
    public void VxodVAkk(final String email,final String password,final String poisk){
        Vxod.VxodAkkaunt(poisk);
        Vxod.EmailVvod(email);
        Vxod.PasswordVvod(password);
        assertTrue(driver.getCurrentUrl().contains("mail.yandex.ru"));
    }
    public void WriteDraft(final String adresat,final String LetterTema,final String LetterText){
        Draft.Write();
        Draft.Letter(adresat, LetterTema, LetterText);
        Draft.Drafts();
        assertTrue(driver.findElement(By.xpath("//*[@id='recipient-1']")).isDisplayed());
        Assert.assertEquals(Proverka2.TestAdresat(),adresat);
        Assert.assertEquals(Proverka2.TestTema(),LetterTema);
        Assert.assertEquals(Proverka2.TestText(),LetterText);

    }
    public void SentLetterAndExit(final String NotInDraft,final String Tema){
        Exit.OtpravkaLetter();
        Assert.assertEquals(Proverka2.DraftOut(),NotInDraft);
        Exit.ProverkaSentLetter();
        Assert.assertEquals(Proverka2.TestTema(),Tema);
        Exit.Exit();
        Proverki.ExitPassword();
    }

}
