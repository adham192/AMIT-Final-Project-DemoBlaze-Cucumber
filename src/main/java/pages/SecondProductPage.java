package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecondProductPage {
    WebDriver driver;
    public SecondProductPage(WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    private By AddtoCartButton = By.xpath("//a[contains(text(),'Add')]");
    private By CartButton = By.linkText("Cart");

    //Actions
    public void clickOnAddButton(){
        driver.findElement(AddtoCartButton).click();
    }
    public String ProductAddedMessage(){
        return driver.switchTo().alert().getText();
    }
    public void AcceptAlertMessage(){
        driver.switchTo().alert().accept();
    }
    public CartPage ClickonCartButton(){
        driver.findElement(CartButton).click();
        return new CartPage(driver);
    }
}
