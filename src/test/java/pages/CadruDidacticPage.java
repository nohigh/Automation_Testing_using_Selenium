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

public class CadruDidacticPage {
    public WebDriver driver;

    public CadruDidacticPage(WebDriver driver) {
        this.driver = driver;
    }

    By creareCadruDidacticButton = By.xpath("//*[@id='jh-create-entity']");
    By numeField = By.xpath("//*[@id='field_nume']");
    By prenumeField = By.xpath("//*[@id='field_prenume']");
    By titluField = By.xpath("//*[@id='field_titlu']");
    By emailField = By.xpath("//*[@id='field_email']");
    By birouField = By.xpath("//*[@id='field_birou']");
    By departamentField = By.xpath("//*[@id='field_departament']");
    By salvareCadruDidacticButton = By.xpath("//*[@id='save-entity']");
    By stergereButton = By.xpath("/html/body/jhi-main/div[2]/div/jhi-cadru-didactic/div/div[1]/table/tbody/tr[1]/td[8]/div/button[3]");
    By confirmareStergereButton = By.xpath("//*[@id='jhi-confirm-delete-cadruDidactic']/span");
    By stergereAlert =  By.xpath("/html/body/jhi-main/div[2]/div/jhi-cadru-didactic/div/jhi-alert/div/div");
    By noCadruDidacticMessage = By.xpath("/html/body/jhi-main/div[2]/div/jhi-cadru-didactic/div/div[1]");



    public void creareCadruDidactic() throws InterruptedException, IOException {
        ArrayList<String> numeCadruDidactic = readExcelData(0);
        ArrayList<String> prenumeCadruDidactic = readExcelData(1);
        ArrayList<String> titluCadruDidactic = readExcelData(2);
        ArrayList<String> emailCadruDidactic = readExcelData(3);
        ArrayList<String> birouCadruDidactic = readExcelData(4);
        ArrayList<String> departamentCadruDidactic = readExcelData(5);

        for(int i=0;i<numeCadruDidactic.size();i++) {
            Thread.sleep(200);
            driver.findElement(creareCadruDidacticButton).click();
            driver.findElement(numeField).sendKeys(numeCadruDidactic.get(i));
            driver.findElement(prenumeField).sendKeys(prenumeCadruDidactic.get(i));
            driver.findElement(titluField).sendKeys(titluCadruDidactic.get(i));
            driver.findElement(emailField).sendKeys(emailCadruDidactic.get(i));
            driver.findElement(birouField).sendKeys(birouCadruDidactic.get(i));
            driver.findElement(departamentField).click();
            driver.findElement(departamentField).sendKeys(departamentCadruDidactic.get(i));
            driver.findElement(salvareCadruDidacticButton).click();
        }
    }

    public ArrayList<String> readExcelData(int colNo) throws IOException {
        FileInputStream fis = new FileInputStream("D:\\Licenta\\Excel_FSEGA.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet s = wb.getSheet("Cadru didactic");
        Iterator<Row> rowIterator = s.iterator();
        rowIterator.next();
        ArrayList<String> list = new ArrayList<String>();
        while(rowIterator.hasNext()) {
            list.add(rowIterator.next().getCell(colNo).getStringCellValue());
        }
        return list;
    }

    public void stergereCadruDidactic() {
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

        wait.until(ExpectedConditions.visibilityOfElementLocated(noCadruDidacticMessage));

    }
}
