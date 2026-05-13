/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.quickchat;

import java.util.Scanner;

/**
 *Main console application for QuickChatApp - Part 1 
 * This is the entry point of the program
 * 
 * @author Lorenza 
 */
public class QuickChatApp {
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Login login = new Login();
        
         //Banner
    printBanner(" === QUICKCHAT - REGISTRATION & LOGIN === ");
    
    System.out.println("=== CREATE YOUR ACCOUNT ===\n");
    
    System.out.print("Enter first name: ");
    String firstName = scanner.nextLine().trim();
    
    System.out.print("Enter last name: ");
    String lastName = scanner.nextLine().trim();
    
    System.out.print("Enter username (e.g., kyl_1): ");
    String username = scanner.nextLine().trim();
    
    System.out.print("Enter password: ");
    String password = scanner.nextLine().trim();
    
    System.out.print("Enter cell number (e.g., +27350264895): ");
    String cell = scanner.nextLine().trim();
    
    System.out.println("\n=== VALIDATION RESULTS ===");
    
    System.out.println(login.checkUserName(username)
            ? "✅ Username successfully captured."
            : "❌ Username is not correctly formatted; please ensure that your username contains an underscore and is no more than 5 characters in length.");
    
    System.out.println(login.checkPasswordComplexity(password)
            ? "✅ Password successfully captured."
            : "❌ Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.");
    
    System.out.println(login.checkCellPhoneNumber(cell)
            ? "✅ Cell number successfully captured."
            : "❌ Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.");
    
    String registerMessage = login.registerUser(username, password, cell, firstName, lastName);
    System.out.println("\n" + registerMessage);
    
    //Login section only if registration succeeded
    if (registerMessage.contains("Registered successfully")) {
        System.out.println("\n=== LOGIN TO YOUR ACCOUNT ===");
        System.out.print("Enter username: ");
        String loginUser = scanner.nextLine().trim();
        System.out.print("Enter password: ");
        String loginPass = scanner.nextLine().trim();
        
        boolean isLoggedIn = login.loginUser(loginUser, loginPass);
        System.out.println("\n" + login.returnLoginStatus(isLoggedIn));
    }
    
    scanner.close();
    System.out.println("\nThank you for using QuickChat!");
    }
    
 
    private static void printBanner(String title){
    
        System.out.println("╔════════════════════════════════════════════════════════════╗");
        System.out.println("║                  " + title + "            ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝\n");
        }  
    }
    
    
    
    
    

