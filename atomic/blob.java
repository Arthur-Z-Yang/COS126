public class Blob {
    // number of pixels in the blob
    private int size;
    // x and y coordinates of the cm
    private double cmX, cmY;
 
    //  creates an empty blob
    public Blob() {
        cmX = 0.0;
        cmY = 0.0;
        size = 0;
    }
 
    //  adds pixel (x, y) to this blob
    public void add(int x, int y) {
        size++;
        cmX = (cmX * (size - 1) + x) / size;
        cmY = (cmY * (size - 1) + y) / size;
    }
 
    //  number of pixels added to this blob
    public int mass() {
        return size;
    }
 
    //  Euclidean distance between the center of masses of the two blobs
    public double distanceTo(Blob that) {
        return Math.sqrt(Math.pow(this.cmX - that.cmX, 2)
                                 + Math.pow(this.cmY - that.cmY, 2));
    }
 
    //  string representation of this blob (see below)
    public String toString() {
        String cmXFormatted = String.format("%.4f", cmX);
        String cmYFormatted = String.format("%.4f", cmY);
        return size + " (" + cmXFormatted + ", " + cmYFormatted + ")";
    }
 
    //  tests this class by directly calling all instance methods
    public static void main(String[] args) {
        Blob b1 = new Blob();
        b1.add(1, 2);
        b1.add(2, 2);
        Blob b2 = new Blob();
        b2.add(2, 2);
        System.out.println("distance btwn b1 and b2:" + b1.distanceTo(b2));
        System.out.println("b1:" + b1);
        System.out.println("blob 1's mass:" + b1.mass());
    }
}
