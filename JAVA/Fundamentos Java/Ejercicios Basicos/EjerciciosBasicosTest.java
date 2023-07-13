import java.util.Arrays;

public class EjerciciosBasicosTest {
    public static void main(String[] args) {
        EjerciciosBasicos basicos = new EjerciciosBasicos();
        int[] list = { 1, 5, 10, -2, -11 };
        // Imprimir 1 - 255
        basicos.algoritmo1();
        // Imprimir los Números Impares Entre 1 - 255
        basicos.algoritmo2();
        // Imprimir la Suma
        basicos.algoritmo3();
        // Recorrer un Arreglo
        basicos.algoritmo4(list);
        // Encontrar el Máximo
        basicos.algoritmo5(list);
        // Obtener el Promedio
        basicos.algoritmo6(list);
        // Arreglo con Números Impares
        basicos.algoritmo7();
        // Mayor que Y
        System.out.println(basicos.algoritmo8(list, 2));
        // Valores al Cuadrado
        basicos.algoritmo9(list);
        System.out.println(Arrays.toString(list));
        // Eliminar Números Negativos
        basicos.algoritmo10(list);
        System.out.println(Arrays.toString(list));
        // Mínimo, Máximo y Promedio
        basicos.algoritmo11(list);
        // Cambiando los Valores del Arreglo
        basicos.algoritmo12(list);
        System.out.println(Arrays.toString(list));
    }

}
