/**
 * The FoundWord class contains all the necessary information to find a word in
 * the Flair puzzle: starting coordinates, direction and length of word.
 *
 * @author Jonathan Lowe
 */
public class FoundWord {
    private int startX;
    private int startY;
    private Direction dir;
    private int len;

    public FoundWord(int startX, int startY, Direction dir, int len) {
        this.startX = startX;
        this.startY = startY;
        this.dir = dir;
        this.len = len;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public Direction getDir() {
        return dir;
    }

    public int getLen() {
        return len;
    }
}