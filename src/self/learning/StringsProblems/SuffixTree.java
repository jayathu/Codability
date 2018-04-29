package self.learning.StringsProblems;

import java.util.*;

public class SuffixTree {

    class SuffixTreeNode
    {
        boolean wordEnding;
        int numOfWordEndings;
        HashMap<Character, SuffixTreeNode> children;

        SuffixTreeNode()
        {
            wordEnding = false;
            numOfWordEndings = 0;
            children = new HashMap<>();
        }
    }

    public SuffixTree()
    {
        root = new SuffixTreeNode();
    }

    private SuffixTreeNode root;
    private HashSet<String> lrs_set =  new HashSet<>(); //longest repeating substring set
    private int lrs_distance;
    private int mrs_length;
    private HashSet<String> mrs_set = new HashSet<>();

    public void addSuffix(String s)
    {
        SuffixTreeNode node = root;
        node.numOfWordEndings += 1;
        int distance_from_root = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            SuffixTreeNode child = node.children.get(c);
            if(child == null)
            {
                child = new SuffixTreeNode();
                node.children.put(c, child);
            }
            node = child;
            node.numOfWordEndings += 1;
            distance_from_root += 1;
            if(node.numOfWordEndings > 1)
            {
                if(distance_from_root > lrs_distance)
                {
                    lrs_set.clear();
                    //System.out.println("Substring: " + s.substring(0, i + 1));
                    lrs_set.add(s.substring(0,i+1));
                    lrs_distance = distance_from_root;

                }
                else if(distance_from_root == lrs_distance)
                {
                    lrs_set.add(s.substring(0, i+1));
                }

                //update most repeated substring set
                if(distance_from_root > 1 && node.numOfWordEndings > mrs_length)
                {
                    mrs_length = node.numOfWordEndings;
                    mrs_set.clear();
                    mrs_set.add(s.substring(0, i+1));
                }
                else if(distance_from_root > 1 && node.numOfWordEndings == mrs_length)
                {
                    mrs_set.add(s.substring(0,i+1));
                }

            }
        }
        node.wordEnding = true;
    }

    public void printAllLRS()
    {
        for(String s : lrs_set)
        {
            System.out.println(s);
        }
    }

    public void printAlMRS()
    {
        for(String s : mrs_set)
        {
            System.out.println(s);
        }
    }

    public void BuildSuffixTree(String s)
    {
        for(int i = s.length() - 1; i >= 0; i--)
        {
            String suffix = s.substring(i);
            addSuffix(suffix);

            //System.out.println("Suffixes in the tree\n");
//            if(searchWord(suffix))
//            {
//                System.out.println(suffix);
//            }
        }

        //printAllLRS();
        printAlMRS();
    }

    public boolean searchWord(String word)
    {
        SuffixTreeNode current = root;
        for(int i = 0; i < word.length(); i++)
        {
            char ch = word.charAt(i);
            SuffixTreeNode node = current.children.get(ch);
            if(node == null)
            {
                return false;
            }
            current = node;
        }

        return current.wordEnding;
    }
}
