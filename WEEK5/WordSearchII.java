public class WordSearchII {

    /**
     * Question : https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/543/week-5-june-29th-june-30th/3376/
     * Reference : https://leetcode.com/problems/word-search-ii/discuss/59780/Java-15ms-Easiest-Solution-(100.00)
     */
    class Solution {

        // TrieNode class
        private class TrieNode {
            private TrieNode[] next = new TrieNode[26];
            private String word;
        }

        public List<String> findWords(char[][] board, String[] words) {

            // init the result
            List<String> result = new ArrayList<>();

            // Build the prefix tree
            TrieNode tree = buildPrefixTree(words);

            // dfs
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    dfs(board, i, j, tree, result);
                }
            }

            // return result
            return result;
        }

        // dfs
        private void dfs(char[][] board, int i, int j, TrieNode tree, List<String> result) {
            char c = board[i][j];

            if (c == '#' || tree.next[c - 'a'] == null) return;

            tree = tree.next[c - 'a'];

            if (tree.word != null) {
                result.add(tree.word);
                tree.word = null;
            }

            board[i][j] = '#';

            if (i > 0) dfs(board, i - 1, j, tree, result);
            if (j > 0) dfs(board, i, j - 1, tree, result);
            if (i < board.length - 1) dfs(board, i + 1, j, tree, result);
            if (j < board[0].length - 1) dfs(board, i, j + 1, tree, result);
            board[i][j] = c;

        }

        // builds the prefix tree
        private TrieNode buildPrefixTree(String[] words) {
            TrieNode tree = new TrieNode();

            for (String word : words) {
                TrieNode temp = tree;
                for (char c : word.toCharArray()) {
                    int i = c - 'a';
                    if (temp.next[i] == null) temp.next[i] = new TrieNode();
                    temp = temp.next[i];
                }

                temp.word = word;
            }

            return tree;
        }

    }
}
