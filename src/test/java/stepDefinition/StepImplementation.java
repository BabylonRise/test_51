package stepDefinition;


import cucumber.api.DataTable;
import cucumber.api.java.ru.А;
import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CreateSecondActive;

import java.util.List;

//import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertEquals;
import static stepDefinition.InitialSteps.*;
import static stepDefinition.WebDrivers.*;

public class StepImplementation {


    @Когда("^пользователь заполняет поле \"Имя пользователя\" значением \"([^\"]*)\"$")
    public void пользователь_заполняет_поле_Имя_пользователя(String username)
            throws Throwable {
        enterData("username", "Имя пользователя", username, driver);
        /*
        WebElement element = driver.findElement(By.xpath("//form/input[@placeholder='Имя пользователя']"));
        element.clear();
        element.sendKeys(username);
*/
    }

    @Когда("^пользователь вводит в поле \"Пароль\" значением \"([^\"]*)\"$")
    public void пользователь_вводит_в_поле_Пароль(String password)
            throws Throwable {

        enterData("password", "Пароль", password, driver);
    }

/*@Когда("^пользователь вводит в поле \"Пароль\" значением \"([^\"]*)\"$")

    public void пользователь_вводит_в_поле_Пароль(String password)
            throws Throwable {
        WebElement element = driver.findElement(By.xpath("//form/input[@placeholder='Пароль']"));
        element.clear();
        element.sendKeys(password);

    }
    */
/*
    @Когда("^пользователь нажимает кнопку \"([^\"]*)\"$")
    public void пользователь_нажимает_кнопку_Войти(String button)
            throws Throwable {
         driver.findElement(By.xpath("//button[text()='"+button+"']")).click();
    }
*/

    @Тогда("^открывается модальное окно \"([^\"]*)\"$")
    public void открывается_модальное_окно_Выбор_финансовой_организации(String modal) throws Throwable {
        checkElement(modal, driver);
    }

    /*
        @Тогда("^пользователь выбирает финансовую организацию \"([^\"]*)\" типа КО$")
        public void пользователь_выбирает_финансовую_организацию(String org) throws Throwable {
            pushButton(org, driver);
        }
        */
    /*
    @Тогда("^пользователь нажимает копку \"([^\"]*)\" в контекстное меню$")
    public void userClicksExitButton(String org) throws Throwable {
        pushButton(org, driver);
    }
    */
    @Тогда("^пользователь нажимает кнопку \"([^\"]*)\" в контекстом меню$")
    @А("^пользователь нажимает копку \"([^\"]*)\" в контекстное меню$")
    public void clickButtonMenu(String button) throws Throwable {
        pushButton(button, driver);
    }

    @Тогда("^пользователь выбирает финансовую организацию \"([^\"]*)\" типа КО$")
    public void clickButtonOrg(String button) throws Throwable {
        pushButton(button, driver);
    }

    @Когда("^пользователь нажимает кнопку \"([^\"]*)\"$")
    public void clickButton(String button) throws Throwable {
        Thread.sleep(1000);
        pushButton(button, driver);
    }

    @Тогда("^открывается страница с логотипом \"([^\"]*)\"$")
    public void openPage(String logo) throws Throwable {
        header.checkLogo(logo, driver);

    }

    @Тогда("^открывается страница с финансовой организацией \"([^\"]*)\"$")
    public void открывается_страница_с_финансовой_организацией(String finOrg) throws Throwable {
        Thread.sleep(1000);
        checkElement(finOrg, driver);
    }


    /*
        @Когда("^пользователь заполняет поле \"([^\"]*)\" и \"([^\"]*)\" значениями | sua_alluys | 12341w2e |$")
        public void пользователь_заполняет_поле_и_значениями_sua_alluys_w_e(String password, String username) throws Throwable {

        }
    */
    @Когда("^пользователь заполняет поле \"Имя пользователя\" и \"Пароль\" значениями$")
    public void пользователь_заполняет_поле_и_значениями(DataTable data) throws Throwable {
        List<String> list = data.asList(String.class);
        enterData("username", "Имя пользователя", list.get(0), driver);
        enterData("password", "Пароль", list.get(1), driver);
    }

    @Тогда("^открывается страница с сообщением \"([^\"]*)\"$")
    public void открывается_страница_с_сообщением(String error) throws Throwable {
        checkElement(error, driver);
    }

    @Дано("^открывается страница с формой \"([^\"]*)\"$")
    public void OpenStartPage(String window)

            throws Throwable {
        checkElement(window, driver);
    }


    @Тогда("^пользователь выбирает пункт \"([^\"]*)\"$")
    public void clickButtonSprav(String button) throws Throwable {
        Thread.sleep(3000);
        pushButton(button, driver);
    }

    @Тогда("^открывается страница с таблицей \"([^\"]*)\"$")
    public void openPageWithTable(String value) throws Throwable {
        tableReferenceBook.checkDirectory(value, driver);
    }

    @Тогда("^пользователь нажимает ссылку \"([^\"]*)\" в столбце \"Краткое наименование\"$")
    public void clickURL(String element) throws Throwable {
        Thread.sleep(3000);
        pushButton(element, driver);
    }

    @Тогда("^пользователь нажимает кнопку \"([^\"]*)\" в верхней панели таблицы$")
    public void пользователь_нажимает_кнопку_в_верхней_панели_таблицы(String arg1) throws Throwable {
        Thread.sleep(3000);
        tableReferenceBook.pushSearchButton(driver);
    }

    @Когда("^пользователь выбирает пункт \"([^\"]*)\" в выпадающем списке \"ID Плана Счетов\"$")
    public void пользователь_выбирает_пункт_в_выпадающем_списке(String value) throws Throwable {

        chooseOptionInSearchModalWindow(value, driver);

    }

    @Когда("^пользователь выбирает пункт \"([^\"]*)\" в выпадающем списке \"содержит\"$")
    public void chooseOptin(String value) throws Throwable {

        chooseOptionInSearchModalWindow(value, driver);
    }

    @Когда("^пользователь заполняет поле значением \"([^\"]*)\"$")
    public void пользователь_заполняет_поле_значением(String value) throws Throwable {
        modalWindowSearchTable.inputDate(value, driver);

    }


    @Тогда("^отображается \"Номер счета 2-го порядка\" содержащий \"([^\"]*)\"$")
    public void отображается_содержащий(String element) throws Throwable {
        checkPresenseOfElements(element, driver);

    }

    @Когда("^пройдена авторизация с параметрами \"([^\"]*)\" \"([^\"]*)\" нажата кнопка \"([^\"]*)\" выбрана финансовая организация \"([^\"]*)\" и нажата кнопка \"([^\"]*)\"$")
    public void пройдена_авторизация_с_параметрами_и_выбрана_финансовая_организация(String login, String password, String button, String button2, String button3) throws Throwable {
        driver = getDriver();
        driver.get("http://172.26.25.86:8081/sua/login");
        enterData("username", "Имя пользователя", login, driver);
        enterData("password", "Пароль", password, driver);
        Thread.sleep(1000);
        pushButton(button, driver);
        Thread.sleep(3000);
        pushButton(button2, driver);
        Thread.sleep(3000);
        pushButton(button3, driver);
    }

    /*
    @Когда("^пользователь нажимает кнопку со списком \"([^\"]*)\"$")
    public void пользователь_нажимает_кнопку_со_списком(String arg1) throws Throwable {

    }
*/
    @Тогда("^пользователь нажимает кнопку с выпадающим списком \"([^\"]*)\"$")
    public void ClickCheckBox(String arg1) throws Throwable {
        //    header.pushSettingsButton(driver);
        Thread.sleep(5000);
        navigationElenetsPush(arg1, driver);
    }

    @Тогда("^открывается страница таблицей \"([^\"]*)\"$")
    public void открывается_страница_таблицей(String arg1) throws Throwable {
        tableReferenceBook2.checkDirectory2(arg1, driver);
    }

    @Тогда("^открывается форма \"([^\"]*)\" с доступными полями \"([^\"]*)\" и \"([^\"]*)\"$")
    public void открывается_форма(String arg1, String arg2, String arg3) throws Throwable {
        Thread.sleep(5000);
        checkElement(arg1, driver);
        navigationElenetsForm(arg2, driver);
        navigationElenetsForm(arg3, driver);
    }

    @Тогда("^открывается экранная форма \"([^\"]*)\"$")
    public void открывается_экранная_форма(String arg1) throws Throwable {
        createSecondActive.checkDisplayform(arg1, driver);
    }

    @Тогда("^на форме \"Карточка актива\" отображаются закладки$")
    public void на_форме_отображаются_закладки(DataTable table) throws Throwable {
        List<String> navigationItems = table.asList(String.class);
        assertEquals(navigationItems, CreateSecondActive.getNavigationLabels());

    }

    @Тогда("^пользователь заполняет поля формы$")
    public void пользователь_заполняет_поля_формы(DataTable arg1) throws Throwable {
        List<List<String>> table = arg1.raw();
        EnterValues(table.get(0).get(0), driver, table.get(0).get(1));
        //EnterValues2(table.get(3).get(0), driver, table.get(3).get(1));
        EnterValues(table.get(1).get(0), driver, table.get(1).get(1));
        EnterValues(table.get(2).get(0), driver, table.get(2).get(1));


    }
}