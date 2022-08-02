package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class SeleniumEx1Test extends BaseSeleniumTestHooks{
    @Test
    public void searchBoxPochta() {
        SeleniumEx1PageObjectVxod PochtaTest = new SeleniumEx1PageObjectVxod(driver);
        var email = "gimitrygimotrov@yandex.ru";
        var password = "Io87v5Ni";
        var poisk = "yandex.ru почта";
        var adresat = "hmlnyryr@yandex.ru";
        var ThemaLetter = "Homework";
        var TextLetter = "Selenium Homework3";

        PochtaTest.open();
        //WebElement search = driver.findElement(By.name("q"));
        //search.sendKeys("yandex.ru почта" + Keys.ENTER);
        //WebElement Vxod = driver.findElement(By.xpath("//*[@class='LC20lb MBeuO DKV0Md']"));
        //Vxod.click();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        //WebElement Vxod2 = driver.findElement(By.xpath("//*[@class='control button2 button2_view_classic button2_size_mail-big button2_theme_mail-white button2_type_link HeadBanner-Button HeadBanner-Button-Enter with-shadow']"));
        //Vxod2.click();
        //WebElement VxodZapas = driver.findElement(By.xpath("//*[contains(@class,'Button2_weight_500')]"));
        //VxodZapas.click();
        PochtaTest.VxodAkkaunt(poisk);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
       //WebElement EmailBox = driver.findElement(By.xpath("//*[@class='Textinput-Control']"));
        //EmailBox.sendKeys("gimitrygimotrov@yandex.ru");
        //WebElement Knopka = driver.findElement(By.xpath("//*[@id='passp:sign-in']"));
        //Knopka.click();
        PochtaTest.EmailVvod(email);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        //WebElement TextBoxPassword = driver.findElement(By.xpath("//*[@id='passp-field-passwd']"));
        //TextBoxPassword.sendKeys("Io87v5Ni"+Keys.ENTER);
        PochtaTest.PasswordVvod(password);
        assertTrue(driver.getCurrentUrl().contains("mail.yandex.ru"));
        //WebElement Napisat = driver.findElement(By.xpath("//*[@class='Button2 Button2_type_link Button2_view_action Button2_size_m Layout-m__compose--3KGCi qa-LeftColumn-ComposeButton ComposeButton-m__root--3ijKP']"));
        //Napisat.click();
        SeleniumEx1PageObjectWriteDraft Draft = new SeleniumEx1PageObjectWriteDraft(driver);
        Draft.Write();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        //WebElement Komy = driver.findElement(By.xpath("//*[@class='composeYabbles']"));
        //Komy.sendKeys("hmlnyryr@yandex.ru"+Keys.ENTER);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        //WebElement Tema = driver.findElement(By.xpath("//*[@name='subject']"));
        //Tema.sendKeys("Homework");
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        //WebElement Letter = driver.findElement(By.xpath("//*[@title='Напишите что-нибудь']"));
        //Letter.sendKeys("Selenium Homework3");
        Draft.Letter(adresat,ThemaLetter,TextLetter);
        //WebElement Krest = driver.findElement(By.xpath("//*[@class='Button2 Button2_view_clear Button2_size_xs ControlButtons__root--3tqjs qa-ControlButton qa-ControlButton_button_close']"));
        //Krest.click();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        //WebElement Letter2 = driver.findElement(By.xpath("//a[@href='#draft']"));
        //Letter2.click();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        Draft.Drafts();
        assertTrue(driver.findElement(By.xpath("//*[@id='recipient-1']")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//*[text()='hmlnyryr@yandex.ru']")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//*[@title='Homework']")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//*[text()='Selenium Homework3']")).isDisplayed());
        //WebElement LetterVxod = driver.findElement(By.xpath("//*[@class='mail-MessageSnippet-Item mail-MessageSnippet-Item_sender js-message-snippet-sender']"));
        //LetterVxod.click();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        //WebElement Otprav = driver.findElement(By.xpath("//*[@class='Button2 Button2_pin_circle-circle Button2_view_default Button2_size_l']"));
        //Otprav.click();
        SeleniumEx1PageOtpravkaAndExit EndPochtaTest = new SeleniumEx1PageOtpravkaAndExit(driver);
        EndPochtaTest.OtpravkaLetter();
        //WebElement Vhodashi = driver.findElement(By.xpath("//*[@href='#inbox']"));
        //Vhodashi.click();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        assertTrue(driver.findElement(By.xpath("//*[text()='В папке «Черновики» нет писем']")).isDisplayed());
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        //WebElement OtpravLetter = driver.findElement(By.xpath("//a[@href='#sent']"));
        //OtpravLetter.click();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        EndPochtaTest.ProverkaSentLetter();
        assertTrue(driver.findElement(By.xpath("//*[@title='Homework']")).isDisplayed());
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        //WebElement Icon = driver.findElement(By.xpath("//img[@class='user-pic__image']"));
        //Icon.click();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        //WebElement Vixod = driver.findElement(By.xpath("//*[@class='legouser__menu-item_action_exit']"));
        //Vixod.click();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        EndPochtaTest.Exit();
        assertTrue(driver.findElement(By.xpath("//*[@id='passp:sign-in']")).isDisplayed());
    }
}

