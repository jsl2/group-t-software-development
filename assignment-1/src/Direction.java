/**
 * Enumeration of all possible two-dimensional directions
 *
 * @author Jonathan Lowe
 */
public enum Direction {
    N(0, -1),
    NE(1, -1),
    E(1, 0),
    SE(1, 1),
    S(0, 1),
    SW(-1, 1),
    W(-1, 0),
    NW(-1, -1);

    private final int dirX;
    private final int dirY;

    Direction(int x, int y) {
        this.dirX = x;
        this.dirY = y;
    }

    public int getX() {
        return dirX;
    }

    public int getY() {
        return dirY;
    }
}
