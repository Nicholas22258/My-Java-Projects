/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.recursion;

import java.util.Scanner;

/**
 *
 * @author FamilyLaptop
 */
public class Recursion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter nth: ");
        int num = scanner.nextInt();
        
        System.out.println("Fibonacci until " + num + ":");
        
        String nums = "";
        for (int i = 0; i < num; i++){
            nums += fibonacci(i) + " ";            
        }
        System.out.println(nums);
        
    }
    
    public static int fibonacci(int num) throws IllegalArgumentException{
        if (num == 0){
            return 0;
        }
        
        if (num == 1 || num == 2){
            return 1;
        }

        return fibonacci(num - 1) + fibonacci(num - 2);
    }
}
