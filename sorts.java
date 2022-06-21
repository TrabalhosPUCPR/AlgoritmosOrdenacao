public class sorts {
    public static void main(String[] args) throws Exception {

        int tamanhoDoConjunto = 50_000;
        // stack overflow garantido nos ~50.000 quando o quicksort ta ordenando um array descrescente
        // bogo sort demora normalmente 10 segundos pra ordena um array com 10 elementos...

        Integer[] arrayDesordenado = etc.criarArray(tamanhoDoConjunto, 10_000);

        //Integer[] testeOrdenado = quicksort(arrayDesordenado.clone(), 0, arrayDesordenado.length-1);
        //Integer[] testeOrdenado = shellsort(arrayDesordenado.clone());
        //Integer[] testeOrdenado = heapsort(arrayDesordenado.clone());
        //Integer[] testeOrdenado = selectionsort(arrayDesordenado.clone());
        //Integer[] testeOrdenado = combsort(arrayDesordenado.clone());
        //Integer[] testeOrdenado = bogosort(arrayDesordenado.clone(), 25);

        // QUICK SORT
        String[] temposQuickSort = new String[3];
        System.out.println("QuickSort: array desordenado...");
        etc.comecarCronometro();
        Integer[] arrayOrdenado = quicksort(arrayDesordenado.clone(), 0, arrayDesordenado.length-1);
        temposQuickSort[0] = String.valueOf(etc.pararCronometro()) + " s";
        System.out.println("QuickSort: pronto");

        Integer[] arrayQuaseOrdenado = etc.deixarQuaseOrdenado(arrayOrdenado.clone());
        Integer[] arrayDescrecente = etc.invertArray(arrayOrdenado.clone());

        System.out.println("QuickSort: array quase ordenado...");
        etc.comecarCronometro();
        quicksort(arrayQuaseOrdenado.clone(), 0, arrayQuaseOrdenado.length-1);
        temposQuickSort[1] = String.valueOf(etc.pararCronometro()) + " s";
        System.out.println("QuickSort: pronto");

        try{
            System.out.println("QuickSort: array decrescente...");
            etc.comecarCronometro();
            quicksort(arrayDescrecente.clone(), 0, arrayDescrecente.length-1);
            temposQuickSort[2] = String.valueOf(etc.pararCronometro()) + " s";
            System.out.println("QuickSort: pronto");
        }catch(StackOverflowError e){
            temposQuickSort[2] = "StackOverflow";
            System.out.println("QuickSort: overflow!");
        }

        // SHELL SORT 
        System.out.println("ShellSort: array desordenado...");
        String[] temposShellSort = new String[3];
        etc.comecarCronometro();
        shellsort(arrayDesordenado.clone());
        temposShellSort[0] = String.valueOf(etc.pararCronometro()) + " s";
        System.out.println("ShellSort: pronto");

        System.out.println("ShellSort: array quase ordenado...");
        etc.comecarCronometro();
        shellsort(arrayQuaseOrdenado.clone());
        temposShellSort[1] = String.valueOf(etc.pararCronometro()) + " s";
        System.out.println("ShellSort: pronto");

        System.out.println("ShellSort: array decrescente...");
        etc.comecarCronometro();
        shellsort(arrayDescrecente.clone());
        temposShellSort[2] = String.valueOf(etc.pararCronometro()) + " s";
        System.out.println("ShellSort: pronto");

        //HEAP SORT
        String[] temposHeapSort = new String[3];
        System.out.println("HeapSort: array desordenado...");
        etc.comecarCronometro();
        heapsort(arrayDesordenado.clone());
        temposHeapSort[0] = String.valueOf(etc.pararCronometro()) + " s";
        System.out.println("HeapSort: pronto");

        System.out.println("HeapSort: array quase ordenado...");
        etc.comecarCronometro();
        heapsort(arrayQuaseOrdenado.clone());
        temposHeapSort[1] = String.valueOf(etc.pararCronometro()) + " s";
        System.out.println("HeapSort: pronto");

        System.out.println("HeapSort: array decrescente...");
        etc.comecarCronometro();
        heapsort(arrayDescrecente.clone());
        temposHeapSort[2] = String.valueOf(etc.pararCronometro()) + " s";
        System.out.println("HeapSort: pronto");

        //SELECTION SORT
        String[] temposSelectionSort = new String[3];
        System.out.println("SelectionSort: array desordenado...");
        etc.comecarCronometro();
        selectionsort(arrayDesordenado.clone());
        temposSelectionSort[0] = String.valueOf(etc.pararCronometro()) + " s";
        System.out.println("SelectionSort: pronto");

        System.out.println("SelectionSort: array quase ordenado...");
        etc.comecarCronometro();
        selectionsort(arrayQuaseOrdenado.clone());
        temposSelectionSort[1] = String.valueOf(etc.pararCronometro()) + " s";
        System.out.println("SelectionSort: pronto");

        System.out.println("SelectionSort: array decrescente...");
        etc.comecarCronometro();
        selectionsort(arrayDescrecente.clone());
        temposSelectionSort[2] = String.valueOf(etc.pararCronometro()) + " s";
        System.out.println("SelectionSort: pronto");

        // COMB SORT
        String[] temposCombSort = new String[3];
        System.out.println("CombSort: array desordenado...");
        etc.comecarCronometro();
        combsort(arrayDesordenado.clone());
        temposCombSort[0] = String.valueOf(etc.pararCronometro()) + " s";
        System.out.println("CombSort: pronto");

        System.out.println("CombSort: array quase ordenado...");
        etc.comecarCronometro();
        combsort(arrayQuaseOrdenado.clone());
        temposCombSort[1] = String.valueOf(etc.pararCronometro()) + " s";
        System.out.println("CombSort: pronto");

        System.out.println("CombSort: array decrescente...");
        etc.comecarCronometro();
        combsort(arrayDescrecente.clone());
        temposCombSort[2] = String.valueOf(etc.pararCronometro()) + " s";
        System.out.println("CombSort: pronto");

         // BOGO SORT 
         // esse algoritmo e terrivel, mas com MUITA MUITA MUITA MUITA SORTE, ele gera um array ordenado aleatoriamente bem rapido, mas a chance disso acontecer ate num array com tamanho 100 ja e muito baixo
         // o nome representa o algoritmo mt bem
         // a funcao tem um parametro a mais, que e o tempo maximo pra deixar o bogo sort rodando
         int tempoMaximo = 25;
         String[] temposBogoSort = new String[3];
         System.out.println("BogoSort: array desordenado...");
         etc.comecarCronometro();
         bogosort(arrayDesordenado.clone(), tempoMaximo);
         if(etc.pararCronometro() >= tempoMaximo) temposBogoSort[0] = "MuitoTempo";
         else temposBogoSort[0] = String.valueOf(etc.pararCronometro()) + " s";
         System.out.println("BogoSort: pronto");
 
         System.out.println("BogoSort: array quase ordenado...");
         etc.comecarCronometro();
         bogosort(arrayQuaseOrdenado.clone(), tempoMaximo);
         if(etc.pararCronometro() >= tempoMaximo) temposBogoSort[1] = "MuitoTempo";
         else temposBogoSort[1] = String.valueOf(etc.pararCronometro()) + " s";
         System.out.println("BogoSort: pronto");
 
         System.out.println("BogoSort: array decrescente...");
         etc.comecarCronometro();
         bogosort(arrayDescrecente.clone(), tempoMaximo);
         if(etc.pararCronometro() >= tempoMaximo) temposBogoSort[2] = "MuitoTempo";
         else temposBogoSort[2] = String.valueOf(etc.pararCronometro()) + " s";
         System.out.println("BogoSort: pronto");

        // eu n to com vontade de fazer uma tabela dinamica, entao vai ficar assim
        System.out.println("");
        System.out.println("_".repeat(65));
        System.out.print("|");     System.out.print(etc.verTamMax_table("Tamanho do conjunto: " + tamanhoDoConjunto, 63));     System.out.println("|");
        System.out.print("|");     System.out.print("_".repeat(63));       System.out.println("|");
        System.out.print("|");     System.out.print(etc.verTamMax_table(" ", 15));      System.out.print("|");     System.out.print(etc.verTamMax_table("Tempo obtidos pelos algoritmos", 47));      System.out.println("|");
        System.out.print("|");     System.out.print("_".repeat(15));       System.out.print("|");     System.out.print("_".repeat(47));       System.out.println("|");
        System.out.print("|");     System.out.print(etc.verTamMax_table("Algoritmo", 15));     System.out.print("|");     System.out.print(etc.verTamMax_table("QuaseOrdenado", 15));     System.out.print("|");      System.out.print(etc.verTamMax_table("Desordenado", 15));     System.out.print("|");      System.out.print(etc.verTamMax_table("Decrescente", 15));     System.out.println("|");
        System.out.print("|");     System.out.print("_".repeat(15));     System.out.print("|");     System.out.print("_".repeat(15));     System.out.print("|");      System.out.print("_".repeat(15));     System.out.print("|");      System.out.print("_".repeat(15));     System.out.println("|");
        System.out.print("|");     System.out.print(etc.verTamMax_table("QuickSort", 15));     System.out.print("|");     System.out.print(etc.verTamMax_table(temposQuickSort[0], 15));     System.out.print("|");      System.out.print(etc.verTamMax_table(temposQuickSort[1], 15));     System.out.print("|");      System.out.print(etc.verTamMax_table(temposQuickSort[2], 15));     System.out.println("|");
        System.out.print("|");     System.out.print("_".repeat(15));     System.out.print("|");     System.out.print("_".repeat(15));     System.out.print("|");      System.out.print("_".repeat(15));     System.out.print("|");      System.out.print("_".repeat(15));     System.out.println("|");
        System.out.print("|");     System.out.print(etc.verTamMax_table("ShellSort", 15));     System.out.print("|");     System.out.print(etc.verTamMax_table(temposShellSort[0], 15));     System.out.print("|");      System.out.print(etc.verTamMax_table(temposShellSort[1], 15));     System.out.print("|");      System.out.print(etc.verTamMax_table(temposShellSort[2], 15));     System.out.println("|");
        System.out.print("|");     System.out.print("_".repeat(15));     System.out.print("|");     System.out.print("_".repeat(15));     System.out.print("|");      System.out.print("_".repeat(15));     System.out.print("|");      System.out.print("_".repeat(15));     System.out.println("|");
        System.out.print("|");     System.out.print(etc.verTamMax_table("HeapSort", 15));     System.out.print("|");     System.out.print(etc.verTamMax_table(temposHeapSort[0], 15));     System.out.print("|");      System.out.print(etc.verTamMax_table(temposHeapSort[1], 15));     System.out.print("|");      System.out.print(etc.verTamMax_table(temposHeapSort[2], 15));     System.out.println("|");
        System.out.print("|");     System.out.print("_".repeat(15));     System.out.print("|");     System.out.print("_".repeat(15));     System.out.print("|");      System.out.print("_".repeat(15));     System.out.print("|");      System.out.print("_".repeat(15));     System.out.println("|");
        System.out.print("|");     System.out.print(etc.verTamMax_table("SelectionSort", 15));     System.out.print("|");     System.out.print(etc.verTamMax_table(temposSelectionSort[0], 15));     System.out.print("|");      System.out.print(etc.verTamMax_table(temposSelectionSort[1], 15));     System.out.print("|");      System.out.print(etc.verTamMax_table(temposSelectionSort[2], 15));     System.out.println("|");
        System.out.print("|");     System.out.print("_".repeat(15));     System.out.print("|");     System.out.print("_".repeat(15));     System.out.print("|");      System.out.print("_".repeat(15));     System.out.print("|");      System.out.print("_".repeat(15));     System.out.println("|");
        System.out.print("|");     System.out.print(etc.verTamMax_table("CombSort", 15));     System.out.print("|");     System.out.print(etc.verTamMax_table(temposCombSort[0], 15));     System.out.print("|");      System.out.print(etc.verTamMax_table(temposCombSort[1], 15));     System.out.print("|");      System.out.print(etc.verTamMax_table(temposCombSort[2], 15));     System.out.println("|");
        System.out.print("|");     System.out.print("_".repeat(15));     System.out.print("|");     System.out.print("_".repeat(15));     System.out.print("|");      System.out.print("_".repeat(15));     System.out.print("|");      System.out.print("_".repeat(15));     System.out.println("|");
        System.out.print("|");     System.out.print(etc.verTamMax_table("BogoSort", 15));     System.out.print("|");     System.out.print(etc.verTamMax_table(temposBogoSort[0], 15));     System.out.print("|");      System.out.print(etc.verTamMax_table(temposBogoSort[1], 15));     System.out.print("|");      System.out.print(etc.verTamMax_table(temposBogoSort[2], 15));     System.out.println("|");
        System.out.print("|");     System.out.print("_".repeat(15));     System.out.print("|");     System.out.print("_".repeat(15));     System.out.print("|");      System.out.print("_".repeat(15));     System.out.print("|");      System.out.print("_".repeat(15));     System.out.println("|");
    }

    public static Integer[] bogosort(Integer[] arr, int tempo){
        long start = System.currentTimeMillis();
        while(!isSorted(arr) && (System.currentTimeMillis() - start) / 100F <= tempo){
            etc.embaralhar(arr);
        }
        return arr;
    }
    private static boolean isSorted(Integer[] arr){
        for(int i = 1; i < arr.length; i++){
            if(arr[i - 1] > arr[i]){
                return false;
            }
        }
        return true;
    }

    public static Integer[] combsort(Integer[] arr) {
        int n = arr.length;
        int gap = n;
        boolean swapped = true;
        while (gap != 1 || swapped == true) {
            gap = getNextGap(gap);
            swapped = false;
            for (int i = 0; i < n - gap; i++) {
                if (arr[i] > arr[i + gap]) {
                    int temp = arr[i];
                    arr[i] = arr[i + gap];
                    arr[i + gap] = temp;
                    swapped = true;
                }
            }
        }
        return arr;
    }
    static int getNextGap(int gap) {
        gap = (gap * 10) / 13;
        if (gap < 1)
            return 1;
        return gap;
    }

    public static Integer[] selectionsort(Integer[] arr){
        for(int i = 0; i< arr.length; i++){
            for(int j= i + 1; j < arr.length; j++){
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }


    public static Integer[] heapsort(Integer arr[]){
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) heapify(arr, n, i);
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
        return arr;
    }
    private static void heapify(Integer arr[], int n, int i){
        int largest = i; 
        int l = 2 * i + 1; 
        int r = 2 * i + 2; 
        if (l < n && arr[l] > arr[largest]) largest = l;
        if (r < n && arr[r] > arr[largest]) largest = r;
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }


    public static Integer[] shellsort(Integer[] A){
        for(int gap = A.length/2; gap > 0; gap /= 2){
            for(int i = gap; i < A.length; i++){
                int j = i;
                while(j >= gap && A[j] < A[j - gap]){
                    int temp = A[j];
                    A[j] = A[j - gap];
                    A[j - gap] = temp;
                    j-=gap;
                }
            }
        }
        return A;
    }


    public static Integer[] quicksort(Integer[] A, int low, int high){
        if(low >= 0 && high >=0 && low < high){
            int P = partition(A, low, high);
            quicksort(A, low, P-1);
            quicksort(A, P+1, high);
        }
        return A;
    }
    public static Integer partition(Integer[] A, int low, int high){
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
