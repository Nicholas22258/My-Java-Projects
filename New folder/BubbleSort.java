/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bubblesort;

/**
 *
 * @author Nicholas Leong EDUV4551923
 */
public class BubbleSort {
    static int givenArray[] = {3, 4, 1, 9, 11, 7, 7, 98, 13, 21, 3, 16};
    
    public static void main(String[] args) {
        int temp;//temporary variable to hold a value to be swopped
        boolean swopped;//determines if a value has been swopped or not
        String display = "";//variable to display neatly
        
        //displays original array neatly
        System.out.println("Bubble Unsorted Array: ");
        for (int k = 0; k < givenArray.length; k++){
            display += givenArray[k] + " ";
        }
        System.out.println(display);
        
        //sorts array
        for (int i = 0; i < givenArray.length - 1; i++){
            swopped = false;
            for (int j = 0; j < givenArray.length - 1; j++){
                if (givenArray[j] > givenArray[j + 1]){
                    temp = givenArray[j];//swops values if necessary
                    givenArray[j] = givenArray[j + 1];
                    givenArray[j + 1] = temp;
                    swopped = true;
                }
            }
            
            if (!swopped){
                break;//if now values were swopped
            }
            
        }
        
        display = "";//displays sorted array neatly
        System.out.println("Bubble Sorted Array: ");
        for (int l = 0; l < givenArray.length; l++){
                display += givenArray[l] + " ";
        }
        System.out.println(display);
        
    }
}
