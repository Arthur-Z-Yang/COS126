public class GuitarString {
    // capacity of ring buffer
    private int n;
    // ring buffer object
    private RingBuffer guitar;
 
    // Creates a guitar string of the specified frequency,
    // using a sampling rate of 44,100.
    public GuitarString(double frequency) {
        n = (int) Math.ceil(44100 / frequency);
        guitar = new RingBuffer(n);
        for (int i = 0; i < n; i++) {
            guitar.enqueue(0.0);
        }
    }
 
    // Creates a guitar string whose length and initial values
    // are given by the specified array.
    public GuitarString(double[] init) {
        n = init.length;
        guitar = new RingBuffer(n);
        for (int i = 0; i < n; i++) {
            guitar.enqueue(init[i]);
        }
    }
 
    // Returns the number of samples in the ring buffer.
    public int length() {
        return guitar.size();
    }
 
    // Returns the current sample.
    public double sample() {
        return guitar.peek();
    }
 
    // Plucks this guitar string by replacing the ring buffer with white noise.
    public void pluck() {
        for (int i = 0; i < length(); i++) {
            double audio = StdRandom.uniformDouble(-0.5, 0.5);
            guitar.dequeue();
            guitar.enqueue(audio);
        }
    }
 
    // Advances the Karplus-Strong simulation one time step.
    public void tic() {
        double result = 0.5 * 0.996 * (guitar.dequeue() + sample());
        guitar.enqueue(result);
    }
 
    // Tests this class by directly calling both constructors
    // and all instance methods.
    public static void main(String[] args) {
        GuitarString g1 = new GuitarString(1000);
        double[] inits = { 0.1, 0.2, 0.4, 0.5 };
        GuitarString g2 = new GuitarString(inits);
        System.out.println(g1.sample());
        System.out.println(g2.sample());
        System.out.println(g2.length());
        g1.pluck();
        g2.tic();
        System.out.println(g2.sample());
        System.out.println(g1.sample());
    }
}
