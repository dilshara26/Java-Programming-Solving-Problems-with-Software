/**
 * Print out total number of babies born, as well as for each gender, in a given CSV file of baby name data.
 * 
 * @author Duke Software Team 
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.io.File;

public class BabyBirths {
    public void printNames () {
        FileResource fr = new FileResource();
        for (CSVRecord rec : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            if (numBorn <= 100) {
                System.out.println("Name " + rec.get(0) +
                           " Gender " + rec.get(1) +
                           " Num Born " + rec.get(2));
            }
        }
    }

    public void totalBirths (FileResource fr) {
        int totalBirths = 0;
        int totalBoys = 0;
        int totalGirls = 0;
        int totalBoyNames = 0 ;
        int totalGirlNames = 0 ;
        int totalNames = 0 ;
        for (CSVRecord rec : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            totalBirths += numBorn;
            totalNames++;
            if (rec.get(1).equals("M")) {
                totalBoys += numBorn;
                totalBoyNames ++;
            }
            else {
                totalGirls += numBorn;
                totalGirlNames ++;
            }
        }
        System.out.println("total births = " + totalBirths);
        System.out.println("female girls = " + totalGirls);
        System.out.println("male boys = " + totalBoys);
        System.out.println("total names = " + totalNames);
        System.out.println("female girl names = " + totalGirlNames);
        System.out.println("male boy names = " + totalBoyNames);
    }
    public int getRank (int year, String name, String gender){
        FileResource fr = new FileResource("us_babynames_by_year\\yob" + Integer.toString(year) +".csv");
        int girlcount = 0;
        for (CSVRecord record : fr.getCSVParser(false)){
            if (record.get(1).equals("F")){
                girlcount++;
               }
           }
        int currCount = 0;
        for (CSVRecord record : fr.getCSVParser(false)){
            currCount ++;
            if (gender == "M" && record.get(0).equals(name) && record.get(1).equals("M")){
                return currCount - girlcount;
               }
            if (gender == "F" && record.get(0).equals(name) &&  record.get(1).equals("F")){
                return currCount;
               }
           }
           return -1;
       }
    public String getName ( int Year , int rank, String gender){
        FileResource fr = new FileResource("us_babynames_by_year\\yob" + Integer.toString(Year) +".csv");
        int girlcount = 0;
        int count = 0;
        for (CSVRecord record : fr.getCSVParser(false)){
            if (record.get(1).equals("F")){
                girlcount++;
               }
           }
        for (CSVRecord record : fr.getCSVParser(false)){
            count ++ ;
            if (gender == "M" && rank + girlcount == count && record.get(1).equals("M") ){
                return record.get(0);
            }
            else if (gender == "F" && rank == count && record.get(1).equals("F") ){
                return record.get(0);
            }
            
        }
        return "No name is found"; 
        }
    public String whatIsNameInYear(String name , int year, int newyear , String gender){
     int currRank = getRank( year, name, gender);
     String newName = "";
     if (currRank != -1){
         newName = getName ( newyear, currRank, gender);
        }
     System.out.println(name + " born in " + year + " would be " + newName + " if she was born in " + newyear);
     return newName ;
     
    }
    public int yearOfHighestRank (String name, String gender){
     DirectoryResource dr = new DirectoryResource();
     int yearOfHighestRank =-1 ;
     int lowrank = 0;
     for ( File f : dr.selectedFiles()){
         int currentYear = Integer.parseInt(f.getName().substring(3,7));
         int currentRank = getRank( currentYear , name , gender);
         if (currentRank != -1 && yearOfHighestRank == -1){
             yearOfHighestRank = currentYear;
             lowrank = currentRank;
            }
         else if (currentRank != -1 && currentRank < lowrank ){
             yearOfHighestRank = currentYear;
             lowrank = currentRank;
            }
         
        }
        return yearOfHighestRank;
    }
    public double  getaverageRank (String name, String gender){
     DirectoryResource dr = new DirectoryResource();
     double rankTot = 0.0;
     int count = 0;
     double avg = 0.0;
     for(File f : dr.selectedFiles()){
         int currentYear = Integer.parseInt(f.getName().substring(3,7));
         int currentRank = getRank( currentYear , name , gender);
         if (currentRank != -1 ){
             rankTot += currentRank;
             count ++;
            }
         if (count != 0)   
         avg = rankTot/ count;
        }
        return avg;
    }
    public int getTotalBirthsRankedHigher(int year, String name , String gender){
         int rank = getRank( year, name, gender);
         String fileName = "us_babynames_by_year\\yob"+ year + ".csv";
         FileResource fr = new FileResource(fileName);
         int total = 0;
         int count = 1;
        for (CSVRecord row : fr.getCSVParser(false)){
             if (rank == 1 ){
                 return 0;
                }
             else if (rank == -1) {
                 return 0;
                 
                }
             else if (row.get(1).equals(gender) && count != rank){
                 total += Integer.parseInt(row.get(2));
                 count ++;
                }
             
            }
     
        return total;
    }
    
    public void testgetRank(){
     int rank = getRank(1971, "Frank", "M");
     System.out.println("Rank: " + Integer.toString(rank));
     
    }
    public void testTotalBirths () {
        //FileResource fr = new FileResource();
        FileResource fr = new FileResource();
        totalBirths(fr);
    }
    public void testwhatIsNameInYear(){
         String name = whatIsNameInYear("Owen",1974,2014,"M");
         
    }
    public void testgetTotalBirthsRankedHigher(){
     int total  =  getTotalBirthsRankedHigher(1990,"Drew", "M");
     System.out.println("Total births before: " + Integer.toString(total));
    }
    public void testyearOfTheHighestRank(){
        int year = yearOfHighestRank("Mich", "M");
        System.out.println("Year of the highest rank " + Integer.toString( year));
    }
    public void testgetaverageRank(){
     double avg = getaverageRank("Robert", "M");
     System.out.println(" The average rank: " + Double.toString(avg));
    }
    public void testgetName(){
     String name = getName(1982, 450, "M");
     System.out.println("Name: " + name);
     
    }
    
    
    
    
}

