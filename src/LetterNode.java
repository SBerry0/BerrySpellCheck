import java.util.ArrayList;

public class LetterNode {
    char letter;
    ArrayList<LetterNode> children;

    public LetterNode(char c) {
        letter = c;
        children = new ArrayList<>();
    }

    public void addChild(LetterNode c) {
        children.add(c);
    }

    public char getLetter() {
        return letter;
    }

    public ArrayList<LetterNode> getChildren() {
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
