package pages;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class StudentPage {
    public WebDriver driver;

    public StudentPage(WebDriver driver) {
        this.driver = driver;
    }

    By creareStudentButton = By.xpath("//*[@id='jh-create-entity']");
    By numeField = By.xpath("//*[@id='field_nume']");
    By prenumeField = By.xpath("//*[@id='field_prenume']");
    By numarMatricolField = By.xpath("//*[@id='field_numarMatricol']");
    By lucrareLicentaField = By.xpath("//*[@id='field_lucrareLicenta']");
    By liniaDePredareField = By.xpath("//*[@id='field_linia']");
    By formaDeInvatamantField = By.xpath("//*[@id='field_forma']");
    By profesorCoordonatorField = By.xpath("//*[@id='field_cadruDidactic']");
    By salvareStudentButton = By.xpath("//*[@id='save-entity']");
    By stergereButton = By.xpath("/html/body/jhi-main/div[2]/div/jhi-student/div/div[1]/table/tbody/tr[1]/td[9]/div/button[3]");
    By confirmareStergereButton = By.xpath("//*[@id='jhi-confirm-delete-student']/span");
    By stergereAlert =  By.xpath("/html/body/jhi-main/div[2]/div/jhi-student/div/jhi-alert/div/div");
    By noStudentsMessage = By.xpath("/html/body/jhi-main/div[2]/div/jhi-student/div/div[1]");
    public void creareStudent() throws InterruptedException, IOException {
        ArrayList<String> numeStudent = readExcelData(0);
        ArrayList<String> prenumeStudent = readExcelData(1);
        ArrayList<String> numarMatricol = readExcelData(2);
        ArrayList<String> lucrareLicenta = readExcelData(3);
        ArrayList<String> liniaDePredare = readExcelData(4);
        ArrayList<String> formaDeInvatamant = readExcelData(5);
        ArrayList<String> profesorCoordonator = readExcelData(6);

        for(int i=0;i<numeStudent.size();i++) {
            Thread.sleep(200);
            driver.findElement(creareStudentButton).click();
            driver.findElement(numeField).sendKeys(numeStudent.get(i));
            driver.findElement(prenumeField).sendKeys(prenumeStudent.get(i));
            driver.findElement(numarMatricolField).sendKeys(numarMatricol.get(i));
            driver.findElement(lucrareLicentaField).sendKeys(lucrareLicenta.get(i));
            driver.findElement(liniaDePredareField).click();
            driver.findElement(liniaDePredareField).sendKeys(liniaDePredare.get(i));
            driver.findElement(formaDeInvatamantField).click();
            driver.findElement(formaDeInvatamantField).sendKeys(formaDeInvatamant.get(i));
            driver.findElement(profesorCoordonatorField).click();
            driver.findElement(profesorCoordonatorField).sendKeys(profesorCoordonator.get(i));
            driver.findElement(salvareStudentButton).click();
        }

    }

    public ArrayList<String> readExcelData(int colNo) throws IOException {
        FileInputStream fis = new FileInputStream("D:\\Licenta\\Excel_FSEGA.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet s = wb.getSheet("Student");
        Iterator<Row> rowIterator = s.iterator();
        rowIterator.next();
        ArrayList<String> list = new ArrayList<String>();
        while(rowIterator.hasNext()) {
            list.add(rowIterator.next().getCell(colNo).getStringCellValue());
        }
        return list;
    }
    public void stergereStudent() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        boolean verificator = driver.findElement(stergereButton) .isDisplayed();

        while(verificator){

            try {
                driver.findElement(stergereButton).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(confirmareStergereButton));
                driver.findElement(confirmareStergereButton).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(stergereAlert));
            }catch(Exception e) {
                verificator = false;
            }
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(noStudentsMessage));

    }
}


