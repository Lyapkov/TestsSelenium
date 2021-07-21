package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class InsurancePage extends BasePage {

    @FindBy(xpath = "//*[@id=\"main-page\"]")
    WebElement body;

    @FindBy(xpath = "//*[@id=\"page-main\"]/div[1]/div/div[2]/div[4]/div/div/div[4]/a")
    WebElement travelInsurance;

    public InsurancePage(){
        super();
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void travelInsurance() {
        BaseSteps.getJse().executeScript("arguments[0].scrollIntoView(true);", travelInsurance);
        waitAndClick(travelInsurance);
    }
}
