import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utility.DriverAndExtentReports;


import java.io.IOException;

public class InsertData extends DriverAndExtentReports {

    @Test
    public void insertDataIntoTables() {
        test = extent.createTest("Insert data in each table");
        Assert.assertTrue(true);

        DepartamentPage data = new DepartamentPage(driver);
        ProgramStudiuPage psp = new ProgramStudiuPage(driver);
        CadruDidacticPage cdp = new CadruDidacticPage(driver);
        StudentPage sp = new StudentPage(driver);
        try {
            test.log(Status.INFO, "Adaugare date in tabela Departament");
            addingDataActions.creareDepartamentNou();
            test.log(Status.PASS, "Adaugarea datelor in tabela Departament a fost realizata cu succes");
            test.log(Status.INFO, "Adaugare date in tabela Program Studiu");
            addingDataActions.creareProgramStudiuNou();
            test.log(Status.PASS, "Adaugarea datelor in tabela Program Studiu a fost realizata cu succes");
            test.log(Status.INFO, "Adaugare date in tabela Cadru Didactic");
            addingDataActions.creareCadruDidacticNou();
            test.log(Status.PASS, "Adaugarea datelor in tabela Cadru Didactic a fost realizata cu succes");
            test.log(Status.INFO, "Adaugare date in tabela Student");
            addingDataActions.creareStudentNou();
            test.log(Status.PASS, "Adaugarea datelor in tabela Student a fost realizata cu succes");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
