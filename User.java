package financeManager;

import java.util.*;

public class User {
    private List<Transaction> transactions = new ArrayList<>();
    private double budget;

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public List<Transaction> getTransactions() { // Added method
        return transactions;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public double getBudget() {
        return budget;
    }

    public double calculateTotalIncome() {
        double totalIncome = 0;
        for (Transaction t : transactions) {
            if (t.getType().equalsIgnoreCase("Income")) {
                totalIncome += t.getAmount();
            }
        }
        return totalIncome;
    }

    public double calculateTotalExpenses() {
        double totalExpenses = 0;
        for (Transaction t : transactions) {
            if (t.getType().equalsIgnoreCase("Expense")) {
                totalExpenses += t.getAmount();
            }
        }
        return totalExpenses;
    }

    public void generateReport() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions to report.");
        } else {
            for (Transaction t : transactions) {
                System.out.println(t);
            }
        }
    }
}
