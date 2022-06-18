import java.util.Random;

public abstract class etc {
    public static Integer[] criarArray(int tamanho, int n_max){
        Random gerador = new Random();
        Integer[] array = new Integer[tamanho];
        for(int i = 0; tamanho > i; i++){
            array[i] = gerador.nextInt(n_max);
        }
        return array;
    }

    public static Integer[] invertArray(Integer[] array){
        for(int i = 0; i < array.length/2; i++){
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
        return array;
    }

    public static Integer[] deixarQuaseOrdenado(Integer[] array){
        Random gerador = new Random();
        int qntdPraEmbaralhar = (int)(array.length*0.2);
        while(qntdPraEmbaralhar >= 0){
            int pos1 = gerador.nextInt(array.length);
            int pos2 = gerador.nextInt(array.length);
            int temp = array[pos1];
            array[pos1] = array[pos2];
            array[pos2] = temp;
            qntdPraEmbaralhar--;
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

    public static String verTamMax_table(Object texto, int max){
        String tex = texto.toString();
        String tex2;
        boolean rev = false;
        while(tex.length() < max){
            if(rev == false){
                rev = true;
                tex = tex + " ";
            }else{
                rev = false;
                tex = " " + tex;
            }
        }
        while(tex.length() > max){
            tex2 = "";
            for(int i = 0; i < tex.length() - 1; i++){
                tex2 += tex.charAt(i); 
            }
            tex = tex2;
        }
        return tex;
    }
}
