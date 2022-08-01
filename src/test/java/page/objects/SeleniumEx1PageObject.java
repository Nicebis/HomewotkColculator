package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumEx1PageObject {
    protected static final String GOOGLE_URL = "https://google.com";
    protected WebDriver driver;
    private WebDriverWait wait;
    @FindBy(xpath = "//*[@name='q']")
    private WebElement searchBox;
    @FindBy(xpath = "//*[@class='LC20lb MBeuO DKV0Md']")
    private WebElement YandexPochtaVxod;
    @FindBy(xpath = "//*[contains(@class,'Button2_weight_500')]")
    private WebElement VxodAkk;
    @FindBy(xpath = "//*[@class='Textinput-Control']")
    private WebElement EmailBox;
    @FindBy(xpath = "//*[@id='passp:sign-in']")
    private WebElement Dalee;
    @FindBy(xpath = "//*[@id='passp-field-passwd']")
    private WebElement PasswordBox;
    @FindBy(xpath = "//*[contains(@class,'Layout-m__compose--3KGCi')]")
    private WebElement Write;
    @FindBy(xpath = "//*[@class='composeYabbles']")
    private WebElement Adressat;
    @FindBy(xpath = "//*[@name='subject']")
    private WebElement Thema;
    @FindBy(xpath = "//*[@title='Напишите что-нибудь']")
    private WebElement Text;
    @FindBy(xpath = "//*[contains(@class,ControlButtons__root--3tqjs)]")
    private WebElement Krest;
    @FindBy(xpath = "//a[@href='#draft']")
    private WebElement BlackLetter;
    @FindBy(xpath = "[contains(@class,js-message-snippet-sender')]")
    private WebElement VxodLetter;
    @FindBy(xpath = "//*[contains(@class,'Button2_pin_circle-circle')]")
    private WebElement Otpravka;
    @FindBy(xpath = "//a[@href='#sent']")
    private WebElement SentLetter;
    @FindBy(xpath = "//img[@class='user-pic__image']")
    private WebElement IconVixod;
    @FindBy(xpath = "//*[@class='legouser__menu-item_action_exit']")
    private WebElement Vixod;
    public SeleniumEx1PageObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void open(){
        driver.navigate().to(GOOGLE_URL);
    }
    public void VxodAkkauntPochta(){

    }










}
