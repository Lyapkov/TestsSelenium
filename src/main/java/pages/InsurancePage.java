package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InsurancePage extends BasePage {

    @FindBy(xpath = "//*[@id=\"main-page\"]")
    WebElement body;

    @FindBy(xpath = "//*[@id=\"page-main\"]/div[1]/div/div[2]/div[4]/div/div/div[4]/a")
    WebElement travelInsurance;

    public InsurancePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void travelInsurance() {
        jse.executeScript("arguments[0].scrollIntoView(true);", travelInsurance);
        waitAndClick(travelInsurance);
    }

    public void selectInsuranceItem(String itemName){
        body.findElement(By.xpath(".//div[contains(@class,'product-catalog__card'), contains(text(),'\"+itemName+\"')]//a[contains(text(),'"+itemName+"')]")).click();
    }
}
