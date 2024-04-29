import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PIMPage {

    @FindBy(className = "oxd-main-menu-item")
    List<WebElement> pimButton;

    @FindBy(className = "oxd-button")
    List<WebElement> button;

    @FindBy(name = "firstName")
    WebElement txtFirstName;

    @FindBy(name = "lastName")
    WebElement txtLastName;

    @FindBy(className = "oxd-switch-input")
    WebElement toggleButton;

    @FindBy(className = "oxd-input")
    List<WebElement> txtFields;

    @FindBy(className = "oxd-topbar-body-nav-tab-item")
    List<WebElement> employeeListTab;

    @FindBy(xpath = "//div[@class='oxd-grid-4 orangehrm-full-width-grid']//div[1]//div[1]//div[2]//div[1]//div[1]//input[1]")
    WebElement txtEmployeeName;

    @FindBy(className = "oxd-icon-button")
    List<WebElement> iconButtons;

    @FindBy(className = "oxd-radio-input")
    List<WebElement> radioButtons;



    public PIMPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public void addEmployee(String firstName, String lastName, String userName, String passWord) throws InterruptedException {
        pimButton.get(1).click(); //Select PIM tab from Menu bar
        Thread.sleep(3000);
        button.get(2).click(); //Click on Add button
        txtFirstName.sendKeys(firstName);
        txtLastName.sendKeys(lastName);
        toggleButton.click();
        txtFields.get(5).sendKeys(userName); //Insert Username
        txtFields.get(6).sendKeys(passWord); // Insert Password
        txtFields.get(7).sendKeys(passWord); //Insert Confirm Password
        button.get(1).click(); //Click on Save button
    }

    public void editEmployee(String employeeName, String employeeOtherId) throws InterruptedException {
        pimButton.get(1).click(); //Select PIM tab from Menu bar
        Thread.sleep(3000);
        employeeListTab.get(1).click();
        Thread.sleep(500);
        txtEmployeeName.sendKeys(employeeName);
        Thread.sleep(500);
        button.get(1).click();
        Thread.sleep(500);
        iconButtons.get(4).click();
        Thread.sleep(500);
        txtFields.get(5).sendKeys(employeeOtherId);
        Thread.sleep(500);
        radioButtons.get(0).click();
        Thread.sleep(500);
        button.get(0).click();
        Thread.sleep(500);
    }
}

