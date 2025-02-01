public class DelannoyMemo {
    // create a global private array for storing values
    private static long[][] memo;
 
    // Returns the Delannoy number D(m, n).
    public static long count(int m, int n) {
        memo = new long[m + 1][n + 1];
        return countR(m, n);
    }
 
    // performs the Delannoy method, calling the array to save time
    private static long countR(int m, int n) {
        if (memo[m][n] != 0) return memo[m][n];
        if (m == 0) memo[m][n] = 1;
        else if (n == 0) memo[m][n] = 1;
        else memo[m][n] = countR(m - 1, n) + countR(m - 1, n - 1) + countR(m, n - 1);
 
        return memo[m][n];
    }
 
    // Takes two integer command-line arguments m and n and prints D(m, n).
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        System.out.println(count(m, n));
 
 
    }
}
