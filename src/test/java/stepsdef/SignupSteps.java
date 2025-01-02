package stepsdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePage;
import pages.SignUpPage;

public class SignupSteps {
    WebDriver driver = Hooks.getDriver();
    HomePage homePage;
    SignUpPage signUpPage;

    @Given("user opens home page and click on Sign up button")
    public void user_opens_home_page_and_click_on_sign_up_button() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.clickOnSignUpButton();
        Thread.sleep(1000);
    }


    @When("user enter username and password and click Sign up")
    public void userEnterAndAndClickSignUp() throws InterruptedException {
        signUpPage = new SignUpPage(driver);
        signUpPage.FillUsernameBox();
        signUpPage.FillPasswordBox();
        signUpPage.clickOnRegisterButton();
        Thread.sleep(1000);
    }

    @Then("Sign up successful message is displayed")
    public void signUpSuccessfulMessageIsDisplayed() {
        String actualresult3 = signUpPage.SignUpSuccessful();
        String expectedresult3 = "Sign up successful.";
        Assert.assertTrue(actualresult3.contains(expectedresult3));
        signUpPage.AcceptSignUpSuccesfulMessage();
    }
}
