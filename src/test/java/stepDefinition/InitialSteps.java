package stepDefinition;

import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Тогда;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.*;

/**
 * Created by user on 28.01.2018.
 */
public class InitialSteps {
    public static Header header;
    static WebDriver driver;
    public static TableReferenceBook tableReferenceBook;
    public static ModalWindowsSearchTable modalWindowSearchTable;
    public static TableReferenceBook2 tableReferenceBook2;
    public static CreateSecondActive createSecondActive;
    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\driver\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("-incognito");
            options.addArguments("start-maximized");
            options.addArguments("dom.webnotifications.enabled");
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            driver = new ChromeDriver(capabilities);
            header = new Header(driver);
            tableReferenceBook=new TableReferenceBook(driver);
            tableReferenceBook2=new TableReferenceBook2(driver);
            modalWindowSearchTable=new ModalWindowsSearchTable(driver);
            createSecondActive=new CreateSecondActive(driver);
        }
        return driver;
    }


    @Дано("^открыт браузер и осуществлен переход по ссылке$")
    public void openBrowser() throws Throwable {
        driver = getDriver();
        driver.get("http://172.26.25.86:8081/sua/login");

    }
@After
    @Тогда("^браузер закрыт$")
    public void браузер_закрыт() throws Throwable {
        driver.quit();
        driver = null;
    }

}