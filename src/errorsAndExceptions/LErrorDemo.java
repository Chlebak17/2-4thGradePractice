package errorsAndExceptions;

public class LErrorDemo {
    public static void main(String[] args)
    {
        int num = 789;
        int reversednum = 0;
        int remainder;

        while (num != 0) {

            // pro správné fungování by jsme měli na řádku 14 použít modulo %
            // místo toho bylo použito dělení /
            remainder = num / 10;
            System.out.println("Step one remainder: " + remainder);
            reversednum
                    = reversednum * 10
                    + remainder;
            System.out.println("Step two reversednum: " + reversednum);

            num /= 10;
            System.out.println("Step three num: " + num);

        }
        System.out.println("Reversed number is "
                + reversednum);
    }
}
