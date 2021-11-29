package com.greatlearning.applications;

import com.greatlearning.model.Employee;
import com.greatlearning.services.CredentialServices;
import java.util.Scanner;

public class EmailApplication {

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the First Name : ");
        String firstName = scan.next();
        System.out.print("Enter the Last Name : ");
        String lastName = scan.next();
        System.out.println("Please enter the department from the following");
        System.out.println("1. Technical\n2. Admin\n3. Human Resource\n4. Legal");
        System.out.print("Department is : ");
        int option = scan.nextInt();
        scan.close();

        // Program to exit if invalid option is entered
        if ((option < 1) || (option > 4)) {
            System.out.println("Invalid Department option selected. You have to choose values between 1 to 4.");
        }
        else {
            // Assigning employee name via parametrized Constructor()
            Employee emp = new Employee(firstName, lastName);
            CredentialServices cs = new CredentialServices(firstName, lastName, option);
            cs.generateEmailAddress();
            cs.generatePassword();
            cs.showCredentials();
        }
    }
}
