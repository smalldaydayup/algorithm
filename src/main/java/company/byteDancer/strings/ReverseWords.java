package company.byteDancer.strings;

public class ReverseWords {

    public static void main(String[] args) {
        System.out.println("  i love you  ".trim());
        System.out.println(reverWOrds("  hello    world!  "));
    }

    public static String reverWOrds(String str) {
        String str1 = str.trim();
        String[] strs = str1.split(" ");
        int len = strs.length;

        StringBuilder sb = new StringBuilder();
        for (int i = len - 1; i >= 0; i--) {
            if (strs[i].equals("")) {
                continue;
            }

            sb.append(strs[i]);
            if (i != 0) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}
