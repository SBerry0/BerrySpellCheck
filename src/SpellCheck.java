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
//        Trie dictionaryTrie = new Trie();
//        for (String word : dictionary) {
//            dictionaryTrie.insert(word);
//        }
//
//        Trie mispelledTrie = new Trie();
        ArrayList<String> mispelled = new ArrayList<>();
//        for (String word : text) {
//            if (!mispelledTrie.lookup(word) && !dictionaryTrie.lookup(word)) {
//                // If the word does not exist in the dictionary add it to mispelled
//                mispelledTrie.insert(word);
//                mispelled.add(word);
//            }
//        }

        TST dictionaryTST = new TST();
        for (String word : dictionary) {
            dictionaryTST.insert(dictionaryTST.getRoot(), word);
        }










        String[] out = new String[mispelled.size()];
        for (int i = 0; i < mispelled.size(); i++) {
            out[i] = mispelled.get(i);
        }
        return out;
    }
}
