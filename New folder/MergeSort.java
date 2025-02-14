/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mergesort;

/**
 *
 * @author Nicholas Leong EDUV4551823
 */
public class MergeSort {
    public static int givenArr[] = new int[]{4, 2, 6, 5, 3, 9};
                                                //l       m         r    
    public static void mergeArray(int arr[], int num1, int num2, int num3){
        int sizeArray1 = num2 - num1 + 1;//finds sizes of two subarrays
        int sizeArray2 = num3 - num2;
        
        int tempArr1[] = new int[sizeArray1];//creates temp arrays
        int tempArr2[] = new int[sizeArray2];
        
        for (int i = 0; i < sizeArray1; ++i){//copy data to temp arrays
            tempArr1[i] = arr[num1 + i];
        }
        for (int j = 0; j < sizeArray2; ++j){
            tempArr2[j] = arr[num2 + 1 + j];
        }
        
        //merging temp arrays
        
        int index1 = 0;//initial indices of 1st and 2nd subarrays
        int index2 = 0;
        
        int k = num1;
        while (index1 < sizeArray1 && index2 < sizeArray2){
            if (tempArr1[index1] <= tempArr2[index2]){
                arr[k] = tempArr1[index1];
                index1++;
            }else{
                arr[k] = tempArr2[index2];
                index2++;
            }
            k++;
        }
        
        while (index1 < sizeArray1){//copies any remaining elements of tempArr1[]
            arr[k] = tempArr1[index1];
            index1++;
            k++;
        }
        
        while (index2 < sizeArray2){//copies any remaining elements of tempArr2[]
            arr[k] = tempArr2[index2];
            index2++;
            k++;
        }        
    }
    
    
    //sorts array
    public static void sortArray(int arr[], int l, int r){
        if (l < r){
            int middle = l + (r - l) / 2;//finds middle point
            sortArray(arr, l, middle);//sorts first half
            sortArray(arr, middle + 1, r);//sorts second half
            mergeArray(arr, l, middle, r);//merges sorted halves
        }
    }
 
    public static void printArray(int arr[]){
        int arrLength = arr.length;
        String display = "";
        for (int i = 0; i < arrLength; ++i){
            display += arr[i] + " ";
        }
        System.out.println(display);
    }

    public static void main(String args[]){     
        System.out.println("Provided array: ");
        printArray(givenArr);

        sortArray(givenArr, 0, givenArr.length - 1);

        System.out.println("\nSorted array: ");
        printArray(givenArr);
    }
}
