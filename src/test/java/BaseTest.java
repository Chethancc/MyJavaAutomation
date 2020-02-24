import common.TestDataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * Created by chethanc on 24/2/20.
 */
public class BaseTest extends TestDataProvider{

    public String path = "/Users/chethanc/Documents/ChethanProject/MyJavaAutomation/src/main/java/TestData/Data.csv";

    @BeforeClass
    public void setTestFilePath(){
        reqFilePath = path;
    }

    @Test(dataProvider = "dp")
    public void setUp(HashMap<String,String> myMap){
        System.out.println(myMap.get("UserName"));
    }
}
