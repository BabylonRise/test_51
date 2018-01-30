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

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 29.01.2018.
 */
public class TableReferenceBook2 {

    public TableReferenceBook2(WebDriver driver) {
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }


    @FindBy(how = How.XPATH, using = "(//self::node()[text()='Список активов'])[2]")
    private WebElement labelDirectory2;

    public void checkDirectory2(String value, WebDriver driver) throws InterruptedException {
        labelDirectory2.findElement(By.xpath("(//self::node()[text()='" + value + "'])[2]"));
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(labelDirectory2));
        labelDirectory2.isDisplayed();
        assertEquals(labelDirectory2.getText(), value);

    }
}
