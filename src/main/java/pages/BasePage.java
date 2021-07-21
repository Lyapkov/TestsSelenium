package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import steps.BaseSteps;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void fillField(WebElement field, String value) {
        field.clear();
        field.sendKeys(value);
    }

    public void waitAndClick(WebElement element) {
        BaseSteps.getWait().until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
}
