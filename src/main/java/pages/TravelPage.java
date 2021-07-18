package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TravelPage extends BasePage {

    @FindBy(xpath = "/html/body/app/ng-component/div/div/div/app-setup-product/div/form/div/div[1]/div/button")
    WebElement checkoutButton;

    public TravelPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void CheckoutButton() {
        jse.executeScript("arguments[0].scrollIntoView(true);", checkoutButton);
        waitAndClick(checkoutButton);
    }
}
