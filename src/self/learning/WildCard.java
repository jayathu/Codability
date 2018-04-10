package self.learning;

public class WildCard {

    static void PrintString(String input)
    {
        PrintRecursively(input.toCharArray(), 0);
    }

    static void PrintRecursively(char[] input, int index)
    {
        if(index == input.length)
        {
            for(char c: input)
            {
                System.out.print(c);
            }
            System.out.println();
            return;
        }

        if(input[index] == '?')
        {
            input[index] = '0';
            PrintRecursively(input, index + 1);

            input[index] = '1';
            PrintRecursively(input, index + 1);

            input[index] = '?';
        }

        else
        {
            PrintRecursively(input, index + 1);
        }


        return;
    }
}
