package TestRunner;

import Configuration.Setup;
import Pages.LoginPage;
import Utils.Utils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AdminLoginTestRunner extends Setup {
    LoginPage loginPage;

    @Test(priority = 1, enabled = false)
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

    @Test(priority = 2, enabled = false)
    public void doLoginWithInvalidCredentials() throws InterruptedException {
        loginPage = new LoginPage(driver);
        Thread.sleep(1000);
        loginPage.doLogin("wrongAdmin", "wrongPassword");
        Thread.sleep(1000);
        String textActual = driver.findElement(By.className("oxd-alert-content-text")).getText();
        Thread.sleep(1000);
        String textExpected = "Invalid credentials";
        Thread.sleep(1000);
        Assert.assertEquals(textActual, textExpected);
    }

    @Test(priority = 3)
    public void doLoginWithValidCredentials() throws InterruptedException, IOException, ParseException {
        loginPage = new LoginPage(driver);
        Thread.sleep(1000);

        String fileLocation = "./src/test/resources/employees.json";
        JSONParser parser = new JSONParser();
        JSONArray employeeArray = (JSONArray) parser.parse(new FileReader(fileLocation));
        JSONObject adminCredentialObject = (JSONObject) employeeArray.get(0);

        if(System.getProperty("username") != null && System.getProperty("password") != null){
            loginPage.doLogin(System.getProperty("username"), System.getProperty("password"));
        }
        else {
            loginPage.doLogin(adminCredentialObject.get("username").toString(), adminCredentialObject.get("password").toString());
        }

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

    public static void main(String[] args) throws IOException, ParseException {
        String fileLocation = "./src/test/resources/employees.json";
        JSONParser parser = new JSONParser();
        JSONArray employeeArray = (JSONArray) parser.parse(new FileReader(fileLocation));
        JSONObject adminCredentialObject = (JSONObject) employeeArray.get(0);
        System.out.println(adminCredentialObject.get("username"));
        System.out.println(adminCredentialObject.get("password"));
    }
}
