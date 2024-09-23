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
        System.out.println(Arrays.toString(characterTree));

        return null;
    }

    public int findChild(LetterNode node, char letter) {
//        for (LetterNode c : node.getChildren()) {
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
        LetterNode currentNode = tree[0];
//        for (int i = 0; i < tree.length; i++) {
//            tree[i] = new LetterNode((char) (i+'a'));
////            tree[i].addChild((char) (i+97));
//        }
        for (String word : dictionary) {
            System.out.println(word);
            for (int i = 0; i < word.length(); i++) {
                char c  = word.charAt(i);
                int childIndex = findChild(currentNode, c);
                LetterNode child;
                if (childIndex != -1) {
                    // If that letter exists on the chain... move to the node
                    child = currentNode.children.get(childIndex);
                }
                else {
                    // If that letter does not exist on the chain... make the node
                    child = new LetterNode(c);
                }
                currentNode.addChild(child);
                currentNode = child;
            }
        }
        System.out.println("TEST");

//        for (LetterNode n : tree[0].children) {
//
//        }

        return tree;
    }



    public int binarySearch(String word, String[] dictionary) {
        return 0;
    }
}
