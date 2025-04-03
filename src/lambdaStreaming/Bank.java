package lambdaStreaming;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Bank {
    public static void main(String[] args) {
        List<Payment> payments = Payment.generateSamplePayments(100);
        payments.forEach(System.out::println);
        System.out.println("--------------------------------");

        //vypsat všechny completed platby
        payments.stream()
                .filter(p -> p.getStatus().equals("Completed"))
                .forEach(System.out::println);

        //vypsat platby vyšší jak 200
        payments.stream()
                .filter(p -> p.getAmount() >= 200)
                .sorted(Comparator.comparing(Payment::getTransactionDate))
                .forEach(System.out::println);

        double averageOf3 = payments.stream()
                .filter(p -> p.getUserId().equals("U003"))
                .mapToDouble(Payment::getAmount)
                .average()
                .orElse(0);

        double součetPlateb = payments.stream()
                .filter(p -> p.getCategory().equals("Entertainment"))
                .mapToDouble(Payment::getAmount)
                .sum();

        System.out.println("----------------------\nprůměr: " + averageOf3 + "\n" + součetPlateb);

        //mapping:
        //mapa kde status je klíč
        Map<String, List<Payment>> statusMap = payments.stream()
                .collect(Collectors.groupingBy(Payment::getStatus));

        //mapa kde category je klíč a počet transakcí hodnota
        Map<String, Long> statesMap = payments.stream()
                .collect(Collectors.groupingBy(
                        Payment::getCategory,
                        Collectors.counting()
                ));

        //mapa kde category je klíč a průměr v ní hodnota
        Map<String, Double> averages = payments.stream()
                .collect(Collectors.groupingBy(
                        Payment::getCategory,
                        Collectors.averagingDouble( Payment::getAmount)
                        //a stejne tak existuje i summingDouble/Int/Long..
                ));

        //vlastni kategorie: dnes, v tydnu, posledni mesic
        LocalDate today = LocalDate.now();
        Map<String, List<Payment>> timePayments = payments.stream()
                .collect(Collectors.groupingBy(payment -> {
                    LocalDate dateOfTransaction = payment.getTransactionDate().toLocalDate();
                    if (dateOfTransaction.isEqual(today)){
                        return "Today";
                    } else if(dateOfTransaction.isAfter(today.minusDays(7))){
                        return "Week";
                    } else if (dateOfTransaction.isAfter(today.minusDays(30))) {
                        return "Month";
                    } else {
                        return "Older";
                    }
                }));
    }
}
