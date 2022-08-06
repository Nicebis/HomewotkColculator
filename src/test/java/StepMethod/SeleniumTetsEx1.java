package StepMethod;

import org.testng.annotations.Test;
import page.objects.BaseSeleniumTestHooks;

import static org.testng.Assert.assertTrue;

public class SeleniumTetsEx1 extends BaseSeleniumTestHooks {
    @Test
    public void SeleniumTestStep(){
        var email = "gimitrygimotrov@yandex.ru";
        var password = "Io87v5Ni";
        var poisk = "yandex.ru почта";
        var adresat = "hmlnyryr@yandex.ru";
        var ThemaLetter = "Homework";
        var TextLetter = "Selenium Homework3";
        var NotInDraft = "В папке «Черновики» нет писем";
        steps.VxodVAkk(email,password,poisk);
        steps.WriteDraft(adresat,ThemaLetter,TextLetter);
        steps.SentLetterAndExit(NotInDraft,ThemaLetter);


    }


}
