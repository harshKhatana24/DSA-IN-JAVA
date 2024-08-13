import java.util.*;

public class quickSort {
    public static void main(String[] args) {
        int[] arr = {50,20,40,30,70,90,10};
        System.out.println(Arrays.toString(arr));
        quickS(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickS(int[] arr, int l, int h){
        if (l<h){
            //1. Divide the array into two subarrays
            int m = Partition(arr,l,h);
            //2. Conquer those subproblems via recursion
            quickS(arr, l, m);
            quickS(arr, m+1, h);
            //3. no need to combine
        }
    }

    private static int Partition(int[] arr, int l, int h) {
        int i = l;

        int pivot = arr[i];

        for (int j=l+1;j<=h;j++){
            if (arr[j] <= pivot){
                i = i+1;
                // swap(arr[i], arr[j]);
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // swap(arr[l], arr[i]);
        int temp = arr[l];
        arr[l] = arr[i];
        arr[i] = temp;

        return i;
    }

}
