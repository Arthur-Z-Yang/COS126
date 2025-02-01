public class RingBuffer {
    // array of data
    private double[] ringBuffer;
    // number of objects in array
    private int size;
    // oldest indexed value and newest indexed value
    private int first, last;
 
    // Creates an empty ring buffer with the specified capacity.
    public RingBuffer(int capacity) {
        ringBuffer = new double[capacity];
        size = 0;
        first = 0;
        last = 0;
    }
 
    // Returns the capacity of this ring buffer.
    public int capacity() {
        return ringBuffer.length;
    }
 
    // Returns the number of items currently in this ring buffer.
    public int size() {
        return size;
    }
 
    // Is this ring buffer empty (size equals zero)?
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
 
    }
 
    // Is this ring buffer full (size equals capacity)?
    public boolean isFull() {
        if (size == capacity()) {
            return true;
        }
        return false;
 
    }
 
    // Adds item x to the end of this ring buffer.
    public void enqueue(double x) {
        if (isFull()) {
            throw new IllegalStateException("Ring Buffer is full");
        }
        if (last == capacity() - 1) {
            ringBuffer[last] = x;
            last = 0;
        }
        else {
            ringBuffer[last] = x;
            last++;
        }
        size++;
    }
 
    // Deletes and returns the item at the front of this ring buffer.
    public double dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Ring Buffer is empty");
        }
        double old = ringBuffer[first];
        if (first == capacity() - 1) {
            ringBuffer[first] = 0;
            first = 0;
        }
        else {
            ringBuffer[first] = 0;
            first++;
        }
        size--;
        return old;
    }
 
    // Returns the item at the front of this ring buffer.
    public double peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Ring Buffer is empty");
        }
        return ringBuffer[first];
    }
 
    // Tests this class by directly calling all instance methods.
    public static void main(String[] args) {
        RingBuffer r1 = new RingBuffer(4);
        System.out.println(r1.capacity());
        System.out.println(r1.isEmpty());
        r1.enqueue(1.0);
        System.out.println(r1.isEmpty());
        System.out.println(r1.isFull());
        System.out.println(r1.peek());
        System.out.println(r1.size());
        r1.enqueue(0.5);
        System.out.println(r1.dequeue());
    }
}
 
