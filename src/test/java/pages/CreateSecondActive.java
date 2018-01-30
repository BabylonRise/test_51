package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;


/**
 * Created by user on 30.01.2018.
 */
public class CreateSecondActive {

    public CreateSecondActive(WebDriver driver) {
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }
    @FindBy(how = How.XPATH, using = "//li[@class='active ng-binding ng-scope'][text()='Создание актива (второй этап)']")
    private WebElement displayform;

    public void checkDisplayform(String value, WebDriver driver) throws InterruptedException {
        displayform.findElement(By.xpath("//li[@class='active ng-binding ng-scope'][text()='" + value + "']"));
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(displayform));
        displayform.isDisplayed();
        assertEquals(displayform.getText(), value);
    }

    @FindAll({@FindBy(how=How.XPATH, using="//div[@class='scrolable-tabs full']/ul/li/a")})
    public static List<WebElement> navigationLabels;

    public  static List<String> getNavigationLabels(){
        return navigationLabels
                .stream().limit(13)
                .map(WebElement::getText)
                .collect(Collectors.toList());

    }

}
