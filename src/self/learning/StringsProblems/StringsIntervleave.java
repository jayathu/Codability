package self.learning.StringsProblems;

public class StringsIntervleave {

    public static boolean find_if_strings_interleave(String a, String b, String i) {
        /*
         * Write your code here.
         */

        char[] strA = a.toCharArray();
        char[] strB = b.toCharArray();
        char[] strI = i.toCharArray();

        if(strI.length != strA.length + strB.length)
            return false;

        int l = 0, j = 0, k = 0;

        while(k < strI.length)
        {
            if(l < strA.length && strI[k] == strA[l])
            {
                l++;
            }
            else if(j < strB.length && strI[k] == strB[j])
            {
                j++;
            }
            else{
                return false;
            }
            k++;
        }

        return true;
    }
}
