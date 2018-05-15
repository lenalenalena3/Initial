package stepDefinition;

import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.Header;
import pages.ModalWindowSearchTable;
import pages.TableReferenceBook;


public class InitialSteps {
    static WebDriver driver;
    public static Header header;
    public static TableReferenceBook tableReferenceBook;
    public static ModalWindowSearchTable modalWindowSearchTable;

    public static WebDriver getDriver() {
        if (driver==null) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\driver\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("-incognito");
            options.addArguments("start-maximized");
            options.addArguments("dom.webnotifications.enabled");
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            driver = new ChromeDriver(capabilities);
            header= new Header(driver);
            tableReferenceBook=new TableReferenceBook(driver);
            modalWindowSearchTable=new ModalWindowSearchTable(driver);
        }
        return driver;
    }

    @Дано("^открыт браузер и осуществлен переход по ссылке$")
    public void openBrauser() throws Throwable {
       driver = getDriver();
       driver.get("http://172.26.25.86:8081/sua/login");
   }


    @Тогда("^браузер закрыт$")
    public void closeBrauser() throws Throwable {
        driver.quit();
        driver=null;
    }
}
