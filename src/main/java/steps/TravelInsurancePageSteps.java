package steps;

import pages.TravelInsurancePage;
import ru.yandex.qatools.allure.annotations.Step;

public class TravelInsurancePageSteps {

    @Step("нажата кнопка \"Оформить онлайн\"")
    public void takeOutInsurance() {
        new TravelInsurancePage().takeOutInsurance();
    }
}
