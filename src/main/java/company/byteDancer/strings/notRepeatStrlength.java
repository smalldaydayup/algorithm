package company.byteDancer.strings;

import java.util.LinkedList;
import java.util.List;

public class notRepeatStrlength {
    public static void main(String[] args) {
        String str = "pwwkew";
        System.out.println(lengthOfStr(str));
    }

    public static int lengthOfStr(String str) {
        if (str.length() == 0) return 0;
        List<Character> list = new LinkedList<>();
        List<Character> curList = new LinkedList<>();
        int max = 0;

        char[] arrs = str.toCharArray();
        for (int i = 0; i < arrs.length; i++) {
            char value = arrs[i];
            int index = list.indexOf(value);

            if (index != -1) {
                list = list.subList(index + 1, list.size());
            } else {
                list.add(value);
                max = Math.max(max, list.size());
            }
        }

        return max;
    }

}
