package steps;

import pages.InsurancePage;
import ru.yandex.qatools.allure.annotations.Step;

public class InsurancePageSteps {

    @Step("выбрана страховка путешестввенника")
    public void travelInsurance(){
        new InsurancePage().travelInsurance();
    }
}
