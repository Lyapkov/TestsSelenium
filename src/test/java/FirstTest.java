import org.junit.Test;
import pages.*;

import static org.junit.Assert.assertEquals;

public class FirstTest extends BaseTest {

    @Test
    public void testInsurance() throws Exception {
        driver.get(baseUrl + "/ru/person");
        MainPage mainPage = new MainPage(driver);
        mainPage.selectMenuItem("Страхование");
        mainPage.selectInsuranceItem("Все страховые программы");

        InsurancePage insurancePage = new InsurancePage(driver);
        insurancePage.travelInsurance();

        TravelInsurancePage travelInsurancePage = new TravelInsurancePage(driver);
        travelInsurancePage.takeOutInsurance();

        TravelPage travelPage = new TravelPage(driver);
        travelPage.CheckoutButton();

        SendAppPage sendAppPage = new SendAppPage(driver);
        sendAppPage.fillField("Фамилия застрахованного", "Иванов");
        sendAppPage.fillField("Имя застрахованного", "Иван");
        sendAppPage.fillField("Дата рождения застрахованного", "01.01.2000");
        sendAppPage.fillField("Фамилия", "Иванов");
        sendAppPage.fillField("Имя", "Иван");
        sendAppPage.fillField("Отчество", "Иванович");
        sendAppPage.fillField("Дата рождения", "11.02.1980");
        sendAppPage.fillField("Серия", "1111");
        sendAppPage.fillField("Номер", "010120");
        sendAppPage.fillField("Дата выдачи", "20.02.2000");
        sendAppPage.fillField("Кем выдан", "МРО");

        assertEquals("Страхование путешественников", driver.getTitle());

        sendAppPage.checkField("Фамилия застрахованного", "Иванов");
        sendAppPage.checkField("Имя застрахованного", "Иван");
        sendAppPage.checkField("Дата рождения застрахованного", "01.01.2000");
        sendAppPage.checkField("Фамилия", "Иванов");
        sendAppPage.checkField("Имя", "Иван");
        sendAppPage.checkField("Отчество", "Иванович");
        sendAppPage.checkField("Дата рождения", "11.02.1980");
        sendAppPage.checkField("Серия", "1111");
        sendAppPage.checkField("Номер", "010120");
        sendAppPage.checkField("Дата выдачи", "20.02.2000");
        sendAppPage.checkField("Кем выдан", "МРО");

        sendAppPage.sendButton.click();
        sendAppPage.checkFieldErrorMessage("AlertMobile", "Поле не заполнено.");
        sendAppPage.checkFieldErrorMessage("AlertMail", "Поле не заполнено.");
        sendAppPage.checkFieldErrorMessage("AlertMailRepeated", "Поле не заполнено.");
        sendAppPage.checkFieldErrorMessage("AlertForm", "При заполнении данных произошла ошибка");
    }
}
