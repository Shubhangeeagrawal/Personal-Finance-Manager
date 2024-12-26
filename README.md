# Personal-Finance-Manager

## **Personal Finance Manager Application**
The **Personal Finance Manager** is a Java-based console application designed to help users track their financial transactions, manage budgets, and gain insights into their spending and income patterns. The application provides an interactive interface with features such as transaction logging, budget management, financial reporting, and visual representation of data.

---
## **File Structure**
PersonalFinanceManager/
├── src/
│   ├── financeManager/
│   │   ├── Transaction.java
│   │   ├── User.java
│   │   ├── FinanceManager.java
│   │   └── Main.java

---

### **Key Components**

#### **1. Transaction Management**
- **Purpose**: To record and organize financial transactions such as expenses and income.
- **Implementation**:
  - Each transaction is represented by the `Transaction` class, which stores details such as:
    - **Date**: When the transaction occurred.
    - **Amount**: The monetary value of the transaction.
    - **Category**: The category of the transaction (e.g., Food, Rent, Entertainment).
    - **Type**: Specifies whether the transaction is an "Income" or "Expense."
    - **Description**: A brief note describing the transaction.
  - Users can add transactions to their account using the `addTransaction()` method.

#### **2. User Profile**
- **Purpose**: To associate financial data with a user and manage budgets.
- **Implementation**:
  - The `User` class stores:
    - A list of transactions (`List<Transaction>`).
    - The user’s budget for managing expenses.
  - Key methods:
    - `addTransaction(Transaction transaction)`: Adds a transaction to the user's profile.
    - `setBudget(double budget)`: Sets a budget for the user.
    - `calculateTotalIncome()`: Calculates the total income from all transactions.
    - `calculateTotalExpenses()`: Calculates the total expenses from all transactions.
    - `generateReport()`: Outputs a detailed financial report for all transactions.

#### **3. Budget Management**
- **Purpose**: To help users set and track a financial budget.
- **Implementation**:
  - Users can set a budget using the `setBudget()` method.
  - The `checkBudget()` method compares the total expenses with the budget and alerts the user if they exceed the budget or informs them of the remaining budget.
  - This feature encourages users to stay within their financial limits.

#### **4. Financial Reports**
- **Purpose**: To provide insights into the user’s financial activities.
- **Implementation**:
  - The `generateReport()` method in the `User` class displays a list of all transactions.
  - The `FinanceManager` class includes methods to:
    - Calculate total income and expenses.
    - Generate category-wise summaries.
  - Bar Graphs (in text format) visually represent category-wise spending, making it easier for users to interpret the data.

#### **5. Bar Graph Representation**
- **Purpose**: To visually display category-wise financial data in a simple text-based bar graph.
- **Implementation**:
  - The `generateBarGraph()` method in the `FinanceManager` class calculates the total amount spent in each category.
  - Each bar represents 100 units of spending, and the graph displays both the category and the corresponding amount.

Example:
```
----- Bar Graph -----
Food           : |||| (400.00)
Rent           : |||||||||||| (1200.00)
Entertainment  : ||| (300.00)
```

#### **6. User Input and Interaction**
- **Purpose**: To provide an interactive interface for the user.
- **Implementation**:
  - The `Main` class uses a `Scanner` object to read input from the user.
  - Menu options include:
    - Adding a transaction.
    - Setting a budget.
    - Generating reports.
    - Displaying total expenses and income.
    - Viewing a bar graph.
    - Checking the budget.
  - Input validation ensures correct data entry using methods like `getValidIntegerInput()` and `getValidDoubleInput()`.

---

### **Program Flow**
1. **Login**:
   - The user logs in with a username and password. While there’s no authentication, it provides a personalized experience by displaying the user's name.

2. **Menu**:
   - A menu is displayed with options for managing transactions, setting budgets, generating reports, and visualizing data.

3. **Adding Transactions**:
   - Users input the details of each transaction (date, amount, category, type, and description).
   - The transaction is stored in the `User`'s list of transactions.

4. **Setting a Budget**:
   - Users set a financial budget to track their spending.

5. **Generating Reports**:
   - Displays all transactions in a detailed format.

6. **Calculating Totals**:
   - Calculates total income and expenses from all transactions.

7. **Visualizing Data**:
   - A text-based bar graph shows category-wise spending.

8. **Checking Budget**:
   - Informs users if they are within their budget or have exceeded it.

---

### **Code Structure**
The program is modular and well-organized into separate classes, each serving a specific purpose:

1. **Transaction.java**:
   - Represents a single financial transaction.
   - Includes fields like `date`, `amount`, `category`, `type`, and `description`.
   - Provides getter methods for accessing transaction details.

2. **User.java**:
   - Stores user-specific data, including a list of transactions and the budget.
   - Contains methods for adding transactions, calculating totals, generating reports, and retrieving data.

3. **FinanceManager.java**:
   - Contains utility methods for calculating total income/expenses and generating category-based summaries.
   - Includes the `generateBarGraph()` method for visual representation.

4. **Main.java**:
   - The entry point of the program.
   - Handles user interaction through a console-based menu.
   - Orchestrates calls to methods in the `User` and `FinanceManager` classes.

---

### **Features**
1. **Add Transactions**:
   - Users can log income and expenses with details such as date, amount, category, and description.

2. **Set a Budget**:
   - Users set a financial limit for their expenses.

3. **Generate Reports**:
   - Displays all transactions in a readable format.

4. **View Total Income and Expenses**:
   - Summarizes financial data.

5. **Visualize Data**:
   - Displays a category-wise bar graph to give insights into spending patterns.

6. **Check Budget**:
   - Alerts users if they exceed their budget and shows remaining funds.

---

### **Advantages**
- **User-Friendly**: Simple, menu-driven interface for easy interaction.
- **Financial Insights**: Provides users with detailed and visual insights into their spending and income.
- **Budget Management**: Encourages users to maintain financial discipline.
- **Extensible Design**: The modular structure makes it easy to add more features in the future, such as recurring transactions or savings goals.

---

### **Sample Outputs**

1. **Report**:
   ```
   ----- Financial Report -----
   Date: 2024-12-27, Amount: 200.00, Category: Food, Type: Expense, Description: Lunch
   Date: 2024-12-28, Amount: 1500.00, Category: Salary, Type: Income, Description: Monthly Salary
   ```

2. **Budget Check**:
   ```
   ----- Budget Check -----
   You are within your budget. Remaining Budget: 800.00
   ```

3. **Bar Graph**:
   ```
   ----- Bar Graph -----
   Food           : |||| (400.00)
   Rent           : |||||||||||| (1200.00)
   Entertainment  : ||| (300.00)
   ```

---

### **Conclusion**
The **Personal Finance Manager** is a robust and practical tool for tracking finances. Its combination of budget management, detailed reporting, and data visualization makes it ideal for users who want to improve their financial literacy and discipline. The modular design ensures scalability, allowing developers to add more advanced features such as recurring transactions, tax calculations, or savings goals in the future.
