import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test class for the implementation of the {@link WordPuzzle}
 *
 * @author Jonathan Lowe
 */
public class WordPuzzleTest {

    WordPuzzle myPuzzle = null;

    /**
     * This function will initialize the myPuzzle variable before you start a new test method
     *
     * @throws Exception
     */
    @Before
    public void setUp() {
        try {
            this.myPuzzle = new WordPuzzle("VNYBKGSRORANGEETRNXWPLAEALKAPMHNWMRPOCAXBGATNOMEL", 7);
        } catch (IllegalArgumentException ex) {
            System.out.println("An exception has occured");
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Test the exceptions of the {@link WordPuzzle} constructor
     */
    @Test
    public void testWordPuzzleExceptions() {
        try {
            new WordPuzzle("VDSERSDERFD", 5);
        } catch (IllegalArgumentException ex) {
            assertEquals("Puzzle length is not a multiple of number of rows.", ex.getMessage());
        }
        try {
            new WordPuzzle("AAA1AAA2", 4);
        } catch (IllegalArgumentException ex) {
            assertEquals("Puzzle contains non-alphabetic character.", ex.getMessage());
        }
    }

    /**
     * Test the constructor of the {@link WordPuzzle} class
     */
    @Test
    public void testWordPuzzle() {
        assertNotNull("The object failed to initialize", this.myPuzzle);
        char[][] expectedArray =
                {
                        {'V', 'N', 'Y', 'B', 'K', 'G', 'S'},
                        {'R', 'O', 'R', 'A', 'N', 'G', 'E'},
                        {'E', 'T', 'R', 'N', 'X', 'W', 'P'},
                        {'L', 'A', 'E', 'A', 'L', 'K', 'A'},
                        {'P', 'M', 'H', 'N', 'W', 'M', 'R'},
                        {'P', 'O', 'C', 'A', 'X', 'B', 'G'},
                        {'A', 'T', 'N', 'O', 'M', 'E', 'L'}
                };
        assertArrayEquals(expectedArray, this.myPuzzle.getGrid());
    }

    /**
     * Test to search for all words.
     */
    @Test
    public void testSearchWord() {
        assertNotEquals(true, this.myPuzzle.searchWord("SOFTWARE").isWordFound());

        SearchResult result = this.myPuzzle.searchWord("BANANA");
        assertEquals(true, result.isWordFound());
        assertEquals(3, result.getFoundWord().getStartX());
        assertEquals(0, result.getFoundWord().getStartY());
        assertEquals(Direction.S, result.getFoundWord().getDir());
        assertEquals(6, result.getFoundWord().getLen());

        result = this.myPuzzle.searchWord("Apple");
        assertEquals(true, result.isWordFound());
        assertEquals(0, result.getFoundWord().getStartX());
        assertEquals(6, result.getFoundWord().getStartY());
        assertEquals(Direction.N, result.getFoundWord().getDir());
        assertEquals(5, result.getFoundWord().getLen());

        result = this.myPuzzle.searchWord("cherry");
        assertEquals(true, result.isWordFound());
        assertEquals(2, result.getFoundWord().getStartX());
        assertEquals(5, result.getFoundWord().getStartY());
        assertEquals(Direction.N, result.getFoundWord().getDir());
        assertEquals(6, result.getFoundWord().getLen());

        result = this.myPuzzle.searchWord("grapes");
        assertEquals(true, result.isWordFound());
        assertEquals(6, result.getFoundWord().getStartX());
        assertEquals(5, result.getFoundWord().getStartY());
        assertEquals(Direction.N, result.getFoundWord().getDir());
        assertEquals(6, result.getFoundWord().getLen());

        result = this.myPuzzle.searchWord("lemon");
        assertEquals(true, result.isWordFound());
        assertEquals(6, result.getFoundWord().getStartX(), 6);
        assertEquals(6, result.getFoundWord().getStartY(), 6);
        assertEquals(Direction.W, result.getFoundWord().getDir());
        assertEquals(5, result.getFoundWord().getLen());

        result = this.myPuzzle.searchWord("orange");
        assertEquals(true, result.isWordFound());

        result = this.myPuzzle.searchWord("tomato");
        assertEquals(true, result.isWordFound());

        /* Test remaining directions with nonsense words */
        result = this.myPuzzle.searchWord("AOHAX");
        assertEquals(true, result.isWordFound());
        assertEquals(Direction.NE, result.getFoundWord().getDir());

        result = this.myPuzzle.searchWord("EAHAM");
        assertEquals(true, result.isWordFound());
        assertEquals(Direction.SE, result.getFoundWord().getDir());

        result = this.myPuzzle.searchWord("WAROV");
        assertEquals(true, result.isWordFound());
        assertEquals(Direction.NW, result.getFoundWord().getDir());

        result = this.myPuzzle.searchWord("SGXAHO");
        assertEquals(true, result.isWordFound());
        assertEquals(Direction.SW, result.getFoundWord().getDir());

        result = this.myPuzzle.searchWord("EALKA");
        assertEquals(true, result.isWordFound());
        assertEquals(Direction.E, result.getFoundWord().getDir());
    }
}
