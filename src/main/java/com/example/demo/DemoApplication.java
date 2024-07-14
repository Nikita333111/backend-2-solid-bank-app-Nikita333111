package com.example.demo;

import com.example.demo.entity.AccountType;
import com.example.demo.io.AccountBasicCLI;
import com.example.demo.io.MyCLI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

        ApplicationContext context = new ClassPathXmlApplicationContext("props.xml");
        System.out.println("Welcome to CLI bank service");


        MyCLI myCLI = (MyCLI) context.getBean(MyCLI.class);
        AccountBasicCLI basicCLI = (AccountBasicCLI) context.getBean(AccountBasicCLI.class);
        String clientID = "1";
        Scanner scanner = new Scanner(System.in);

        System.out.println("1 - show accounts \n" +
                "2 - create account \n" +
                "3 - deposit \n" +
                "4 - withdraw \n" +
                "5 - transfer \n" +
                "6 - this message \n" +
                "7 - exit");
        label:
        while (true){
            String cli = scanner.nextLine();
            String regex = "^[1-7]$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(cli);
            if (!matcher.matches()) {
                System.out.println(cli + " не соответствует списку команд.");
                continue;
            }

            switch (cli) {
                case "1":
                    basicCLI.getAccounts(clientID);
                    break;
                case "2":
                    System.out.println("Choose account type \n" +
                            Arrays.toString(AccountType.values()));
                    try {
                        basicCLI.createAccountRequest(clientID);
                        System.out.println("Bank account created");
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex + "\n" + "Invalid account type");
                        continue;
                    }
                    break;
                case "7":
                    System.out.println("Application closed !");
                    break label;
            }
        }
    }

}






















