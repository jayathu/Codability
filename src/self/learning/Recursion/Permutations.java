package self.learning.Recursion;

public class Permutations {

    static void PrintPerms(char[] arr)
    {
        PrintPermsRecurse(arr, 0);
    }

    static void PrintPermsRecurse(char[] arr, int index)
    {
        if(index == arr.length)
        {
           PrintArray(arr);
           return;
        }
        for(int i = index; i < arr.length; i++)
        {
            Swap(arr, i, index);
            PrintPermsRecurse(arr, index + 1);
            Swap(arr, index, i);
        }
        return;
    }

    static void PrintArray(char[] arr)
    {
        for(char c : arr)
        {
            System.out.print(c);
        }

        System.out.println();
    }

    static void Swap(char[] arr, int a, int b)
    {
        char temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
