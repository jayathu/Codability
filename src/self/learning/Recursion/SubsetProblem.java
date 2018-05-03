package self.learning.Recursion;

import com.sun.deploy.util.ArrayUtil;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class SubsetProblem {

    static void PrintSubsets(String s)
    {
        String[] subsets = generate_all_subsets(s);
        for(String str : subsets)
        {
            System.out.println(str);
        }
    }

    public  static String[] generate_all_subsets(String s) {
        if(s == null || s.length() == 0) {
            return new String[]{""};
        }

        char[] subsets_so_far = new char[s.length()];
        ArrayList<String> allSubsets = new ArrayList<>();
        generate_recurse(s, 0, subsets_so_far, 0, allSubsets);
        for(String str: allSubsets)
        {
            System.out.println(str);
        }

        ArrayList<Integer> results = new ArrayList<>();

        results.toArray(new Integer[results.size()]);
        //allSubsets = generate_recurse(s, 0, subsets_so_far, 0, allSubsets);
        return allSubsets.toArray(new String[allSubsets.size()]);



    }

    static ArrayList<String> generate_recurse(String s, int i, char[] subsets_so_far, int k, ArrayList<String> allSubsets)
    {

        if(i == s.length())
        {
            StringBuffer sb = new StringBuffer();
            for(int index = 0; index < k; index++)
            {
                sb.append(subsets_so_far[index]);
            }

            allSubsets.add(sb.toString());

        }else {

            generate_recurse(s, i + 1, subsets_so_far, k, allSubsets);
            subsets_so_far[k] = s.charAt(i);
            generate_recurse(s, i + 1, subsets_so_far, k + 1, allSubsets);
        }
        return allSubsets;

    }

    static void GenerateSubsets(String str)
    {
        char[] input = str.toCharArray();
        char[] output = new char[input.length];
        PrintSubsets(input, 0, output, 0);
    }

    static void PrintSubsets(char[] input, int i, char[] output, int k)
    {
        if(i == input.length)
        {
            for(int j = 0; j < k; j++)
            {
                System.out.print(output[j]);
            }
            System.out.println();
        }else {
            PrintSubsets(input, i + 1, output, k);
            output[k] = input[i];
            PrintSubsets(input, i + 1, output, k + 1);
        }
    }
}
