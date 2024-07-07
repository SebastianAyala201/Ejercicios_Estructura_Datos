package ejercicio03;

import java.util.PriorityQueue;

public class HeapSort {

    public void sort(int[] arr) {
        int n = arr.length;

        // Construir el heap (montículo)
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            heap.offer(arr[i]);
        }

        // Extraer elementos del heap uno por uno
        for (int i = 0; i < n; i++) {
            arr[i] = heap.poll();
        }
    }
}
