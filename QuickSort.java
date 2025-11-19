public class QuickSort {
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

    public static void main(String[] args) {
        int[] datos = {5, 3, 8, 4, 2};
        quickSort(datos, 0, datos.length - 1);

        for (int n : datos) {
            System.out.print(n + " ");
        }
    }
}
