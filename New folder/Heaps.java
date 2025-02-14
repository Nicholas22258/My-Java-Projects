/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.heaps;

import java.util.Scanner;

/**
 *
 * @author Nicholas Leong
 */

class Node{//Node class
        int key;
        Node left, right;
        
        public Node(int item){
            key = item;
            left = right = null;
        }
    }
                //Heaps refer to binary search tree
public class Heaps {//bst class
    //https://www.geeksforgeeks.org/implementing-a-binary-tree-in-java/
    Node root;
    
    public Heaps(){
        root = null;
    }
    
    //insert new node with a given key
    public void insertElement(int key){
        root = insertRec(root, key);
    }
    
    //recursive function to insert a new key into bst as a min heap
    private Node insertRec(Node root, int key){
        //if tree is empty, return new node
        if (root == null){
            root = new Node(key);
            return root;
        }
        
        //else recur down tree
        if (key < root.key){
            root.left = insertRec(root.left, key);
        }else if (key > root.key){
            root.right = insertRec(root.right, key);
        }
        
        //return unchanged node pointer
        return root;
    }
    
    //print tree in order
    public void inOrder(){
        inOrderRec(root);
    }
    
    //function to print inorder traversal of bst
    private void inOrderRec(Node root){
        if (root != null){
            inOrderRec(root.left);
            System.out.println(root.key + " ");
            inOrderRec(root.right);
        }
    }
    
    //search for a key in the tree
    public boolean search(int key){
        return searchRec(root, key);
    }
    
    //function to search
    private boolean searchRec(Node root, int key){
        if (root == null){
            return false;
        }
        
        if (root.key == key){
            return true;
        }
        
        if (key < root.key){
            return searchRec(root.left, key);
        }else{
            return searchRec(root.right, key);
        }
    }
    
    //find min value
    public int findMin(){
        return findMinRec(root);
    }
    
    //function to find min
    private int findMinRec(Node root){
        if (root == null){
            throw new IllegalStateException("Tree is empty");
        }
        
        if (root.left == null){
            return root.key;
        }
        
        return findMinRec(root.left);
    }
    
    //find max value
    public int findMax(){
        return findMaxRec(root);
    }
    
    //function to find max
    private int findMaxRec(Node root){
        if (root == null){
            throw new IllegalStateException("Tree is empty");
        }
        
        if (root.right == null){
            return root.key;
        }
        
        return findMaxRec(root.right);
    }
    
    public static void main(String[] args) {
        Heaps BST = new Heaps();
        Scanner sc = new Scanner(System.in);
        
        //add values
        BST.insertElement(60);
        BST.insertElement(24);
        BST.insertElement(55);
        BST.insertElement(10);
        BST.insertElement(20);
        BST.insertElement(89);
        BST.insertElement(6);
        
        //print in order of traversal
        System.out.println("\nIn order traversal: ");
        BST.inOrder();
        
        //search for key
        System.out.println("\nEnter number to search for(60, 24, 55, 10, 20, 89, 6):");
        int i = sc.nextInt();
        if (BST.search(i)){
            System.out.println("\nKey: \"" + i + "\" found in tree");
        }else{
            System.out.println("\nKey: \"" + i + "\" not found in tree");
        }
        
        //find min and max values
        System.out.println("\nMin Value: " + BST.findMin());
        System.out.println("Max Value: " + BST.findMax());
    }
    
    
}
