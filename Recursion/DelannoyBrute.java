public class DelannoyBrute {
    // Returns the Delannoy number D(m, n).
    public static long count(int m, int n) {
        if (m == 0) return 1;
        if (n == 0) return 1;
        return count(m - 1, n) + count(m - 1, n - 1) + count(m, n - 1);
    }
 
    /*
    Takes two integers m and n
    computes corresponding delannoy number
    using only single step paths
     */
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        long totalCount = count(m, n);
        System.out.println(totalCount);
    }
}
