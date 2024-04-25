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

    @FindBy(className = "oxd-button")
    List<WebElement> txtFields;

    public PIMPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public void addEmployee(String firstName, String lastName, String userName, String passWord){
        pimButton.get(1).click(); //Select PIM tab from Menu bar
        button.get(2).click(); //Click on Add button
        txtFirstName.sendKeys(firstName);
        txtLastName.sendKeys(lastName);
        toggleButton.click();
        txtFields.get(5).sendKeys(userName); //Insert Username
        txtFields.get(6).sendKeys(passWord); // Insert Password
        txtFields.get(7).sendKeys(passWord); //Insert Confirm Password
        button.get(1).click(); //Click on Save button
    }
}

