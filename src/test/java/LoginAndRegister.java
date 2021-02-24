
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.Constants;
import utility.DriverAndExtentReports;
import static org.testng.Assert.assertEquals;


public class LoginAndRegister extends DriverAndExtentReports {

    @Test
    public void LoginAndRegister() {
        test = extent.createTest("Login into application and register");
        Assert.assertTrue(true);


        test.log(Status.INFO, "Pornire aplicatie de testare");
        driver.get(Constants.URL);

        test.log(Status.INFO, "Logare sub forma utilizatorului admin");
        loginActions.login(Constants.ADMIN_USERNAME, Constants.ADMIN_PASSWORD);
        assertEquals("Ești autentificat cu numele de utilizator \"admin\".", homePage.getTextHomePage());

        test.log(Status.PASS, "Autentificarea a avut loc cu succes");
        logoutActions.logout();
        test.log(Status.INFO, "Logout din aplicatia de testare");

        assertEquals("Încă nu aveți un cont?", homePage.getTextPaginaDeStart());
        test.log(Status.INFO, "Logare sub forma utilizatorului user");
        loginActions.login(Constants.USER_USERNAME, Constants.USER_PASSWORD);
        test.log(Status.PASS, "Autentificarea a avut loc cu succes");
        assertEquals("Ești autentificat cu numele de utilizator \"user\".", homePage.getTextHomePage());

        test.log(Status.INFO, "Logout din aplicatia de testare");
        logoutActions.logout();
        test.log(Status.PASS, "Logout-ul a fost realizat cu succes");
        assertEquals("Încă nu aveți un cont?", homePage.getTextPaginaDeStart());

        test.log(Status.INFO, "Inregistrare utilizator nou");
        registerActions.clickRegisterUserButton();
        assertEquals("Înregistrare", registerPage.getInregistrareTitle());
        registerActions.registerUser("DragosNohai", "dragos@nohai.ro", "nohaidragos15", "nohaidragos15");
        test.log(Status.PASS, "Inregistrarea a fost realizata cu succes");
        assertEquals("Înregistrare salvată! Vă rugăm să vă verificați emailul pentru confirmare.", registerPage.getInregistrareSalvataText());

        test.log(Status.INFO, "Logare sub forma utilizatorului admin");
        loginActions.login(Constants.ADMIN_USERNAME, Constants.ADMIN_PASSWORD);
        assertEquals("Ești autentificat cu numele de utilizator \"admin\".", homePage.getTextHomePage());

    }

}
