/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.selectionsort;

/**
 *
 * @author Nicholas Leong EDUV4551823
 */
public class SelectionSort {
    static int givenArray[] = {3, 4, 1, 9, 11, 7, 7, 98, 13, 21, 3, 16};

    public static void main(String[] args) {
        int minElementID;
        int temp;
        
        String display = "";//variable to display neatly
        
        //displays original array neatly
        System.out.println("Selection Unsorted Array: ");
        for (int k = 0; k < givenArray.length; k++){
            display += givenArray[k] + " ";
        }
        System.out.println(display);
                
        for (int i = 0; i < givenArray.length - 1; i++){
            minElementID = i;//assumes current index's element is minimum
            
            //searches for actual minimum
            for (int j = i + 1; j < givenArray.length; j++){
                if (givenArray[j] < givenArray[minElementID]){
                    minElementID = j;//updates minimum element's index
                }
            }
            
            temp = givenArray[i];
            givenArray[i] = givenArray[minElementID];
            givenArray[minElementID] = temp;
        }
        
        display = "";//displays sorted array neatly
        System.out.println("Selection Sorted Array: ");
        for (int l = 0; l < givenArray.length; l++){
                display += givenArray[l] + " ";
        }
        System.out.println(display);
        
    }
}
