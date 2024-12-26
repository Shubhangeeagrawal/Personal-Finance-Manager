package financeManager;

import java.util.*;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static User user = new User();
    static FinanceManager financeManager = new FinanceManager();

    public static void main(String[] args) {
        login();

        while (true) {
            showMenu();
            int option = getValidIntegerInput("Choose an option: ");
            switch (option) {
                case 1:
                    addTransaction();
                    break;
                case 2:
                    setBudget();
                    break;
                case 3:
                    generateReport();
                    break;
                case 4:
                    calculateTotalExpensesAndIncome();
                    break;
                case 5:
                    generateBarGraph();
                    break;
                case 6:
                    checkBudget(); // Call the budget check method
                    break;
                case 7:
                    System.out.println("Exiting program.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void checkBudget() {
        double totalExpenses = user.calculateTotalExpenses();
        double budget = user.getBudget();

        System.out.println("\n----- Budget Check -----");
        if (totalExpenses > budget) {
            System.out.printf("You have exceeded your budget by %.2f!\n", totalExpenses - budget);
        } else {
            System.out.printf("You are within your budget. Remaining Budget: %.2f\n", budget - totalExpenses);
        }
    }

    private static void login() {
        System.out.println("----- Login -----");
        System.out.print("Enter Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        System.out.println("Login Successful! Welcome, " + username);
    }

    private static void showMenu() {
        System.out.println("\n1. Add Transaction");
        System.out.println("2. Set Budget");
        System.out.println("3. Generate Report");
        System.out.println("4. Calculate Total Expenses and Income");
        System.out.println("5. Display Bar Graph");
        System.out.println("6. Check Budget"); // New option for budget check
        System.out.println("7. Exit");
    }

    private static int getValidIntegerInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }

    private static double getValidDoubleInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }

    private static void addTransaction() {
        scanner.nextLine(); // Clear newline character after integer input
        System.out.print("Enter Date (YYYY-MM-DD): ");
        String date = scanner.nextLine();
        double amount = getValidDoubleInput("Enter Amount: ");
        scanner.nextLine(); // Clear newline character after reading amount
        System.out.print("Enter Category: ");
        String category = scanner.nextLine();
        System.out.print("Enter Type (Income/Expense): ");
        String type = scanner.nextLine();
        System.out.print("Enter Description: ");
        String description = scanner.nextLine();

        Transaction transaction = new Transaction(date, amount, category, type, description);
        user.addTransaction(transaction);
        System.out.println("Transaction added successfully!");
    }

    private static void setBudget() {
        double budget = getValidDoubleInput("Enter your budget: ");
        user.setBudget(budget);
        System.out.println("Budget set successfully!");
    }

    private static void generateReport() {
        System.out.println("\n----- Report -----");
        user.generateReport();
    }

    private static void calculateTotalExpensesAndIncome() {
        System.out.println("\n----- Total Expenses and Income -----");
        double totalIncome = user.calculateTotalIncome();
        double totalExpenses = user.calculateTotalExpenses();
        System.out.println("Total Income: " + totalIncome);
        System.out.println("Total Expenses: " + totalExpenses);
    }

    private static void generateBarGraph() {
        financeManager.generateBarGraph(user.getTransactions());
    }
}
