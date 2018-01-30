package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/**
 * Created by user on 29.01.2018.
 */
public class ModalWindowsSearchTable {

    public ModalWindowsSearchTable(WebDriver driver) {
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }
    @FindBy(how = How.XPATH, using = "(//td/input[@role='textbox'][@class='input-elm'])")
    private WebElement fieldInput;

    public void inputDate(String value, WebDriver driver){
        fieldInput.clear();
        fieldInput.sendKeys(value);
    }

}
