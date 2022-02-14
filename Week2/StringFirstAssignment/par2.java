
/**
 * Write a description of par2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class par2 {
        public String findSimpleGene(String dna, String startCodon , String endCodon){
        if (dna.indexOf("ATG") == -1){
            return "Gene String: ";
              
        }
        else if (dna.indexOf("TAA") == -1){
            return "Gene String: ";
        
        }
        else if ((dna.indexOf("TAA") - dna.indexOf("ATG")) % 3 != 0) {
            return "Gene String: ";
        }
        else {
            return "Gene String: " + dna.substring(dna.indexOf("ATG"), dna.indexOf("TAA")+3);
        }
    
    
    }
   
    public void testSimpleGene (){
     String startCodon = "ATG";
     String endCodon = "AAT";
     
     String dna = "ATACCCGAC";
     System.out.println("Dna is " + dna);
     String gene = findSimpleGene(dna,startCodon,endCodon);
     System.out.println(gene);
     
     dna ="ATATGAACGGTATG";
     System.out.println("Dna is " + dna);
     gene = findSimpleGene(dna,startCodon,endCodon);
     System.out.println(gene);
     
     dna = "ATATGAACGGTAATG";
     System.out.println("Dna is " + dna);
     gene = findSimpleGene(dna, startCodon,endCodon);
     System.out.println(gene);
     
     dna = "ATATGAACGGATAATG";
     System.out.println("Dna is " + dna);
     gene = findSimpleGene(dna, startCodon, endCodon);
     System.out.println(gene);
     
     
    }

}
