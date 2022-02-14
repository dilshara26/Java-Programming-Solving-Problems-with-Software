
/**
 * Write a description of part4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;

public class part4 {
    public void urlCheck(String s){
        URLResource UR = new URLResource(s);
        for (String lines : UR.words()){
            if (lines.toLowerCase().contains("youtube")){
             
                String links = lines.substring(lines.indexOf("\"")+1, lines.lastIndexOf("\""));
                
                System.out.println(links);
            }
            
        }
        
    }
    public void testUrl(){
     urlCheck("https://www.dukelearntoprogram.com//course2/data/manylinks.html")   ;
    }

}
