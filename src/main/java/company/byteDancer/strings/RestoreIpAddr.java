package company.byteDancer.strings;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RestoreIpAddr {
    private static final int fullStep = 4;

    public static void main(String[] args) {
        ArrayList<String> res = new ArrayList<>();
        System.out.println(validIp("25511135", 2));

        restoreIpAddr("25525511135", 1, new ArrayList<String>(), res);
        System.out.println(res.toString());
    }


    public static void restoreIpAddr(String str, int step, List<String> list, List<String> res) {
        if (step == 4) {
            if (validSubIp(str)) {
                list.add(str);
                String result =  geneIp(list);
                res.add(result);
            }
        } else {
            //
            String firstStr = str.substring(0, 1);
            String remainStr = str.substring(1);
            if (validSubIp(firstStr) && validIp(remainStr, step + 1)) {
                ArrayList<String> strs = new ArrayList<>(list);
                strs.add(firstStr);
                restoreIpAddr(remainStr, step + 1, strs, res);
            }

            //
            if (str.length() > 1) {
                firstStr = str.substring(0, 2);
                remainStr = str.substring(2);

                if (validSubIp(firstStr) && validIp(remainStr, step + 1)) {
                    ArrayList<String> strs = new ArrayList<>(list);
                    strs.add(firstStr);
                    restoreIpAddr(remainStr, step + 1, strs, res);
                }
            }

            if (str.length() > 2) {
                firstStr = str.substring(0, 3);
                remainStr = str.substring(3);

                if (validSubIp(firstStr) && validIp(remainStr, step + 1)) {
                    ArrayList<String> strs = new ArrayList<>(list);
                    strs.add(firstStr);
                    restoreIpAddr(remainStr, step + 1, strs, res);
                }
            }

        }
    }

    public static boolean validIp(String str, int step) {
        return (1 * (fullStep - step + 1)) <= str.length() &&  (3 * (fullStep - step + 1)) >= str.length();
    }

    public static boolean validSubIp(String str) {
        int value = Integer.valueOf(str);
        return value >= 0 && value <= 255;
    }

    public static String geneIp(List<String> list) {
        StringBuilder sb =  new StringBuilder();

        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i != list.size() -1) {
                sb.append(".");
            }
        }

        return sb.toString();
    }
}
