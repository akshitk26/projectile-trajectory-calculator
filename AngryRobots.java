//Angry Robots
//ITCS and Physics - Integrated Projectile Project

import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;
import javax.swing.JOptionPane;

public class AngryRobots {

   // global variables
   // These can be used in any method in this program without having to pass the variable as a parameter
   // Note that Ay and Ax are declared final, they cannot be changed   
   public static final double Ay = -9.8;
   public static final double Ax = 0;
   public static double v0 = 0; 
   public static double angleDegrees = 0;
   public static double y = 0.0;
   public static double x = 0.0;
   public static double v0x = 0.0;
   public static double v0y = 0.0;
   public static double t = 0.0;
   public static double dt = 0.05;
     
   public static void main(String[] args){
      // Open default map and set speed
      Display.setSize(100, 100);
      Display.setSpeed(8);
       
      // User input to define initial velocity and launch angle
      // the parseDouble method converts the string input to a double
      v0 = Double.parseDouble(JOptionPane.showInputDialog("Please enter an initial velocity in m/s"));
      angleDegrees = Double.parseDouble(JOptionPane.showInputDialog("Please enter an initial angle in degrees"));
   
      // TODO: Calculate x and y initial velocities
      // Print them to the console to verify
      
      v0x = v0 * Math.cos(Math.toRadians(angleDegrees));
      v0y = v0 * Math.sin(Math.toRadians(angleDegrees));
      
      System.out.println(v0x);
      System.out.println(v0y);
      
   
      // TODO: Calculate and plot x/y positions of the projectile as long as it remains above ground
      
      while(y >= 0)
      {
         x = (v0x * t);
         y = (v0y * t) + (0.5 * Ay * Math.pow(t, 2));
         
         int xPos = (int) Math.round(x);
         int yPos = (int) Math.round(y);
         
         Robot lineBot = new Robot(xPos, yPos, Display.NORTH, 0);
         t += dt;
         System.out.println("at t: " + t + ", x = " + x + ", y = " + y);
      }
      System.out.println("The range for " + angleDegrees + " degrees is " + x);
      
   }
}