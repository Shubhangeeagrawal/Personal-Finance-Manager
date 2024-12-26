package financeManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FinanceManager {

    public double calculateTotalExpenses(List<Transaction> transactions) {
        return transactions.stream()
                .filter(t -> t.getType().equalsIgnoreCase("Expense"))
                .mapToDouble(Transaction::getAmount)
                .sum();
    }

    public double calculateTotalIncome(List<Transaction> transactions) {
        return transactions.stream()
                .filter(t -> t.getType().equalsIgnoreCase("Income"))
                .mapToDouble(Transaction::getAmount)
                .sum();
    }

    public Map<String, Double> calculateCategoryTotals(List<Transaction> transactions) {
        Map<String, Double> categoryTotals = new HashMap<>();
        for (Transaction t : transactions) {
            categoryTotals.put(
                    t.getCategory(),
                    categoryTotals.getOrDefault(t.getCategory(), 0.0) + t.getAmount()
            );
        }
        return categoryTotals;
    }

    public void generateReport(List<Transaction> transactions) {
        System.out.println("----- Financial Report -----");
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }

    public void generateBarGraph(List<Transaction> transactions) {
        System.out.println("\n----- Bar Graph -----");

        Map<String, Double> categoryTotals = calculateCategoryTotals(transactions);

        for (Map.Entry<String, Double> entry : categoryTotals.entrySet()) {
            String category = entry.getKey();
            double amount = entry.getValue();
            int bars = (int) (amount / 100); // 1 bar represents 100 units
            System.out.printf("%-15s: %s (%.2f)\n", category, "|".repeat(bars), amount);
        }
    }
}
