/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.patternmatchingalgorithm;

/**
 *
 * @author FamilyLaptop
 */
public class PatternMatchingAlgorithm {

    public static void search(String text, String pattern){
        int length1 = text.length();
        int length2 = pattern.length();
        int count = 0;
        
        int i = 0;
        int j;
        
        for (j = length2 - 1; j < length1;){
            if (pattern.equals(text.substring(i, j + 1))){
                count++;
            }
            i++;
            j++;
        }
        
        System.out.println("Pattern \"" + text + "\" is found " + count + " times");
    }
    
    public static void main(String[] args) {
        String pattern = "ABABBABBAABAAABBBAAB";
        String text = "ABA";
        search(pattern, text);
        search(pattern, "BA");
    }
}
