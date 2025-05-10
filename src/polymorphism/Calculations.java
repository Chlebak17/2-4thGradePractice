package polymorphism;

public class Calculations {
    public static void main(String[] args) {

        int a = 5;
        long b = 65;
        double c = 2.5;

        System.out.println(Math.sum(a,a));

        System.out.println(Math.sum(b,b));

        System.out.println(Math.sum(c,c));

        System.out.println(Math.weirdSum(a,b));

        System.out.println(Math.weirdSum(b,a));

    }
}
