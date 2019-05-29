package StringTest;

public class StringPlus {
    public static void main(String[] args) {
        String string = "";
        for (int i=0;i<10000;i++){
            string += "hello";
        }
    }

}
