import java.io.*;
import java.util.*;

public class QuickSort {

    // ---------------- ALGORITMO QUICK SORT ----------------
    public static void quickSort(int[] arr, int inicio, int fin) {
        if (inicio < fin) {
            int pivote = particion(arr, inicio, fin);
            quickSort(arr, inicio, pivote - 1);
            quickSort(arr, pivote + 1, fin);
        }
    }

    public static int particion(int[] arr, int inicio, int fin) {
        int pivote = arr[fin];
        int i = (inicio - 1);

        for (int j = inicio; j < fin; j++) {
            if (arr[j] <= pivote) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[fin];
        arr[fin] = temp;

        return i + 1;
    }

    // --------------------------- MAIN ---------------------------
    public static void main(String[] args) {
        try {
            // Leer archivo
            Scanner sc = new Scanner(new File("input.txt"));
            List<Integer> lista = new ArrayList<>();

            while (sc.hasNextInt()) {
                lista.add(sc.nextInt());
            }

            int[] datos = lista.stream().mapToInt(i -> i).toArray();

            // Ordenar usando QuickSort
            quickSort(datos, 0, datos.length - 1);

            // Guardar archivo de salida
            PrintWriter pw = new PrintWriter("output.txt");
            for (int n : datos) pw.print(n + " ");
            pw.close();

            System.out.println("¡Quick Sort terminado! Revisa output.txt");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
