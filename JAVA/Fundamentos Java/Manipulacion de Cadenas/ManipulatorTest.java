public class ManipulatorTest {
    public static void main(String[] args) {
        Manipulator manipulator = new Manipulator();
        // Manipulacion trimAndConcat(String, String)
        System.out.println(manipulator.trimAndConcat("    Hola     ","     Mundo    ")); // HolaMundo
        
        // Manipulacion getIndexOrNull(String, char)
        char letter = 'n';
        int a = manipulator.getIndexOrNull("Coding", letter);
        int b = manipulator.getIndexOrNull("Hola Mundo", letter);
        int c = manipulator.getIndexOrNull("Saludar", letter);
        System.out.println(a); // 4
        System.out.println(b); // 7
        System.out.println(c); // -1

        // Manipulacion getIndexOrNull(String, String)
        String word = "Hola";
        String subString = "la";
        String notSubString = "mundo";
        System.out.println(manipulator.getIndexOrNull(word, subString)); // 2
        System.out.println(manipulator.getIndexOrNull(word, notSubString)); // -1

        // Manipulacion concatSubstring(String, int, int, String)
        System.out.println(manipulator.concatSubstring("Hola", 1, 3, "mundo")); // olmundo

    }
}
