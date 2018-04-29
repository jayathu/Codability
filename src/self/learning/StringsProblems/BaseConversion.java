package self.learning.StringsProblems;

public class BaseConversion {

    public static String convertBase(String numAsString, int b1, int b2)
    {
        boolean isNegative = numAsString.startsWith("-");
        int numAsInt = 0;

        int beg = (isNegative ? 1 : 0);
        for(int i = beg; i < numAsString.length(); i++)
        {
            numAsInt *= b1;
            numAsInt += Character.isDigit(numAsString.charAt(i)) ? numAsString.charAt(i) - '0' : numAsString.charAt(i) - 'A' + 10;
        }

        return constructFromBase(numAsInt, b2);

    }

    private static String constructFromBase(int numAsInt, int base)
    {
        if(numAsInt == 0)
            return "";

        char c;
        int digit = numAsInt % base;
        if(digit >= 10)
        {
            c = (char)('A' + digit - 10);
        }
        else
        {
            c = (char)('0' + digit);
        }
        return constructFromBase(numAsInt / base, base) + c;
    }
}
