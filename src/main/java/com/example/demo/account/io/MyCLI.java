package com.example.demo.account.io;

import com.example.demo.account.util.AccountType;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Scanner;
@Component
@Getter
public class MyCLI implements CLIUI{
    private Scanner scanner;

    public MyCLI() {
        scanner = new Scanner(System.in);
    }
    public MyCLI(Scanner scanner){
        this.scanner = scanner;
    }

    public double requestClientAmount() {
        System.out.println("Type Amount of money");
        return scanner.nextDouble();
    }

    public String requestClientAccountNumber() {
        System.out.println("Type account ID");
        return scanner.nextLine();
    }

    public AccountType requestAccountType() throws IllegalArgumentException{
        System.out.println("Choose account type \n" +
                Arrays.toString(AccountType.values()));
        return AccountType.valueOf(scanner.nextLine());
    }
}











