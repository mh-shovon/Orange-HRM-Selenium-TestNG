import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.List;

public class PIMTestRunner extends Setup {
    @BeforeTest
    public void doLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin("Admin", "admin123");
    }

    public void addEmployee() throws InterruptedException {
        PIMPage pimPage = new PIMPage(driver);
        pimPage.addEmployee("Hasan", "Shovon", "hasanshovon", "P@ssword123");
        List<WebElement> headerElement = driver.findElements(By.className("orangehrm-main-title"));
        String textActual = headerElement.get(0).getText();
        String textExpected = "Personal Details";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf((WebElement) headerElement));
        Assert.assertEquals(textActual, textExpected);
    }
}
