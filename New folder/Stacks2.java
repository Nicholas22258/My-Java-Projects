/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.stacks2;

/**
 *
 * @author FamilyLaptop
 */
public class Stacks2 {
    static int[] arr = new int[20];
    static int front = -1;
    static int rear = -1;
    
    public static void stackPush(int num){
        if (isFull()){
            System.out.println("FUUULLLLLLL");
        }else{
            if (isEmpty()){
                front++;
                rear++;
                arr[front] = num;
            }else{
                rear++;
                for (int i = arr.length - 1; i > 0; i--){
                    arr[i] = arr[i - 1];
                }
                arr[front] = num;
            }
        }
    }
    
    public static boolean isEmpty(){
        if (front == -1 && rear == -1){
            return true;
        }else{
            return false;
        }
    }
    
    public static boolean isFull(){
        if (rear == arr.length - 1){
            return true;
        }else{
            return false;
        }
    }
    
    public static int stackPeek(){
        if (front == -1){
            return -1;
        }
        return arr[front];
        
    }
    
    public static int stackPop(){
        int temp = arr[front];
        for (int i = 0; i < arr.length - 1; i++){
            arr[i] = arr[i + 1];
        }
        return temp;
    }
    
    public static boolean stackSearch(int num){
        if (isEmpty()){
            System.out.println("EMPTYYYYYYYYYYYYYYYYYYY");
        }else{
            for (int i = 0; i < arr.length - 1; i++){
                if (arr[i] == num){
                    return true;
                }
            }
        }
        return false;
    }
    
    public static void display(){
        String toDisplay = "";
        for (int i = 0; i < arr.length - 1; i++){
            toDisplay += arr[i] + " ";
        }
        System.out.println(toDisplay);
    }

    public static void main(String[] args) {
        stackPush(55);
        stackPush(27);
        stackPush(11);
        stackPush(48);
        stackPush(2);
        stackPush(99);
        stackPush(65);
        stackPush(23);
        stackPush(79);
        stackPush(12);
        stackPush(56);
        stackPush(89);
        stackPush(48);
        display();
        System.out.println("Peek: " + stackPeek());
        System.out.println("Pop: " + stackPop());
        display();
        System.out.println("Search 99?: " + stackSearch(99));
        System.out.println("Search 33?: " + stackSearch(33));
    }
}
