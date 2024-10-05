public class TSTNode {
    public final int LESS = 0;
    public final int EQUAL = 1;
    public final int GREATER = 2;


//    private TSTNode equal;
//    private TSTNode greater;
//    private TSTNode less;
    private char letter;
    private TSTNode[] children;
    private boolean isEnding;

    TSTNode(char letter) {
        isEnding = false;
        this.letter = letter;
        // 0=less; 1=equal; 2=greater
        this.children = new TSTNode[3];
    }

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

    public TSTNode setChild(char compChar, char nextChar) {
        if (letter == compChar) {
            return setChildNode(EQUAL, nextChar);
        }
        if (letter > compChar) {
            return setChildNode(LESS, nextChar);
        }
        return setChildNode(GREATER, nextChar);
    }

    public TSTNode setChild(char c) {
        if (letter == c) {
            return setChildNode(EQUAL, c);
        }
        if (letter > c) {
            return setChildNode(LESS, c);
        }
        return setChildNode(GREATER, c);
    }

    public TSTNode setChildNode(int index, char c) {
        if (children[index] == null) {
            children[index] = new TSTNode(c);
        }
        else {
            children[index].setChild(c);
        }
        return children[index];
    }


//    public void setGreater(char c) {
//        if (this.greater == null) {
//            this.greater = new TSTNode(c);
//        } else {
//            this.greater.se
//        }
//        this.greater = greater;
//    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public void setEnding(boolean ending) {
        isEnding = ending;
    }
}
