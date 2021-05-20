package QuickSort;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] x = new int[]{2, 5, 3, 1, 1};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(x);
        for (int i = 0; i < x.length; i++){
            System.out.print(x[i] + " ");
        }
    }
}
