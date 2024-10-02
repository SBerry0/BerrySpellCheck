public class TSTNode {
    private TSTNode equal;
    private TSTNode greater;
    private TSTNode less;
    private char letter;
    private boolean isEnding;

    TSTNode(char letter) {
        isEnding = false;
        this.letter = letter;
    }

    public TSTNode getEqual() {
        return equal;
    }

    public TSTNode getGreater() {
        return greater;
    }

    public TSTNode getLess() {
        return less;
    }

    public char getLetter() {
        return letter;
    }

    public boolean isEnding() {
        return isEnding;
    }

    public void setEqual(TSTNode equal) {
        this.equal = equal;
    }

    public void setGreater(TSTNode greater) {
        this.greater = greater;
    }

    public void setLess(TSTNode less) {
        this.less = less;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public void setEnding(boolean ending) {
        isEnding = ending;
    }
}
