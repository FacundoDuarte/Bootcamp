import java.util.ArrayList;

public class ListExceptions {
    public static void tryCast(ArrayList<Object> myList) {
        try {
            for (int i = 0; i < myList.size(); i++) {
                int castedValue = (int) myList.get(i);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e); // TODO: handle exception
        }
    }
}