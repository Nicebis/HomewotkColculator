package AllureHomeworkV2;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;

public class Listener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result){
     var driver = (WebDriver) result.getTestContext().getAttribute("driver");
     attachPageSource(driver);
     attachScreenshot(driver);
    }
    @Attachment(type ="image/png",fileExtension =".png")
    private byte[] attachScreenshot(final WebDriver driver){
        return makescreenshot(driver);
    }
    private void attachPageSource(final WebDriver driver){
        byte[] pageSource =getPageSource(driver);
        Allure.addAttachment("page_source", "text/html", new ByteArrayInputStream(pageSource),
                ".html");

    }

}
