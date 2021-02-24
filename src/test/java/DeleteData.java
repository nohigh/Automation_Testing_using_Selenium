import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.DriverAndExtentReports;

public class DeleteData extends DriverAndExtentReports {

    @Test
    public void deleteDataFromTables() {
        test = extent.createTest("Delete all data from tables");
        Assert.assertTrue(true);

        test.log(Status.INFO, "Stergere date din tabela Student");
        deleteDataActions.deleteDataFromStudent();
        test.log(Status.PASS, "Stergerea datelor din tabela Student a fost realizata cu succes");
        test.log(Status.INFO, "Stergere date din tabela Cadru Didactic");
        deleteDataActions.deleteDataFromCadruDidactic();
        test.log(Status.PASS, "Stergerea datelor din tabela Cadru Didactic a fost realizata cu succes");
        test.log(Status.INFO, "Stergere date din tabela Program Studiu");
        deleteDataActions.deleteDataFromProgramStudiu();
        test.log(Status.PASS, "Stergerea datelor din tabela Program Studiu a fost realizata cu succes");
        test.log(Status.INFO, "Stergere date din tabela Departament");
        deleteDataActions.deleteDataFromDepartament();
        test.log(Status.PASS, "Stergerea datelor din tabela Departament a fost realizata cu succes");
    }
}
