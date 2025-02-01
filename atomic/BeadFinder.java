import java.awt.Color;
import java.util.ArrayList;
 
public class BeadFinder {
    // is blob?
    private boolean[][] isblob;
    // is marked as a blob?
    private boolean[][] ismarkedasblob;
    // array list of blobs above min value
    private ArrayList<Blob> blobs;
 
    //  finds all blobs in the specified picture using luminance threshold tau
    public BeadFinder(Picture picture, double tau) {
        int width = picture.width();
        int height = picture.height();
        isblob = new boolean[width][height];
        ismarkedasblob = new boolean[width][height];
        blobs = new ArrayList<Blob>();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color color = picture.get(x, y);
                double luminance = Luminance.intensity(color);
 
                if (luminance >= tau) {
                    isblob[x][y] = true;
                }
                else {
                    isblob[x][y] = false;
                }
            }
        }
 
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (isblob[x][y] && !ismarkedasblob[x][y]) {
                    Blob temps = new Blob();
                    dfs(temps, x, y);
                    blobs.add(temps);
                }
            }
        }
    }
 
    // helper method
    private void dfs(Blob temps, int i, int j) {
        // base cases
        // out of bounds
        if (i < 0 || i >= isblob.length) return;
        if (j < 0 || j >= isblob[0].length) return;
 
        // already marked
        if (ismarkedasblob[i][j]) return;
 
        // not blob
        if (!isblob[i][j]) return;
 
        ismarkedasblob[i][j] = true;
        temps.add(i, j);
 
 
        // recurse
        dfs(temps, i + 1, j);   // down
        dfs(temps, i, j + 1);   // right
        dfs(temps, i, j - 1);   // left
        dfs(temps, i - 1, j);   // up
    }
 
 
    //  returns all beads (blobs with >= min pixels)
    public Blob[] getBeads(int min) {
        ArrayList<Blob> modify = new ArrayList<Blob>();
        for (int k = 0; k < blobs.size(); k++) {
            modify.add(blobs.get(k));
        }
        int i = 0;
        while (i < modify.size()) {
            if (modify.get(i).mass() >= min) {
                i++;
            }
            else {
                modify.remove(i);
            }
        }
        Blob[] beads = new Blob[modify.size()];
        for (int k = 0; k < modify.size(); k++) {
            beads[k] = modify.get(k);
        }
        return beads;
    }
 
    //  test client, as described below
    public static void main(String[] args) {
        int min = Integer.parseInt(args[0]);
        double tau = Double.parseDouble(args[1]);
        String filename = args[2];
        Picture picture = new Picture(filename);
        BeadFinder finder = new BeadFinder(picture, tau);
        Blob[] foundblobs = finder.getBeads(min);
        for (int i = 0; i < foundblobs.length; i++) {
            System.out.println(foundblobs[i]);
        }
    }
 
 
}
