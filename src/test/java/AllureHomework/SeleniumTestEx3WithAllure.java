package AllureHomework;

import org.testng.annotations.Test;
import page.objects.BaseSeleniumTestHooks;

public class SeleniumTestEx3WithAllure extends BaseSeleniumTestHooks {
    @Test
    public void SeleniumStepEx3(){
        var email = "gimitrygimotrov@yandex.ru";
        var password = "Io87v5Ni";
        var poisk = "yandex.ru почта";
        var adresat = "hmlnyryr@yandex.ru";
        var ThemaLetter = "Homework";
        var TextLetter = "Selenium Homework3";
        var NotInDraft = "В папке «Черновики» нет писем";
        var Fake="Gimitry Gimotrov";
        var TextKorzina="Письма из этой папки автоматически удаляются через 31 день.";
        steps2.VxodVAkk(email,password,poisk);
        steps2.SentLetter(email,ThemaLetter,TextLetter,Fake);
        steps2.Korzina();
        steps2.Exit();
    }
}
