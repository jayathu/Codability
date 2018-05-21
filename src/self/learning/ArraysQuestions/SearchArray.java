package self.learning.ArraysQuestions;

/*
Given a 2D array where numbers appear in an increasing order both row and col wise,
and an element to be searched, return true if found, false otherwise
 */
public class SearchArray {

    //most optimal if the array contains duplicates
    //O(logR + logC)
    public boolean find(int[][] arr, int num)
    {
        int rows = arr.length;
        int cols = arr[0].length;
        int rowIndex = 0;
        int colIndex = cols - 1;

        while(rowIndex < rows && colIndex >= 0)
        {
            if(arr[rowIndex][colIndex] < num)
            {
                rowIndex++;
            }
            else if(arr[rowIndex][colIndex] > num)
            {
                colIndex--;
            }
            else{
                //System.out.print("Found num at (" + rowIndex + "," + colIndex + ")");
                return true;
            }
        }
        System.out.print("Num not found");
        return false;
    }

    //most optimal if the array doesn't have duplicates
    //Time Complexity: O(logR * logC)
    public boolean twoDArraySearch(int[][] a,  int start, int end, int num) {

        if(start > end) return false;

        int col = a[0].length;

        int mid = start + (end - start)/2;
        int midVal = a[mid][0];

        if (midVal == num) return true;

        if( midVal < num && num <=  a[mid][col-1] ) {
            // do search in the row
            if(binarySearch(a[mid], 0, col-1, num))
                return true;
        }
        if (midVal < num ) {
            // move down the row by doing binary search on
            if(twoDArraySearch(a, mid+1, end, num ))
                return true;
        }
        if( midVal > num) {
            // move up the row
            return twoDArraySearch(a, start, mid-1, num );
        }
        return false;
    }

    boolean binarySearch(int a[], int start, int end, int num) {
        //Base Case
        if(start > end) return false;

        // Recursive Case for Search
        int mid = start + (end-start)/2;
        int mid_val = a[mid];

        if(mid_val == num )
            return true;
        else if(mid_val > num)
            return  binarySearch(a, start, mid-1, num);
        else
            return  binarySearch(a, mid+1, end, num);
    }
}
