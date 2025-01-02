package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    private By FirstProduct = By.xpath("//td[contains(text(),'i5')]");
    private By SecondProduct = By.xpath("//td[contains(text(),'i7')]");
    private By FirstProductPrice = By.xpath("//td[contains(text(),'790')]");
    private By SecondProductPrice = By.xpath("(//td[contains(text(),'790')])[1]");
    private By TotalPrice = By.cssSelector("#totalp");
    private By PlaceOrderButton = By.xpath("//button[(@data-target='#orderModal')]");
    private By HomeButton = By.xpath("//a[contains(text(),'Ho')]");


    //Actions
    public boolean FirstProductIsDisplayed(){
        boolean check1 = driver.findElement(FirstProduct).isDisplayed();
        return check1;
    }
    public boolean SecondProductIsDisplayed(){
        boolean check2 = driver.findElement(SecondProduct).isDisplayed();
        return check2;
    }
    public boolean FirstProductPriceIsDisplayed(){
        boolean check3 = driver.findElement(FirstProductPrice).isDisplayed();
        return check3;
    }
    public boolean SecondProductPriceIsDisplayed(){
        boolean check4 = driver.findElement(SecondProductPrice).isDisplayed();
        return check4;
    }
    public boolean CheckThatTotalPriceIsCorrect(){
        String price1 = driver.findElement(FirstProductPrice).getText();
        String price2 = driver.findElement(SecondProductPrice).getText();
        Integer sum = Integer.parseInt(price1)+Integer.parseInt(price2);
        if(sum.toString().equals(driver.findElement(TotalPrice).getText())){
            return true;
        }
        return false;
    }
    public PlaceOrderPage clickOnPlaceOrderButton(){
        driver.findElement(PlaceOrderButton).click();
        return new PlaceOrderPage(driver);
    }
    public HomePage ReturntoHomePage(){
        driver.findElement(HomeButton).click();
        return new HomePage(driver);
    }
}
