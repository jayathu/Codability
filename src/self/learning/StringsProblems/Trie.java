package self.learning.StringsProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trie {

    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public TrieNode getRoot()
    {
        return root;
    }

    public void addWord(String word)
    {
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++) {

            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if(node == null)
            {
                node = new TrieNode();
                current.children.put(ch, node);
            }
            current = node;
        }
        current.isWordEnding = true;
    }

    public boolean searchWord(String word)
    {
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++)
        {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if(node == null)
            {
                return false;
            }
            current = node;
        }

        return current.isWordEnding;
    }

    public List<String> searchPrefix(String prefix)
    {
        TrieNode current = root;
        for(int i = 0; i < prefix.length(); i++)
        {
            char ch = prefix.charAt(i);
            TrieNode node = current.children.get(ch);
            if(node == null)
            {
                return new ArrayList<>();
            }
            current = node;
        }
        List<String> output = new ArrayList<>();
        StringBuilder buffer = new StringBuilder(prefix);
        collectAllFromPrefix(current, buffer, output);
        return output;
    }

    private List<String> collectAllFromPrefix(TrieNode current, StringBuilder path, List<String> output)
    {
        if(current.isWordEnding == true)
        {
            output.add(path.toString());
        }
        for(Character ch : current.children.keySet())
        {
            path.append(ch);
            TrieNode node = current.children.get(ch);
            collectAllFromPrefix(node, path, output);
            path.deleteCharAt(path.length() - 1);
        }
        return output;
    }

}
