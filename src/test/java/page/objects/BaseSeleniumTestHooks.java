package page.objects;

import AllureHomeworkV2.StepMethod3WithAllure;
import StepsSposob.Ex1.StepMethod;
import StepsSposob.Ex2.StepMethod2;
import StepsSposob.Ex3.StepMethod3;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public abstract class BaseSeleniumTestHooks {
    protected static final String GOOGLE_URL = "https://google.com";
    protected WebDriver driver;

    protected static final Faker FAKER = new Faker();

    protected WebDriverWait wait;
    protected StepMethod steps;
    protected StepMethod2 steps1;
    protected StepMethod3 steps2;
    protected StepMethod3WithAllure steps3;

    @BeforeSuite
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp(ITestContext context) {
        final var headless = System.getProperty("browser.headless","false");
        driver = new ChromeDriver((new ChromeOptions().setHeadless(Boolean.parseBoolean(headless))));
        driver.navigate().to(GOOGLE_URL);
        driver.manage().window().maximize();
        steps = new StepMethod(driver);
        steps1 = new StepMethod2(driver);
        steps2 = new StepMethod3(driver);
        steps3 = new StepMethod3WithAllure(driver);
        context.setAttribute("driver",driver);

    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
