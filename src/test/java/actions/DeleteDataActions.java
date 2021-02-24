package actions;
import org.openqa.selenium.WebDriver;
import pages.*;

public class DeleteDataActions {
    public WebDriver driver;

    public DeleteDataActions(WebDriver driver) {
        this.driver = driver;
    }

    public void deleteDataFromStudent() {
        StudentPage studentPage = new StudentPage(driver);
        HomePage homePage = new HomePage(driver);
        homePage.clickAcasaButton();
        homePage.clickTabeleButton();
        homePage.clickStudentTableButton();
        studentPage.stergereStudent();
    }

    public void deleteDataFromCadruDidactic() {
        CadruDidacticPage cadruDidacticPage = new CadruDidacticPage(driver);
        HomePage homePage = new HomePage(driver);
        homePage.clickAcasaButton();
        homePage.clickTabeleButton();
        homePage.clickCadruDidacticTableButton();
        cadruDidacticPage.stergereCadruDidactic();
    }

    public void deleteDataFromProgramStudiu() {
        ProgramStudiuPage programStudiuPage = new ProgramStudiuPage(driver);
        HomePage homePage = new HomePage(driver);
        homePage.clickAcasaButton();
        homePage.clickTabeleButton();
        homePage.clickProgramStudiuTableButton();
        programStudiuPage.stergereProgramStudiu();
    }
    public void deleteDataFromDepartament() {
        DepartamentPage departamentPage = new DepartamentPage(driver);
        HomePage homePage = new HomePage(driver);
        homePage.clickAcasaButton();
        homePage.clickTabeleButton();
        homePage.clickDepartmentTableButton();
        departamentPage.stergereDepartament();
    }
}
