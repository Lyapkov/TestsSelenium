import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class FirstTest {
    private WebDriver driver;
    private String baseUrl;
    private JavascriptExecutor jse;
    private Wait<WebDriver> wait;


    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");

        driver = new ChromeDriver();
        baseUrl = "http://www.sberbank.ru";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        jse = (JavascriptExecutor)driver;
        wait = new WebDriverWait(driver, 5, 1000);
    }

    @Test
    public void testInsurance() throws Exception {
        driver.get(baseUrl + "/ru/person");
        driver.findElement(By.xpath("//*[@id=\"main-page\"]/div[1]/div/div[4]/nav/div/ul/li[9]/a[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"main-page\"]/div[1]/div/div[4]/nav/div/ul/li[9]/div/div[1]/ul/li[1]/a")).click();

        jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[@id=\"page-main\"]/div[1]/div/div[2]/div[4]/div/div/div[4]/a")));

        driver.findElement(By.xpath("//*[@id=\"page-main\"]/div[1]/div/div[2]/div[4]/div/div/div[4]/a")).click();

        assertEquals("Страхование для путешественников — СберБанк", driver.getTitle());

        jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[@id=\"page-main\"]/div[2]/div/div/div/div/div/div[1]/div[2]/a")));
        waitAndClick(By.xpath("//*[@id=\"page-main\"]/div[2]/div/div/div/div/div/div[1]/div[2]/a"));
        driver.findElement(By.xpath("/html/body/app/ng-component/div/div/div/app-setup-product/div/form/div/fieldset[5]/div/div/online-card-program")).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                driver.findElement(By.xpath("/html/body/app/ng-component/div/div/div/app-setup-product/div/form/div/div[1]/div/button"))));
        driver.findElement(By.xpath("/html/body/app/ng-component/div/div/div/app-setup-product/div/form/div/div[1]/div/button")).click();

        fillField(By.xpath("//*[@id=\"surname_vzr_ins_0\"]"), "Иванов");
        fillField(By.xpath("//*[@id=\"name_vzr_ins_0\"]"), "Иван");
        fillField(By.xpath("//*[@id=\"birthDate_vzr_ins_0\"]"), "01.01.2000");

        fillField(By.xpath("//*[@id=\"person_lastName\"]"), "Иванов");
        fillField(By.xpath("//*[@id=\"person_firstName\"]"), "Иван");
        fillField(By.xpath("//*[@id=\"person_lastName\"]"), "Иванов");
        fillField(By.xpath("//*[@id=\"person_middleName\"]"), "Иванович");
        fillField(By.xpath("//*[@id=\"person_birthDate\"]"), "11.02.1980");
        //waitAndClick(By.xpath("/html/body/app/ng-component/div/div/div/app-forming-product/div/form/div/fieldset[2]/div/div/person-general-data/div/div[5]/div/form-control-label/div/radio-button-group/div/div/label[2]"));
        fillField(By.xpath("//*[@id=\"passportSeries\"]"), "1111");
        fillField(By.xpath("//*[@id=\"passportSeries\"]"), "1111");
        fillField(By.xpath("//*[@id=\"passportNumber\"]"), "010120");
        fillField(By.xpath("//*[@id=\"documentDate\"]"), "20.02.2000");
        fillField(By.xpath("//*[@id=\"documentIssue\"]"), "МРО");
        fillField(By.xpath("//*[@id=\"documentIssue\"]"), "МРО");

        assertEquals("Иванов", driver.findElement(By.xpath("//*[@id=\"surname_vzr_ins_0\"]")).getAttribute("value"));
        assertEquals("Иван", driver.findElement(By.xpath("//*[@id=\"name_vzr_ins_0\"]")).getAttribute("value"));
        assertEquals("01.01.2000", driver.findElement(By.xpath("//*[@id=\"birthDate_vzr_ins_0\"]")).getAttribute("value"));
        assertEquals("Иванов", driver.findElement(By.xpath("//*[@id=\"person_lastName\"]")).getAttribute("value"));
        assertEquals("Иван", driver.findElement(By.xpath("//*[@id=\"person_firstName\"]")).getAttribute("value"));
        assertEquals("Иванович", driver.findElement(By.xpath("//*[@id=\"person_middleName\"]")).getAttribute("value"));
        assertEquals("11.02.1980", driver.findElement(By.xpath("//*[@id=\"person_birthDate\"]")).getAttribute("value"));
        assertEquals("1111", driver.findElement(By.xpath("//*[@id=\"passportSeries\"]")).getAttribute("value"));
        assertEquals("010120", driver.findElement(By.xpath("//*[@id=\"passportNumber\"]")).getAttribute("value"));
        assertEquals("20.02.2000", driver.findElement(By.xpath("//*[@id=\"documentDate\"]")).getAttribute("value"));
        assertEquals("МРО", driver.findElement(By.xpath("//*[@id=\"documentIssue\"]")).getAttribute("value"));

        waitAndClick(By.xpath("/html/body/app/ng-component/div/div/div/app-forming-product/div/form/div/div[3]/div/div[2]/button"));


        wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.xpath("/html/body/app/ng-component/div/div/div/app-forming-product/div/form/div/alert-form[1]/div"))));

        assertEquals("При заполнении данных произошла ошибка",
                driver.findElement(By.xpath("/html/body/app/ng-component/div/div/div/app-forming-product/div/form/div/alert-form[1]/div")).getText());

        assertEquals("Поле не заполнено.",
                driver.findElement(By.xpath("/html/body/app/ng-component/div/div/div/app-forming-product/div/form/div/fieldset[4]/div[3]/div/form-control-label/div/input-email/span/validation-message/span")).getText());

        assertEquals("Поле не заполнено.",
                driver.findElement(By.xpath("/html/body/app/ng-component/div/div/div/app-forming-product/div/form/div/fieldset[4]/div[1]/div/form-control-label/div/input-phone2/span/validation-message/span")).getText());

        assertEquals("Поле не заполнено.",
                driver.findElement(By.xpath("/html/body/app/ng-component/div/div/div/app-forming-product/div/form/div/fieldset[4]/div[2]/div/form-control-label/div/input-email/span/validation-message/span")).getText());
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }


    private void fillField(By locator, String value) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }

    private void waitAndClick(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(
                driver.findElement(locator)));
        driver.findElement(locator).click();
    }
}
