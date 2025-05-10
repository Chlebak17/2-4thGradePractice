package polymorphism;

public class Math {

    public static int sum(int a, int b) {
        return a + b;
    }

    public static int sum(int a, int b,int c) {
        return a+b+c;
    }

    //toto nebude fungovat jedná o stejné datové typy ve stejném pořadí
    //public static int sum(int b, int a) {
    //   return a+b;
    //}

    public static double sum(double a, double b) {
        return a + b;
    }

    public static long sum(long a, long b) {
        return a + b;
    }

    //tohle funguje datové typy jsou v jiném pořadí
    public static long weirdSum(long a, int b) {
        return a+b;
    }

    public static long weirdSum(int a, long b) {
        return a+b;
    }
}
