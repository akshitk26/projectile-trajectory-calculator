//Angry Robots
//ITCS and Physics - Integrated Projectile Project

import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;
import javax.swing.JOptionPane;

public class AngryRobotsTester {

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
        
   public static void main(String[] args){ //------------------------main-----------------------------------------------------------
      // Open default map and set speed
      Display.setSize(50, 50);
      Display.setSpeed(10);
       
      v0 = Double.parseDouble(JOptionPane.showInputDialog("Please enter an initial velocity"));
      double h = Double.parseDouble(JOptionPane.showInputDialog("How high should the projectile start:"));
      
      for(int angleDegrees = 0; angleDegrees <=90; angleDegrees++)
      {
         x = 0.0;
         y = h;
         t = 0.0;
         
         v0x = v0 * Math.cos(angleDegrees * (Math.PI/180));
         v0y = v0 * Math.sin(angleDegrees * (Math.PI/180));
            
         while(y >= 0.0)
         {   
            t += dt;
            x = (v0x * t);
            y = h + (v0y * t) + ( 0.5 * Ay * Math.pow(t, 2));         
         }
         
         System.out.println("for angle " + angleDegrees + " degrees, range is " + x + "m");
         
         if(x > maxRange)
         {
            maxRange = x;
            maxAngle = angleDegrees;
         }
      }
      
      System.out.println("[height started: " + h + "] Optimal angle for maximum range is: " + maxAngle);
      System.out.println("[height started: " + h + "] For an initial velocity of: " + v0 + " max range was " + maxRange);
      
      //other planet --------------------------------------------------------------------------------------------------------------
      
      v0 = Double.parseDouble(JOptionPane.showInputDialog("[on saturn] Please enter an initial velocity"));
      angleDegrees = Double.parseDouble(JOptionPane.showInputDialog("[on saturn] Please enter an angle in degrees"));
      
      Ay = -10.44;
      
      x = 0.0;
      y = 0.0;
      t = 0.0;
     
      v0x = v0 * Math.cos(angleDegrees * (Math.PI/180));
      v0y = v0 * Math.sin(angleDegrees * (Math.PI/180));
         
      while(y >= 0)
      {
         x = (v0x * t);
         y = (v0y * t) + (0.5 * Ay * Math.pow(t, 2));
         int xPos = (int) Math.round(x);
         int yPos = (int) Math.round(y);
            
         Robot spacebot = new Robot(xPos, yPos, Display.NORTH, 0);
         t += dt;  
      }
      System.out.println("[on saturn - 1st graph] trajectory of projectile with " + v0 + " initial velocity at " + angleDegrees + " degrees:");
      System.out.println("range on saturn: " + x);
      
      Ay = -9.8;
      
      x = 0.0;
      y = 0.0;
      t = 0.0;
     
      v0x = v0 * Math.cos(angleDegrees * (Math.PI/180));
      v0y = v0 * Math.sin(angleDegrees * (Math.PI/180));
         
      while(y >= 0)
      {
         x = (v0x * t);
         y = (v0y * t) + (0.5 * Ay * Math.pow(t, 2));
         int xPos = (int) Math.round(x);
         int yPos = (int) Math.round(y);
            
         Robot spacebot = new Robot(xPos, yPos, Display.NORTH, 0);
         t += dt;  
      }
      System.out.println("[on earth - 2nd graph] trajectory of projectile with " + v0 + " initial velocity at " + angleDegrees + " degrees:");
      System.out.println("range on earth: " + x);
      
   }
}