/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.threads;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author FamilyLaptop
 */
public class Threads {
    public static void main(String[] args){

        Thread threadA = new Thread(new Threads().new MyRunnableA());
        threadA.start();        
        for (int i = 0; i < 5; i++){
            System.out.println("Main Thread: " + i);
        }
        
        Thread threadB = new Thread(new Threads().new MyRunnableB());
        threadB.start();
        for (int i = 0; i < 5; i++){
            System.out.println("Main Thread: " + i);
        }
        ExecutorService te = Executors.newCachedThreadPool();
        System.out.println("Using Executer Framework: ");
        te.execute(threadA);
        te.execute(threadB);
        te.shutdown();
    }
    
    public class MyRunnableA implements Runnable{
        @Override
        public void run(){
            for (int i = 0; i < 5; i++){
                System.out.println("Thread A: " + i);
            }
        }
    }
    
    public class MyRunnableB implements Runnable{
        @Override
            public void run(){
               for (int i = 0; i < 5; i++){
                System.out.println("Thread B: " + i);
            } 
        }
    }
    

}
