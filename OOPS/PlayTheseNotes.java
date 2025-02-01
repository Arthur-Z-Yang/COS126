public class PlayTheseNotes {
 
    // Reads a sequence of notes from the given file and returns a
    // Note array based on the given instrument
    public static Note[] read(String filename, String instrument) {
        In in = new In(filename);
        // constructor for an input stream --> need to do that
        int numberOfNotes = in.readInt();
        Note[] notes = new Note[numberOfNotes];
        // create not an int array, but a Notes[] array; can think as if
        // it's an int array
        for (int i = 0; i < numberOfNotes; i++) {
            int midiNumber = in.readInt();
            notes[i] = new Note(midiNumber, instrument);
            // each value in the array is a Note(), not an int
            double duration = in.readDouble();
        }
        return notes;
    }
 
 
    // Takes three command-line arguments (a file name, an instrument name,
    // a delta value for transpose), reads a sequence of notes from the file
    // and plays the musical notes, according to the given instrument on
    // standard audio
    public static void main(String[] args) {
        String file = args[0];
        String instrument = args[1];
        int delta = Integer.parseInt(args[2]);
        Note[] readMidi = read(file, instrument);
        for (int i = 0; i < readMidi.length; i++) {
            readMidi[i] = readMidi[i].transpose(delta);
            System.out.print(readMidi[i].name() + readMidi[i].octave() + " ");
            readMidi[i].play();
            // what's the difference between play() as a function and ....play?
 
 
        }
 
 
    }
}
