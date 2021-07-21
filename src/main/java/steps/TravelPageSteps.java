package steps;

import pages.TravelPage;
import ru.yandex.qatools.allure.annotations.Step;

public class TravelPageSteps {

    @Step("нажата кнопка \"Оформить\"")
    public void checkoutButton() {
        new TravelPage().checkoutButton();
    }
}
