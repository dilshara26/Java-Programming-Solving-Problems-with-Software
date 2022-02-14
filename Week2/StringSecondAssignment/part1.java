
/**
 * Write a description of part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
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
        return dna.length();
    }
    public String findGene (String dna){
        
        if (dna.indexOf("ATG") != -1){
            int ATG = dna.indexOf("ATG");
            
            int TAA = findStopCodon(dna, ATG, "TAA");
            int TAG = findStopCodon(dna,ATG ,"TAG");
            int TGA = findStopCodon(dna, ATG,"TGA");
            
            int firstMin = Math.min(TAA,TAG);
            int min = Math.min(firstMin, TGA);
            if (min != dna.length()){
                return dna.substring(ATG,min+2);
            
            }
            
        }
        return "";
        }
        
        
    
    public void testGenes (){
        String dna = "GCATGCAACGTAAGTAA";
        Integer startIndex = dna.indexOf("ATG");
        int output = findStopCodon(dna,startIndex,"TAA");
        System.out.println(output);
    
    }
    
    public void testFindGene (){
        String dna = "GCATGCAACGTAAGTAA";
        String output = findGene(dna);
        System.out.println(output);
        dna = "GCATGCAACGTAAGTAGCGTAA";
        output = findGene(dna);
        System.out.println(output);
        dna = "GCATGCATGACGTAAGTAGCGTAA";
        output = findGene(dna);
        System.out.println(output);
    }

}

