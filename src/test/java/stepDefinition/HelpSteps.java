package stepDefinition;

import com.sun.org.apache.xpath.internal.functions.FuncSubstring;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.assertTrue;


public class HelpSteps {

    /*---------------------------------------------------------------------
                                Ввод
    -----------------------------------------------------------------------*/

    //ввод в поле логина и пароля
    public static void enterData(String id, String placeholder, String data, WebDriver driver) {
        WebElement element = driver.findElement(By.xpath("//input[@id='" + id + "'][@placeholder='" + placeholder + "']"));
        element.clear();
        element.sendKeys(data);
    }


    //ввод в текстовое поле на вкладке Основная информация
    public static void enterField(String myNameField, String myField, WebDriver driver) {
        WebElement inputAccount = driver.findElement(By.xpath("//label[text()='" + myNameField + "']/parent::*/following-sibling::*/div/input"));
        inputAccount.click();
        inputAccount.clear();
        inputAccount.sendKeys(myField);
    }

    //ввод в поле начальной балансовой стоимости на вкладке Основная информация
    public static void enterValueBalance(String valueBalance, WebDriver driver) {
        WebElement inputValueBalance = driver.findElement(By.xpath("//label[text()='Начальная балансовая стоимость']/parent::*/following-sibling::*/div/div/input"));
        inputValueBalance.click();
        inputValueBalance.clear();
        inputValueBalance.sendKeys(valueBalance);
    }

    //ввод в поле в валюте счета
    public static void enterValuta(String valuta, WebDriver driver) {
        WebElement inputValueBalance = driver.findElement(By.xpath("//label[text()='Начальная балансовая стоимость']/parent::*/following-sibling::*/div/input"));
        inputValueBalance.click();
        inputValueBalance.clear();
        inputValueBalance.sendKeys(valuta);
    }

    //ввод в поле дата начала на вкладке Прием
    public static void inputDataN(String myDateN, WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        WebElement inputDataN = driver.findElement(By.xpath("//label[text()='Дата начала действия актива ']/parent::*/following-sibling::*/div//input"));
        inputDataN.click();
        inputDataN.clear();
        inputDataN.sendKeys(myDateN);
        inputDataN.sendKeys(Keys.TAB);
    }

    public static void inputDataK(String myDateK, WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        WebElement inputDataK = driver.findElement(By.xpath("//label[text()='Дата окончания действия актива']/parent::*/following-sibling::*/div//input"));
        inputDataK.click();
        inputDataK.clear();
        inputDataK.sendKeys(myDateK);
        inputDataK.sendKeys(Keys.TAB);
    }
    /*---------------------------------------------------------------------
                                Проверки
    ----------------------------------------------------------------------*/

    //проверить текст элемента и его видимость
    public static void checkElement(String element, WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        WebElement el = driver.findElement(By.xpath("//self::node()[text()='" + element + "']"));
        (new WebDriverWait(driver, 10)).until((ExpectedConditions.visibilityOf(el)));
        el.isDisplayed();
        // assertEquals(el.getText(),element);
        assertTrue(el.getText().equalsIgnoreCase(element));
    }

    //проверить видимость элемента
    public static void presenceField(String data, WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        WebElement el = driver.findElement(By.xpath("//self::node()[text()='" + data + " ']"));
        (new WebDriverWait(driver, 10)).until((ExpectedConditions.visibilityOf(el)));
        el.isDisplayed();
    }

    //проверить видимость формы с заголовком
    public static void checkLogo(String logo, WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        WebElement el = driver.findElement(By.xpath("//self::node()[@title='" + logo + "']"));
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(el));
        el.isDisplayed();
    }

    //проверка что найдена хоть одна запись по данному значению
    public static boolean checkPresenseOfElements(String element, WebDriver driver) {
        List<WebElement> list = driver.findElements(By.xpath("//self::node()[text()='" + element + "']"));
        if (list.size() >= 1) {
            return true;
        }
        return false;
    }

    //проверка значения поля Текущая балансовая стоимость
    public static boolean valueBalance(WebDriver driver) {
        WebElement el1 = driver.findElement(By.xpath("//label[text()='Текущая балансовая стоимость']/parent::*/following-sibling::*/div/div/input"));
        WebElement el2 = driver.findElement(By.xpath("//label[text()='Начальная балансовая стоимость']/parent::*/following-sibling::*/div/div/input"));
        if (el1.getText().contains(el2.getText())) {
            return true;
        }
        return false;
    }
    //проверка значения поля Валюта счёта
    public static boolean valueValuta(WebDriver driver) {
        WebElement el1 = driver.findElement(By.xpath("//label[text()='Номер счёта']/parent::*/following-sibling::*/div/input"));
        WebElement el2 = driver.findElement(By.xpath("//label[text()='Валюта счёта']/parent::*/following-sibling::*//select"));
        String val;
        System.out.println("валюта "+el1.getText()+"и "+el2.getText());
   //     val = el1.getText().substring(6,3);

    /*    if (val=="810") {
           if (el2.getText().contains("Российский рубль")) {
               return true;
           }
        }*/
        return false;
    }
    /*---------------------------------------------------------------------
                                Клик по элементу
    -----------------------------------------------------------------------*/

    //кликнуть по элементу
    public static void pushButton(String button, WebDriver driver) throws InterruptedException {
        Thread.sleep(5000);
        WebElement element = driver.findElement(By.xpath("//self::node()[text()='" + button + "']"));
        (new WebDriverWait(driver, 10)).until((ExpectedConditions.visibilityOf(element)));
        element.click();
    }

    public static void saveActiv(WebDriver driver) throws InterruptedException {
        Thread.sleep(5000);
        WebElement element = driver.findElement(By.xpath("(//self::node()[text()='Сохранить'])[2]"));
        (new WebDriverWait(driver, 10)).until((ExpectedConditions.visibilityOf(element)));
        element.click();
    }

    //кликнуть по пункту из выпадающегося списка в модальном окне
    public static void chooseOptionInSearchModalWindows(String option, WebDriver driver) {
        WebElement element = driver.findElement(By.xpath("//option[text()='" + option + "']"));
        element.click();
    }

    //кликнуть по верхнему меню
    public static void navigation(String option, WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        WebElement element = driver.findElement(By.xpath(" //li[@class='dropdown']/a[contains(text(),'" + option + "')]"));
        element.click();
    }

    //кликнуть по вкладке
    public static void clickTab(String tab, WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        WebElement elementTab = driver.findElement(By.xpath("//a[text()='" + tab + "']"));
        elementTab.click();
    }

}
