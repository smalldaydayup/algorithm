package company.byteDancer.strings;

public class SimplifyPath {
    public static void main(String[] args) {
        System.out.println(simplifyPath("/a//b////c/d//././/.."));
    }

    public static String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return path;
        }
        path = p1(path);// 处理多斜杠重复问题
        path = p2(path);// 处理单点回到本目录问题
        path = p3(path);// 处理双点回到上一级目录问题
        // 如果最后一个字符是斜杆将其删除
        if (path.length() != 1 && path.charAt(path.length() - 1) == '/') {
            path = path.substring(0, path.length() - 1);
        }
        return path;
    }

    public static String p1(String path) {
        StringBuilder res = new StringBuilder();
        int i = 0;
        while (i < path.length()) {
            res.append('/');
            while (i < path.length() && path.charAt(i) == '/') {
                i ++;
            }
            while (i < path.length() && path.charAt(i) != '/') {
                res.append(path.charAt(i));
                i ++;
            }
        }
        return res.toString();
    }

    public static String p2(String path) {
        StringBuilder res = new StringBuilder();
        int i = 0;
        while (i < path.length()) {
            // 这个条件判断意思是如果当前字符是一个'.'，如果这个字符前面是'/'后面也是'/'（或者后面就是path的结尾）,那么就会跳过这几个字符相当于留在了当前目录。
            if (i != 0 &&path.charAt(i - 1) == '/' && path.charAt(i) == '.'
                    && (i == path.length() - 1 || path.charAt(i + 1) == '/')) {
                i += 2;// 跳过字符
                continue;
            } else {
                res.append(path.charAt(i));
                i ++;
            }
        }
        return res.toString();
    }


    public static String p3(String path) {
        StringBuilder res = new StringBuilder();
        int i = 0;
        while (i < path.length()) {
            // 跟函数p2同理，如果当前字符是'.'，前一个字符是'/'，后一个字符是'.'，后面第二个字符是'/'，这种情况就需要把前面读入的一级目录删除，这就相当于执行了返回上一级目录的操作。
            if (i != 0 && path.charAt(i - 1) == '/' && path.charAt(i) == '.' &&
                    (i == path.length() - 2 || (path.charAt(i + 1) == '.' && path.charAt(i + 2) == '/'))) {
                if (res.length() != 1) {// 如果当前目录没有内容即在根目录(res此时的长度会为1)就不需要跳转到上一级目录了
                    int j = res.length() - 1;
                    res.delete(j, j + 1);
                    j --;
                    while (res.charAt(j) != '/') {
                        res.delete(j, j + 1);
                        j --;
                    }
                }
                i += 3; // 跳过字符
            } else {
                res.append(path.charAt(i));
                i ++;
            }
        }
        return res.toString();
    }


}
