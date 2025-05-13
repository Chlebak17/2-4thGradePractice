package letsWorkWithFiles;

import java.io.*;
import java.nio.file.Paths;

public class FastRead {
    public static void main(String[] args) {
        BufferedReader br;
        {
            try {
                br = new BufferedReader(new FileReader("file.txt"));
                String line;

                long start = System.nanoTime();
                while ((line = br.readLine()) != null){
                    System.out.println(line);
                }
                br.close();
                long end = System.nanoTime();
                long finalTime = ((end - start)/1_000_000);

                System.out.println("Time: " + finalTime + " milisec");

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
