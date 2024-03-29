package page.objects.Ex3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import page.objects.BaseSeleniumTestHooks;
import page.objects.Ex1.SeleniumEx1PageObjectVxod;
import page.objects.Ex1.SeleniumEx1PageObjectWriteDraft;
import page.objects.Ex1.SeleniumEx1PageOtpravkaAndExit;
import page.objects.Ex1.SeleniumEx1PageProverki;
import page.objects.Ex2.SeleniumPageObjectEx2Proverka;

import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SeleniumTestEx3 extends BaseSeleniumTestHooks {

    @Test
    public void Korzina() {
        var email = "gimitrygimotrov@yandex.ru";
        var password = "Io87v5Ni";
        var poisk = "yandex.ru почта";
        var adresat = "hmlnyryr@yandex.ru";
        var ThemaLetter = "Homework";
        var TextLetter = "Selenium Homework3";
        var adresat2 = "Gimitry Gimotrov";
        var InTrash = "Письма из этой папки автоматически удаляются через 31 день.";
        SeleniumEx1PageObjectVxod Vxod = new SeleniumEx1PageObjectVxod(driver);
        Vxod.VxodAkkaunt(poisk);
        Vxod.EmailVvod(email);
        Vxod.PasswordVvod(password);

        assertTrue(driver.getCurrentUrl().contains("mail.yandex.ru"));
        SeleniumEx1PageObjectWriteDraft KorzinaLetter = new SeleniumEx1PageObjectWriteDraft(driver);
        KorzinaLetter.Write();
        KorzinaLetter.Letter(email,ThemaLetter,TextLetter);

        SeleniumEx1PageOtpravkaAndExit Sent = new SeleniumEx1PageOtpravkaAndExit(driver);
        Sent.LetterSent();
        SeleniumPageObjectEx2Proverka Trash = new SeleniumPageObjectEx2Proverka(driver);
        //WebElement Otprav = driver.findElement(By.xpath("//*[@class='Button2 Button2_pin_circle-circle Button2_view_default Button2_size_l']"));
        //Otprav.click();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        SeleniumPageObjectEx3Elements Elements = new SeleniumPageObjectEx3Elements(driver);
        Elements.VxodLetter();
        //WebElement Vxodashie = driver.findElement(By.xpath("//*[@href='#tabs/relevant']"));
        //Vxodashie.click();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        //WebElement Reload = driver.findElement(By.xpath("//*[contains(@class,'Layout-m__sync--1YGpp')]"));
        //Reload.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        assertTrue(driver.findElement(By.xpath("//*[@class='mail-MessageSnippet-Item_dateText']")).isDisplayed());
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        //assertTrue(driver.findElement(By.xpath("//*[text()='Gimitry Gimotrov']")).isDisplayed());
        assertEquals(Trash.FolderTestLetterAdresat(),adresat2);
        assertEquals(Trash.FolderTestLetterThema(),ThemaLetter);
        assertEquals(Trash.FolderTestLetterText(),TextLetter);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        //assertTrue(driver.findElement(By.xpath("//*[@title='Homework']")).isDisplayed());
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        //assertTrue(driver.findElement(By.xpath("//*[text()='Selenium Homework3']")).isDisplayed());
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        Elements.Trash();
        //WebElement Galka = driver.findElement(By.xpath("//*[contains(@class,'_nb-checkbox-normal-flag')]"));
        //Galka.click();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        //WebElement Delete = driver.findElement(By.xpath("//*[contains(@title,'Удалить')]"));
        //Delete.click();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        //WebElement Korzina = driver.findElement(By.xpath("//*[@href='#trash']"));
        //Korzina.click();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        assertEquals(Trash.TrashFolder(),InTrash);
        //assertTrue(driver.findElement(By.xpath("//*[contains(text(),'Письма из этой папки автоматически удаляются')]")).isDisplayed());
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        //Reload.click();
        Sent.Exit();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        //WebElement Icon = driver.findElement(By.xpath("//img[@class='user-pic__image']"));
        //Icon.click();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        //WebElement Vixod = driver.findElement(By.xpath("//*[contains(@class,'legouser__menu-item_action_exit')]"));
        //Vixod.click();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        assertTrue(driver.findElement(By.xpath("//*[@id='passp:sign-in']")).isDisplayed());
    }
}
