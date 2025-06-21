
import java.io.FileInputStream;
import java.util.Properties;

class readFilesTest{

    String read_properties_file(String path , String fieldName){
        
        Properties prop = new Properties();
        try{
            FileInputStream fis = new FileInputStream(path);
            prop.load(fis);
            return prop.getProperty(fieldName);        
        }catch(Exception e){
            System.err.println(e);
            return null;
        }     
    }
}