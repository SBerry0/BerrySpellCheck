import java.util.ArrayList;

public class LetterNode {
    int NUM_CHARACTERS = 256;
    char letter;
    LetterNode[] children;
    boolean isWordEnd;

    public LetterNode(char c, boolean isWordEnd) {
        letter = c;
        children = new LetterNode[NUM_CHARACTERS];
        this.isWordEnd = isWordEnd;
    }

    public void addChild(LetterNode c) {
        children[c.getLetter()] = c;
    }

    public boolean isWordEnd() {
        return isWordEnd;
    }

    public void setWordEnd(boolean wordEnd) {
        isWordEnd = wordEnd;
    }

    public char getLetter() {
        return letter;
    }

    public LetterNode[] getChildren() {
        return children;
    }

    public String toString() {
        return ""+letter;
    }

//    public String toString() {
//        String out = "Letter: ";
//        out += letter + "\n";
//
//        for (char c : children) {
//            out += c;
//            out += ", ";
//        }
//
//        return out;
//    }
}
