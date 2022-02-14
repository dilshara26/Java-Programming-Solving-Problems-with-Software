
/**
 * Write a description of perimeter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.File;
public class perimeter {
    public double calPerimeter(Shape s){
        //create the perimeter vairable 
        double peri = 0.0;
        
        // use the option of getting the last point
        Point prev = s.getLastPoint();
        
        // create the loop
        for (Point currPt : s.getPoints()){
            // current distance would be compared to the previos distance
            Double currDist = currPt.distance(prev);
            // add to the perimeter
            peri = peri + currDist;
            // assign current point to the prev
            prev =  currPt;
        }
        // return perimeter
        return peri;
       
        
        

    }
    public int getNumPoints(Shape s){
        int counter = 0;
        for (Point current : s.getPoints()){
            counter = counter + 1;
            
        }
        return counter;
      
    }
    public double getAverage (Shape s){
        
        double avg = calPerimeter(s) / getNumPoints(s);
        return avg;
        
        
    }
     public double getLargestSide(Shape s){
        
        double largeSide = 0.0;
        Point prev = s.getLastPoint();
        for (Point points : s.getPoints()){
            double length = (prev.distance(points));
            if (length > largeSide){
                largeSide = length;
            
            }
        prev = points;
    }
    return largeSide;
    }
    public int largestX (Shape s){
        
        int lx = 0;
        for (Point curr : s.getPoints()){
            if (lx < curr.getX()){
                lx = curr.getX();
            }
            
        }
        
        return lx;
    }
    public double HighestPerimeter(){
        double maxPerimeter = 0.0;
        DirectoryResource dr = new DirectoryResource();
        
        for (File f : dr.selectedFiles()){ 
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
         
          if (calPerimeter(s) > maxPerimeter ){
              
              maxPerimeter = calPerimeter(s);
            
            }
            
        }
        return maxPerimeter ;
    }
    public void getFileWithLargestPerimeter (){
        File temp = null;
        double maxperi = 0.0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            if (calPerimeter(s) > maxperi){
                maxperi = calPerimeter(s);
                temp = f;
                
                
            }
            
            
        }
        System.out.println("Largest Perimeter File " + temp.getName());
    }
    public void testPerimeter(){
        FileResource f = new FileResource();
        Shape s = new Shape(f);
        double length = calPerimeter(s);
        int points = getNumPoints(s);
        double average = getAverage(s);
        int largeX = largestX(s);
        double largestSide = getLargestSide(s);
        ;
        System.out.println("perimeter " + length + " Points "+ points + " average" + average );
        System.out.println("largest X " + largeX + " Largest side " + largestSide);
     
        
      
    }
    public void largestPerimetercall(){
        double largestPer = HighestPerimeter();
        System.out.println("largestPerimeter " + largestPer);
    }
       
    public static void main(String[] args){
        perimeter pr = new perimeter();
        pr.testPerimeter();
        pr.getFileWithLargestPerimeter();
        
    }
}


