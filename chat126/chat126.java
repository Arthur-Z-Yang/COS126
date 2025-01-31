public class Chat126 {
    // client method of markov lm
    public static void main(String[] args) {
        // take command line input
 
        int k = Integer.parseInt(args[0]);
        int t = Integer.parseInt(args[1]);
 
        // read standard input
 
        String text = StdIn.readAll();
 
        // build markov model
        MarkovLM model = new MarkovLM(text, k);
 
        // print T-k transitions
        StringBuilder sb = new StringBuilder();
        sb.append(text, 0, k);
        for (int i = 0; i < t - k; i++) {
            sb.append(model.predictNext(sb.substring(i, i + k)));
        }
 
        System.out.println(sb);
    }
}
