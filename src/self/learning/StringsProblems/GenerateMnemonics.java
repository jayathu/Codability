package self.learning.StringsProblems;
import java.util.*;

public class GenerateMnemonics {

    Map<Character, String> keypad = new HashMap<>();
    List<String> results = new ArrayList<>();

    public GenerateMnemonics()
    {
        keypad.put('1', "ABC");
        keypad.put('2', "DEF");
        keypad.put('3', "GHI");
    }

    public void Generate(String phone)
    {
        GenerateRecursive(phone.toCharArray(), 0, new StringBuilder());

        for(String s : results)
        {
            System.out.println(s);
        }
    }

    private void GenerateRecursive(char[] phone, int index, StringBuilder s)
    {
        if(index == phone.length)
        {
            results.add(s.toString());
            return;
        }

        char[] letters = keypad.get(phone[index]).toCharArray();
        for(char c : letters)
        {
            s.append(c);
            GenerateRecursive(phone, index + 1, s);
            s.deleteCharAt(index);
        }

        return;
    }
}
