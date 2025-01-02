package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LaptopsPage {
    WebDriver driver;
    public LaptopsPage(WebDriver driver) {
        this.driver = driver;
    }

    //locators
    private By FirstProduct = By.linkText("Sony vaio i5");
    private By SecondProduct = By.linkText("Sony vaio i7");


    //Actions
    public FirstProductPage clickOnFirstProduct(){
        driver.findElement(FirstProduct).click();
        return new FirstProductPage(driver);
    }
    public SecondProductPage clickOnSecondProduct(){
        driver.findElement(SecondProduct).click();
        return new SecondProductPage(driver);
    }
}
