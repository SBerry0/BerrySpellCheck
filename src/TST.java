public class TST {
    TSTNode root;

    public TST() {
//        root = new TSTNode('_');
    }

    public TSTNode getRoot() {
        return root;
    }

    public TSTNode insertChar(TSTNode node, char c) {
        if (node == null) {
            node = new TSTNode(c);
        }
        return node;
    }

    public void insert(TSTNode node, String word) {
        root = insert(node, word, 0);
    }

    public TSTNode insert(TSTNode node, String word, int d) {
        char c = word.charAt(d);
        if (node == null) {
            node = new TSTNode(c);
        }
        if (c < node.getLetter()) {
            node.setLess(insert(node.getLess(), word, d));
        }
        else if (c > node.getLetter()) {
            node.setGreater(insert(node.getGreater(), word, d));
        }
        else if (c == node.getLetter()) {
            if (d < word.length()-1) {
                node.setEqual(insert(node.getEqual(), word, d+1));
            } else {
                // On the last letter... no need to make another child, but do have to set wordEnd
                node.setEnding(true);
            }
        }
        return node;
    }



//    public void insert(String word) {
//        TSTNode currentNode = root;
//
//
//        for (int i = 0; i < word.length()-1; i++) {
//            char c = word.charAt(i);
//            if (root == null && currentNode == null) {
//                root = new TSTNode(c);
//                currentNode = root;
////                i--;
//            }
//
//            currentNode = currentNode.setChild(c, word.charAt(i+1));
////
////            else if (currentNode.getLetter() == c) {
////                currentNode = insertChar(currentNode.getEqual(), c);
////            } else if (currentNode.getLetter() > c) {
////                currentNode = insertChar(currentNode.getLess(), c);
////            } else if (currentNode.getLetter() < c) {
////                currentNode.setGreater(c);
//////                currentNode = insertChar(currentNode.getGreater(), c);
////            }




        // Inserts a string into its appropriate spot in the trie
//        TSTNode currentNode = root;
//        for (int i = 0; i < word.length(); i++) {
//            char c = word.charAt(i);
////            TSTNode child;
//            if (currentNode == null) {
//                currentNode = new TSTNode(c);
//            }
//            if (root == null) {
//                root = currentNode;
//            }
//            if (currentNode.getLetter() == c) {
//                // If the letters match, go to the equals node
//                currentNode = currentNode.getEqual();
////                if (currentNode.getEqual() == null) {
//                    // If that letter does not exist on the chain make the node
////                        currentNode.setEqual(new TSTNode());
////                }
////                child = new TrieNode(c, (i == word.length() - 1));
////                currentNode.addChild(child);
//            }
//            else if (currentNode.getLetter() < c) {
//                // If the node's character is less than the word's character, go to the less node
//                currentNode = currentNode.getLess();
//
//            }
//            else {
//                // If the node's character is greater than the word's character, go to the greater node
//                currentNode = currentNode.getGreater();
//
//            }
////            currentNode = child;
//        }
//    }

}
