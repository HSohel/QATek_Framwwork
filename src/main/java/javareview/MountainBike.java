package javareview;

public class MountainBike extends BiCycle {
    int seatHeight;
    public MountainBike(int gear,int speed, int startHeight){
        super(gear,speed);
        seatHeight=startHeight;

    }

    public void PrintValue(){
        System.out.println("No of gear :"+gear+" Speed of bicycle :"+speed+" SeatHeight is :"+seatHeight);
    }


}
