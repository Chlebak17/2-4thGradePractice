package lambdaStreaming;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Payment implements Comparable<Payment>{
    private String transactionId;
    private String userId;
    private double amount;
    private LocalDateTime transactionDate;
    private String paymentMethod;
    private String status;
    private String category;

    final static Comparator<Payment> COMPARE_BY_STATUS = new Comparator<Payment>() {
        @Override
        public int compare(Payment o1, Payment o2) {
            return o1.status.compareTo(o2.status);
        }
    };

    public Payment(String transactionId, String userId, double amount, LocalDateTime transactionDate,
                   String paymentMethod, String status, String category) {
        this.transactionId = transactionId;
        this.userId = userId;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.paymentMethod = paymentMethod;
        this.status = status;
        this.category = category;
    }

    public String getTransactionId() { return transactionId; }
    public String getUserId() { return userId; }
    public double getAmount() { return amount; }
    public LocalDateTime getTransactionDate() { return transactionDate; }
    public String getPaymentMethod() { return paymentMethod; }
    public String getStatus() { return status; }
    public String getCategory() { return category; }
    public void setTransactionId(String transactionId) {this.transactionId = transactionId;}
    public void setUserId(String userId) {this.userId = userId;}

    @Override
    public String toString() {
        return String.format("Payment{ID=%s, User=%s, Amount=%.2f, Date=%s, Method=%s, Status=%s, Category=%s}",
                transactionId, userId, amount, transactionDate, paymentMethod, status, category);
    }

    public static List<Payment> generateSamplePayments(int count) {
        Random random = new Random();
        List<String> users = Arrays.asList("U001", "U002", "U003", "U004", "U005");
        List<String> paymentMethods = Arrays.asList("Credit Card", "Debit Card", "PayPal", "Bank Transfer");
        List<String> statuses = Arrays.asList("Completed", "Pending", "Failed");
        List<String> categories = Arrays.asList("Groceries", "Entertainment", "Utilities", "Travel", "Shopping");

        return IntStream.range(0, count).mapToObj(i -> new Payment(
                "TXN" + (1000 + i),
                users.get(random.nextInt(users.size())),
                10 + (500 * random.nextDouble()),
                LocalDateTime.now().minusDays(random.nextInt(30)),
                paymentMethods.get(random.nextInt(paymentMethods.size())),
                statuses.get(random.nextInt(statuses.size())),
                categories.get(random.nextInt(categories.size()))
        )).collect(Collectors.toList());
    }


    @Override
    public int compareTo(Payment o) {
        return (int) (this.amount - o.amount);
    }
}
