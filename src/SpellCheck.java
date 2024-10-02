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
     * @param text       The list of all words in the text.
     * @param dictionary The list of all accepted words.
     * @return String[] of all mispelled words in the order they appear in text. No duplicates.
     */
    public String[] checkWords(String[] text, String[] dictionary) {
        Trie dictionaryTrie = new Trie();
        for (String word : dictionary) {
            dictionaryTrie.insert(word);
        }
        System.out.println(Arrays.toString(dictionaryTrie.printTrie()));

        Trie mispelledTrie = new Trie();
        ArrayList<String> mispelled = new ArrayList<>();
        for (String word : text) {
            if (!mispelledTrie.lookup(word) && !dictionaryTrie.lookup(word)) {
                // If the word does not exist in the dictionary add it to mispelled
                mispelledTrie.insert(word);
                mispelled.add(word);
            } else {

            }
        }
//        String[] out = mispelledTrie


//        LetterNode[] characterTree = makeTree(dictionary);
//        LetterNode[] mispelledTree = new LetterNode[1];
//
        String[] out = new String[mispelled.size()];
        for (int i = 0; i < mispelled.size(); i++) {
            out[i] = mispelled.get(i);
        }

        return out;
    }

    private ArrayList<String> findMispelled(String[] text, LetterNode[] characterTree, LetterNode[] mispelledTree) {
        ArrayList<String> mispelled = new ArrayList<>();
        for (String word : text) {
            LetterNode currentNode = characterTree[0];
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                System.out.println("Checking:");

                if (currentNode.getChildren()[c] != null) {
                    // Word is so far in the dictionary
                    currentNode = currentNode.children[currentNode.getChildren()[c].getLetter()];
                    if (i == word.length() - 1) {
                        if (!currentNode.isWordEnd()) {
                            // If the end of the word isn't the end of any words in the dictionary
                            mispelled.add(word);
                            // No need for a break
                        }
                    }
                } else {
                    // Word is not in the dictionary
                    mispelled.add(word);
                    break;
                }
            }
        }
        return mispelled;
    }

    public LetterNode[] makeTree(String[] dictionary) {
        LetterNode[] tree = new LetterNode[1];
        tree[0] = new LetterNode('_', false);

        for (String word : dictionary) {
            LetterNode currentNode = tree[0];
//            System.out.println(word);
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                System.out.println(c);

                currentNode = put(word, currentNode, c, i);
            }
        }
        return tree;
    }

    private LetterNode put(String word, LetterNode currentNode, char c, int i) {
        LetterNode child;
        if (currentNode.getChildren()[c] == null) {
            // If that letter does not exist on the chain... make the node
            child = new LetterNode(c, (i == word.length() - 1));
            currentNode.addChild(child);
        } else {
            // If the next letter exists on the chain...move to the node
//                    System.out.println(c + " exists");
            child = currentNode.children[c];
            child.setWordEnd(i == word.length() - 1);
        }
        return child;
    }
}
