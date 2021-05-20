package QuickSort;

public class QuickSort {
    public void quickSort(int[] x){
        quickSort(x, 0, x.length - 1);
    }

    private void quickSort(int[] x, int start, int end){
        if (start < end){
            int pi = partition(x, start, end);
            quickSort(x, start, pi - 1);
            quickSort(x, pi + 1, end);
        }
    }

    private int partition(int[] x, int start, int end){
        int pivot = x[end];
        int k = start, z = end - 1;
        while (k < z) {
            if (x[k] > pivot){
                if(x[z] < pivot){
                    swap(x, k, z);
                    z--;
                    break;
                } else {
                    z--;
                    continue;
                }
            }
            k++;
        }
        swap(x, k, end);
        return end;
    }

    private static void swap(int[] x, int i, int j){
        int t = x[i];
        x[i] = x[j];
        x[j] = t;
    }
}
