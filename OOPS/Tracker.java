public class Tracker {
    // name of tracker
    private String name;
    // position of tracker in degrees
    private double latitude, longitude;
    // whether the tracker is lot or not
    private boolean lostMode;
 
 
    // Creates a new Tracker with the given name and initial location.
    // By default, a new Tracker's lost mode is disabled.
    public Tracker(String name, double initialLatitude, double initialLongitude) {
        this.name = name;
        this.latitude = initialLatitude;
        this.longitude = initialLongitude;
        this.lostMode = false;
    }
 
    // Is this tracker in lost mode?
    public boolean isInLostMode() {
        return lostMode;
    }
 
    // Enables lost mode on this tracker.
    public void enableLostMode() {
        lostMode = true;
    }
 
    // Disables lost mode on this tracker.
    public void disableLostMode() {
        lostMode = false;
    }
 
    // Moves this tracker to the new location.
    public void move(double newLatitude, double newLongitude) {
        this.latitude = newLatitude;
        this.longitude = newLongitude;
    }
 
    // Returns the great circle distance between the two trackers.
    public double distanceTo(Tracker other) {
        double radius = 6371.0;
        double sinX = Math.sin(Math.toRadians((other.latitude - latitude) / 2));
        double sinY = Math.sin(Math.toRadians((other.longitude - longitude) / 2));
        double cosX1 = Math.cos(Math.toRadians(latitude));
        double cosX2 = Math.cos(Math.toRadians(other.latitude));
        return 2 * radius * Math.asin(
                Math.sqrt(Math.pow(sinX, 2) + cosX1 * cosX2 * Math.pow(sinY, 2)));
    }
 
    // Returns a string representation of this tracker.
    public String toString() {
        return name + " (" + latitude + ", " + longitude + ")";
    }
 
    // Unit tests the Tracker data type.
    public static void main(String[] args) {
        Tracker t1 = new Tracker("backpack", 60.0, 15.0);
        Tracker t2 = new Tracker("ipad", 60.0, 105.0);
        System.out.println(t1.distanceTo(t2));
        t1.move(60.0, 150.0);
        t2.enableLostMode();
        System.out.println(t2.isInLostMode());
        t2.disableLostMode();
        System.out.println(t2.isInLostMode());
        System.out.println(t1);
 
    }
 
}
