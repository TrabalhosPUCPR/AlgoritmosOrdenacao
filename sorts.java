public class sorts {
    public static void main(String[] args) throws Exception {

        int tamanhoDoConjunto = 10_000;

        int[] arrayDesordenado = etc.criarArray(tamanhoDoConjunto, 10000);
        int[] arrayOrdenado = quicksort(arrayDesordenado.clone(), 0, arrayDesordenado.length-1);
        int[] arrayQuaseOrdenado = etc.deixarQuaseOrdenado(arrayOrdenado.clone());
        int[] arrayDescrecente = etc.invertArray(arrayOrdenado.clone());

        
        // QUICK SORT
        float[] temposQuickSort = new float[3];
        System.out.print("QuickSort em array Desordenado: ");
        etc.comecarCronometro();
        quicksort(arrayDesordenado, 0, arrayDesordenado.length-1);
        temposQuickSort[0] = etc.pararCronometro();
        System.out.println("Tempo: " + temposQuickSort[0] + " s");

        System.out.print("QuickSort em array Quase ordenado: ");
        etc.comecarCronometro();
        quicksort(arrayQuaseOrdenado, 0, arrayQuaseOrdenado.length-1);
        temposQuickSort[1] = etc.pararCronometro();
        System.out.println("Tempo: " + temposQuickSort[1] + " s");

        System.out.print("QuickSort em array Decrescente: ");
        etc.comecarCronometro();
        quicksort(arrayDescrecente, 0, arrayDescrecente.length-1);
        temposQuickSort[2] =  etc.pararCronometro();
        System.out.println("Tempo: " + temposQuickSort[2] + " s");
        //etc.printArray(quicksort(array, 0, array.length-1));

        // SHELL SORT 
        float[] temposShellSort = new float[3];


        //HEAP SORT
        float[] temposHeapSort = new float[3];
        
        // eu n to com vontade de fazer uma tabela dinamica, entao vai ficar assim
        System.out.println("");
        System.out.println("_".repeat(65));
        System.out.print("|");     System.out.print(etc.verTamMax_table("Tamanho do conjunto: " + tamanhoDoConjunto, 63));     System.out.println("|");
        System.out.print("|");     System.out.print("_".repeat(63));       System.out.println("|");
        System.out.print("|");     System.out.print(etc.verTamMax_table(" ", 15));      System.out.print("|");     System.out.print(etc.verTamMax_table("Tempo obtidos pelos algoritmos", 47));      System.out.println("|");
        System.out.print("|");     System.out.print("_".repeat(15));       System.out.print("|");     System.out.print("_".repeat(47));       System.out.println("|");
        System.out.print("|");     System.out.print(etc.verTamMax_table("Algoritmo", 15));     System.out.print("|");     System.out.print(etc.verTamMax_table("QuaseOrdenado", 15));     System.out.print("|");      System.out.print(etc.verTamMax_table("Desordenado", 15));     System.out.print("|");      System.out.print(etc.verTamMax_table("Decrescente", 15));     System.out.println("|");
        System.out.print("|");     System.out.print("_".repeat(15));     System.out.print("|");     System.out.print("_".repeat(15));     System.out.print("|");      System.out.print("_".repeat(15));     System.out.print("|");      System.out.print("_".repeat(15));     System.out.println("|");
        System.out.print("|");     System.out.print(etc.verTamMax_table("QuickSort", 15));     System.out.print("|");     System.out.print(etc.verTamMax_table(temposQuickSort[0] + " s", 15));     System.out.print("|");      System.out.print(etc.verTamMax_table(temposQuickSort[1] + " s", 15));     System.out.print("|");      System.out.print(etc.verTamMax_table(temposQuickSort[2] + " s", 15));     System.out.println("|");
        System.out.print("|");     System.out.print("_".repeat(15));     System.out.print("|");     System.out.print("_".repeat(15));     System.out.print("|");      System.out.print("_".repeat(15));     System.out.print("|");      System.out.print("_".repeat(15));     System.out.println("|");
        System.out.print("|");     System.out.print(etc.verTamMax_table("ShellSort", 15));     System.out.print("|");     System.out.print(etc.verTamMax_table(temposShellSort[0] + " s", 15));     System.out.print("|");      System.out.print(etc.verTamMax_table(temposShellSort[1] + " s", 15));     System.out.print("|");      System.out.print(etc.verTamMax_table(temposShellSort[2] + " s", 15));     System.out.println("|");
        System.out.print("|");     System.out.print("_".repeat(15));     System.out.print("|");     System.out.print("_".repeat(15));     System.out.print("|");      System.out.print("_".repeat(15));     System.out.print("|");      System.out.print("_".repeat(15));     System.out.println("|");
        System.out.print("|");     System.out.print(etc.verTamMax_table("HeapSort", 15));     System.out.print("|");     System.out.print(etc.verTamMax_table(temposHeapSort[0] + " s", 15));     System.out.print("|");      System.out.print(etc.verTamMax_table(temposHeapSort[1] + " s", 15));     System.out.print("|");      System.out.print(etc.verTamMax_table(temposHeapSort[2] + " s", 15));     System.out.println("|");
        System.out.print("|");     System.out.print("_".repeat(15));     System.out.print("|");     System.out.print("_".repeat(15));     System.out.print("|");      System.out.print("_".repeat(15));     System.out.print("|");      System.out.print("_".repeat(15));     System.out.println("|");

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
