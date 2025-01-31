package byow.InputDemo;

/**
 * Created by hug.
 */
import edu.princeton.cs.algs4.StdDraw;
//import edu.princeton.cs.introcs.StdDraw;

public class KeyboardInputSource implements InputSource {
    private static final boolean PRINT_TYPED_KEYS = false;
    public KeyboardInputSource() {
        StdDraw.text(0.3, 0.3, "press m to moo, q to quit");
    }

    public char getNextKey() {
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start < 10) {
            if (StdDraw.hasNextKeyTyped()) {
                char c = Character.toUpperCase(StdDraw.nextKeyTyped());
                if (PRINT_TYPED_KEYS) {
                    System.out.print(c);
                }
                return c;
            }
        }
        return '\0';
    }

    public boolean possibleNextInput() {
        return true;
    }
}
