
/**
 * Write a description of part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
 
import edu.duke.*;
public class part1 {
    public int findStopCodon (String dna, Integer StartIndex, String StopCodon){
        int currIndex = dna.indexOf(StopCodon, StartIndex+3);
        
        while (currIndex != -1){
         if ((currIndex - StartIndex) % 3 == 0){
          String finalDNA = dna.substring(StartIndex,currIndex +3);
          
          return finalDNA.length();
          
        }
        else{
            currIndex = dna.indexOf(StopCodon, currIndex +1);
        }
         
        }
        return -1;
    }
    public String findGene(String dna, int Index)
    {
        int startIndex = dna.indexOf("ATG", Index);

        if(startIndex == -1)
        {
            return "";
        }
        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
        int minIndex = 0;

        if (taaIndex == -1 || (tgaIndex != -1 && tgaIndex < taaIndex))
        {
            minIndex = tgaIndex;
        }
        else {
            minIndex = taaIndex;
        }
        if (minIndex == -1 || (tagIndex != -1 && tagIndex < minIndex))
        {
            minIndex = tagIndex;
        }
        if (minIndex == -1){
            return "";
        }
        return dna.substring(startIndex, minIndex + 3);
    }
        public void printAllGenes(String dna)
    {
        int startIndex = 0;

        while ( true )
        {
            String currentGene = findGene(dna, startIndex);
            if (currentGene.isEmpty())
            {
                break;
            }
            System.out.println(currentGene);
            startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
        }
    }
      public StorageResource getAllGenes(String dna)
    {
        int startIndex = 0;
        StorageResource resource = new StorageResource();

        while ( true )
        {
            String currentGene = findGene(dna, startIndex);
            
            if (currentGene.isEmpty())
            {
                break;
            }
            resource.add(currentGene);
            startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
        }
        return resource;
    }
    public double cgRatio (String dna){
       double CGCount =  0.0;
     for ( int i = 0; i< dna.length(); i++){
         if (dna.charAt(i) == 'C' || dna.charAt(i) == 'G'){
             CGCount ++;
             
            }
         
         
        }
        double CGRatio = CGCount / dna.length();
        return CGRatio;
    }
    public int CTG (String dna){
        int pos = dna.indexOf("CTG");
        int count = 0 ;
        while (pos !=-1){
            
            count++;
            pos = dna.indexOf("CTG", pos+1);
        }
        System.out.println(count);
        return count;
        
    }
    public void processGenes (StorageResource sr){
        int count = 0;
        int CGCount = 0 ;
        int max = 0;
        String longest = "";
        
        for ( String s : sr.data()){
            if (s.length() > 9){
                System.out.println(s);
                count++;
            }
            double CGratio = cgRatio(s);
            if (CGratio > 0.35){
             System.out.println(s);  
             CGCount++;
            }
            if (s.length() > max ){
                longest = s;
            }
            
            
        }
        System.out.println(count);
        System.out.println(CGCount);
        System.out.println(longest);
    }
    public void testProcessGenes(String dna){
        CTG(dna);
        StorageResource genes = getAllGenes(dna);
        processGenes(genes);
        double CGRatio = cgRatio(dna);
        
        
        
    }
    public void testData (){
        FileResource fr = new FileResource("brca1line.fa");
        String dna = fr.asString().toUpperCase();
        testProcessGenes(dna);
        
    }
    
    
   
    
        
    
    


}
