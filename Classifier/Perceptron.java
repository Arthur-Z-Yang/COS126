public class Perceptron {
    
    // weight collection
    private double[] weights;
    // n inputs
    private final int n;
 
    // Creates a perceptron with n inputs. It should create an array
    // of n weights and initialize them all to 0.
    public Perceptron(int n) {
        this.n = n;
        weights = new double[n];
    }
 
    // Returns the number of inputs n.
    public int numberOfInputs() {
        return n;
    }
 
    // Returns the weighted sum of the weight vector and x.
    public double weightedSum(double[] x) {
        double sum = 0.0;
        for (int i = 0; i < n; i++) {
            sum += x[i] * weights[i];
        }
        return sum;
    }
 
    // Predicts the binary label (+1 or -1) of input x. It returns +1
    // if the weighted sum is positive and -1 if it is negative (or zero).
    public int predict(double[] x) {
        if (weightedSum(x) > 0) return +1;
        else return -1;
    }
 
    // Trains this perceptron on the binary labeled (+1 or -1) input x.
    // The weights vector is updated accordingly.
    public void train(double[] x, int binaryLabel) {
        if (predict(x) < binaryLabel) {
            // false negative
            for (int i = 0; i < n; i++) {
                weights[i] = weights[i] + x[i];
            }
        }
        else if (predict(x) > binaryLabel) {
            // false positive
            for (int j = 0; j < n; j++) {
                weights[j] = weights[j] - x[j];
            }
        }
    }
 
    // Returns a String representation of the weight vector, with the
    // individual weights separated by commas and enclosed in parentheses.
    // Example: (2.0, 1.0, -1.0, 5.0, 3.0)
    public String toString() {
        String content = "(";
        for (int i = 0; i < n; i++) {
            content += weights[i];
            if (i < n - 1) content += ", ";
        }
        return content + ")";
    }
 
    // Tests this class by directly calling all instance methods.
    public static void main(String[] args) {
        Perceptron perceptron = new Perceptron(3);
        int number = perceptron.numberOfInputs();
        double[] a = new double[3];
        double sum = perceptron.weightedSum(a);
        System.out.print(sum);
        System.out.print(number);
        perceptron.train(a, 1);
        perceptron.predict(a);
    }
}
