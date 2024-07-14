package com.example.demo.io;

import com.example.demo.entity.AccountType;

import java.util.Scanner;

public class MyCLI implements CLIUI{
    private Scanner scanner;

    public MyCLI() {
        scanner = new Scanner(System.in);
    }
    public MyCLI(Scanner scanner){
        this.scanner = scanner;
    }

    public double requestClientAmount() {
        return 0.0;
    }

    public String requestClientAccountNumber(){
        return "";
    }

    public AccountType requestAccountType() throws IllegalArgumentException{
        return AccountType.valueOf(scanner.nextLine());
    }
}











