package fileReaders;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsvReader {


    //Logger log = LoggerFactory.getLogger(CsvReader.class);

    public List<String []> readFileData(String filePath){
        List<String[]> allData = null;
        try{
            FileReader fileReader = new FileReader(new File(filePath));
            CSVReader csvReader = new CSVReader(fileReader);
            allData =  csvReader.readAll();

        }catch (FileNotFoundException fne)
        {
           //log.error("File Not Found , Please Check the File Path");
        }catch (IOException io)
        {
            //log.error("File not able to load , Check the format of the file");
        }
        return allData;
    }

    public Map<String,String> getData(String filePath,String profile)
    {
        Map<String,String> myData = new HashMap<String, String>();
        List<String[]> allData = readFileData(filePath);
        int rowNumber = getRowFromProfile(filePath,profile);
        String [] allHeaders = allData.get(0);
        String [] requiredData = allData.get(rowNumber);
        for (int i=1 ; i<requiredData.length;i++) {
            myData.put(allHeaders[i], requiredData[i]);
        }
        return myData;
    }

    public int getRowFromProfile(String filePath,String profile)
    {
        List<String []> allData = readFileData(filePath);
        int rowNumber = 0;
        for(int i=1;i<allData.size();i++){
            String [] requiredData = allData.get(i);
            String requiredProfile = requiredData[0];
            if(requiredProfile.equals(profile))
            {
                rowNumber = i;
                break;
            }
            else{
                //log.error("No given profile Name");
            }
        }
          return rowNumber;
    }

    public static void main(String[] args) {
        CsvReader csvReader = new CsvReader();
        Map<String ,String> myMap =csvReader.getData("/Users/chethanc/Documents/ChethanProject/MyJavaAutomation/src/main/java/TestData/Data.csv","Profile3");
        System.out.println(myMap);
    }
}
