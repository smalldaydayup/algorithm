package company.byteDancer.strings;

import javafx.beans.binding.StringBinding;

import java.util.*;

public class inclusion {
    public static void main(String[] args) {

//        System.out.println(checkInclusion("ab", "eidbaooo"));
        String s1 = "eidbcacooo";

        List<String> ss = getClusions("abcc");

        for (String s: ss) {
            if (s1.contains(s)) {
                System.out.println(true);
                break;
            }
        }

    }


    public static List<String> getClusions(String s1) {
        StringBuilder sb = new StringBuilder();

        HashSet<String> set = new HashSet<>();
        LinkedList <StringBuilder> setSb = new LinkedList<>();

        char[] arr = s1.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                StringBuilder tmp = new StringBuilder(Character.toString(arr[i]));
                setSb.add(tmp);
                set.add(tmp.toString());
            } else {
                LinkedList<StringBuilder> newSbList = new LinkedList<>();
                for (int j = 0; j < setSb.size(); j++) {
                    StringBuilder value = setSb.get(j);

                    for (int k = 0; k <= value.length(); k++) {
                        StringBuilder tmpSb = new StringBuilder(value.toString());
                        StringBuilder newSb = tmpSb.insert(k, arr[i]);
                        String str = newSb.toString();
                        if(set.contains(str)) {

                        } else {
                            newSbList.add(newSb);
                            set.add(str);
                        }
                    }
                    set.remove(value.toString());

                }
                setSb = newSbList;
            }
        }

        return new LinkedList<String>(set);
    }



    public static boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        for (int i = 0; i < arr1.length; i++) {
            Integer value = map1.get(arr1[i]);
            if(value == null) {
                map1.put(arr1[i], 1);
            } else {
                map1.put(arr1[i], value + 1);
            }
        }

        for (int i = 0; i < arr2.length; i++) {
            Integer value = map2.get(arr2[i]);
            if(value != null) {
                map2.put(arr2[i], value + 1);
            } else {
                map2.put(arr2[i], 1);
            }
        }

        for (char c : map1.keySet()) {
            Integer value1 = map1.get(c);
            Integer value2 = map2.get(c);

            if (value2 == null || value1.compareTo(value2) > 0) {
                return false;
            }
        }

        return true;
    }
}
