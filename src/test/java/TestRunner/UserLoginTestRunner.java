package TestRunner;

import Configuration.Setup;
import Pages.LoginPage;
import Utils.Utils;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class UserLoginTestRunner extends Setup {
    LoginPage loginPage;
    @Test(priority = 1, description = "User can login with valid credentials")
    public void doLoginByUserWithValidCredentials() throws InterruptedException, IOException, ParseException {
        loginPage = new LoginPage(driver);
        String username = Utils.getEmployee().get("username").toString();
        String password = Utils.getEmployee().get("password").toString();
        Thread.sleep(1000);
        loginPage.doLogin(username, password);
        Thread.sleep(1000);
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
        Thread.sleep(1000);
        boolean isImageExists = driver.findElement(By.className("oxd-userdropdown-img")).isDisplayed();
        Thread.sleep(1000);
        Assert.assertTrue(isImageExists);
        Thread.sleep(1000);
    }
}
