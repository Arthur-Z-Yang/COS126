public class BeadTracker {
    // tracking beads
    public static void main(String[] args) {
        int min = Integer.parseInt(args[0]);
        double tau = Double.parseDouble(args[1]);
        double delta = Double.parseDouble(args[2]);
        for (int i = 3; i < args.length - 1; i++) {
            // at time t
            String filename1 = args[i];
            Picture pic1 = new Picture(filename1);
            BeadFinder find1 = new BeadFinder(pic1, tau);
 
            // at time t+dt
            String filename2 = args[i + 1];
            Picture pic2 = new Picture(filename2);
            BeadFinder find2 = new BeadFinder(pic2, tau);
 
            Blob[] blobs1 = find1.getBeads(min); // blobs in time t
            Blob[] blobs2 = find2.getBeads(min); // blobs in time t+1
 
            double mindistance = delta;
            double temp;
            boolean isChanged = false;
            for (int j = 0; j < blobs2.length; j++) {
                for (int k = 0; k < blobs1.length; k++) {
                    temp = blobs2[j].distanceTo(blobs1[k]);
                    if (temp <= mindistance) {
                        mindistance = temp;
                        isChanged = true;
                    }
                }
                if (mindistance <= delta && isChanged) {
                    String mindistanceformatted =
                            String.format("%.4f", mindistance);
                    System.out.println(mindistanceformatted);
                    mindistance = delta;
                    isChanged = false;
                }
            }
 
        }
    }
}
