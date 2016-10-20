/**
 * WordPuzzle class to store a Flair Puzzle and find words within the puzzle.
 *
 * @author Jonathan Lowe
 */
public class WordPuzzle {
    private char grid[][];
    private int width;
    private int height;

    /**
     * Generate a two-dimensional word search puzzle
     *
     * @param puzzle       String with all characters
     * @param numberOfRows Number of rows to divide puzzle string into
     * @throws IllegalArgumentException when the puzzle contains non-alphabetic characters or the
     *                                  puzzle length is not a multiple of the numberOfRows argument
     */
    public WordPuzzle(String puzzle, int numberOfRows) throws IllegalArgumentException {
        if (puzzle.length() % numberOfRows != 0)
            throw new IllegalArgumentException("Puzzle length is not a multiple of number of rows.");

        for (int i = 0; i < puzzle.length(); i++)
            if (!Character.isAlphabetic(puzzle.charAt(i)))
                throw new IllegalArgumentException("Puzzle contains non-alphabetic character.");

        puzzle = puzzle.toUpperCase();

        this.height = numberOfRows;
        this.width = puzzle.length() / numberOfRows;

        this.grid = new char[height][width];

        for (int y = 0; y < height; y++)
            for (int x = 0; x < width; x++)
                grid[y][x] = puzzle.charAt(y * width + x);
    }

    /**
     * Returns two-dimensional puzzle array generated from puzzle string
     */
    public char[][] getGrid() {
        return grid;
    }

    /**
     * Search for word in puzzle in all 8 directions, horizontally, vertically and diagonally
     *
     * @param word Word to find in puzzle
     * @return SearchResult object which indicates if the word was found, and if so, the required
     * information to identify the word: start x and y coordinates, direction and length
     */
    public SearchResult searchWord(String word) {
        word = word.toUpperCase();
        SearchResult res = new SearchResult();

        for (int startY = 0; startY < height; startY++) {
            for (int startX = 0; startX < width; startX++) {
                if (grid[startY][startX] != word.charAt(0))
                    continue;

                for (Direction dir : Direction.values()) {
                    // Will the word fit in this direction (i.e. do bounds check before reaching bound)
                    int endX = startX + word.length() * dir.getX();
                    int endY = startY + word.length() * dir.getY();
                    if (endX < -1 || endX > width || endY < -1 || endY > height)
                        continue;

                    // Search in this direction until there is a mismatch
                    int k = 1;
                    for (; k < word.length(); k++)
                        if (grid[startY + k * dir.getY()][startX + k * dir.getX()] != word.charAt(k))
                            break;

                    // If search in given direction completed, then word was found
                    if (k == word.length()) {
                        FoundWord foundWord = new FoundWord(startX, startY, dir, word.length());
                        res.setFoundWord(foundWord);
                        return res;
                    }
                }
            }
        }

        // Return unaltered SearchResult object, word not found
        return res;
    }
}
