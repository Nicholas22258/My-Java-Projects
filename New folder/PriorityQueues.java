/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.priorityqueues;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author FamilyLaptop
 */

class item{
    public int value;
    public int priority;
}        
        
public class PriorityQueues {

    public static item[] prQueue = new item[100000];//pr queue
    public static int size = -1;//pointer to last index
    
    //insert new element into pr queue
    static void enQueue(int value, int priority){
        size++;
        
        prQueue[size] = new item();
        prQueue[size].value = value;
        prQueue[size].priority = priority;
    }
    
    //check top element
    static int peek(){
        int highestPriority = Integer.MIN_VALUE;
        int ind = -1;
        
        //check for element with highest priority
        for (int i = 0; i <= size; i++){
            //if priority is the same, choose element with highest value
            if (highestPriority == prQueue[i].priority 
                    && ind > -1 
                    && prQueue[ind].value < prQueue[i].value){
                
                highestPriority = prQueue[i].priority;
                ind = i;
            }else if (highestPriority < prQueue[i].priority){
                highestPriority = prQueue[i].priority;
                ind = i;
            }
        }
        
        //return position of element
        return ind;
    }
    
    //remove element with highest priority
    static void deQueue(){
        int ind = peek();
        //shift the element one index before the position
        //of the element, with highest priority, is found
        for (int i = ind; i < size; i++){
            prQueue[i] = prQueue[i + 1];
        }
        
        size--;
    }
    
    public static void main(String[] args) {
        enQueue(10, 2);
        enQueue(14, 4);
        enQueue(16, 4);
        enQueue(12, 3);
        
        for (int i = 0; i < size; i++){
            System.out.println("Values: " + prQueue[i].value);
        }
        
        int ind = peek();
        
        System.out.println("Peek: " + prQueue[ind].value);
        
        deQueue();
        
        ind = peek();
        System.out.println("Peek2: " + prQueue[ind].value);
        
        deQueue();
        
        ind = peek();
        System.out.println("Peek3: " + prQueue[ind].value);
        
        
       //=======================================================================4
       System.out.println("""
                          \n===================================================
                          Priority Queue examples
                          """);
       
       PriorityQueue<Integer> pq = new PriorityQueue<>();
       pq.add(12);
       pq.add(15);
       pq.add(12);
       pq.add(21);
       pq.add(8);
       System.out.println("\nBasic PQ: ");
       while (!pq.isEmpty()){
           System.out.println(pq.poll());
       }
       
       
       List<Integer> numbers = Arrays.asList(12, 15, 12, 21, 8);
       PriorityQueue<Integer> pq2 = new PriorityQueue<>(numbers);
       System.out.println("\nPQ with predefined colletion: ");
       while (!pq2.isEmpty()){
           System.out.println(pq2.poll());
       }
       
       PriorityQueue<Integer> pq3 = new PriorityQueue<>(5);
       pq3.add(12);
       pq3.add(15);
       pq3.add(12);
       pq3.add(21);
       pq3.add(8);
       System.out.println("\nPQ with initial capacity: ");
       while (!pq3.isEmpty()){
           System.out.println(pq3.poll());
       }
       
       Comparator<Integer> comp = (a, b) -> b - a;
       PriorityQueue<Integer> pq4 = new PriorityQueue<>(5, comp);
       pq4.add(12);
       pq4.add(15);
       pq4.add(12);
       pq4.add(21);
       pq4.add(8);
       System.out.println("\nPQ with initial capacity & comparator: ");
       while (!pq4.isEmpty()){
           System.out.println(pq4.poll());
       }
       
       PriorityQueue<Integer> pq5_1 = new PriorityQueue<>();
       pq5_1.add(12);
       pq5_1.add(15);
       pq5_1.add(12);
       pq5_1.add(21);
       pq5_1.add(8);
       PriorityQueue<Integer> pq5_2 = new PriorityQueue<>(pq5_1);
       System.out.println("\nPQ using copied queue: ");
       while (!pq5_2.isEmpty()){
           System.out.println(pq5_2.poll());
       }
       
       SortedSet<Integer> ss = new TreeSet<>();
       ss.add(12);
       ss.add(15);
       ss.add(12);
       ss.add(21);
       ss.add(8);
       PriorityQueue<Integer> pq6 = new PriorityQueue<>(ss);
       System.out.println("\nPQ with sorted set: ");
       while (!pq6.isEmpty()){
           System.out.println(pq6.poll());
       }
    }
}
