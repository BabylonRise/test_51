package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static stepDefinition.InitialSteps.driver;

public class WebDrivers {

    public static void enterData(String id, String placeholder, String data, WebDriver driver) {

        WebElement element = driver.findElement(By.xpath("//input[@id='" + id + "'][@placeholder='" + placeholder + "']"));
        element.clear();
        element.sendKeys(data);

    }

    public static void pushButton(String button, WebDriver driver) throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("//self::node()[text()='" + button + "']"));
        element.click();
    }

    public static void checkElement(String element, WebDriver driver) throws InterruptedException {
        WebElement el = driver.findElement(By.xpath("//self::node()[text()='" + element + "']"));
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(el));
        el.isDisplayed();
        //assertEquals(el.getText(), element);
        assertTrue(el.getText().equalsIgnoreCase(element));
    }

    public static void chooseOptionInSearchModalWindow(String option, WebDriver driver) {
        WebElement element = driver.findElement(By.xpath("//option[text()='" + option + "']"));
        element.click();

    }

    public static boolean checkPresenseOfElements(String element, WebDriver driver) {
        List<WebElement> list = driver.findElements(By.xpath("//self::node()[text()='" + element + "']"));
        if (list.size() >= 1) {
            return true;
        }
        return false;
    }
    public static void navigationElenetsPush(String option, WebDriver driver) {
        WebElement element = driver.findElement(By.xpath("//li/a[@class='dropdown-toggle'][contains(text(),'" + option + "')]"));
        element.click();
    }

    public static void navigationElenetsForm(String option, WebDriver driver) {
        WebElement element = driver.findElement(By.xpath("//label[@class='control-label'][text()='" + option + "']"));
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(element));
        element.isDisplayed();


    }
    public static void EnterValues(String option, WebDriver driver, String arg1) {
        WebElement element = driver.findElement(By.xpath("//div/label[contains(text(),'" + option + "')]/parent::*/following-sibling::*//input"));
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(element));
        element.click();
        element.sendKeys(arg1);
    }

}

