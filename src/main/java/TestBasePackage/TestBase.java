package TestBasePackage;

import PagesPackage.PageFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class TestBase {
    public static WebDriver driver;
    public static Properties prop;
    protected static PageFactory pageFactory;

    @BeforeClass
    public void launch_browser() {
        pageFactory = new PageFactory();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        try
        {
            //Environment specific properties file loading
            InputStream ip = new FileInputStream(System.getProperty("user.dir") +"\\src\\main\\" +
                    "java\\ConfigPackage\\Config.properties");
            prop = new Properties();
            prop.load(ip);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    @BeforeMethod
    public void loadBaseUrl() {
        pageFactory = new PageFactory();
        driver.get(prop.getProperty("url"));
        driver.manage().deleteAllCookies();
    }

    @AfterMethod
    public void screenshotAndDeleteCookies(ITestResult testResult) throws IOException {
        pageFactory = new PageFactory();
        //Taking screenshot in case of failure
        if(testResult.getStatus() == ITestResult.FAILURE){
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("errorScreenshots\\" + testResult.getName() + "-"
                    + Arrays.toString(testResult.getParameters()) +  ".jpg"));
        }
        //Deleting cookies
        driver.manage().deleteAllCookies();
    }
    @AfterClass
    public void suiteTearDown() {
        driver.quit();
    }
}
