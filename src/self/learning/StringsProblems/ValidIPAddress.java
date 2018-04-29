package self.learning.StringsProblems;
import java.util.*;

public class ValidIPAddress {

    public static void generate(String ipaddress)
    {
        List<String>  validIPAddresses = new ArrayList<>();

        for(int i = 1; i < 4 && i < ipaddress.length(); i++)
        {
            String s1 = ipaddress.substring(0, i);
            if(isValid(s1))
            {
                for(int j = 1; i + j < ipaddress.length() && j < 4; j++)
                {
                    String s2 = ipaddress.substring(i, i + j);
                    if(isValid(s2))
                    {
                        for(int k = 1; i + j + k < ipaddress.length() && k < 4; k++)
                        {
                            String s3 = ipaddress.substring(i + j, i + j + k);
                            if(isValid(s3))
                            {
                                String s4 = ipaddress.substring(i + j + k);
                                if(isValid(s4))
                                {
                                    validIPAddresses.add(s1 + "." + s2 + "." + s3 + "." + s4);
                                }
                            }
                        }
                    }
                }
            }
        }

        for(String s : validIPAddresses)
        {
            System.out.println(s);
        }

    }

    static boolean isValid(String s)
    {
        if(s.length() > 3)
            return false;

        if(s.startsWith("0") && s.length() > 1)
            return false;

        int addr = Integer.parseInt(s);

        return addr >= 0 && addr <= 255;
    }
}
