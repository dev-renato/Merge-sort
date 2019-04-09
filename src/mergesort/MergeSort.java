
package mergesort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int []v = {1, 2, 23, 512, 1024, 12, 0, -1, 12, 33, 56, 98, 54,
        65, 87, 87, 32, 1, 333, 6565};
        int []w = new int[v.length];
        
        mergeSort(v, w, 0, v.length-1);
        System.out.println(Arrays.toString(v));
    }
    private static void mergeSort(int[] v, int[] w, int inicio, int fim) {
        if(inicio < fim){
            int meio = (inicio + fim) / 2;
            mergeSort(v, w, inicio, meio);
            mergeSort(v, w, meio+1, fim);
            intercalar(v, w, inicio, meio, fim);
        }
    }

    private static void intercalar(int[] v, int[] w, int inicio, int meio, int fim) {
        for(int k = inicio; k <= fim; k++){
            w[k] = v[k];
        }
        int i = inicio;
        int j = meio + 1;
        
        for(int k = inicio; k <= fim; k++){
            if (i > meio) v[k] = w[j++];
            else if (j > fim) v[k] = w[i++];
            else if (w[i] < w[j]) v[k] = w[i++];
            else v[k] = w[j++];
        }
    }
    
}
