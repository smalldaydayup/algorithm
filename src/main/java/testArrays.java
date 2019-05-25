import java.util.Arrays;

public class testArrays {

    public static void main(String[] args) {
        int [] a = {1,2,3,4,5,6,7};
        int[] b = Arrays.copyOfRange(a, 0, 1);
        for (int value: b) {
            System.out.println(value);
        }
    }
}
