
/**
 * Write a description of part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class part3 {
    
    public Boolean twoStringOccurences(String stringa, String stringb){
        Boolean answer;
        if (stringb.indexOf(stringa) != -1){
            int pos = stringb.indexOf(stringa);
            if (stringb.indexOf(stringa,pos+1) != -1){
                answer = true;
                
            }
            else{
                answer = false;
            }
        }
        else{
             answer = false;
        }
        return answer;
    }
    public String lastPart(String stringa , String stringb){
        String output ;
       if (stringb.indexOf(stringa) != -1) {
           output = stringb.substring(stringb.indexOf(stringa)+stringa.length());
           
       }
       else{
         output = stringb; 
        }
        return output;
    }
    public void testing(){
        String a = "H";
        String b = "Hello World";
        Boolean present = twoStringOccurences(a,b);
        String followString = lastPart(a,b);
        System.out.println(present);
        System.out.println(followString);
        
        a = "ba";
        b = "banaba";
        present = twoStringOccurences(a,b);
        followString = lastPart(a,b);
        System.out.println(present);
        System.out.println(followString);
        
        
        
    }
   
    

}
