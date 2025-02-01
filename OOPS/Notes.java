public class Note {
 
    private static final int NOTES_IN_AN_OCTAVE = 12;
 
    // get the midiNumber
    private final int midiNumber;
    // get the instrument name
    private final String name;
    // constant notes in an octave
 
 
    // Creates a new Note corresponding to the MIDI number and instrument.
    public Note(int midiNumber, String instrumentName) {
        this.midiNumber = midiNumber;
        this.name = instrumentName;
    }
 
    // Returns the MIDI number.
    public int midi() {
        return midiNumber;
    }
 
    // Returns the frequency of this note.
    public double frequency() {
        return 440 * Math.pow(2, ((double) midiNumber - 69) / NOTES_IN_AN_OCTAVE);
    }
 
    // Plays this note to standard audio using an associated WAV file.
    public void play() {
        StdAudio.play(name + "/" + name + midiNumber + ".wav");
    }
 
 
    // Returns the name of this note (such as C or A#).
    public String name() {
 
 
        // defines the number of notes in an octave
 
 
        if (midiNumber % NOTES_IN_AN_OCTAVE == 0) { 
            return "C"; 
        } 
        else if (midiNumber % NOTES_IN_AN_OCTAVE == 1) { 
            return "C#"; 
        } 
        else if (midiNumber % NOTES_IN_AN_OCTAVE == 2) { 
            return "D"; 
        } 
        else if (midiNumber % NOTES_IN_AN_OCTAVE == 3) { 
            return "D#"; 
        } 
        else if (midiNumber % NOTES_IN_AN_OCTAVE == 4) { 
            return "E"; 
        } 
        else if (midiNumber % NOTES_IN_AN_OCTAVE == 5) { 
            return "F"; 
        } 
        else if (midiNumber % NOTES_IN_AN_OCTAVE == 6) { 
            return "F#"; 
        } 
        else if (midiNumber % NOTES_IN_AN_OCTAVE == 7) { 
            return "G"; 
        } 
        else if (midiNumber % NOTES_IN_AN_OCTAVE == 8) { 
            return "G#"; 
        } 
        else if (midiNumber % NOTES_IN_AN_OCTAVE == 9) { 
            return "A"; 
        } 
        else if (midiNumber % NOTES_IN_AN_OCTAVE == 10) { 
            return "A#"; 
        } 
        else { 
            return "B"; 
        } 
    }
 
    // Returns the octave of this note.
    public int octave() {
 
        return (midiNumber / NOTES_IN_AN_OCTAVE) - 1;
    }
 
    // Returns a new Note that is transposed delta halftones.
    public Note transpose(int delta) {
        return new Note(midiNumber + delta, name);
    }
 
    // Returns a string representation of this note.
    public String toString() {
        return midiNumber + " " + this.name() + this.octave() +
                " (" + name + ")";
    }
 
    // Unit tests the Note data type.
    public static void main(String[] args) {
        Note n1 = new Note(69, "piano");
        System.out.println(n1);
        System.out.println(n1.midi());
        System.out.println(n1.octave());
        System.out.println(n1.frequency());
        System.out.println(n1.name());
        Note n2 = n1.transpose(5);
        n1.play();
        System.out.println(n2);
    }
 
}
