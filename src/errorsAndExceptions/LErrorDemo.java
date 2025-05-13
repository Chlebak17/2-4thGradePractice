package errorsAndExceptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LErrorDemo {

    public static void firstCase(){
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

    public static void secondCase(){
        int[] array = new int[20];
        try {
            array[20] = 20;
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Takhle dlouhý pole není...");
        }

    }

    public static void exceptionCase() throws IOException {
        List<String> list = Files.readAllLines(Paths.get("file.txt"));
    }

    public static void main(String[] args)
    {
        firstCase();
        secondCase();
    }
}
