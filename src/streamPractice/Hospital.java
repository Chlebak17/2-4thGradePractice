package streamPractice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Hospital {
    public static void main(String[] args) throws IOException {
        List<Patient> patients = Files.lines(Paths.get("health.csv")).skip(1)
                .map(p -> p.split(","))
                .map(p -> new Patient(
                        p[0],Integer.parseInt(p[1]),p[2],p[3],Double.parseDouble(p[4])
                )).toList();
        System.out.println(patients.get(0));
        //patients.forEach(System.out::println);


        long soucet = patients.stream()
                .filter(p -> p.getAge() >= 20 && p.getAge() <= 50)
                .filter(p -> p.getBloodType().equals("A-"))
                .count();
        //System.out.println(soucet);

        long allO = patients.stream()
                .filter(p -> p.getBloodType().equals("O+") || p.getBloodType().equals("O-"))
                .count();

        System.out.println((double) allO/patients.size()*100);

        long onlyUniqueWomen = patients.stream()
                .filter(patient -> patient.getGender().equals("Female"))
                .distinct()
                .count();

        long allWomen = patients.stream()
                        .filter(p -> p.getGender().equals("Female"))
                                .count();


        System.out.println(onlyUniqueWomen);
        System.out.println(allWomen);
        long notUniqueWomen = allWomen - onlyUniqueWomen;
        System.out.println("Not unique womens: " + notUniqueWomen);

        System.out.println("All - and under= 1000");
        /*
        patients.stream()
                .filter(p -> p.getBill() <= 10000 && p.getBloodType().contains("-"))
                .forEach(System.out::println);
        */

        System.out.println("All + under= 5000");

        /*
        patients.stream()
                .filter(p -> p.getBill() <= 50000 && p.getBloodType().contains("+"))
                .forEach(System.out::println);
        */

        List<Patient> canGiveToBplus = patients.stream()
                .filter(patient -> patient.getBloodType().contains("B") || patient.getBloodType().contains("O"))
                .toList();

        double averageBillMan = canGiveToBplus.stream()
                .filter(p -> p.getGender().equals("Male"))
                .mapToDouble(Patient::getBill)
                .average()
                .orElse(0);

        double billSummaryWomen = patients.stream()
                .mapToDouble(Patient::getBill)
                .sum();

        /*
        System.out.println("There is" + canGiveToBplus.size() + " who can give to B+");
        System.out.println("And average bill out of every man is: " + averageBillMan);
        System.out.println("Summary of all womens bills is: " + billSummaryWomen);
        */

    }
}
