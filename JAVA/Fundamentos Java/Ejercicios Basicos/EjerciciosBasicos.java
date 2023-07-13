import java.util.ArrayList;

public class EjerciciosBasicos {
    // Imprimir 1 - 255
    public static void algoritmo1() {
        for (int i = 1; i <= 255; i++) {
            System.out.println(i);
        }
    }

    // Imprimir los Números Impares Entre 1 - 255
    public static void algoritmo2() {
        for (int i = 1; i <= 255; i++) {
            if (i % 2 != 0) {
                System.out.println(i);
            }
        }
    }

    // Imprimir la Suma
    public static void algoritmo3() {
        int suma = 0;
        for (int i = 0; i <= 255; i++) {
            suma += i;
            System.out.println("Nuevo numero: " + i + " Suma: " + suma);
        }
    }

    // Recorrer un Arreglo
    public static void algoritmo4(int[] list) {
        for (int i = 0; i <= list.length - 1; i++) {
            System.out.println(list[i]);
        }
    }

    // Encontrar el Máximo
    public static void algoritmo5(int[] list) {
        int maximo = Integer.MIN_VALUE; // Inicializamos el máximo con el valor mínimo posible
        for (int i = 0; i < list.length; i++) {
            if (list[i] > maximo) {
                maximo = list[i];
            }
        }
        System.out.println("El maximo valor es: " + maximo);
    }

    // Obtener el Promedio
    public static void algoritmo6(int[] list) {
        int suma = 0;
        for (int i = 0; i <= list.length - 1; i++) {
            suma += list[i];
        }
        System.out.println("El promedio es: " + (suma / list.length));
    }

    // Arreglo con Números Impares
    public static void algoritmo7() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= 255; i++) {
            if (i % 2 != 0) {
                list.add(i);
            }
        }
        System.out.println(list);
    }

    // Mayor que Y
    public String algoritmo8(int[] list, int num) {
        int contador = 0;
        for (int i = 0; i <= list.length - 1; i++) {
            if (num < list[i]) {
                contador++;
            }
        }
        return "Hay " + contador + " numeros mayores que " + num;
    }

    // Valores al Cuadrado
    public static void algoritmo9(int[] list) {
        for (int i = 0; i < list.length; i++) {
            list[i] = list[i] * list[i];
        }
    }

    // Eliminar Números Negativos
    public static void algoritmo10(int[] list) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] < 0) {
                list[i] = 0;
            }
        }
    }

    // Mínimo, Máximo y Promedio
    public static void algoritmo11(int[] list) {
        int[] listTransformed = new int[3];
        int suma = 0;
        int maximo = Integer.MIN_VALUE;
        int minimo = Integer.MAX_VALUE;
        for (int i = 0; i <= list.length - 1; i++) {
            if (list[i] > maximo) {
                maximo = list[i];
                listTransformed[0] = maximo;
            }
            if (list[i] < minimo) {
                minimo = list[i];
                listTransformed[1] = minimo;
            }
            suma += list[i];
        }
        int promedio = suma / list.length;
        listTransformed[2] = promedio;
        for (int x = 0; x < listTransformed.length; x++) {
            System.out.println(listTransformed[x]);
        }
    }

    // Cambiando los Valores del Arreglo
    public static void algoritmo12(int[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            list[i] = list[i + 1];
        }
        list[list.length - 1] = 0;
    }

}