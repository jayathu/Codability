package self.learning.StringsProblems;

import java.util.*;

public class BoggleSolver {

    public void Execute()
    {
        String[] dictionary = new String[]{"GEEKS", "FOR", "QUIZ", "GUEST", "SEI"};
        String[][] board = new String[][]{ {"G", "I", "Z"}, {"U", "E", "K"}, {"Q", "S", "E"}};


        String[] res = findWords(dictionary, board);

        for(String s : res)
        {
            System.out.println(s);
        }
    }

    String[] findWords(String[] dictionaryList, String[][] board)
    {
        //Set<String> dictionarySet = new HashSet<>();

        Trie trie = new Trie();

        for(String s : dictionaryList)
        {
            //dictionarySet.add(s);
            trie.addWord(s);
        }

        boolean[][] visited = new boolean[board.length][board[0].length];
        char[][] charBoard = new char[board.length][board[0].length];

        List<String> list = new ArrayList<>();

        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                charBoard[i][j] = board[i][j].toCharArray()[0];
            }
        }

        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                //list = findWordDFS(dictionarySet, charBoard, visited, i, j, new StringBuilder(), list);
                TrieNode child = trie.getRoot().children.get(charBoard[i][j]);
                if(child != null) {
                    list = findWordTrie(child, charBoard, visited, i, j, new StringBuilder(), list);
                }
            }
        }

        return list.toArray(new String[list.size()]);
    }


//    class Boggle
//    {
//        int row;
//        int col;
//        StringBuilder aChar;
//        TrieNode node;
//
//        public Boggle(int r, int c, char ch, TrieNode n)
//        {
//            aChar = new StringBuilder();
//            row = r; col = c; aChar.append(c); node = n;
//        }
//    }

    List<String> findWordTrie(TrieNode currentNode, char[][] board, boolean[][] visited, int i, int j, StringBuilder s, List<String> list)
    {
        visited[i][j] = true;
        s.append(board[i][j]);

        for(int row = i-1; row < i+2; row++)
        {
            for(int col = j-1; col < j+2; col++)
            {
                if(row >= 0 && row < board.length && col >= 0 && col < board[0].length)
                {
                    if(!visited[row][col] && currentNode.children.get(board[row][col]) != null)
                    {
                        findWordTrie(currentNode.children.get(board[row][col]), board, visited, row, col, s, list);
                    }
                }
            }
        }

        if(currentNode.isWordEnding)
        {
            list.add(s.toString());
        }
        s.deleteCharAt(s.length() - 1);
        visited[i][j] = false;

        return list;
    }

    List<String> findWordDFS(Set<String> dictionary, char[][] board, boolean[][] visited, int i, int j, StringBuilder s, List<String> list)
    {
        visited[i][j] = true;
        s.append(board[i][j]);
        for(int row = i - 1; row < i + 2; row++)
        {
            for(int col = j - 1; col < j + 2; col++)
            {
                if(row >= 0 && row < board.length && col >=0 && col < board[0].length)
                {
                    if(!visited[row][col])
                    {
                        findWordDFS(dictionary, board, visited, row, col, s, list);
                    }
                }
            }
        }

        if(dictionary.contains(s.toString())) {
            list.add(s.toString());
        }

        s.deleteCharAt(s.length() - 1);
        visited[i][j] = false;

        return list;
    }

}
