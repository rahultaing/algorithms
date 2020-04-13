// https://leetcode.com/problems/traffic-light-controlled-intersection/discuss/444382/5-lines-Java-Solution-beats-100-using-synchronized-keyword-(Runtime:-37-ms)/401846

public class TrafficLight {

    private volatile int green_road_id = 1;

    public TrafficLight() {
        
    }
    
    public void carArrived(
        int carId,           // ID of the car
        int roadId,          // ID of the road the car travels on. Can be 1 (road A) or 2 (road B)
        int direction,       // Direction of the car
        Runnable turnGreen,  // Use turnGreen.run() to turn light to green on current road
        Runnable crossCar    // Use crossCar.run() to make car cross the intersection 
    ) {
        
        if (green_road_id == roadId){
            crossCar.run();
        }
        else{

            synchronized(this){
                if (green_road_id!=roadId){
                    green_road_id = roadId;
                    turnGreen.run();
                }

                crossCar.run();
            }
        }
    }
}