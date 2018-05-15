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

import java.util.List;
import java.util.stream.Collectors;

public class Header {

    @FindBy(how = How.XPATH, using = "//self::node()[@title='Агентство по страхованию вкладов']")
    private WebElement labelLogo;
    /*
        @FindBy(how = How.XPATH, using = "//li[@id='tuningMenu']/a[@role='button']")
        private WebElement buttonSettings;

        public void pushSettingsButton(WebDriver driver) {

            buttonSettings.click();
        }
    */
    //все вкладки на странице
    @FindBy(how = How.XPATH, using = "//div[@class='scrolable-tabs full']//li")
    private List<WebElement> tabPage;

    public Header(WebDriver driver) {
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    public void checkLogo(String logo, WebDriver driver) {
        labelLogo.findElement(By.xpath("//self::node()[@title='" + logo + "']"));
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(labelLogo));
        labelLogo.isDisplayed();
    }

    public List<String> navidgation() {
        return tabPage
                .stream()
                .limit(13)
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
