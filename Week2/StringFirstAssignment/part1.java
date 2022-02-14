
/**
 * Write a description of part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class part1 {
    
    public String findSimpleGene(String gene){
        if (gene.indexOf("ATG") == -1){
            return "Gene String: ";
              
        }
        else if (gene.indexOf("TAA") == -1){
            return "Gene String: ";
        
        }
        else if ((gene.indexOf("TAA") - gene.indexOf("ATG")) % 3 != 0) {
            return "Gene String: ";
        }
        else {
            return "Gene String: " + gene.substring(gene.indexOf("ATG"), gene.indexOf("TAA")+3);
        }
    
    
    }
   
    public void testSimpleGene (){
     String gene = "ATACCCGAC";
     System.out.println("Dna is " + gene);
     String dna = findSimpleGene(gene);
     System.out.println(dna);
     
     gene = "ATATGAACGGTATG";
     System.out.println("Dna is " + gene);
     dna = findSimpleGene(gene);
     System.out.println(dna);
     
     gene = "ATATGAACGGTAATG";
     System.out.println("Dna is " + gene);
     dna = findSimpleGene(gene);
     System.out.println(dna);
     
     gene = "ATATGAACGGATAATG";
     System.out.println("Dna is " + gene);
     dna = findSimpleGene(gene);
     System.out.println(dna);
     
     
    }
    
     

}
