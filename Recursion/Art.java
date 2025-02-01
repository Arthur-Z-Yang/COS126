public class Art { 
    // draws the length, and updates the array positions
    private static void drawLength(double step, double[] xyCoord, int[] degree) {
        double currX = xyCoord[0];
        double currY = xyCoord[1];
        // taking current position and updating using trigonometry
        xyCoord[0] += step * Math.cos(Math.toRadians(degree[0]));
        xyCoord[1] += step * Math.sin(Math.toRadians(degree[0]));
        // draw
        StdDraw.line(currX, currY, xyCoord[0], xyCoord[1]);
    }
 
    // draws a single side of a Koch triangle
    // general idea is to use the calculated step size, and draw out the lines
    // the formula was determined by drawing out a koch triangle of size 1
    // found here https://en.wikipedia.org/wiki/Koch_snowflake
    // taking one side and assuming it to be flat
    private static void koch(int n, double step, double[] xyCoord, int[] degree) {
        if (n == 0) {
            drawLength(step, xyCoord, degree);
            StdDraw.setPenColor(StdDraw.BLACK);
            return;
        }
        // if depth is 1 set color to aqua
        if (n == 1) {
            StdDraw.setPenColor(StdDraw.AQUA);
        }
        // when koch triangle is size 1, always start with a straight line
        koch(n - 1, step, xyCoord, degree);
        // then, it moves up 60 degrees
        degree[0] += 60;
        koch(n - 1, step, xyCoord, degree);
        // here, the angle needs to be 60 degrees below the horizontal
        // so we need to subtract the initial 60 and another 60 (120)
        degree[0] -= 120;
        koch(n - 1, step, xyCoord, degree);
        // we need to straighten out so add 60 degrees
        degree[0] += 60;
        koch(n - 1, step, xyCoord, degree);
 
    }
 
    // takes n depth and performs a koch snowflake
    // I used arrays here because non primitive types' data
    // can be used in functions and updated, compared to primitive types
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double step = 0.5 / Math.pow(3.0, n);
        double[] xyCoord = { 0.25, 0.75 };
        int[] degree = { 0 };
        koch(n, step, xyCoord, degree);
        degree[0] -= 120;
        koch(n, step, xyCoord, degree);
        degree[0] -= 120;
        koch(n, step, xyCoord, degree);
    }
}
