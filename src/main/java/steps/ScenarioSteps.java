package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ScenarioSteps {

    MainPageSteps mainPageSteps = new MainPageSteps();
    InsurancePageSteps insurancePageSteps = new InsurancePageSteps();
    TravelInsurancePageSteps travelInsurancePageSteps = new TravelInsurancePageSteps();
    TravelPageSteps travelPageSteps = new TravelPageSteps();
    SendAppPageSteps sendAppPageSteps = new SendAppPageSteps();

    @When("^выбран пункт меню \"(.+)\"$")
    public void selectMenuItem(String menuName) {
        mainPageSteps.selectMenuItem(menuName);
    }

    @When("^выбрана категория страхования \"(.+)\"$")
    public void selectMenuInsurance(String menuName) {
        mainPageSteps.selectMenuInsurance(menuName);
    }

    @When("^выбран вид страхования Страхование путешественников$")
    public void travelInsurance() {
        insurancePageSteps.travelInsurance();
    }

    @When("^выполнено нажати на кнопку Оформить онлайн$")
    public void takeOutInsurance() {
        travelInsurancePageSteps.takeOutInsurance();
    }

    @When("^выполнено нажати на кнопку Оформить$")
    public void checkoutButton() {
        travelPageSteps.checkoutButton();
    }

    @When("^заполняются поля:$")
    public void fillForm(DataTable fields) {
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> sendAppPageSteps.fillField(field, value));

    }

    @When("^заголовок страницы - Страхование путешественников \"(.+)\"$")
    public void checkPageTitle(String title) {
        sendAppPageSteps.checkPageTitle(title);
    }


    @Then("^значения полей равны:$")
    public void checkFillForm(DataTable fields) {
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> sendAppPageSteps.checkFillField(field, value));
    }

    @When("^выполнено нажати на кнопку Продолжить$")
    public void clickButton() {
        sendAppPageSteps.clickButton();
    }

    @Then("^в поле \"(.+)\" присутствует сообщение об ошибке \"(.+)\"$")
    public void checkErrorMessage(String field, String errorMessage) {
        sendAppPageSteps.checkErrorMessageField(field, errorMessage);

    }
}
