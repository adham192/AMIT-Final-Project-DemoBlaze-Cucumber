package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PlaceOrderPage {
    WebDriver driver;
    public PlaceOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //locators
    private By NameBox = By.id("name");
    private By CountryBox = By.id("country");
    private By CityBox = By.id("city");
    private By CreditCardBox = By.id("card");
    private By MonthBox = By.id("month");
    private By YearBox = By.id("year");
    private By PurchaseButton = By.xpath("//button[(@onclick='purchaseOrder()')]");

    public void insertName(String name){
        driver.findElement(NameBox).sendKeys(name);
    }
    public void insertCountry(String country){
        driver.findElement(CountryBox).sendKeys(country);
    }
    public void insertCity(String city){
        driver.findElement(CityBox).sendKeys(city);
    }
    public void insertCreditCard(String card){
        driver.findElement(CreditCardBox).sendKeys(card);
    }
    public void insertMonth(String month){
        driver.findElement(MonthBox).sendKeys(month);
    }
    public void insertYear(String year){
        driver.findElement(YearBox).sendKeys(year);
    }
    public PurchaseConfirmationPage clickOnPurchaseButton(){
        driver.findElement(PurchaseButton).click();
        return new PurchaseConfirmationPage(driver);
    }
}
