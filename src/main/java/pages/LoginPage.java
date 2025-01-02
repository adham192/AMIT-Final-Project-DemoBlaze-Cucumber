package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //locators
    private By UsernameBox = By.cssSelector("#loginusername");
    private By PasswordBox = By.cssSelector("#loginpassword");
    private By LoginButton = By.xpath("//button[@onclick = 'logIn()']");
    private By nameOfUser = By.cssSelector("#nameofuser");


    //Actions
    public void insertUsername(String username){
        driver.findElement(UsernameBox).sendKeys(username);
    }
    public void insertPassword(String password){
        driver.findElement(PasswordBox).sendKeys(password);
    }
    public void clickOnLoginButton(){
        driver.findElement(LoginButton).click();
    }
    public boolean verifyThatUserIsLoggedSuccessfully() {
        boolean check = driver.findElement(nameOfUser).isDisplayed();
        return check;
    }

}
