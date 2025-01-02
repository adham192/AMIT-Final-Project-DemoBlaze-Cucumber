package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PurchaseConfirmationPage {
    WebDriver driver;
    public PurchaseConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    private By validationMessage = By.xpath("(//h2)[3]");
    private By OkButton = By.xpath("//button[contains(text(),'OK')]");

    //Actions
    public String GetValidationMessage(){
        return driver.findElement(validationMessage).getText();
    }
    public void clickOnOKButton(){
        driver.findElement(OkButton).click();
    }
}
