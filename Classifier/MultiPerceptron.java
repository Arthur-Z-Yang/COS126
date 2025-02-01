public class MultiPerceptron {
    // Creates a multi-perceptron object with m classes and n inputs.
    // It creates an array of m perceptrons, each with n inputs.
    // multiperc
    private Perceptron[] multiperc;

    // multiperc
    public MultiPerceptron(int m, int n) {
        multiperc = new Perceptron[m];
        for (int i = 0; i < m; i++) {
            multiperc[i] = new Perceptron(n);
        }

    }

    // Returns the number of classes m.
    public int numberOfClasses() {
        return multiperc.length;
    }

    // Returns the number of inputs n (length of the feature vector).
    public int numberOfInputs() {
        return multiperc[0].numberOfInputs();
    }

    // Returns the predicted class label (between 0 and m-1) for the given input.
    public int predictMulti(double[] x) {
        double max = multiperc[0].weightedSum(x);
        int label = 0;
        for (int i = 1; i < multiperc.length; i++) {
            if (multiperc[i].weightedSum(x) > max) {
                max = multiperc[i].weightedSum(x);
                label = i;
            }
        }
        return label;
    }

    // Trains this multi-perceptron on the labeled (between 0 and m-1) input.
    public void trainMulti(double[] x, int classLabel) {
        multiperc[classLabel].train(x, +1);
        for (int i = 0; i < multiperc.length; i++) {
            if (i != classLabel)
                multiperc[i].train(x, -1);
        }

    }


    // Returns a String representation of this MultiPerceptron, with
    // the string representations of the perceptrons separated by commas
    // and enclosed in parentheses.
    // Example with m = 2 and n = 3: ((2.0, 0.0, -2.0), (3.0, 4.0, 5.0))
    public String toString() {
        String content = "(";
        for (int j = 0; j < multiperc.length; j++) {
            content += multiperc[j].toString();
            if (j < multiperc.length - 1) content += ", ";
        }
        content = content + ")";
        return content;
    }


    // Tests this class by directly calling all instance methods.
    public static void main(String[] args) {
        MultiPerceptron mp = new MultiPerceptron(5, 4);
        double[] x = { 4.0, 6.0, 2.0, 6.0 };
        mp.trainMulti(x, 4);
        System.out.println(mp);
        System.out.println(mp.numberOfClasses());
        System.out.println(mp.numberOfInputs());
        System.out.println(mp.predictMulti(x));


    }
}
