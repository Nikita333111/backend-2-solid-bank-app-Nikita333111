package com.example.demo;

import com.example.demo.account.util.AccountType;
import com.example.demo.account.io.AccountBasicCLI;
import com.example.demo.account.io.MyCLI;
import com.example.demo.transaction.io.TransactionDepositCLI;
import com.example.demo.transaction.io.TransactionWithdrawCLI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DemoApplication.class, args);

        System.out.println("Welcome to CLI bank service");
        String clientID = "1";

        MyCLI myCLI = context.getBean(MyCLI.class);
        AccountBasicCLI basicCLI = context.getBean(AccountBasicCLI.class);
        TransactionDepositCLI transactionDepositCLI = context.getBean(TransactionDepositCLI.class);
        TransactionWithdrawCLI transactionWithdrawCLI = context.getBean(TransactionWithdrawCLI.class);

        String menuMessage = """
                1 - show accounts\s
                2 - create account\s
                3 - deposit\s
                4 - withdraw\s
                5 - transfer\s
                6 - this message\s
                7 - exit""";
        System.out.println(menuMessage);

        label:
        while (true){;
            String input = myCLI.getScanner().nextLine();
            if (!input.matches("[1-7]"))
                continue;

            switch (input) {
                case "1":
                    basicCLI.getAccounts(clientID);
                    break;
                case "2":
                    try {
                        basicCLI.createAccountRequest(clientID);
                        System.out.println("Bank account created");
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex + "\n" + "Invalid account type");
                        continue;
                    }
                    break;
                case "3":
                    try {
                        transactionDepositCLI.depositMoney(clientID);
                    } catch (Exception e) {
                        System.out.println(e + " Incorrect input data");
                    }
                    break;
                case "4":
                    try {
                        transactionWithdrawCLI.withdrawMoney(clientID);
                    } catch (Exception e){
                        System.out.println(e + " Incorrect input data !");
                    }
                    break;
                case "6":
                    System.out.println(menuMessage);
                    break;
                case "7":
                    System.out.println("Application closed !");
                    break label;
                default:
                    System.out.println("Command not recognized!\n");
                    break;
            }
        }
    }

}






















