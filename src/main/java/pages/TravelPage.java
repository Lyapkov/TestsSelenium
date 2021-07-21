package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class TravelPage extends BasePage {

    @FindBy(xpath = "/html/body/app/ng-component/div/div/div/app-setup-product/div/form/div/div[1]/div/button")
    WebElement checkoutButton;

    public TravelPage() {
        super();
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void checkoutButton() {
        BaseSteps.getJse().executeScript("arguments[0].scrollIntoView(true);", checkoutButton);
        waitAndClick(checkoutButton);
    }
}
