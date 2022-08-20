package StepsSposob.Ex3;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import page.objects.Ex1.SeleniumEx1PageObjectVxod;
import page.objects.Ex1.SeleniumEx1PageObjectWriteDraft;
import page.objects.Ex1.SeleniumEx1PageOtpravkaAndExit;
import page.objects.Ex1.SeleniumEx1PageProverki;
import page.objects.Ex2.SeleniumPageObjectEx2Elements;
import page.objects.Ex2.SeleniumPageObjectEx2Proverka;
import page.objects.Ex3.SeleniumPageObjectEx3Elements;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class StepMethod3 {
    private WebDriver driver;
    private SeleniumEx1PageObjectVxod Vxod;
    private SeleniumEx1PageObjectWriteDraft Letter;
    private SeleniumPageObjectEx3Elements Elements;
    private SeleniumEx1PageOtpravkaAndExit Sent;
    private SeleniumPageObjectEx2Proverka Proverka;
    private SeleniumEx1PageProverki Proverka2;
    public StepMethod3(WebDriver driver){
        this.driver=driver;
        this.Vxod= new SeleniumEx1PageObjectVxod(driver);
        this.Elements = new SeleniumPageObjectEx3Elements(driver);
        this.Proverka = new SeleniumPageObjectEx2Proverka(driver);
        this.Letter = new SeleniumEx1PageObjectWriteDraft(driver);
        this.Sent= new SeleniumEx1PageOtpravkaAndExit(driver);
        this.Proverka2=new SeleniumEx1PageProverki(driver);

    }
    @Step("Вход в аккаунт яндекс почты")
    public void VxodVAkk(final String email,final String password,final String poisk){
        Vxod.VxodAkkaunt(poisk);
        Vxod.EmailVvod(email);
        Vxod.PasswordVvod(password);
        assertTrue(driver.getCurrentUrl().contains("mail.yandex.ru"));
    }
    @Step("Написание письма и проверка его во входящих")
    public void SentLetter(final String adresat,final String LetterTema,final String LetterText,final String LetterAdresat){
        Letter.Write();
        Letter.Letter(adresat, LetterTema, LetterText);
        Sent.LetterSent();
        Elements.VxodLetter();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        assertTrue(driver.findElement(By.xpath("//*[@class='mail-MessageSnippet-Item_dateText']")).isDisplayed());
        Assert.assertEquals(Proverka.TestAdresat2(),LetterAdresat);
        Assert.assertEquals(Proverka.TestTema2(),LetterTema);
        Assert.assertEquals(Proverka.TestText(),LetterText);
    }
    @Step("Работа с корзиной")
    public void Korzina(){
        Elements.Trash();
        assertTrue(driver.findElement(By.xpath("//*[contains(text(),'Письма из этой папки автоматически удаляются')]")).isDisplayed());
    }
    @Step("Выход из аккаунта")
    public void Exit(){
        Sent.Exit();
        Proverka2.ExitPassword();

    }

}
