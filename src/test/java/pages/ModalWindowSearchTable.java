package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


public class ModalWindowSearchTable {

    public ModalWindowSearchTable (WebDriver driver) {
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    @FindBy(how = How.XPATH, using = "//td/input[@role='textbox'][@class='input-elm']")
    private WebElement fieldInput;


    public void inputDate(String value, WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        fieldInput.clear();
        fieldInput.sendKeys(value);
    }
}
