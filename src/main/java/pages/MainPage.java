package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"main-page\"]/div[1]/div/div[4]/nav/div/ul")
    WebElement menuItems;

    @FindBy(xpath = "//*[@id=\"main-page\"]/div[1]/div/div[4]/nav/div/ul/li[9]/div")
    WebElement menuInsurance;

    public MainPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void selectMenuItem(String itemName){
        menuItems.findElement(By.xpath(".//li[contains(@class,'kitt-top-menu__item kitt-top-menu__item_first')]/*[contains(text(),'"+itemName+"')]")).click();
    }

    public void selectInsuranceItem(String itemName){
        menuInsurance.findElement(By.xpath(".//li[contains(@class,'kitt-top-menu__item')]//a[contains(text(),'"+itemName+"')]")).click();
    }
}
