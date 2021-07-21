package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class TravelInsurancePage extends BasePage {

    @FindBy(xpath = "//*[@id=\"page-main\"]/div[2]/div/div/div/div/div/div[1]/div[2]/a")
    WebElement arrange;

    public TravelInsurancePage() {
        super();
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void takeOutInsurance() {
        BaseSteps.getJse().executeScript("arguments[0].scrollIntoView(true);", arrange);
        waitAndClick(arrange);
    }
}
