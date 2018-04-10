package self.learning.StringsProblems;

public class SinusoidalString {

    public static void print_string_sinusoidally(String s)
    {
        char[][] table = new char[3][s.length()];

        for(int i = 0; i < table.length; i++)
        {
            for(int j = 0; j < table[0].length; j++)
            {
                table[i][j] = ' ';
            }
        }

        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i) == ' ' ? '~' : s.charAt(i);

            if(i % 4 == 0)
            {
                table[2][i] = c;
            }
            else if(i % 2 == 1)
            {
                table[1][i] = c;
            }
            else
                table[0][i] = c;
        }

        for(int i = 0; i < table.length; i++)
        {
            for(int j = 0; j < table[0].length; j++)
            {
                System.out.print(table[i][j]);
            }
            System.out.println();
        }


    }

}
