import java.util.Arrays;
import java.util.ArrayList;
public class PuzzleJavaTest{
    public static void main(String[] args) {
        PuzzleJava puzzle = new PuzzleJava();
        int[] list = {3,5,1,2,7,9,8,13,25,32};
        ArrayList<String> listNames = new ArrayList<String>();
        listNames.add("Nancy");
        listNames.add("Jinichi");
        listNames.add("Fujibayashi");
        listNames.add("Momochi");
        listNames.add("Ishikawa");
        puzzle.numberAboveTen(list);
        puzzle.nameRandom(listNames);
    }
    
}
