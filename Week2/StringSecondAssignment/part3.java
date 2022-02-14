
/**
 * Write a description of part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class part3 {
     public int findStopCodon (String dna, Integer StartIndex, String StopCodon){
        int currIndex = dna.indexOf(StopCodon, StartIndex+3);
        
        while (currIndex != -1){
         if ((currIndex - StartIndex) % 3 == 0){
          return currIndex ;
          
          
          
        }
        else{
            currIndex = dna.indexOf(StopCodon, currIndex +1);
        }
         
        }
        return -1;
    }
    public String findGene (String dna, int start){
        int ATG = dna.indexOf("ATG", start);
        int minIndex;
        if (dna.indexOf("ATG") != -1){
            
            
            int TAA = findStopCodon(dna, ATG, "TAA");
            int TAG = findStopCodon(dna,ATG ,"TAG");
            int TGA = findStopCodon(dna, ATG,"TGA");
            
            
        if (TAA == -1 || (TGA!= -1 && TGA < TAA))
        {
            minIndex = TGA;
        }
        else {
            minIndex = TAA;
        }
        if (minIndex == -1 || (TAG!= -1 && TAG < minIndex))
        {
            minIndex = TAG;
        }
        if (minIndex == -1){
            return "";
        }
        return dna.substring(ATG, minIndex + 3);
            
        }
        return "";
        }
    public int countGenes(String dna){
        int pos ;
        int counter = 0;
        int currentPosition = 0;
        while (true){
            String CurrGene = findGene(dna,currentPosition);
            
            if (CurrGene.isEmpty()){ 
                break;
            }
            pos = CurrGene.length();
            currentPosition = dna.indexOf("ATG", currentPosition)+pos;
            counter = counter + 1;
           
            
            
        }
        return counter;
    }
    public void testNumberOfGenes (){
        String dna = "ATGTAAGATGCCCTAGT";
        int output = countGenes(dna);
        System.out.println(output);
    }

}
