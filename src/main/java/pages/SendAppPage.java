package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

public class SendAppPage extends BasePage {

    @FindBy(id = "surname_vzr_ins_0")
    WebElement insuredSurname;

    @FindBy(xpath = "//*[@id=\"name_vzr_ins_0\"]")
    WebElement insuredName;

    @FindBy(xpath = "//*[@id=\"birthDate_vzr_ins_0\"]")
    WebElement insuredDateBirth;

    @FindBy(id = "person_lastName")
    WebElement lastName;

    @FindBy(id = "person_firstName")
    WebElement firstName;

    @FindBy(id = "person_middleName")
    WebElement middleName;

    @FindBy(id = "person_birthDate")
    WebElement dateBirth;

    @FindBy(id = "passportSeries")
    WebElement passportSeries;

    @FindBy(id = "passportNumber")
    WebElement passportNumber;

    @FindBy(id = "documentDate")
    WebElement documentDate;

    @FindBy(id = "documentIssue")
    WebElement documentIssue;

    @FindBy(xpath = "/html/body/app/ng-component/div/div/div/app-forming-product/div/form/div/div[3]/div/div[2]/button")
    public WebElement sendButton;

    @FindBy(xpath = "/html/body/app/ng-component/div/div/div/app-forming-product/div/form/div/fieldset[4]/div[1]/div/form-control-label/div/input-phone2/span/validation-message/span")
    public WebElement alertMobile;

    @FindBy(xpath = "/html/body/app/ng-component/div/div/div/app-forming-product/div/form/div/fieldset[4]/div[2]/div/form-control-label/div/input-email/span/validation-message/span")
    public WebElement alertMail;

    @FindBy(xpath = "/html/body/app/ng-component/div/div/div/app-forming-product/div/form/div/fieldset[4]/div[3]/div/form-control-label/div/input-email/span/validation-message/span")
    public WebElement alertMailRepeated;

    @FindBy(xpath = "/html/body/app/ng-component/div/div/div/app-forming-product/div/form/div/alert-form[1]/div")
    public WebElement alertForm;

    public SendAppPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void fillField(String fieldName, String value) {
        switch (fieldName) {
            case "Фамилия застрахованного":
                fillField(insuredSurname, value);
                break;
            case "Имя застрахованного":
                fillField(insuredName, value);
                break;
            case "Дата рождения застрахованного":
                fillField(insuredDateBirth, value);
                insuredDateBirth.sendKeys(Keys.TAB);
                break;
            case "Фамилия":
                fillField(lastName, value);
                break;
            case "Имя":
                fillField(firstName, value);
                break;
            case "Отчество":
                fillField(middleName, value);
                break;
            case "Дата рождения":
                fillField(dateBirth, value);
                dateBirth.sendKeys(Keys.TAB);
                break;
            case "Серия":
                fillField(passportSeries, value);
                break;
            case "Номер":
                fillField(passportNumber, value);
                break;
            case "Дата выдачи":
                fillField(documentDate, value);
                documentDate.sendKeys(Keys.TAB);
                break;
            case "Кем выдан":
                fillField(documentIssue, value);
                break;
            default:
                throw new AssertionError("Поле '" + fieldName + "' не объявлено на странице");
        }
    }

    public String getFillField(String fieldName) {
        switch (fieldName) {
            case "Фамилия застрахованного":
                return insuredSurname.getAttribute("value");
            case "Имя застрахованного":
                return insuredName.getAttribute("value");
            case "Дата рождения застрахованного":
                return insuredDateBirth.getAttribute("value");
            case "Фамилия":
                return lastName.getAttribute("value");
            case "Имя":
                return firstName.getAttribute("value");
            case "Отчество":
                return middleName.getAttribute("value");
            case "Дата рождения":
                return dateBirth.getAttribute("value");
            case "Серия":
                return passportSeries.getAttribute("value");
            case "Номер":
                return passportNumber.getAttribute("value");
            case "Дата выдачи":
                return documentDate.getAttribute("value");
            case "Кем выдан":
                return documentIssue.getAttribute("value");
        }
        throw new AssertionError("Поле не объявлено на странице");
    }

    public void checkField(String attr, String value) {
        switch (attr) {
            case "Фамилия застрахованного":
                assertEquals(value,
                        insuredSurname.getAttribute("value"));
                break;
            case "Имя застрахованного":
                assertEquals(value,
                        insuredName.getAttribute("value"));
                break;
            case "Дата рождения застрахованного":
                assertEquals(value,
                        insuredDateBirth.getAttribute("value"));
                break;
            case "Фамилия":
                assertEquals(value,
                        lastName.getAttribute("value"));
                break;
            case "Имя":
                assertEquals(value,
                        firstName.getAttribute("value"));
                break;
            case "Отчество":
                assertEquals(value,
                        middleName.getAttribute("value"));
                break;
            case "Дата рождения":
                assertEquals(value,
                        dateBirth.getAttribute("value"));
                break;
            case "Серия":
                assertEquals(value,
                        passportSeries.getAttribute("value"));
                break;
            case "Номер":
                assertEquals(value,
                        passportNumber.getAttribute("value"));
                break;
            case "Дата выдачи":
                assertEquals(value,
                        documentDate.getAttribute("value"));
                break;
            case "Кем выдан":
                assertEquals(value,
                        documentIssue.getAttribute("value"));
                break;
            default:
                throw new AssertionError("Поле не объявлено на странице");
        }
    }

    public void checkFieldErrorMessage(String attr, String value) {
        switch (attr) {
            case "AlertMobile":
                assertEquals(value,
                        alertMobile.getText());
                break;
            case "AlertMail":
                assertEquals(value,
                        alertMail.getText());
                break;
            case "AlertMailRepeated":
                assertEquals(value,
                        alertMailRepeated.getText());
                break;
            case "AlertForm":
                assertEquals(value,
                        alertForm.getText());
                break;
            default:
                throw new AssertionError("Поле не объявлено на странице");
        }

    }
}
