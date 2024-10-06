// TSTNode.java by Sohum Berry
public class TSTNode {
    public final int LESS = 0;
    public final int EQUAL = 1;
    public final int GREATER = 2;

    private char letter;
    private TSTNode[] children;
    private boolean isEnding;

    TSTNode(char letter) {
        isEnding = false;
        this.letter = letter;
        // 0=less; 1=equal; 2=greater
        this.children = new TSTNode[3];
    }

    // Getters
    public TSTNode getEqual() {
        return children[EQUAL];
    }

    public TSTNode getGreater() {
        return children[GREATER];
    }

    public TSTNode getLess() {
        return children[LESS];
    }

    public char getLetter() {
        return letter;
    }

    public boolean isEnding() {
        return isEnding;
    }

    // Setters
    public void setLess(TSTNode n) {
        children[LESS] = n;
    }

    public void setEqual(TSTNode n) {
        children[EQUAL] = n;
    }

    public void setGreater(TSTNode n) {
        children[GREATER] = n;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public void setEnding(boolean ending) {
        isEnding = ending;
    }
}
