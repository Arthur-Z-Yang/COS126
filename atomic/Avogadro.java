public class Avogadro {
    // finding avogadro's number
    public static void main(String[] args) {
        int count = 0;
        double sum = 0;
        // loop through and calculate the sums of the distances
        while (!StdIn.isEmpty()) {
            count++;
            sum += Math.pow((StdIn.readDouble()) * 0.175E-6, 2);
        }
        // calculate gaussian distribution using the formula
        double gaussDist = sum / (count * 2);
        double t = 297;
        double n = 9.135E-4;
        double p = 0.5E-6;
        // calculate the boltzmann constant
        double k = (gaussDist * 6 * Math.PI * n * p) / (t);
        double r = 8.31446;
        // calculate avogadro's number
        double nA = r / k;
        // print
        String boltzman = String.format("%.4e", k);
        String avogadro = String.format("%.4e", nA);
        System.out.println("Boltzmann = " + boltzman);
        System.out.println("Avogadro = " + avogadro);
    }
}
