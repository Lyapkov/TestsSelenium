package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TravelInsurancePage extends BasePage {

    @FindBy(xpath = "//*[@id=\"page-main\"]/div[2]/div/div/div/div/div/div[1]/div[2]/a")
    WebElement arrange;

    public TravelInsurancePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void takeOutInsurance() {
        jse.executeScript("arguments[0].scrollIntoView(true);", arrange);
        waitAndClick(arrange);
    }
}
