package stepDefinition;

import cucumber.api.DataTable;
import cucumber.api.java.ru.*;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static stepDefinition.HelpSteps.*;
import static stepDefinition.InitialSteps.*;

public class StepImplementation {

    @Когда("^пользователь заполняет поле \"Имя пользователя\" значением \"([^\"]*)\"$")
    public void inputUser(String username) throws Throwable {
        enterData("username", "Имя пользователя", username, driver);
    }

    @Когда("^пользователь вводит в поле \"Пароль\" значением \"([^\"]*)\"$")
    public void inputPassword(String password) throws Throwable {
        enterData("password", "Пароль", password, driver);
    }

    @Когда("^пользователь заполняет поле \"Имя пользователя\" и \"Пароль\" значениями$")
    public void userFillsFields(DataTable data) throws Throwable {
        List<String> list = data.asList(String.class);
        enterData("username", "Имя пользователя", list.get(0), driver);
        enterData("password", "Пароль", list.get(1), driver);
    }

    @Если("^пользователь выбирает пункт \"([^\"]*)\"$")
    @А("^пользователь нажимает ссылку \"([^\"]*)\" в столбце \"Краткое наименование\"$")
    @Тогда("^пользователь выбирает финансовую организацию \"([^\"]*)\" типа КО$")
    @И("^пользователь нажимает кнопку \"([^\"]*)\" в контексном меню$")
    @Когда("^пользователь нажимает кнопку \"([^\"]*)\"$")
    public void clickOnElement(String element) throws Throwable {
        pushButton(element, driver);
    }

    @И("^пользователь сохраняет по кнопке Сохранить$")
    public void save() throws Throwable {
        saveActiv(driver);
    }

    @Пусть("^открывается страница с формой \"([^\"]*)\"$")
    @Когда("^открывается страница с сообщением \"([^\"]*)\"$")
    @Тогда("^открывается модальное окно \"([^\"]*)\"$")
    @И("^открывается страница с финансовой организацией \"([^\"]*)\"$")
    public void openPage(String window) throws Throwable {
        checkElement(window, driver);
    }

    @Тогда("^открывается страница с логотипом \"([^\"]*)\"$")
    public void openLogotip(String logo) throws Throwable {
        header.checkLogo(logo, driver);
    }

    @И("^пользователь нажимает кнопку с выпадающим списком \"([^\"]*)\"$")
    public void пользователь_нажимает_кнопку_с(String setting) throws Throwable {
        navigation(setting, driver);
        //header.pushSettingsButton(setting,driver);
    }

    @Тогда("^открывается страница с таблицей \"([^\"]*)\"$")
    public void OpenPageWithTamle(String value) throws Throwable {
        tableReferenceBook.checkDirectory(value, driver);
    }

    @Тогда("^пользователь нажимает кнопку \"([^\"]*)\" в верхней панели таблицы$")
    public void userPush(String find) throws Throwable {
        tableReferenceBook.pushSearchButton(driver);
    }

    @И("^пользователь выбирает пункт \"([^\"]*)\" в выпадающем списке \"Тип актива функциональный \"$")
    @Пусть("^пользователь выбирает пункт \"([^\"]*)\" в выпадающем списке \"содержит\"$")
    @То("^пользователь выбирает пункт \"([^\"]*)\" в выпадающем списке \"ID Плана Счетов\"$")
    public void chooseOption(String value) throws Throwable {
        chooseOptionInSearchModalWindows(value, driver);
    }

    @Когда("^пользователь заполняет поле значением \"([^\"]*)\"$")
    public void userFills(String value) throws Throwable {
        modalWindowSearchTable.inputDate(value, driver);
    }

    @Когда("^отображается \"Номер счета 2-ого порядка\" содержащий \"([^\"]*)\"$")
    public void checkPresens(String element) throws Throwable {
        checkPresenseOfElements(element, driver);
    }

    @То("^на странице присутствуют поля$")
    public void opsenPage(DataTable field) throws Throwable {
        List<String> listField = field.asList(String.class);
        if (listField.size() > 0) {
            for (int i = 0; i < listField.size(); i++) {
                presenceField(listField.get(i), driver);
            }
        }
    }

    @Тогда("^на форме отображаются закладки$")
    public void на_форме_отображаются_закладки(DataTable myList) throws Throwable {
        List<String> nav = myList.asList(String.class);
        assertEquals(nav, header.navidgation());
    }

    @Когда("^пользователь перешел на вкладку \"([^\"]*)\"$")
    public void clickTabForm(String tab) throws Throwable {
        clickTab(tab, driver);
    }

    @Когда("^пользователь заполняет обязательные поля на вкладке Основная информация$")
    public void InputFieldInfo(DataTable myField) throws Throwable {
        List<List<String>> list = myField.asLists(String.class);
        for (int i = 0; i < myField.raw().size(); i++) {
            switch (list.get(i).get(0).toString()) {
                case "Номер счёта":
                case "Наименование актива":
                    enterField(list.get(i).get(0), list.get(i).get(1), driver);
                    break;
                case "Начальная балансовая стоимость":
                    enterValueBalance(list.get(i).get(1), driver);
                    break;
                case "В валюте счёта":
                    enterValuta(list.get(i).get(1), driver);
                    break;
            }
        }
    }

    @Когда("^пользователь заполняет обязательные поля на вкладке Прием$")
    public void InputFieldFunction(DataTable myField) throws Throwable {
        Thread.sleep(1000);
        List<List<String>> list = myField.asLists(String.class);
        for (int i = 0; i < myField.raw().size(); i++) {
            switch (list.get(i).get(0).toString()) {
                case "Дата начала действия актива":
                    inputDataN(list.get(i).get(1), driver);
                    break;
                case "Дата окончания действия актива":
                    inputDataK(list.get(i).get(1), driver);
                    break;
            }
        }

    }

    @То("^на вкладке Основная информация заполнились поля$")
    public void AutoFildInfo(DataTable autoField) throws Throwable {
        List<String> auto = autoField.asList(String.class);
        for (int i = 0; i < auto.size(); i++) {
            switch (auto.get(i).toString()) {
                case "Текущая балансовая стоимость":
                    valueBalance(driver);
                    break;
                case "Валюта счёта":
                 //   valueValuta(driver);
                    break;
            }

        }
    }

}
