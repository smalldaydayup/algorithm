package spring.aop;

public class SubjectNew {
    int a, b;
    public SubjectNew(int a, int b) {};

    public SubjectNew() {};

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        SubjectNew sn = new SubjectNew(10, 20);
        Class cls = sn.getClass();

        Object ni = cls.newInstance();
        SubjectNew ns = (SubjectNew) ni;
        ns.a = 50;
        ns.b = 50;


        System.out.println(  ni instanceof SubjectNew );

    }
}

