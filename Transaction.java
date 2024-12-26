package financeManager;

public class Transaction {
    private String date;
    private double amount;
    private String category; // Category of the transaction
    private String type; // "Income" or "Expense"
    private String description;

    public Transaction(String date, double amount, String category, String type, String description) {
        this.date = date;
        this.amount = amount;
        this.category = category;
        this.type = type;
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public String getCategory() { // Added method
        return category;
    }

    @Override
    public String toString() {
        return "Date: " + date + ", Amount: " + amount + ", Category: " + category + ", Type: " + type + ", Description: " + description;
    }
}
