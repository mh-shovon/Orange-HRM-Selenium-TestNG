import org.checkerframework.checker.index.qual.PolyUpperBound;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.TestNG;
import org.testng.annotations.Test;

public class LoginTestRunner extends Setup {
    LoginPage loginPage;

    @Test(priority = 1)
    public void doLoginWithNoCredentials() throws InterruptedException {
        loginPage = new LoginPage(driver);
        Thread.sleep(1000);
        loginPage.doLogin("", "");
        Thread.sleep(1000);
        String loginHeaderTitleActual = driver.findElement(By.className("orangehrm-login-title")).getText();
        Thread.sleep(1000);
        String loginHeaderExpected = "Login";
        Thread.sleep(1000);
        Assert.assertEquals(loginHeaderTitleActual,loginHeaderExpected);
        Thread.sleep(1000);

    }

    @Test(priority = 2)
    public void doLoginWithInvalidCredentials() throws InterruptedException {
        loginPage = new LoginPage(driver);
        Thread.sleep(1000);
        loginPage.doLogin("admin", "wrongPassword");
        Thread.sleep(1000);
        String textActual = driver.findElement(By.className("oxd-alert-content-text")).getText();
        Thread.sleep(1000);
        String textExpected = "Invalid credentials";
        Thread.sleep(1000);
        Assert.assertEquals(textActual, textExpected);
    }

    @Test(priority = 3)
    public void doLoginWithValidCredentials() throws InterruptedException {
        loginPage = new LoginPage(driver);
        Thread.sleep(1000);
        loginPage.doLogin("Admin", "admin123");
        Thread.sleep(1000);
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
        Thread.sleep(1000);
        boolean isImageExists = driver.findElement(By.className("oxd-userdropdown-img")).isDisplayed();
        Thread.sleep(1000);
        Assert.assertTrue(isImageExists);
        Thread.sleep(1000);
    }

    @Test(priority = 4)
    public void doLogout() throws InterruptedException {
        loginPage = new LoginPage(driver);
        Thread.sleep(1000);
        loginPage.doLogout();
        Thread.sleep(1000);
        String loginHeaderTitleActual = driver.findElement(By.className("orangehrm-login-title")).getText();
        Thread.sleep(1000);
        String loginHeaderExpected = "Login";
        Thread.sleep(1000);
        Assert.assertEquals(loginHeaderTitleActual,loginHeaderExpected);
        Thread.sleep(1000);
    }
}
