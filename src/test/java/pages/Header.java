package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by user on 28.01.2018.
 */
public class Header {

    public Header(WebDriver driver){
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,30), this);
    }

    //@FindBy(how= How.XPATH, using="//li[@id='tuningMenu']/a[@role='button']")
    @FindBy(how= How.XPATH, using="//li[@id='tuningMenu']/a[@role='button']")
    private WebElement buttonSettings;
/*
    @FindBy(how= How.XPATH, using="//li/a[@class='dropdown-toggle'][contains(text(),'Настройка')]")
    private WebElement buttonSettingsqwqw;

    public void navigationElenetsPushASA(String option, WebDriver driver) {
       WebElement element = buttonSettingsqwqw.findElement(By.xpath("//li/a[@class='dropdown-toggle'][contains(text(),'"+option+"')]"));
        element.click();

    }
   */
    public void pushSettingsButton(WebDriver driver){

        buttonSettings.click();
    }
    @FindBy(how= How.XPATH, using="//self::node()[@title='Агентство по страхованию вкладов']")
    private WebElement labelLogo;
    public void checkLogo(String logo, WebDriver driver) {
        labelLogo.findElement(By.xpath("//self::node()[@title='" + logo + "']"));
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(labelLogo));
        labelLogo.isDisplayed();
    }
}
