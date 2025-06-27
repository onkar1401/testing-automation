
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

class readFilesTest{

    String read_properties_file(String path , String fieldName){
        
        try{
            Properties prop = new Properties();
            FileInputStream fis = new FileInputStream(path);
            prop.load(fis);
            return prop.getProperty(fieldName);        
        }catch(Exception e){
            System.err.println(e);
            return null;
        }     
    }
    @Test
    void read_excel(String path) throws FileNotFoundException, IOException{
        FileInputStream fis = new FileInputStream(path);
        Workbook workbook =new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("Test");

        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

    }
}