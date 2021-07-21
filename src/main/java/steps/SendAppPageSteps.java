package steps;

import pages.SendAppPage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;

import static org.junit.Assert.assertTrue;

public class SendAppPageSteps {

    @Step("поле {0} заполняется значением {1}")
    public void fillField(String field, String value){
        new SendAppPage().fillField(field, value);
    }

    @Step("поле {0} заполнено значением {1}")
    public void checkFillField(String field, String value){
        String actual = new SendAppPage().getFillField(field);
        assertTrue(String.format("Значение поля [%s] равно [%s]. Ожидалось - [%s]", field, actual, value),
                actual.equals(value));
    }

    @Step("в поле {0} присутствует сообщение об ошибке {1}")
    public void checkErrorMessageField(String field, String value){
        new SendAppPage().checkFieldErrorMessage(field, value);
    }

    @Step("поля заполнены верно")
    public void checkFillFields(HashMap<String, String> fields){
        fields.forEach((k, v)-> checkFillField(k,v));
    }

    @Step("заполняются поля")
    public void fillFields(HashMap<String, String> fields){
        fields.forEach((k, v)-> fillField(k,v));
    }

    @Step("Title страницы {0}")
    public void checkPageTitle(String value) {
        new SendAppPage().checkPageTitle(value);
    }

    @Step("Нажата кнопка \"Продолжить\"")
    public void clickButton() {
        new SendAppPage().clickButton();
    }
}
