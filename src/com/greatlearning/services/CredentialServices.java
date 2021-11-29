package com.greatlearning.services;

import com.greatlearning.model.Employee;

import java.util.Locale;
import java.util.Random;

public class CredentialServices {

        String password;
        String domainAddress = ".abc.com";
        String email;
        String firstName;
        String lastName;
        int department;

    public CredentialServices(String fName, String lName, int option) {
        this.firstName = fName;
        this.lastName = lName;
        this.department = option;

    }

    public void generatePassword() {
            int length = 8; // Setting length of the password based on the requirements

            // All the four mandatory requirements for password generation are enforced here by mandatory assignment from each category
            String upperCaseAlphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String lowerCaseAlphabets = "abcdefghijklmnopqrstuvwxyz";
            String specialCharacters = "!@#$%&_)(+*";
            String digits = "1234567890";
            Random random = new Random();
            char[] pwd = new char[length];

            pwd[0] = upperCaseAlphabets.charAt(random.nextInt(upperCaseAlphabets.length()));
            pwd[1] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));

            for (int i = 2; i<7; i++)
            {
                pwd[i] = lowerCaseAlphabets.charAt(random.nextInt(lowerCaseAlphabets.length()));
            }
            pwd[7] = digits.charAt(random.nextInt(digits.length()));
            password = String.valueOf(pwd);
        }

        public void generateEmailAddress() {
            // Based on the dept of the employee, email id is generated after converting the name to lowercase

            switch (department){
                case 1: {
                    email = firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+"tech"+domainAddress;
                    break;
                }
                case 2 : {
                    email = firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+"admin"+domainAddress;
                    break;
                }
                case 3 : {
                    email = firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+"hr"+domainAddress;
                    break;
                }
                case 4 : {
                    email = firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+"legal"+domainAddress;
                    break;
                }
                default : { email = "NA"; }
            }
        }

        public void showCredentials() {
            System.out.println("Dear "+firstName+ ", your generated credential are as follows");
            System.out.println("Email --> " + email);
            System.out.println("Password --> " + password);
        }

}
