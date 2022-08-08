package StepsSposob.Ex2;

import org.testng.annotations.Test;
import page.objects.BaseSeleniumTestHooks;

public class SeleniumTestEx2 extends BaseSeleniumTestHooks {
    @Test
    public void SeleniumStepsEx2(){
        var email = "gimitrygimotrov@yandex.ru";
        var password = "Io87v5Ni";
        var poisk = "yandex.ru почта";
        var adresat = "hmlnyryr@yandex.ru";
        var ThemaLetter = "HomeworkТест";
        var TextLetter = "Selenium Homework3";
        var NotInDraft = "В папке «Черновики» нет писем";
        var Fake="Gimitry Gimotrov";
        steps1.VxodVAkk(email,password,poisk);
        steps1.SentLetter(email,ThemaLetter,TextLetter);
        steps1.FolderTest(Fake,ThemaLetter,TextLetter);
    }
}
