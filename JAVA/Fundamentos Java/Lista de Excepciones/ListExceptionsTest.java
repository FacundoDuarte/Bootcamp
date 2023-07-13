import java.util.ArrayList;

public class ListExceptionsTest {
    public static void main(String[] args) {
        ListExceptions exceptions = new ListExceptions();
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("Hola Mundo");
        myList.add(48);
        myList.add("Adios Mundo");
        exceptions.tryCast(myList);
    }
}
