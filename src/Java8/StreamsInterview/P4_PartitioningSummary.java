package Java8.StreamsInterview;

import java.util.*;
import java.util.stream.Collectors;

class Transaction {
    private String id;
    private double amount;

    public Transaction(String id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    public double getAmount() { return amount; }
}

public class P4_PartitioningSummary {
    public static void main(String[] args) {
        List<Transaction> transactions = List.of(
            new Transaction("TX1", 120.0),
            new Transaction("TX2", 4500.0),
            new Transaction("TX3", 89.5),
            new Transaction("TX4", 12000.0),
            new Transaction("TX5", 350.0)
        );

        double highValueThreshold = 1000.0;

        Map<Boolean, DoubleSummaryStatistics> statsByPartition = transactions.stream()
            .collect(Collectors.partitioningBy(
                tx -> tx.getAmount() >= highValueThreshold,
                Collectors.summarizingDouble(Transaction::getAmount)
            ));

        System.out.println("=== Transaction Summary Statistics ===");
        System.out.println("High Value Stats (>= $" + highValueThreshold + "):");
        System.out.println("  Count: " + statsByPartition.get(true).getCount());
        System.out.println("  Total Sum: $" + statsByPartition.get(true).getSum());
        System.out.println("  Average: $" + statsByPartition.get(true).getAverage());

        System.out.println("\nLow Value Stats (< $" + highValueThreshold + "):");
        System.out.println("  Count: " + statsByPartition.get(false).getCount());
        System.out.println("  Total Sum: $" + statsByPartition.get(false).getSum());
    }
}
