package self.learning.StringsProblems;

import java.util.HashMap;
import java.util.Map;

public class TrieNode{
    Map<Character, TrieNode> children;
    boolean isWordEnding;
    public TrieNode()
    {
        children = new HashMap<>();
        isWordEnding = false;
    }
}