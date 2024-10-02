import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Trie {
    LetterNode[] trie;

    public Trie() {
        trie = new LetterNode[1];
        trie[0] = new LetterNode('_', false);
    }

    public void insert(String word) {
        // Inserts a string into its appropriate spot in the trie
        LetterNode currentNode = trie[0];
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            LetterNode child;
            if (currentNode.getChildren()[c] == null) {
                // If that letter does not exist on the chain... make the node
                child = new LetterNode(c, (i == word.length() - 1));
                currentNode.addChild(child);
            } else {
                // If the next letter exists on the chain...move to the node
                child = currentNode.children[c];
                if (i == word.length() - 1) {
                    child.setWordEnd(true);
                    System.out.println("setting end word");
                }
//                child.setWordEnd(i == word.length() - 1);
            }
            currentNode = child;
        }
    }

    public boolean lookup (String word) {
        // Returns false if the word is not in the trie
        LetterNode currentNode = trie[0];
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            System.out.println("Checking:");

            if (currentNode.getChildren()[c] != null) {
                // Word is so far in the dictionary
                currentNode = currentNode.children[currentNode.getChildren()[c].getLetter()];
                if (i == word.length() - 1) {
                    if (!currentNode.isWordEnd()) {
                        // If the end of the word isn't the end of any words in the dictionary
                        return false;
                    }
                }
            } else {
                // Word is not in the dictionary
                return true;
            }
        }
        return false;
    }

    public void printTrie(LetterNode node, String letters) {
        if (node.isWordEnd()) {
            System.out.println(letters);
        }


    }

    public String[] printTrie() {
        Stack<LetterNode> possibilities = new Stack<>();
        possibilities.add(trie[0]);
        String word = "";
        ArrayList<String> words = new ArrayList<>();

        while (!possibilities.isEmpty()) {
            LetterNode node = possibilities.pop();
            if (node != null) {
                if (node.getLetter() != '_') {
                    word += node.getLetter();
                }
                if (node.isWordEnd()) {
                    words.add(word);
                    System.out.println(word);
                    word = "";
                }
//                System.out.println(Arrays.toString(node.getChildren()));
                for (LetterNode child : node.getChildren()) {
                    if (child != null) {
                        possibilities.add(child);
                    }
                }
            }
        }
        String[] out = new String[words.size()];
        for (int i = 0; i < words.size(); i++) {
            out[i] = words.get(i);
        }

        return out;
    }

}
