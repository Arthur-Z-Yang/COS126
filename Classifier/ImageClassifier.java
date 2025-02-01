import java.awt.Color;
 
public class ImageClassifier {
 
    // width of config file
    private final int width;
    // height of config file
    private final int height;
    // m = number of class names;
    private final int m;
    // label names
    private String[] labels;
    // creates object multi perceptron;
    private MultiPerceptron multi;
 
 
    // Uses the provided configuration file to create an
    // ImageClassifier object.
    public ImageClassifier(String configFile) {
        In sc = new In(configFile);
        width = sc.readInt();
        height = sc.readInt();
        m = sc.readInt();
        int n = width * height;
        multi = new MultiPerceptron(m, n);
        labels = new String[m];
        for (int i = 0; i < m; i++) {
            labels[i] = sc.readString();
        }
    }
 
    // Creates a feature vector (1D array) from the given picture.
    public double[] extractFeatures(Picture picture) {
        int picwidth = picture.width();
        int picheight = picture.height();
        if (picwidth != this.width || picheight != this.height) {
            throw new IllegalArgumentException("invalid dimensions");
        }
 
        double[] gray = new double[width * height];
 
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                Color color = picture.get(col, row);
                gray[row * width + col] = color.getRed();
            }
        }
        return gray;
 
    }
 
    // Trains the perceptron on the given training data file.
    public void trainClassifier(String trainFile) {
        In train = new In(trainFile);
        while (!train.isEmpty()) {
            Picture picture = new Picture(train.readString());
            double[] extracted = extractFeatures(picture);
            multi.trainMulti(extracted, train.readInt());
        }
    }
 
    // Returns the name of the class for the given class label.
    public String classNameOf(int classLabel) {
        if (classLabel < 0 || classLabel > m - 1) {
            throw new IllegalArgumentException("classLabel out of bounds");
        }
        return labels[classLabel];
 
    }
 
    // Returns the predicted class for the given picture.
    public int classifyImage(Picture picture) {
        double[] extracted = extractFeatures(picture);
        return multi.predictMulti(extracted);
    }
 
    // Returns the error rate on the given testing data file.
    // Also prints the misclassified examples - see specification.
    public double testClassifier(String testFile) {
        In test = new In(testFile);
        int count = 0;
        double total = 0.0;
        while (!test.isEmpty()) {
            String name = test.readString();
            total = total + 1.0;
            Picture picture = new Picture(name);
            int predicted = classifyImage(picture);
            int label = test.readInt();
            if (predicted != label) {
                System.out.print(name + ", ");
                String namelabel = this.classNameOf(label);
                String namepredicted = this.classNameOf(predicted);
                System.out.println("label = " + namelabel + ", predict = " +
                                           namepredicted);
                count++;
            }
 
        }
 
        double error = count / total;
        return error;
    }
 
    // Tests this class using a configuration file, training file and test file.
    // See below.
    public static void main(String[] args) {
        ImageClassifier classifier = new ImageClassifier(args[0]);
        classifier.trainClassifier(args[1]);
        double testErrorRate = classifier.testClassifier(args[2]);
        System.out.println("test error rate = " + testErrorRate);
    }
}
 
