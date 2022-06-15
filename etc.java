import java.util.Random;

public abstract class etc {
    public static int[] criarArray(int tamanho, int n_max){
        Random gerador = new Random();
        int[] array = new int[tamanho];
        for(int i = 0; tamanho > i; i++){
            array[i] = gerador.nextInt(n_max);
        }
        return array;
    }

    public static long start = 0;
    public static void comecarCronometro(){
        etc.start = System.currentTimeMillis();
    }
    public static float pararCronometro(){
        return (System.currentTimeMillis() - start) / 100F;
    }


    public static void printArray(int[] array){
        System.out.print("[");
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i]);
            if(i + 1 != array.length) System.out.print(", ");
        }
        System.out.print("]");
    }
}
