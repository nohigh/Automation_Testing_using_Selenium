import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.Constants;
import utility.DriverAndExtentReports;



public class DeleteUserAndCloseApp extends DriverAndExtentReports {

    @Test
    public void DeleteUserAndCloseApp() {
            test = extent.createTest("Delete created user and close the application");
            Assert.assertTrue(true);

            test.log(Status.INFO, "Logout din utilizatorul curent");
            logoutActions.logout();
            test.log(Status.PASS, "Logout-ul fost realizat cu succes");

            test.log(Status.INFO, "Logare sub forma utilizatorului admin");
            loginActions.login(Constants.ADMIN_USERNAME, Constants.ADMIN_PASSWORD);
            test.log(Status.PASS, "Logarea a avut loc cu succes");
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='admin-menu']/span/span")));
            test.log(Status.INFO, "Stergere utilizator creat");
            gestiuneUtilizatoriActions.gestiuneUtilizatoriStergereUser();
            test.log(Status.PASS, "Utilizatorul a fost sterg cu succes");
            driver.quit();
    }

}
