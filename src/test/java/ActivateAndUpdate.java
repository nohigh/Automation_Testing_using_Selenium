import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.DriverAndExtentReports;
import utility.Constants;
import static org.testng.Assert.assertEquals;


public class ActivateAndUpdate extends DriverAndExtentReports {

    @Test
    public void activateAndUpdateUser() {

        test = extent.createTest("Activate and update user");
        Assert.assertTrue(true);

        test.log(Status.INFO, "Navigare in pagina de gestiune utilizatori");
        gestiuneUtilizatoriActions.gestiuneUtilizatoriBar();
        assertEquals("Utilizatori", gestiuneUtilizatoriPage.getUtilizatoriText());

        test.log(Status.INFO, "Activare utilizator nou inregistrat");
        gestiuneUtilizatoriActions.gestiuneUtilizatoriActivare();
        assertEquals("Activat", gestiuneUtilizatoriPage.getActivatButtonText());

        test.log(Status.INFO, "Setare rol admin pentru noul utilizator inregistrat");
        gestiuneUtilizatoriActions.gestiuneUtilizatoriEditare();
        assertEquals(Constants.ROLE, gestiuneUtilizatoriPage.getRoleAdminText());

        test.log(Status.INFO, "Logout din contul de administrator");
        logoutActions.logout();

        test.log(Status.INFO, "Logare sub forma noului utilizator inregistrat");
        assertEquals("Încă nu aveți un cont?", homePage.getTextPaginaDeStart());
        loginActions.login("DragosNohai", "nohaidragos15");
        test.log(Status.PASS, "Logarea cu noul utilizator a fost facuta cu succes");

        test.log(Status.INFO, "Schimbare nume utilizator din pagina Setari");
        setariActions.changeNumePrenume("Dragos", "Nohai");
        assertEquals("Setări salvate!", setariPage.getSetariSalvateAlertText());
        test.log(Status.PASS, "Setarile au fost realizate cu succes");

    }

}
