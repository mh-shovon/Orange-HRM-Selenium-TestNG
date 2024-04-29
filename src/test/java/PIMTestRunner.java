import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class PIMTestRunner extends Setup {
    @BeforeTest
    public void doLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin("Admin", "admin123");
    }

    @Test(priority = 1)
    public void addEmployee() throws InterruptedException {
        PIMPage pimPage = new PIMPage(driver);
        Thread.sleep(1000);
        pimPage.addEmployee("Hasan", "Shovon", "hasanshovon666700", "P@ssword123");
        WebElement headerElement = driver.findElement(By.xpath("//h6[normalize-space()='Personal Details']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOf(headerElement));
        String textActual = headerElement.getText();
        String textExpected = "Personal Details";
        Assert.assertEquals(textActual, textExpected);
    }

    @Test(priority = 2)
    public void editEmployee() throws InterruptedException {
        PIMPage pimPage = new PIMPage(driver);
        pimPage.editEmployee("Hasan Shovon", "666700");
        WebElement headerElement = driver.findElement(By.xpath("//h6[normalize-space()='Personal Details']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOf(headerElement));
        String textActual = headerElement.getText();
        String textExpected = "Personal Details";
        Assert.assertEquals(textActual, textExpected);

    }
}
