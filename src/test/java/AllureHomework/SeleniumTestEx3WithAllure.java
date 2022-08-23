package AllureHomework;

import io.qameta.allure.*;
import io.qameta.allure.util.ResultsUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.objects.BaseSeleniumTestHooks;
@Epic("Тесты яндекс почты")
@Feature("Падающий тест работы с корзиной в почте")
@Link(value = "Тестовая ссылка",url="https://youtube.com",name="Тестовая ссылка",type= ResultsUtils.HOST_LABEL_NAME)
public class SeleniumTestEx3WithAllure extends BaseSeleniumTestHooks {

    @Test(description = "Тест работы с корзиной в почте")
    @Story("Тест удаления письма из яндекс почты")
    @Description("Тест для проверки умения работать с методом Steps")
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
        steps3.VxodVAkk(email,password,poisk);
        steps3.SentLetter(email,ThemaLetter,TextLetter,Fake);
        steps3.Korzina();
        steps3.Exit();
    }
}
