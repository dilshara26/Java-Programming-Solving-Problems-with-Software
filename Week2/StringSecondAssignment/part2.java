
/**
 * Write a description of part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class part2 {
    
    public int howMany (String stringa, String stringb ){
        int counter = 0;
        int currentIndex = stringb.indexOf(stringa);
        while (currentIndex != -1){
             counter = counter + 1;
             currentIndex = stringb.indexOf(stringa,currentIndex + stringa.length());
                
                
          }
          return counter;
        }
    public void testHowMany(){
        int output = howMany("AA", "ATAAAA");
        System.out.println(output);
    
    }
    
    }
    



