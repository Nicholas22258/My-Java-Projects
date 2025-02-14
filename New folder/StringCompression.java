/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.stringcompression;

import java.util.Scanner;

/**
 *
 * @author FamilyLaptop
 */
public class StringCompression {

    public static String compression(String s){
        int count = 1;
        StringBuilder sb = new StringBuilder();
        
        //Counts all chars of string except for last char
        //last char wont be appended by the class StringBuilder
        //as it does not enter the for loop once the length completes the count
        for (int i = 1; i < s.length() - 1; i++){
            if (s.charAt(i) == s.charAt(i - 1)){
                count++;
            }else{
                sb.append(s.charAt(i - 1));
                sb.append(count);
                count = 1;
            }
        }
        
        if (s.length() > 1){
            if (s.charAt(s.length() - 1) == s.charAt(s.length() - 2)){
                count++;
            }else{
                sb.append(s.charAt(s.length() - 2));
                sb.append(count);
                count = 1;
            }
            sb.append(s.charAt(s.length() - 1));
            sb.append(count);
        }
        s = sb.toString();
        System.out.println("The compressed string along with the counts of repeated characters is: \n" + s);
        return s;
    }
    
    public static void main(String[] args) {
        StringCompression str = new StringCompression();
        String s1;
        String s2;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        s1 = scanner.nextLine();
        //trim spaces
        s2 = s1.replaceAll("\\s", "");//removes spaces
        str.compression(s2);
    }
}
