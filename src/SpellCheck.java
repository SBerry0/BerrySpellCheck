import java.util.ArrayList;

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
        ArrayList<String> mispelled = new ArrayList<>();

        // Trie:
//        Trie dictionaryTrie = new Trie();
//        for (String word : dictionary) {
//            dictionaryTrie.insert(word);
//        }
//
//        Trie mispelledTrie = new Trie();
//
//        for (String word : text) {
//            if (!mispelledTrie.lookup(word) && !dictionaryTrie.lookup(word)) {
//                // If the word does not exist in the dictionary add it to mispelled
//                mispelledTrie.insert(word);
//                mispelled.add(word);
//            }
//        }

        // TST:
        TST dictionaryTST = new TST();
        int mid = dictionary.length / 2 - 1;

        // Moving from the middle outwards to optimize the TST
        for (int i = 0; i < dictionary.length; i++) {
            // If i is even, index is middle plus half of i
            // If i is odd, index is middle plus the length of the dictionary minus half of i+1
            // All is mod by the length of the dictionary to stay in bounds
            int index = (mid + ((i%2 == 0) ? i / 2 : dictionary.length-(i+1)/2))%dictionary.length;
            dictionaryTST.insert(dictionary[index]);
        }

        TST mispelledTST = new TST();

        for (String word : text) {
            if (!mispelledTST.lookup(word) && !dictionaryTST.lookup(word)) {
                mispelledTST.insert(word);
                mispelled.add(word);
            }
        }

        // ArrayList conversion to array
        String[] out = new String[mispelled.size()];
        for (int i = 0; i < mispelled.size(); i++) {
            out[i] = mispelled.get(i);
        }
        return out;
    }
}
