public class Manipulator{
    public String trimAndConcat(String cadenaA, String cadenaB){
        return cadenaA.trim() + cadenaB.trim();
    }
    public int getIndexOrNull(String cadena, char letter){
        return cadena.indexOf(letter);
    }
        public int getIndexOrNull(String cadena, String subString){
        return cadena.indexOf(subString);
    }
       public String concatSubstring(String cadenaA, int inicio, int fin, String cadenaB){
        return cadenaA.substring(inicio, fin) + cadenaB;
    }
}