public class GuitarHero {
    // Guitar Hero, using a collection of 37 guitar strings 
    // Simulates the 37 keys on a piano 
    public static void main(String[] args) {
        String keyboardString = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        // initialize new collection of strings
        GuitarString[] strings = new GuitarString[keyboardString.length()];
        // initialize all guitar strings
        for (int i = 0; i < strings.length; i++) {
            double freq = (440 * Math.pow(2, (i - 24) / 12.0));
            strings[i] = new GuitarString(freq);
        }
        // the main input loop
        Keyboard keyboard = new Keyboard();
        while (true) {
 
            // check if the user has played a key; if so, process it
            if (keyboard.hasNextKeyPlayed()) {
 
                // the key the user played
                char key = keyboard.nextKeyPlayed();
 
                // pluck the corresponding string
                int index = keyboardString.indexOf(key);
                if (index != -1) {
                    strings[index].pluck();
                }
 
            }
            // compute superposition and tic forward all strings
            double sample = 0;
            for (int i = 0; i < strings.length; i++) {
                sample += strings[i].sample();
                strings[i].tic();
            }
 
            // play the sample on standard audio
            StdAudio.play(sample);
 
        }
    }
}
