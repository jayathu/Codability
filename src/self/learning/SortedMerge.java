package self.learning;

public class SortedMerge {

    static int[] merger_first_into_second(int[] arr1, int[] arr2) {

        int index1 = arr1.length - 1; //array with n elements
        int index2 = arr1.length - 1; //array with 2n elements
        int index3 = arr2.length - 1; //merged elements index

        while(index1 >= 0)
        {
            if(index2 >=0 && arr2[index2] > arr1[index1])
            {
                arr2[index3] = arr2[index2];
                index2--;
            }
            else{
                arr2[index3] = arr1[index1];
                index1--;
            }
            index3--;
        }

        for(int i: arr2)
        {
            System.out.print(i + " ");
        }
        return arr2;

    }
}
