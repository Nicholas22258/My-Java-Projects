/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.queues;

/**
 *https://www.freecodecamp.org/news/queue-data-structure-definition-and-java-example-code/
 * @author FamilyLaptop
 */
public class Queues {
    
    public int size = 5;
    public int items[] = new int[size];
    public static int front = -1, rear = -1;
//    public String toDisplay = "";
    
//    public boolean isFull(){
//        if (front == 0 || rear == size - 1){
//            return true;
//        }else{
//            return false;
//        }
//    }
    
    public boolean isFull(){
        if (rear == size - 1){
            return true;
        }else{
            return false;
        }
    }
    
//    public boolean isEmpty(){
//        if (front == -1){
//            return true;
//        }else{
//            return false;
//        }
//    }
    
    public boolean isEmpty(){
        if (front == -1 && rear == -1){
            return true;
        }else{
            return false;
        }
    }
    
//    public void enQueue(int element){
//        if (isFull()){
//            System.out.println("QUEUE IS FULL");
//        }else{
//            if (front == -1){
//                front = 0;
//                rear++;
//                items[rear] = element;
//            }
//        }
//    }
    
    public void peek(){
        System.out.println("Front value: " + items[front]);
    }
    
    public void enQueue(int element){
        if (isFull()){
            System.out.println("QUEUE IS FULL");
        }else{
            if (front == -1 && rear == -1){
                front = rear = 0;
//                rear++;
                items[rear] = element;
            }else{
                rear++;
                items[rear] = element;
            }
        }
    }
    
    public void deQueue(){        
        if (isEmpty()){
            System.out.println("Queue is empty");
            return;
        }else{
            if (front >= rear){
                front -= 1;
                rear -= 1;
                for (int j = front; j <= rear; j++){
                    items[front] = items[front + 1];
                }
                size--;
            }else{
                front++;
            }
        }
    }
    
    public void display(){
//        int i;
        if (isEmpty()){
            System.out.println("QUEUE IS EMPTY");
        }else{
            System.out.println("Front index -> " + front);
            System.out.println("Items: ");
            for (int i = front; i <= rear; i++){
                System.out.println(items[i]);
            }
        }
    }

    public static void main(String[] args) {
        Queues q = new Queues();
        
        q.deQueue();
        
        q.enQueue(5);
        q.enQueue(2);
        q.enQueue(4);
        q.enQueue(3);
        q.enQueue(1);
        
        q.enQueue(6);
        
        q.display();
        
        q.deQueue();
        
        q.display();
        
        q.peek();
    }
}
