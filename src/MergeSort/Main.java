package MergeSort;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] x = new int[]{7, 5, 3, 1, 11};
        MergeSort.sort(x);
        for(int i = 0; i < x.length; i++){
            System.out.print(x[i] + " ");
        }
    }
}
