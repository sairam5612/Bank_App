# Java Bank Account Simulation

This project is a Java-based console application that simulates basic banking operations. It demonstrates core Object-Oriented Programming (OOP) principles by modeling different types of bank accounts with shared and unique behaviors.

## 🚀 Features

* **Account Creation:** Create multiple account types (Savings and Checking).
* **Transaction Handling:** Perform deposits and withdrawals.
* **Security:** All operations like withdrawals and balance checks are secured by a 4-digit PIN.
* **PIN Management:** Securely change an account's PIN.
* **Transaction History:** Automatically records every successful transaction (deposits, withdrawals, interest) with a timestamp.
* **Interest Calculation:** Apply interest specific to each account type.
* **OOP Concepts:** Built using Abstraction, Inheritance, and Method Overriding.

## 📁 Project Structure

The application is built with the following classes:

* **`Account.java` (Abstract Class):** The base class for all account types. It manages shared attributes and methods like `accountNumber`, `balance`, `transactionHistory`, `deposit()`, and `pinChange()`. It defines an `abstract` method `cash_withdrawl()` to be implemented by child classes.
* **`SavingsAccount.java` (Child Class):** Inherits from `Account`. It implements its own `cash_withdrawl()` logic (checking for sufficient balance) and adds a unique `interestApply()` method.
* **`CheckingAccount.java` (Child Class):** Inherits from `Account`. It implements its own `cash_withdrawl()` logic. (Note: This class could be further extended to include overdraft features).
* **`Transaction.java` (Helper Class):** A simple data class used to store information about each transaction (type, amount, new balance, timestamp).
* **`BankApp.java` (Main Class):** The entry point of the application. It contains the `main` method used to simulate bank operations, create accounts, and test all features.

## 🧑‍💻 How to Run

This is a package-based Java console application.

1.  **Clone the repository:**
    ```sh
    git clone [your-repo-link]
    cd [your-project-directory]
    ```

2.  **Compile the code:**
    You must compile all `.java` files from the root directory (the one containing the `com` folder).

    ```sh
    # On Windows
    javac com\BankApp\*.java

    # On macOS/Linux
    javac com/BankApp/*.java
    ```

3.  **Run the application:**
    Run the `BankApp` class, specifying the full package name.

    ```sh
    java com.BankApp.BankApp
    ```

4.  **View the Output:**
    The console will display a step-by-step test of all features, including account creation, PIN verifications, successful transactions, failed transactions (e.g., insufficient funds, wrong PIN), and the final transaction history for each account.
