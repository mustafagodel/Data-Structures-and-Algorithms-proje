import java.util.ArrayList;
import java.util.Random;

public class Beetle {
    private Location location;
    ArrayList<Location> lookedLocations;
    int N;
    private int movementAmount;
    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location) {
        this.location = location;
    }
    public Beetle(FourWayLinkedList f) {
        Random random=new Random();
        int N=(int)Math.sqrt(f.size);
        location=new Location(random.nextInt(N),random.nextInt(N));
        lookedLocations=new ArrayList<>();
        lookedLocations.add(new Location(location.x, location.y));
        this.N=N;
    }


    public int getMovementAmount() {
        return movementAmount;
    }

    public void setMovementAmount(int movementAmount) {
        this.movementAmount = movementAmount;
    }

    public void move(){
        Random random=new Random();
        while (true){
            boolean isValid=false;
            if (random.nextBoolean()){
                if (random.nextBoolean() && location.x+1<N){
                    location.x+=1;
                    isValid=true;
                }
                else if (location.x-1>=0){
                    location.x-=1;
                    isValid=true;
                }
            }
            else{
                if (random.nextBoolean() && location.y+1<N){
                    location.y+=1;
                    isValid=true;
                }
                else if (location.y-1>=0){
                    location.y-=1;
                    isValid=true;
                }
            }
            if (isValid){
               break;
            }
        }
        movementAmount++;
        for (Location locations:lookedLocations) {
            if (locations.equals(new Location(location.x, location.y))){
               return;
            }
        }
        lookedLocations.add(new Location(location.x, location.y));
    }
}
