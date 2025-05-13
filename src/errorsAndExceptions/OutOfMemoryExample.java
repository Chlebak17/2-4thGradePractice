package errorsAndExceptions;

import java.util.ArrayList;
import java.util.List;

public class OutOfMemoryExample {
    public static void main(String[] args) {
        List<int[]> memoryHog = new ArrayList<>();

        try {
            while (true) {
                // Přidávání velkých polí do seznamu, aby se rychle vyčerpala paměť
                memoryHog.add(new int[1_000_000]);
                System.out.println("Přidáno další pole. Velikost seznamu: " + memoryHog.size());
            }
        } catch (OutOfMemoryError e) {
            System.err.println("Došlo k OutOfMemoryError!");
            e.printStackTrace();
        }
    }
}

