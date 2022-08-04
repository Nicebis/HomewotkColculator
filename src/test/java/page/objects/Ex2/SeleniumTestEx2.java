package page.objects.Ex2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.objects.BaseSeleniumTestHooks;
import page.objects.Ex1.SeleniumEx1PageObjectVxod;
import page.objects.Ex1.SeleniumEx1PageObjectWriteDraft;
import page.objects.Ex1.SeleniumEx1PageOtpravkaAndExit;

import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SeleniumTestEx2 extends BaseSeleniumTestHooks {
    @Test
    public void PapkaTest() {
        SeleniumEx1PageObjectVxod Vxod = new SeleniumEx1PageObjectVxod(driver);
        var email = "gimitrygimotrov@yandex.ru";
        var password = "Io87v5Ni";
        var poisk = "yandex.ru почта";
        var adresat = "hmlnyryr@yandex.ru";
        var ThemaLetter = "HomeworkТест";
        var TextLetter = "Selenium Homework3";
        var adresat2 ="Gimitry Gimotrov";
        Vxod.VxodAkkaunt(poisk);
        Vxod.EmailVvod(email);
        Vxod.PasswordVvod(password);
        SeleniumEx1PageObjectWriteDraft Letter1 = new SeleniumEx1PageObjectWriteDraft(driver);
        Letter1.Write();
        Letter1.Letter(email,ThemaLetter,TextLetter);
        SeleniumEx1PageOtpravkaAndExit Otpravka = new SeleniumEx1PageOtpravkaAndExit(driver);
        Otpravka.LetterSent();
        Otpravka.ProverkaSentLetter();
        SeleniumPageObjectEx2Proverka Find = new SeleniumPageObjectEx2Proverka(driver);
        assertEquals(Find.SentLetterFind(),ThemaLetter);
        SeleniumPageObjectEx2Elements Elements = new SeleniumPageObjectEx2Elements(driver);
        Elements.FolderTest();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        assertTrue(driver.findElement(By.xpath("//*[contains(@class,'mail-MessageSnippet-Item')]")).isDisplayed());
        Assert.assertEquals(Find.FolderTestLetterAdresat(),adresat2);
        Assert.assertEquals(Find.FolderTestLetterThema(),ThemaLetter);
        Assert.assertEquals(Find.FolderTestLetterText(),TextLetter);
        Otpravka.Exit();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        assertTrue(driver.findElement(By.xpath("//*[@id='passp:sign-in']")).isDisplayed());

    }
}
