package ejercicio03;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("----------Ordenamiento con Heapsort----------");

        // Pedir al usuario el tamaño del arreglo
        System.out.print("Ingrese la cantidad de elementos del arreglo: ");
        int n = scanner.nextInt();

        // Crear el arreglo
        int[] arr = new int[n];

        // Pedir al usuario los elementos del arreglo
        System.out.println("Ingrese los elementos del arreglo:");
        for (int i = 0; i < n; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            arr[i] = scanner.nextInt();
        }

        // Crear objeto de la clase HeapSort y ordenar el arreglo
        HeapSort heapSort = new HeapSort();
        heapSort.sort(arr);

        // Mostrar el arreglo ordenado
        System.out.println("Arreglo ordenado: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println("");

        scanner.close();
    }
}
