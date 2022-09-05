package PagesPackage;

import EnumsPackage.Products_SauceDemoEnums;
import TestBasePackage.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HomePage extends TestBase {

    private String name = "//div[contains(text(),'%s')]//following::button";
    private String getName = "//div[contains(text(),'%s')]";

    @FindBy(id = "react-burger-menu-btn")
    WebElement burgerBtn;

    @FindBy(id = "logout_sidebar_link")
    WebElement logoutbtn;

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void addProductsInCart() {
        for (Products_SauceDemoEnums pro : Products_SauceDemoEnums.values()){
            driver.findElement(By.xpath(String.format(name, pro.getResourcesName()))).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }
    }

    /* Get products into a list */
    public void getProducts(){
        for (Products_SauceDemoEnums pro : Products_SauceDemoEnums.values()){
            List<String> list= new ArrayList<>();
            list.add(driver.findElement(By.xpath(String.format(getName, pro.getResourcesName()))).getText());
            System.out.print(list);
        }
    }
    public void logOut() {
        burgerBtn.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        logoutbtn.click();
    }
}


