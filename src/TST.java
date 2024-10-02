public class TST {
    TSTNode root;

    public void insert(String word) {
        // Inserts a string into its appropriate spot in the trie
        TSTNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
//            TSTNode child;
            if (currentNode == null) {
                currentNode = new TSTNode(c);
            }
            if (currentNode.getLetter() == c) {
                // If the letters match, go to the equals node
                currentNode = currentNode.getEqual();
//                if (currentNode.getEqual() == null) {
                    // If that letter does not exist on the chain make the node
//                        currentNode.setEqual(new TSTNode());
//                }
//                child = new TrieNode(c, (i == word.length() - 1));
//                currentNode.addChild(child);
            }
            else if (currentNode.getLetter() < c) {
                // If the node's character is less than the word's character, go to the less node
                currentNode = currentNode.getLess();

            }
            else {
                // If the node's character is greater than the word's character, go to the greater node
                currentNode = currentNode.getGreater();

            }
//            currentNode = child;
        }
    }

}
