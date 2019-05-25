package StringTest;

import java.util.Scanner;

public class Replace {
    public static String replaceSpace(String str) {
        return str == null ? null : str.replaceAll(" ", "%20");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = "";
        if (sc.hasNextLine()) {
            s = sc.nextLine();
        }
        System.out.println(Replace.replaceSpace(s));
    }
}
