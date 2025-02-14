/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.stacks;

import java.util.Stack;
import javax.swing.JOptionPane;

/**
 *
 * @author FamilyLaptop
 */
public class Stacks {

    public String sName;
    
    public static void main(String[] args) {        
        Stack<Stacks> stack = new Stack<Stacks>();
        
//        System.out.println("Push Operation: ");
//        System.out.println(stack_push(stack));
        stack_push(stack);

        System.out.println("Pop Operation: ");
        stack_pop(stack);
        
        stack_push(stack);

        System.out.println("\nPeek Operation: ");
        stack_peek(stack);
        
        System.out.println("\nSearch Operation: ");
        stack_search(stack);
    }
    
    public Stacks(String name){
        this.sName = name;
    }
    
    public String getName(){
        return sName;
    }
    
    public void setName(String name){
        this.sName = name;
    }
    
    public static void stack_push(Stack<Stacks> stack){
        Stacks student1 = new Stacks("Stu");
        Stacks student2 = new Stacks("Dent");
        Stacks student3 = new Stacks("Num");
        Stacks student4 = new Stacks("Ber");
        
        stack.push(student1);
        stack.push(student2);
        stack.push(student3);
        stack.push(student4);
    }
    
    public static void stack_pop(Stack<Stacks> stack){
        System.out.println("Size: " + stack.size());
        
        while (!stack.isEmpty()){
            System.out.println(stack.pop().getName());
        }
        
//        for (int i = 0; i <= stack.size(); i++){
//            System.out.println(stack.pop().getName());
//        }
    }
    
    public static void stack_peek(Stack<Stacks> stack){
        System.out.println(stack.peek().getName());
    }
    
    public static void stack_search(Stack<Stacks> stack){
        String search = JOptionPane.showInputDialog("Enter the student's name: ");
        System.out.println(search + " is found at position " + stack.search(search));
    }
}
