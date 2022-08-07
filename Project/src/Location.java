public class Location {
    int x;
    int y;
    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public boolean equals(Location another){
        return another.x==x && another.y==y;
    }
    @Override
    public String toString() {
        return "Location{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
