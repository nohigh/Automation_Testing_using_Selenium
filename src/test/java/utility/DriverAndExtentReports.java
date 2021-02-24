package utility;

import actions.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.*;

public class DriverAndExtentReports {

    protected static WebDriver driver = initDriver();
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest test;

    private static WebDriver initDriver() {
        System.setProperty("webdriver.chrome.driver", "D:\\Licenta\\Selenium_Tests\\src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    protected LoginActions loginActions = new LoginActions(driver);
    protected LogoutActions logoutActions = new LogoutActions(driver);
    protected HomePage homePage = new HomePage(driver);
    protected RegisterPage registerPage = new RegisterPage(driver);
    protected RegisterActions registerActions = new RegisterActions(driver);
    protected GestiuneUtilizatoriPage gestiuneUtilizatoriPage = new GestiuneUtilizatoriPage(driver);
    protected GestiuneUtilizatoriActions gestiuneUtilizatoriActions = new GestiuneUtilizatoriActions(driver);
    protected SetariPage setariPage = new SetariPage(driver);
    protected SetariActions setariActions = new SetariActions(driver);
    protected AddingDataActions addingDataActions = new AddingDataActions(driver);
    protected DeleteDataActions deleteDataActions = new DeleteDataActions(driver);


    @BeforeSuite
    public void setUp(){
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/TestReports/SeleniumReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    @AfterMethod
    public void getResult(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.fail(MarkupHelper.createLabel(result.getName() + "Test Case failed", ExtentColor.RED));
            test.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass(MarkupHelper.createLabel(result.getName() + "Test Case passed", ExtentColor.GREEN));
        } else {
            test.skip(MarkupHelper.createLabel(result.getName() + "Test Case skipped", ExtentColor.YELLOW));
            test.skip(result.getThrowable());
        }
    }

    @AfterSuite
    public void tearDown() {
        extent.flush();
    }

}
