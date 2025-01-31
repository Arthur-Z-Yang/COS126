public class MarkovLM {
    private static final int ASCII = 128;
    // order of markov
    private int k;
    // frequency of phrases
    private ST<String, Integer> freqCur;
    // frequency of the next character given a phrase
    private ST<String, int[]> freqNext;

    // creates a Markov model of order k based on the specified text
    public MarkovLM(String text, int k) {
        this.k = k;
        freqCur = new ST<String, Integer>();
        freqNext = new ST<String, int[]>();
        StringBuilder sb = new StringBuilder();
        sb.append(text + text.substring(0, k));
        for (int i = 0; i < text.length(); i++) {
            if (freqCur.contains(sb.substring(i, k + i))) {
                int count = freqCur.get(sb.substring(i, k + i));
                freqCur.put(sb.substring(i, k + i), count + 1);
                freqNext.get(sb.substring(i, k + i))[sb.charAt(k + i)]++;
            }
            else {
                freqCur.put(sb.substring(i, k + i), 1);
                int[] vals = new int[ASCII];
                vals[sb.charAt(k + i)]++;
                freqNext.put(sb.substring(i, k + i), vals);
            }
        }

    }

    // returns the order of the model (also known as k)
    public int order() {
        return k;
    }

    // returns a String representation of the model (more info below)
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : freqNext.keys()) {
            // print out the word and its frequency, separated by a space
            sb.append(word + ": ");
            int[] vals = freqNext.get(word);
            for (int i = 0; i < vals.length; i++) {
                if (vals[i] > 0) {
                    sb.append((char) i + " " + vals[i] + " ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }


    // returns the # of times 'kgram' appeared in the input text
    public int freq(String kgram) {
        if (kgram.length() != k)
            throw new IllegalArgumentException("kgram out of bounds");
        if (!freqCur.contains(kgram))
            return 0;
        return freqCur.get(kgram);
    }

    // returns the # of times 'c' followed 'kgram' in the input text
    public int freq(String kgram, char c) {
        if (kgram.length() != k)
            throw new IllegalArgumentException("kgram out of bounds");
        if (!freqNext.contains(kgram))
            return 0;
        int[] vals = freqNext.get(kgram);
        return vals[c];
    }

    // returns a character, chosen with weight proportional to the
    // number of times each character followed 'kgram' in the input text
    public char predictNext(String kgram) {
        if (kgram.length() != k)
            throw new IllegalArgumentException("kgram out of bounds");
        if (!freqNext.contains(kgram))
            throw new IllegalArgumentException("kgram does not appear");
        int[] vals = freqNext.get(kgram);
        int result = StdRandom.discrete(vals);
        return (char) result;
    }

    // tests all instance methods to make sure they're working as expected
    public static void main(String[] args) {
        String text1 = "gagggagaggcgagaaa";
        MarkovLM model1 = new MarkovLM(text1, 17);
        System.out.println(model1);
        System.out.println(model1.predictNext("gagggagaggcgagaaa"));
        System.out.println(model1.freq("gagggagaggcgagaaa", 'a'));
        System.out.println(model1.freq("gagggagaggcgagaaa"));
        System.out.println(model1.order());
    }

}
