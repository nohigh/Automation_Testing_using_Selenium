package actions;
import org.openqa.selenium.WebDriver;
import pages.*;
import java.io.IOException;


public class AddingDataActions {
    public WebDriver driver;

    public AddingDataActions(WebDriver driver) {
        this.driver = driver;
    }

    public void creareDepartamentNou() throws IOException, InterruptedException {
        HomePage homePage = new HomePage(driver);
        DepartamentPage departamentPage = new DepartamentPage(driver);
        homePage.clickTabeleButton();
        homePage.clickDepartmentTableButton();
        departamentPage.creareDepartament();
    }

    public void creareProgramStudiuNou() throws IOException, InterruptedException {
        HomePage homePage = new HomePage(driver);
        ProgramStudiuPage programStudiuPage = new ProgramStudiuPage(driver);
        homePage.clickTabeleButton();
        homePage.clickProgramStudiuTableButton();
        programStudiuPage.creareProgramStudiu();
    }

    public void creareCadruDidacticNou() throws IOException, InterruptedException {
        HomePage homePage = new HomePage(driver);
        CadruDidacticPage cadruDidacticPage = new CadruDidacticPage(driver);
        homePage.clickTabeleButton();
        homePage.clickCadruDidacticTableButton();
        cadruDidacticPage.creareCadruDidactic();
    }

    public void creareStudentNou() throws IOException, InterruptedException {
        HomePage homePage = new HomePage(driver);
        StudentPage studentPage = new StudentPage(driver);
        homePage.clickTabeleButton();
        homePage.clickStudentTableButton();
        studentPage.creareStudent();
    }
}
