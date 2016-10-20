/**
 * Search result class. If word is found, wordFound will be true and foundWord
 * will contain a {@link FoundWord} object with all the information necessary
 * to find the word
 *
 * @author Jonathan Lowe
 */
public class SearchResult {
    private boolean wordFound;
    private FoundWord foundWord;

    public SearchResult() {
        wordFound = false;
    }

    public boolean isWordFound() {
        return wordFound;
    }

    public FoundWord getFoundWord() {
        return foundWord;
    }

    /**
     * Sets foundWord and thus sets wordFound to true
     *
     * @param foundWord
     */
    public void setFoundWord(FoundWord foundWord) {
        wordFound = true;
        this.foundWord = foundWord;
    }
}
