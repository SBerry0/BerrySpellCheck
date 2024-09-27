import java.util.ArrayList;
import java.util.Arrays;

/**
 * Spell Check
 * A puzzle written by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: Sohum Berry
 * */

public class SpellCheck {


    /**
     * checkWords finds all words in text that are not present in dictionary
     *
     * @param text The list of all words in the text.
     * @param dictionary The list of all accepted words.
     * @return String[] of all mispelled words in the order they appear in text. No duplicates.
     */
    public String[] checkWords(String[] text, String[] dictionary) {
        LetterNode[] characterTree = makeTree(dictionary);
        ArrayList<String> mispelled = new ArrayList<>();
        for (String word : text) {
            LetterNode currentNode = characterTree[0];
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                System.out.println("Checking: " + currentNode.getChildren().size());

                int childPosition = findChild(currentNode, c);
                if (childPosition != -1) {
                    // Word is so far in the dictionary
                    currentNode = currentNode.children.get(childPosition);
                    continue;
                }
                else {
                    // Word is not in the dictionary
                    mispelled.add(word);
                    break;
                }
            }
        }
        String[] out = new String[mispelled.size()];
        for (int i = 0; i < mispelled.size(); i++) {
            out[i] = mispelled.get(i);
        }

        return out;
    }

    public int findChild(LetterNode node, char letter) {
        // Binary Search
//        int start = 0;
//        int end = node.getChildren().size()-1;
//        System.out.println(node.getChildren());
//        System.out.println("looking for " + letter);
//        while (start <= end) {
//            int mid = Math.min((int) ((1.0*start + end) / 2 + 0.5), end);
//            if (node.getChildren().get(mid).getLetter() == letter) {
//                return mid;
//            }
//            if (node.getChildren().get(mid).getLetter() < letter) {
//                end = mid;
//            }
//            else {
//                start = mid+1;
//            }
//        }
//        return -1;
        for (int i = 0; i < node.getChildren().size(); i++) {
            if (node.getChildren().get(i).getLetter() == letter) {
                return i;
            }
        }
        return -1;
    }

    public LetterNode[] makeTree(String[] dictionary) {
        LetterNode[] tree = new LetterNode[1];
        tree[0] = new LetterNode('_');

        for (String word : dictionary) {
            LetterNode currentNode = tree[0];
//            System.out.println(word);
            for (int i = 0; i < word.length(); i++) {
                char c  = word.charAt(i);
                System.out.println("Making: " + currentNode.getChildren().size());
                int childIndex = findChild(currentNode, c);
                System.out.println(childIndex);
                LetterNode child;
                if (childIndex != -1) {
                    // If the next letter exists on the chain...move to the node
//                    System.out.println(c + " exists");
                    child = currentNode.children.get(childIndex);
                }
                else {
//                    System.out.println(c + " being added");
                    // If that letter does not exist on the chain... make the node
                    child = new LetterNode(c);
                    currentNode.addChild(child);
                }
                currentNode = child;
            }
        }
        return tree;
    }
}
