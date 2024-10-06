// TST.java by Sohum Berry
public class TST {
    TSTNode root;

    public void insert(String word) {
        root = insert(root, word, 0);
    }

    // Inserting into the TST
    public TSTNode insert(TSTNode node, String word, int d) {
        char c = word.charAt(d);
        // Create new node if it doesn't exist
        if (node == null) {
            node = new TSTNode(c);
        }
        // Recurse using the less node, staying at the same letter
        if (c < node.getLetter()) {
            node.setLess(insert(node.getLess(), word, d));
        }
        // Recurse using the greater node, staying at the same letter
        else if (c > node.getLetter()) {
            node.setGreater(insert(node.getGreater(), word, d));
        }
        // If the node is equal to the letter
        else if (c == node.getLetter()) {
            // If it isn't the last letter, recurse using the equal node and iterate the character
            if (d < word.length()-1) {
                node.setEqual(insert(node.getEqual(), word, d+1));
            } else {
                // On the last letter... no need to make another child, but do have to set wordEnd
                node.setEnding(true);
            }
        }
        return node;
    }

    // Returns true if word is in TST, false if not
    public boolean lookup(String word) {
        return lookup(root, word, 0) != null;
    }

    // Looking up a string in the TST
    public TSTNode lookup(TSTNode node, String word, int d) {
        char c = word.charAt(d);
        // If the node doesn't exist, return null which will be found to return false
        if (node == null) {
            return null;
        }
        // Recurse to the corresponding nodes if the letter is greater or less than the node
        if (c < node.getLetter()) {
            return lookup(node.getLess(), word, d);
        } else if (c > node.getLetter()) {
            return lookup(node.getGreater(), word, d);
        }
        // If the letters are equal...
        else {
            // If it's the last letter return whether or not the node is a word end
            if (d == word.length() - 1) {
                if (node.isEnding()) {
                    return node;
                }
                return null;
                // Otherwise continue recursing...
            }
            // Only move onto the next letter when the initial one has been found in the TST
            return lookup(node.getEqual(), word, d+1);
        }
    }
}
