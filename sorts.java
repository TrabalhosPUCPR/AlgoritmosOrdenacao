public class sorts {
    public static void main(String[] args) throws Exception {
        int[] array = etc.criarArray(10000, 10000);
        System.out.println("QuickSort comecou! ");
        etc.comecarCronometro();
        quicksort(array, 0, array.length-1);
        System.out.println("QuickSort Terminou! Tempo: " + etc.pararCronometro() + " s");
        //etc.printArray(quicksort(array, 0, array.length-1));
    }

    public static int[] quicksort(int[] A, int low, int high){
        if(low >= 0 && high >=0 && low < high){
            int P = partition(A, low, high);
            quicksort(A, low, P-1);
            quicksort(A, P+1, high);
        }
        return A;
    }

    public static int partition(int[] A, int low, int high){
        int pivot = A[high];
        int i = low - 1;
        for(int j = low; j <= high - 1; j++){
            if(A[j] <= pivot){
                i++;
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        i++;
        int temp = A[i];
        A[i] = A[high];
        A[high] = temp;
        return i;
    }
}
