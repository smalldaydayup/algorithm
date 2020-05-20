package company.byteDancer.strings;


import java.math.BigDecimal;

public class StringMulti {

    public static void main(String[] args) {
        System.out.println(calChar('9'));
//        System.out.println(calAddString("0000981", "23492398549235463446457567657568457568567436457457568678"));
//        System.out.println(singleCal("981", '3'));
        System.out.println(multiply("9800002342134124124235423514564574567", "32032423542341202304234"));
        BigDecimal b1 = new BigDecimal("9800002342134124124235423514564574567");
        BigDecimal b2 = new BigDecimal("32032423542341202304234");
        System.out.println(b1.multiply(b2));
    }

    public static String multiply(String str1, String str2) {
        String sum = "0";
        int len2 = str2.length();
        char[] arr = str2.toCharArray();
        for (int i = len2 - 1; i >= 0; i--) {
            String str = appendZero(str1, len2 - 1 - i);
            String value = singleCal(str, arr[i]);
            sum = calAddString(sum, value);
        }
        return sum;
    }

    public static String singleCal(String s1, char c){
        int num =  calChar(c);
        if (num == 0) {
            return "0";
        }
        char[] arr = s1.toCharArray();
        int len =  arr.length;
        String sum = "0";
        for (int i = len-1; i >= 0; i--) {
            int value = calChar(arr[i]);
            if (value == 0) {
                continue;
            }
            int result = num * value;
            String valueStr = String.valueOf(result);
            String realValue = appendZero(valueStr, len - 1 -i);
            sum = calAddString(realValue, sum);
        }

        return sum;
    }

    public static String calAddString(String s1, String s2) {
        int firstCur = 0;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int len1 = c1.length;
        int len2 = c2.length;
        if (len1 > len2) {
            c2 = fillArr(c2, len1);

        } else {
            c1 = fillArr(c1, len2);
        }
        int maxLen = Math.max(len1, len2);
        char[] c = new char[maxLen];

        for (int i = maxLen - 1; i >= 0; i--) {
            int value1 = calChar(c1[i]);
            int value2 = calChar(c2[i]);
            int sum = value1 + value2 + firstCur;
            char[] sumArr = twoSizeSum(sum);
            c[i] = sumArr[1];
            firstCur = calChar(sumArr[0]);
        }

        if (firstCur > 0) {
            return firstCur + new String(c);
        }
        return new String(c);
    }

    public static char[] twoSizeSum(int value) {
        char[] arr = new char[]{'0', '0'};
        String s = String.valueOf(value);
        char[] arrStr = s.toCharArray();
        arr[1] = arrStr[arrStr.length - 1];
        if (arrStr.length > 1) {
            arr[0] = arrStr[0];
        }

        return arr;
    }

    public static char[] fillArr(char[] arr, int len) {
        int len1 = arr.length;
        char[] newArr = new char[len];
        for (int i = len-1; i >= 0; i--) {
            if (i < len - len1) {
                newArr[i] = '0';
            } else {
                newArr[i] = arr[i + len1 - len];
            }
        }

        return newArr;
    }

    public static String appendZero(String s, int len) {
        if (len < 1) {
            return s;
        }

        char[] successor = new char[len];
        for (int i= 0; i< successor.length; i ++) {
            successor[i] = '0';
        }

        return s + String.valueOf(successor);
    }

    public static int calChar(char c) {
       return Integer.valueOf(Character.toString(c));
    }
}
