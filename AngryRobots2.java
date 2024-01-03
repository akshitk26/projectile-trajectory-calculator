//Angry Robots
//ITCS and Physics - Integrated Projectile Project

import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;
import javax.swing.JOptionPane;

public class AngryRobots2 {

   // global variables
   // These can be used in any method in this program without having to pass the variable as a parameter
   // Note that Ay and Ax are declared final, they cannot be changed   
   public static double Ay = -9.8;
   public static final double Ax = 0;
   public static double v0 = 0; 
   public static double angleDegrees = 0;
   public static double y = 0.0;
   public static double x = 0.0;
   public static double v0x = 0.0;
   public static double v0y = 0.0;
   public static double t = 0.0;
   public static double dt = 0.1;
   public static double maxAngle = 0.0;
   public static double maxRange = 0.0;
   
   public static double calcMaxRange(double v0)
   {
      for(int angleDegrees = 0; angleDegrees <=90; angleDegrees++)
      {
         x = 0.0;
         y = 0.0;
         t = 0.0;
         
         v0x = v0 * Math.cos(angleDegrees * (Math.PI/180));
         v0y = v0 * Math.sin(angleDegrees * (Math.PI/180));
            
         while(y >= 0.0)
         {   
            t += dt;
            x = (v0x * t);
            y = (v0y * t) + ( 0.5 * Ay * Math.pow(t, 2));         
         }
         
         System.out.println("for angle " + angleDegrees + " degrees, range is " + x + "m");
         
         if(x > maxRange)
         {
            maxRange = x;
            maxAngle = angleDegrees;
         }
      }
      
      return maxAngle;
   }
   
   public static void plotLines(double optimalAngle, double v0)
   {
      double angle = optimalAngle - 30;
      double range = 0.0;
      
      for(angle = optimalAngle - 30; angle <= optimalAngle + 30; angle += 15)
      {
         x = 0.0;
         y = 0.0;
         t = 0.0;
         maxAngle = 0.0;
      
         v0x = v0 * Math.cos(angle * (Math.PI/180));
         v0y = v0 * Math.sin(angle * (Math.PI/180));
         
         while(y >= 0)
         {
            x = (v0x * t);
            y = (v0y * t) + (0.5 * Ay * Math.pow(t, 2));
            int xPos = (int) Math.round(x);
            int yPos = (int) Math.round(y);
            
            Robot botter = new Robot(xPos, yPos, Display.NORTH, 0);
            t += dt;  
         }
         
         System.out.println("The range for " + angle + " degrees is " + x); 
      }
   }
     
   public static void main(String[] args){ //------------------------main-----------------------------------------------------------
      // Open default map and set speed
      Display.setSize(50, 50);
      Display.setSpeed(10);
       
      v0 = Double.parseDouble(JOptionPane.showInputDialog("Please enter an initial velocity"));

      System.out.println("Optimal angle for maximum range is: " + calcMaxRange(v0));
      System.out.println("For an initial velocity of: " + v0 + " max range was " + maxRange);
      
      plotLines(maxAngle, v0);
   }
}