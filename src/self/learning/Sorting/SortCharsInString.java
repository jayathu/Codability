package self.learning.Sorting;

public class SortCharsInString {

    //aiming for an O(N) runtime, with constant space
    //assuming only lower case ascii set
    public void Sort(String s)
    {
        int[] asciiset = new int[128];

        char[] arr = s.toCharArray();

        for(char c : arr)
        {
            int digit = c;
            asciiset[c] += 1;
        }

        StringBuilder sb = new StringBuilder();
       for(int i = 0; i < asciiset.length; i++)
        {
            if(asciiset[i] > 0)
            {
                int count = asciiset[i];
                while(count > 0)
                {
                    sb.append((char)i);
                    count--;
                }
            }
        }

        System.out.print(sb.toString());
    }

    static String sortCharacters(String inString) {
        int[] letterCounts = new int[256];

        char[] arr = inString.toCharArray();

        for(char c : arr){
            letterCounts[c] += 1;
            System.out.print("count[" + (int)c + "] = " + letterCounts[c] + "(" + c + ")\n");
        }

        System.out.println();

        int index = 0;
        for(int i = 0; i < letterCounts.length; i++)
        {
            while(letterCounts[i] > 0)
            {
                arr[index] = (char)i;
                letterCounts[i] -= 1;
                index++;
            }
        }

        System.out.println(arr);
        return String.valueOf(arr);
    }

}
