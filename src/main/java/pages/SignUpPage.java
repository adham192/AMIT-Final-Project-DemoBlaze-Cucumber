package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
    WebDriver driver;
    Faker faker = new Faker();

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    //locators
    private By UsernameBox = By.cssSelector("#sign-username");
    private By PasswordBox = By.cssSelector("#sign-password");
    private By RegisterButton = By.xpath("//button[@onclick = 'register()']");

    //Actions
    public void FillUsernameBox(){
        String username = faker.name().username();
        driver.findElement(UsernameBox).sendKeys(username);
    }
    public void FillPasswordBox(){
        String password = faker.name().name();
        driver.findElement(PasswordBox).sendKeys(password);
    }
    public void clickOnRegisterButton(){
        driver.findElement(RegisterButton).click();
    }
    public String SignUpSuccessful(){
        return driver.switchTo().alert().getText();
    }
    public void AcceptSignUpSuccesfulMessage(){
        driver.switchTo().alert().accept();
    }
}
