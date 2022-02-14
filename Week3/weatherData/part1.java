
/**
 * Write a description of part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.File;
public class part1 {
    public CSVRecord coldestHourInFile(CSVParser parser){
        CSVRecord coldestSofar = null;
        for (CSVRecord currentTemp : parser){
         if (coldestSofar == null){
             coldestSofar = currentTemp;
         }
         else{
             double coldesttemp = Double.parseDouble(coldestSofar.get("TemperatureF"));
             double currenttemp = Double.parseDouble(currentTemp.get("TemperatureF"));
             if (coldesttemp > currenttemp && currenttemp > -90.0){
                 coldesttemp = currenttemp;
                 coldestSofar = currentTemp;
                }
        }         
        }
        return coldestSofar;
    }
  
    public String fileWithColdestTemperature(){
        String coldestFile = "";
        CSVRecord coldestRecord = null;
        DirectoryResource dr = new DirectoryResource();
        
        for (File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVParser parse = fr.getCSVParser();
            CSVRecord current = coldestHourInFile(parse);
            if (coldestRecord == null){
             coldestRecord = current;
             coldestFile = f.getAbsolutePath();
         }
         else{
             double coldesttemp = Double.parseDouble(coldestRecord.get("TemperatureF"));
             double currenttemp = Double.parseDouble(current.get("TemperatureF"));
             if (coldesttemp > currenttemp){
                 coldestRecord = current;
                 coldestFile = f.getAbsolutePath();
                }
        } 
            
        }
        return coldestFile;
    }
     public void testColdestHourInFile(){
     FileResource fr = new FileResource();
     CSVRecord smallest = coldestHourInFile( fr.getCSVParser());
     System.out.println("Coldest temperature in the file was " + smallest.get("TemperatureF") + " at " + smallest.get("DateUTC")); 
    }
    public void testFileWithColdestTemperature(){
     String nameFile = fileWithColdestTemperature();
     FileResource fr = new FileResource(nameFile);
     CSVRecord smallestTemp = coldestHourInFile(fr.getCSVParser());
      System.out.println("Coldest day was in file "+ nameFile);
      System.out.println("Coldest Temp on that day was "+ smallestTemp.get("TemperatureF"));
      System.out.println("All the Temps on that coldest day were: ");

        for(CSVRecord record: fr.getCSVParser())
        {
            System.out.println(record.get("DateUTC") + ": " + record.get("TemperatureF"));
        }
    }
    public CSVRecord lowestHumidityInFile(CSVParser csvparse){
       CSVRecord CSVLowHumid = null;
       for (CSVRecord parser : csvparse){
           if (parser.get("Humidity").length() != 3){
               if (CSVLowHumid == null){
                   CSVLowHumid = parser;
                }
                else{
                    double Lowest = Double.parseDouble(CSVLowHumid.get("Humidity"));
                    double current = Double.parseDouble(parser.get("Humidity"));
                    if (Lowest > current){
                        Lowest = current;
                        CSVLowHumid = parser;
                    }
                    
                }
           
            }
       }
       return CSVLowHumid;
    }
    public CSVRecord lowestHumidityInManyFiles(){
     CSVRecord smallestHum = null;
     DirectoryResource dr = new DirectoryResource();
     for ( File f : dr.selectedFiles()){
         FileResource fr =new FileResource(f);
         CSVParser parse = fr.getCSVParser();
         CSVRecord LowHumOfFile = lowestHumidityInFile(parse);
         if ( smallestHum == null){
             smallestHum =LowHumOfFile;
             
            }
          else{
             double currHum = Double.parseDouble(LowHumOfFile.get("Humidity"));
             double lowestHum = Double.parseDouble(smallestHum.get("Humidity"));
             if (lowestHum > currHum){
                 lowestHum = currHum;
                 smallestHum = LowHumOfFile;
                 
                }
        }
        }
        return smallestHum;
    }
    public void  testLowestHumidityInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord csv = lowestHumidityInFile(parser);
        System.out.println("Humidity : " + csv.get("Humidity")+ " Date and Time: " + csv.get("DateUTC"));
    }
    public void  testLowestHumidityInManyFiles() {
     CSVRecord Record = lowestHumidityInManyFiles();
     System.out.println("Lowest Humidity was  " + Record.get("Humidity") + " at " + Record.get("DateUTC"));
    }
    public double averageTemperatureInFile( CSVParser parser){
     double avgTemp = 0.0;
     double totalTemp = 0;
     int count = 0;
     for (CSVRecord row : parser){
         double temp = Double.parseDouble(row.get("TemperatureF"));
         totalTemp = totalTemp + temp;
         count ++;
        }
        avgTemp = totalTemp / count;
        return avgTemp;
    }
    
    public void testAverageTemperatureInFile(){
     FileResource fr = new FileResource();
     CSVParser record = fr.getCSVParser();
     double avg = averageTemperatureInFile(record);
     System.out.println("Average temperature is "  +avg);
    
    }   
    public double  averageTemperatureWithHighHumidityInFile (CSVParser parser, int value){
     double avgTemp = 0.0;
     double totalTemp = 0;
     int count = 0;
     for (CSVRecord row : parser){
         if (value <= Double.parseDouble(row.get("Humidity"))){
         double temp = Double.parseDouble(row.get("TemperatureF"));
         totalTemp = totalTemp + temp;
         count ++;
        }
        }
     if (count != 0){
        avgTemp = totalTemp / count;
    }
        return avgTemp;
        
    }
    public void testAverageTemperatureWithHighHumidityInFile(){
        FileResource fr = new FileResource();
        CSVParser parse = fr.getCSVParser();
        double average =  averageTemperatureWithHighHumidityInFile(parse,80);
        if (average == 0.0){
            System.out.println("There's no temperature above given humidity");
        }
        else{
            System.out.println("Average temperature of high humidity is " + average);
        }
    }
   
     
    }
   
   


