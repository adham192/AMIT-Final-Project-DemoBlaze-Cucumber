package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    //locators
    private By SignUpButton = By.cssSelector("#signin2");
    private By LoginButton = By.cssSelector("#login2");
    private By LaptopsButton = By.xpath("//a[contains(text(),'Lap')]");
    private By CartButton = By.linkText("Cart");


    //Actions
    public SignUpPage clickOnSignUpButton(){
        driver.findElement(SignUpButton).click();
        return new SignUpPage(driver);
    }
    public LoginPage clickOnLoginButton(){
        driver.findElement(LoginButton).click();
        return new LoginPage(driver);
    }
    public LaptopsPage clickOnLaptopsButton(){
        driver.findElement(LaptopsButton).click();
        return new LaptopsPage(driver);
    }
    public CartPage clickOnCartButton(){
        driver.findElement(CartButton).click();
        return new CartPage(driver);
    }
}
