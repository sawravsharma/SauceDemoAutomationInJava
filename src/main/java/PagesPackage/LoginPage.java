package PagesPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static TestBasePackage.TestBase.prop;

public class LoginPage {
    @FindBy(id = "user-name")
    WebElement uname;
    @FindBy(id = "password")
    WebElement pword;
    @FindBy(id = "login-button")
    WebElement login;

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void login() throws InterruptedException {
        uname.sendKeys(prop.getProperty("username"));
        pword.sendKeys(prop.getProperty("pword"));
        login.click();
        Thread.sleep(10000);
    }
}
