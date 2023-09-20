package somePractics;

import java.lang.*;
public class Ball {
   private String color;
   private int radius;

   public Ball(String color, int radius){
       this.color = color;
       this.radius = radius;
   }

   public Ball(String color){
       this.color = color;
       this.radius = 0;
   }

   public Ball(){
       this.color = "";
       this.radius = 0;
   }

   public void setColor(String color){
       this.color = color;
   }

   public void setRadius(int radius){
       this.radius = radius;
   }

   public String getColor(){
       return color;
   }

   public int getRadius(){
       return radius;
   }

   public String toString(){
       return "color "+this.color+", radius = "+this.radius;
   }

   public void getVolume(){
       System.out.println("The ball with color "+this.color+" and radius "+radius+" has volume "+(4*Math.pow(radius, 3)*Math.PI)/3);
   }
}