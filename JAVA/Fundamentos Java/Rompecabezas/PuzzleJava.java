import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class PuzzleJava {
    public static void numberAboveTen(int[] list) {
        int sum = 0;
        ArrayList<Integer> numbersAboveTen = new ArrayList<Integer>();
        for (int i = 0; i < list.length - 1; i++) {
            sum += list[i];
            if (list[i] > 10) {
                numbersAboveTen.add(list[i]);
            }
        }
        System.out.println("La suma es de: " + sum);
        Integer[] numerosArray = numbersAboveTen.toArray(new Integer[0]);
        System.out.println("Nuevo arreglo con elementos mayores a 10: "+Arrays.toString(numerosArray));
    }

    public static void nameRandom(ArrayList<String>list){
        Random random = new Random(); 
        ArrayList<String> namesLength = new ArrayList<String>();
      for (int i = 0; i < list.size(); i++) {
              if(list.get(i).length() > 5){
            namesLength.add(list.get(i));
          }
          Collections.shuffle(list);
      }
      String[] randomList = list.toArray(new String[0]);
       String[] namesMoreThanFive = namesLength.toArray(new String[0]);
      System.out.println("Arreglo random: "+Arrays.toString(randomList));
      System.out.println("Nombres con mas de 5 caracteres: "+Arrays.toString(namesMoreThanFive));
    }
}