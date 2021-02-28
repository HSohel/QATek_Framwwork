package javareview;

public class BiCycle {

    int gear;
    int speed;

    public BiCycle(int gear, int speed){
        this.gear=gear;
        this.speed=speed;
    }

    public void applyBreak(int decrement){
        speed-=decrement;
        System.out.println("Speed is "+speed+" after applying break");
    }

   public void speedUp(int increment){
        speed+=increment;
       System.out.println("Speed is "+speed+" after speeding up");
   }

   public void PrintValue(){
       System.out.println("No of gear :"+gear+" Speed of bicycle :"+speed);
   }


}
