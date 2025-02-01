public class Sierpinski {
 
    // Height of an equilateral triangle with the specified side length.
    public static double height(double length) {
        return length * (Math.sqrt(3.0) / 2);
    }
 
    // Draws a filled equilateral triangle with the specified side length
    // whose bottom vertex is (x, y).
    public static void filledTriangle(double x, double y, double length) {
        double h = height(length) + y;
        double x1 = x - length / 2;
        double x2 = x + length / 2;
        double[] xPos = { x1, x, x2 };
        double[] yPos = { h, y, h };
        StdDraw.filledPolygon(xPos, yPos);
    }
 
    // Draws a Sierpinski triangle of order n, such that the largest filled
    // triangle has the specified side length and bottom vertex (x, y).
    public static void sierpinski(int n, double x, double y, double length) {
        if (n == 0) return;
        filledTriangle(x, y, length);
        double newLength = length / 2;
        double newHeight = height(length);
        sierpinski(n - 1, x + newLength, y, newLength);
        sierpinski(n - 1, x - newLength, y, newLength);
        sierpinski(n - 1, x, newHeight + y, newLength);
    }
 
    // Takes an integer command-line argument n;
    // draws the outline of an upwards equilateral triangle of length 1
    // whose bottom-left vertex is (0, 0) and bottom-right vertex is (1, 0);
    // and draws a Sierpinski triangle of order n that fits inside the outline.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double[] x = { 0, 0.5, 1 };
        double[] y = { 0, height(1), 0 };
        StdDraw.enableDoubleBuffering();
        StdDraw.polygon(x, y);
        sierpinski(n, 0.5, 0, 0.5);
        StdDraw.show();
    }
}
