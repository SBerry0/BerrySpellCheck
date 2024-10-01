import java.util.Stack;

public class Trie {
    LetterNode[] trie;

    public Trie() {
        trie = new LetterNode[1];
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
                child.setWordEnd(i == word.length() - 1);
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

//    public void printTrie() {
//        Stack<LetterNode> possibilities = new Stack<>();
//        possibilities.add(trie[0]);
//
//        while (!possibilities.isEmpty()) {
//            LetterNode node = possibilities.pop();
//            for (LetterNode child : node.getChildren()) {
//                possibilities.add(child);
//            }
//        }
//
//    }

}
