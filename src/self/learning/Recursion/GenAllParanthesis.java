package self.learning.Recursion;

public class GenAllParanthesis {

    static void Generate(int n)
    {
        char[] output = new char[2 * n];
        GenerateRecurse(n, n, output, 0);
    }

    static void GenerateRecurse(int left, int right, char[] string, int k)
    {
        if(left == 0 && right == 0)
        {
            System.out.println(string);
            return;
        }

        if(left > 0)
        {
            string[k] = '(';
            GenerateRecurse(left - 1, right, string, k+1);

        }
        if(right > left)
        {
            string[k] = ')';
            GenerateRecurse(left, right - 1, string, k+1);
        }

        return;
    }
}
