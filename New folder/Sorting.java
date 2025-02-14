/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author FamilyLaptop
 * Implement a bubble sort algorithm that will arrange element in a descending order.
 */
public class Sorting {
    public static int arrOrig[] = {17, 3, 22, 24, 10, 25, 6, 10, 8, 28};
    public static int arrCopy[] = {17, 3, 22, 24, 10, 25, 6, 10, 8, 28};
    public static final int arrLength = arrOrig.length;
    public static double arrFloat[] = {0.172, 0.302, 0.222, 0.242, 0.102, 0.252, 0.602, 0.102, 0.802, 0.282};
    
    //=======================Start Bubble=======================================
    
    public static void bubbleSort(int arr[]){
        boolean swopped;
        int temp;
        
        for (int i = 0; i < arrLength - 1; i++){
            swopped = false;
            for (int j = 0; j < arrLength - i - 1; j++){
                if (arr[j] < arr[j + 1]){
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    swopped = true;
                }
            }
            
            if (!swopped){
                break;
            }
        }
    }
    
    //==========================End Bubble======================================
    //==========================Start Merge=====================================
    
    public static void mergeSort(int arr[], int n, int m){//actual sorting method
        if (n < m){
            int middle = n + (m - n) / 2;//middle point
            mergeSort(arr, n, middle);
            mergeSort(arr, middle + 1, m);
            mergeArray(arr, n, middle, m);
        }
    }
    
    public static void mergeArray(int arr[], int num1, int num2, int num3){//merges arrays
        int sizeArray1 = num2 - num1 + 1;//size of 2 subarrays
        int sizeArray2 = num3 - num2;
        
        int tempArr1[] = new int[sizeArray1];//temp arrays
        int tempArr2[] = new int[sizeArray2];
        
        for (int i = 0; i < sizeArray1; i++){//copy data to temp arrays
            tempArr1[i] = arr[num1 + i];
        }
        
        for (int j = 0; j < sizeArray2; j++){
            tempArr2[j] = arr[num2 + j + 1];
        }
        
        int index1 = 0;//initial indices of subarray 1 and 2
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
        
        //copies any remaining elements of tempArr1[]
        while (index1 < sizeArray1){
            arr[k] = tempArr1[index1];
            index1++;
            k++;
        }
        
        while (index2 < sizeArray2){
            arr[k] = tempArr2[index2];
            index2++;
            k++;
        }
        
    }
    
    //==========================End Maerge======================================
    //==========================Start Selection=================================
    
    public static void selectionSort(int arr[]){
        for (int i = 0; i < arrLength - 1; i++){
            int minElementID = i;//assumes current element holds min element
            
            for (int j = i + 1; j < arrLength; j++){
                if (arr[j] < arr[minElementID]){
                    minElementID = j;//finds actual min ID
                }
            }
            
            int temp = arr[i];//move min element to correct position
            arr[i] = arr[minElementID];
            arr[minElementID] = temp;
        }
    }
    
    //==========================End Selection===================================
    //==========================Start Insertion=================================
    
    public static void insertionSort(int arr[]){
        int n = arr.length;
        for (int i = 1; i < n; i++){
            int key = arr[i];
            int j = i - 1;
            
            //move elements of arr[0..i-1] that are greater than key, to one position ahead of their current position
            while (j >= 0 && arr[j] > key){
                arr[j + 1] = arr[j];
                j -= 1;
            }
            arr[j + 1] = key;
        }

    }
    
    //==========================End Insertion===================================
    //==========================Start Bucket====================================
    
    public static void insertionSort(List<Double> buckets){
        double key;//will sort indiv buckets
        for (int i = 1; i < buckets.size(); ++i){
            key = buckets.get(i);
            int j = i - 1;
            while (j >= 0 && buckets.get(j) > key){
                buckets.set(j + 1, buckets.get(j));
                j--;
            }
            buckets.set(j + 1, key);
        }
    }
    
    public static void bucketSort(double arr[]){
        //create empty buckets
        List<Double>[] buckets = new ArrayList[arrLength];
        for (int i = 0; i < arrLength; i++){
            buckets[i] = new ArrayList<>();
        }
        
        //put array elements into different buckets
        for (int i = 0; i < arrLength; i++){
            int bi = (int) (arrLength * arr[i]);
            buckets[bi].add(arr[i]);
        }
        
        //sort individual buckets using insertion sort
        for (int i = 0; i < arrLength; i++){
            insertionSort(buckets[i]);
        }
        
        //concatenate all buckets into arr[]
        int index = 0;
        for (int i = 0; i < arrLength; i++){
            for (int j = 0; j < buckets[i].size(); j++){
                arr[index++] = buckets[i].get(j);
            }
        }
    }
    
    //==========================End Bucket======================================
    //==========================Start Radix=====================================
    
    public static void radixSort(int arr[]){
        //get max num to know num of digits
        int m = getMax(arr);
        
        // Do counting sort for every digit. Note that
        // instead of passing digit number, exp is passed.
        // exp is 10^i where i is current digit number
        for (int exp = 1; m/exp > 0; exp *= 10){
            countSort(arr, exp);
        }   
    }
    
    public static int getMax(int arr[]){//get max value of arr[]
        int max = arr[0];
        for (int i = 1; i < arrLength; i++){
            if (arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
    
    //does counting sort of arr[] according to digit represented by exp
    public static void countSort(int arr[], int exp){
        int output[] = new int[arrLength];
        int i;
        int count[] = new int[12];
        Arrays.fill(count, 0);
        
        //store number of occurrences in count[]
        for (i = 0; i < arrLength; i++){
            count[(arr[i]/exp) % 10]++;
        }
        
        //change count[i] so that count[i] now contains actual position of this digit in output
        for (i = 1; i < 10; i++){
            count[i] += count[i-1];
        }
        
        //build output array
        for (i = arrLength - 1; i >= 0; i--){
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
        
        //copy output array to arr[], so that arr[] now 
        //contains sorted nums according to current digit
        for (i = 0; i < arrLength; i++){
            arr[i] = output[i];
        }
    }
    
    //=========================End Radix========================================
    //=========================Start Quick======================================
    //partition function
    public static int partition(int[] arr, int low, int high){
        int pivot = arr[high];//choode pivot point
        
        //index of smaller element and indicates the right position of pivot found so far
        int i = low - 1;
        
        //Traverse arr[low..high] and move all smaller elements to the left
        //side. Elements from low to i are smaller after every iteration
        for (int j = low; j <= high - 1; j++){
            if (arr[j] < pivot){
                i++;
                swap(arr, i, j);
            }
        }
        
        swap(arr, i + 1, high);
        return i + 1;
    }
    
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void quickSort(int[] arr, int low, int high){
        if (low < high){
            //pi is the partition - return index of pivot
            int pi = partition(arr, low, high);
            
            //recursion calls for smaller elements
            //and greater or equals elements
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    
    //=========================End Quick========================================
    
    public static void display(int arr[], String sortType){
        String toDisplay = "";
        for (int f = 0; f < arrLength; f++){
            toDisplay += arr[f] + " ";
        }
        System.out.println("\n" + sortType + "\n" + toDisplay);
    }
    
    public static void display(double arr[], String sortType){
        String toDisplay = "";
        for (int f = 0; f < arrLength; f++){
            toDisplay += arr[f] + " ";
        }
        System.out.println("\n" + sortType + "\n" + toDisplay);
    }
    
    public static void resetArray(){
        for (int x = 0; x < arrCopy.length; x++){
            arrOrig[x] = arrCopy[x];
        }
    }

    public static void main(String[] args) {
        String origArray = "";
        for (int z = 0; z < arrLength; z++){
            origArray += arrOrig[z] + " ";
        }
        System.out.println("Original Array:\n" + origArray);
        
        bubbleSort(arrOrig);
        display(arrOrig, "Bubble Sort - Descending");
        resetArray();
        
        mergeSort(arrOrig, 0, arrLength - 1);
        display(arrOrig, "Merge Sort");
        resetArray();
        
        selectionSort(arrOrig);
        display(arrOrig, "Selection Sort");
        resetArray();
        
        insertionSort(arrOrig);
        display(arrOrig, "Insertion Sort");
        resetArray();
        
        bucketSort(arrFloat);
        display(arrFloat, "Bucket Sort");
        resetArray();
        
        radixSort(arrOrig);
        display(arrOrig, "Radix Sort");
        resetArray();
        
        quickSort(arrOrig, 0, arrLength - 1);
        display(arrOrig, "Quick Sort");
        resetArray();
    }
}
