package org;

import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Title;
import steps.*;

import java.util.HashMap;

public class InsuranceTest extends BaseSteps {

    MainPageSteps mainPageSteps = new MainPageSteps();
    InsurancePageSteps insurancePageSteps = new InsurancePageSteps();
    TravelInsurancePageSteps travelInsurancePageSteps = new TravelInsurancePageSteps();
    TravelPageSteps travelPageSteps = new TravelPageSteps();
    SendAppPageSteps sendAppPageSteps = new SendAppPageSteps();

    HashMap<String, String> testData = new HashMap<>();

    @Title("Заявка на страхование путешественников")
    @Test
    public void testInsurance() throws Exception {

        testData.put("Фамилия застрахованного", "Иванов");
        testData.put("Имя застрахованного", "Иван");
        testData.put("Дата рождения застрахованного", "01.01.2000");
        testData.put("Фамилия", "Иванов");
        testData.put("Имя", "Иван");
        testData.put("Отчество", "Иванович");
        testData.put("Дата рождения", "11.02.1980");
        testData.put("Серия", "1111");
        testData.put("Номер", "010120");
        testData.put("Дата выдачи", "20.02.2000");
        testData.put("Кем выдан", "МРО");

        mainPageSteps.selectMenuItem("Страхование");
        mainPageSteps.selectMenuInsurance("Все страховые программы");
        insurancePageSteps.travelInsurance();
        travelInsurancePageSteps.takeOutInsurance();
        travelPageSteps.checkoutButton();
        sendAppPageSteps.fillFields(testData);
        sendAppPageSteps.checkPageTitle("Страхование путешественников");
        sendAppPageSteps.checkFillFields(testData);
        sendAppPageSteps.clickButton();
        sendAppPageSteps.checkErrorMessageField("AlertMobile", "Поле не заполнено.");
        sendAppPageSteps.checkErrorMessageField("AlertMail", "Поле не заполнено.");
        sendAppPageSteps.checkErrorMessageField("AlertMailRepeated", "Поле не заполнено.");
        sendAppPageSteps.checkErrorMessageField("AlertForm", "При заполнении данных произошла ошибка");
    }
}
