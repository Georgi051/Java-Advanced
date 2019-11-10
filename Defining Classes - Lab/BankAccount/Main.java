package DefiningClassesLab.BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer,BankAccount> accountMap = new HashMap<>();

        String command = scanner.nextLine();
        while (!"End".equals(command)) {
            String[] data = command.split("\\s+");
            String output = "";
            switch (data[0]) {
                case "Create":
                    BankAccount bankAccount = new BankAccount();
                    accountMap.put(bankAccount.getId(),bankAccount);
                    output = String.format("Account ID%d created",bankAccount.getId());
                    break;
                case "Deposit":
                    int id = Integer.parseInt(data[1]);
                    double amount = Double.parseDouble(data[2]);
                    if (accountMap.containsKey(id)){
                        BankAccount currentAccount = accountMap.get(id);
                        currentAccount.deposit(amount);
                        output = String.format("Deposited %.0f to ID%d"
                                ,amount,id);
                    }else {
                        output = "Account does not exist";
                    }
                    break;
                case "SetInterest":
                    double interest = Double.parseDouble(data[1]);
                    BankAccount.setInterestRate(interest);
                    break;
                case "GetInterest":
                    int currentId = Integer.parseInt(data[1]);
                    int years = Integer.parseInt(data[2]);
                    if (accountMap.containsKey(currentId)){
                        double interestRate = accountMap.get(currentId).getInterestRate(years);
                        output = String.format("%.2f",interestRate);
                    }else {
                        output = "Account does not exist";
                    }
                    break;
            }
            command = scanner.nextLine();
            if (!output.isEmpty()){
                System.out.println(output);
            }
        }
    }
}
