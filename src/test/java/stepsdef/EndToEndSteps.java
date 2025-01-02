package stepsdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.*;

public class EndToEndSteps {
    WebDriver driver = Hooks.getDriver();
    HomePage homePage;
    LoginPage loginPage;
    LaptopsPage laptopsPage;
    FirstProductPage firstProductPage;
    SecondProductPage secondProductPage;
    CartPage cartPage;
    PlaceOrderPage placeOrderPage;
    PurchaseConfirmationPage purchaseConfirmationPage;

    @Given("user click on login in the header")
    public void user_click_on_login_in_the_header () throws InterruptedException{
        homePage = new HomePage(driver);
        homePage.clickOnLoginButton();
        Thread.sleep(2000);
    }
    @When("user enters {string} and {string} and click login")
    public void user_enters_username_and_password_and_click_login (String username , String password)  throws InterruptedException{
        loginPage = new LoginPage(driver);
        loginPage.insertUsername(username);
        loginPage.insertPassword(password);
        loginPage.clickOnLoginButton();
        Thread.sleep(2000);
    }
    @Then("verify that user logged in successfully")
    public void verify_that_user_logged_in_successfully () throws InterruptedException {
        Assert.assertTrue(loginPage.verifyThatUserIsLoggedSuccessfully());
        Thread.sleep(1000);
    }
    @And("user clicks on laptops categories then user selects the first laptop and adds the first laptop to the cart")
    public void userClicksOnLaptopsCategoriesThenUserSelectsTheFirstLaptopAndAddsTheFirstLaptopToTheCart() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.clickOnLaptopsButton();
        Thread.sleep(2000);

        laptopsPage = new LaptopsPage(driver);
        laptopsPage.clickOnFirstProduct();
        Thread.sleep(2000);

        firstProductPage = new FirstProductPage(driver);
        firstProductPage.clickOnAddtoCartButton();
        Thread.sleep(2000);
        String actualresult = firstProductPage.ProductAddedMessage();
        String expectedresult = "Product added";
        Assert.assertTrue(actualresult.contains(expectedresult));
        firstProductPage.AcceptAlertMessage();
    }

    @And("user clicks on the cart in the header then checks that the first laptop is added to the cart")
    public void userClicksOnTheCartInTheHeaderThenChecksThatTheFirstLaptopIsAddedToTheCart() throws InterruptedException {
        firstProductPage = new FirstProductPage(driver);
        firstProductPage.clickOnCartButton();
        Thread.sleep(3000);

        cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.FirstProductIsDisplayed());
        Assert.assertTrue(cartPage.FirstProductPriceIsDisplayed());
    }

    @And("click on home button in the header then user clicks on laptops categories then user clicks on the second laptop and adds the second laptop to the cart")
    public void clickOnHomeButtonInTheHeaderThenUserClicksOnLaptopsCategoriesThenUserClicksOnTheSecondLaptopAndAddsTheSecondLaptopToTheCart() throws InterruptedException {
        cartPage = new CartPage(driver);
        cartPage.ReturntoHomePage();
        Thread.sleep(2000);

        homePage = new HomePage(driver);
        laptopsPage = new LaptopsPage(driver);
        secondProductPage = new SecondProductPage(driver);

        homePage.clickOnLaptopsButton();
        Thread.sleep(2000);
        laptopsPage.clickOnSecondProduct();
        Thread.sleep(2000);
        secondProductPage.clickOnAddButton();
        Thread.sleep(2000);


        String actualresult1 = secondProductPage.ProductAddedMessage();
        String expectedresult1 = "Product added";
        Assert.assertTrue(actualresult1.contains(expectedresult1));
        secondProductPage.AcceptAlertMessage();
    }

    @And("user clicks on the cart in the header then checks that the second laptop is added to the cart then checks that the total price is correct")
    public void userClicksOnTheCartInTheHeaderThenChecksThatTheSecondLaptopIsAddedToTheCartThenChecksThatTheTotalPriceIsCorrect() throws InterruptedException {
        secondProductPage = new SecondProductPage(driver);
        cartPage = new CartPage(driver);
        secondProductPage.ClickonCartButton();
        Thread.sleep(3000);
        Assert.assertTrue(cartPage.SecondProductIsDisplayed());
        Assert.assertTrue(cartPage.SecondProductPriceIsDisplayed());

        Assert.assertTrue(cartPage.CheckThatTotalPriceIsCorrect());
    }

    @And("click on place order button and write name {string} and write country {string} and city {string} and credit card {string} and month {string} and year {string} and click on purchase button and click ok")
    public void clickOnPlaceOrderButtonAndWriteNameAndWriteCountryAndCityAndCreditCardAndMonthAndYearAndClickOnPurchaseButtonAndClickOk(String name, String country, String city, String credit_card, String month, String year) throws InterruptedException {
        cartPage = new CartPage(driver);
        placeOrderPage = new PlaceOrderPage(driver);


        cartPage.clickOnPlaceOrderButton();
        Thread.sleep(2000);

        placeOrderPage.insertName(name);
        placeOrderPage.insertCountry(country);
        placeOrderPage.insertCity(city);
        placeOrderPage.insertCreditCard(credit_card);
        placeOrderPage.insertMonth(month);
        placeOrderPage.insertYear(year);
        placeOrderPage.clickOnPurchaseButton();
        Thread.sleep(2000);

        purchaseConfirmationPage = new PurchaseConfirmationPage(driver);
        String actualresult2 = purchaseConfirmationPage.GetValidationMessage();
        String expectedresult2 = "Thank you for your purchase!";
        Assert.assertTrue(actualresult2.contains(expectedresult2));
        purchaseConfirmationPage.clickOnOKButton();
    }
}
