public class QuickSort{

    public void sort(int[] x){

        sort(x, 0, x.length-1);
    }

    private void sort(int[] x, int lo, int hi){

        if (lo < hi){

            int p = partition(x, lo, hi);
            sort(x, lo, p-1);
            sort(x, p+1, hi);
        }
    }

    private int partition(int[] x, int begin, int end){

        int key = x[end];

        int i = begin - 1;

        for (int j = begin; j<end; j++){

            if (x[j] <= key){

                i++;

                Utils.swap(x, i, j);
            }
        }

        Utils.swap(x, end, i+1);
        return i+1;
    }
}