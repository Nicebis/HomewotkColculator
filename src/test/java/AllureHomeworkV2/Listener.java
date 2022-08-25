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
      attachScreenshot(driver);
      attachPageSource(driver);
    }
    @Attachment(type ="image/png",fileExtension =".png")
    private byte[] attachScreenshot(final WebDriver driver) {
        return AttachmentUtils.makeScreenshot(driver);
    }
    private void attachPageSource(final WebDriver driver){
        byte[] pageSource =AttachmentUtils.getPageSource(driver);
        Allure.addAttachment("page_source","text/html",
                new ByteArrayInputStream(pageSource),".html");
    }


}
