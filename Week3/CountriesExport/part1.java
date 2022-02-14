
/**
 * Write a description of part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
public class part1 {
   public String countryInfo (String country,CSVParser parser ){
       
       for (CSVRecord record : parser ){
           if (record.get("Country").equals(country)){
               String dataset = record.get("Country") + " " + record.get("Exports") + " " + record.get("Value (dollars)");
               return dataset;
            }
            
           
        }
        
       return "No Data Found";
    }
   public void listExportersTwoProducts (CSVParser parser, String exportItem1, String exportItem2){
       
       for ( CSVRecord records : parser){
           if (records.get("Exports").contains(exportItem1) && records.get("Exports").contains(exportItem2)){
             
               System.out.println("The countries thayt export " +exportItem1 + " " + exportItem2 + " : " + records.get("Country"));
            }
           
        }
        
    }
     public int numberOfExportes (CSVParser parser, String exportItem){
         int count = 0 ;
       for ( CSVRecord records : parser){
           if (records.get("Exports").contains(exportItem)){
             count ++;
             
               
            }
           
        }
        return count;
    }
       public void bigExporters (CSVParser parser, String amount)
    {
        for(CSVRecord record: parser)
        {
            String value = record.get("Value (dollars)");
            if(value.length() > amount.length())
            {
                String countryCheck = record.get("Country");
                System.out.println( "Countires that export greater than " + amount);
                System.out.println(countryCheck + " " + value);
            }
        }
    }

    public void tester(){
     FileResource fr = new FileResource();
     
     CSVParser parser = fr.getCSVParser();
     String CountryInfo = countryInfo( "Nauru", parser);
     System.out.println(CountryInfo);
     
     parser = fr.getCSVParser();
     listExportersTwoProducts(parser, "cotton", "flowers");
     
     parser = fr.getCSVParser();
     bigExporters(parser, " $999,999,999,999");
     
     parser = fr.getCSVParser();
     int numberEx = numberOfExportes(parser, "cocoa");
     System.out.println("The number of countries " +  numberEx);
     
     
     
    }
}
