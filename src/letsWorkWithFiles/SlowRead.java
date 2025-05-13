package letsWorkWithFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SlowRead {
    public static void main(String[] args) {
        String pathName = "file.txt";
        File source = new File(pathName);
        System.out.println(source.exists());
        Scanner sc = null;

        try {
            sc = new Scanner(source);
            long start = System.nanoTime();
            while (sc.hasNext()){
                System.out.println(sc.nextLine());
            }
            sc.close();
            long end = System.nanoTime();
            long finalTime = ((end - start)/1_000_000);

            System.out.println("Time: " + finalTime + " milisec");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }



    }
}
