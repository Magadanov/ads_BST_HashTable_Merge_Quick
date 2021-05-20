package MergeSort;

public class MergeSort {
    public static void sort(int[] x){
        sort(x, 0, x.length - 1);
    }

    private static void sort(int[] x, int start, int end){
        if (start < end){
            int middle = (end + start) / 2;
//            System.out.println("middle " + middle);
            sort(x, start, middle);
            sort(x, middle + 1, end);

            merge(x, start, end, middle);
        }
    }

    public static void merge(int[] x, int start, int end, int middle) {

        int capacity1 = middle - start + 1;
        int capacity2 = end - middle;
        int[] a = new int[capacity1];
        int[] b = new int[capacity2];

        for (int i = 0; i < a.length; ++i){
            a[i] = x[start + i];
        }

        for (int j = 0; j < b.length; ++j){
            b[j] = x[middle + j + 1];
        }

        int i = 0, j = 0;

        int k = start;
        while (i < a.length && j < b.length) {
            int n;
            if (a[i] <= b[j]) {
                n = a[i++];
            }
            else {
                n = b[j++];
            }
            x[k++] = n;
        }
        while (i < a.length) {
            x[k++] = a[i++];
        }
        while (j < b.length) {
            x[k++] = b[j++];
        }
    }
}
