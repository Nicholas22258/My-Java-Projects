/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.avltree;

/**
 *
 * @author Nicholas Leong EDUV4551823
 */

class Node { 
    int key; 
    Node left, right; 
    int height; 

    Node(int k) { 
        key = k; 
        left = null; 
        right = null; 
        height = 1; 
    }
} 

public class AVLTree {
    //gets height of tree
    static int getHeight(Node node) { 
        if (node == null) 
            return 0; 
        return node.height; 
    } 

    //rotates subtree right
    static Node rotateRight(Node y) { 
        Node x = y.left; 
        Node T2 = x.right; 
 
        x.right = y; //rotation
        y.left = T2; 

        y.height = 1 + Math.max(getHeight(y.left), 
                                getHeight(y.right)); //update height
        x.height = 1 + Math.max(getHeight(x.left), 
                                getHeight(x.right)); 

        return x; //return new node
    } 

    //rotates subtree left
    static Node rotateLeft(Node x) { 
        Node y = x.right; 
        Node T2 = y.left; 

        y.left = x; //rotation
        x.right = T2; 

        x.height = 1 + Math.max(getHeight(x.left),
                                getHeight(x.right)); //update height
        y.height = 1 + Math.max(getHeight(y.left), 
                                getHeight(y.right)); 

        return y; //return new node
    } 

    //get balance factor of node N 
    static int getBalance(Node node) { 
        if (node == null) 
            return 0; 
        return getHeight(node.left) - getHeight(node.right); 
    } 

    //recursive function to insert new node
    static Node insert(Node node, int key) { 
      
        if (node == null) //normal insertion into tree
            return new Node(key); 

        if (key < node.key) 
            node.left = insert(node.left, key); 
        else if (key > node.key) 
            node.right = insert(node.right, key); 
        else
            return node; 

        node.height = 1 + Math.max(getHeight(node.left), 
                                   getHeight(node.right)); //updates height
 
        int balance = getBalance(node); 

        //if this node becomes unbalanced, then there are 4 cases

        //left left Case 
        if (balance > 1 && key < node.left.key) 
            return rotateRight(node); 

        //right right Case 
        if (balance < -1 && key > node.right.key) 
            return rotateLeft(node); 

        //left right Case 
        if (balance > 1 && key > node.left.key) { 
            node.left = rotateLeft(node.left); 
            return rotateRight(node); 
        } 

        //right left Case 
        if (balance < -1 && key < node.right.key) { 
            node.right = rotateRight(node.right); 
            return rotateLeft(node); 
        } 

        return node; 
    } 

    //function to print preorder traversal of the tree 
    static void preOrder(Node root) { 
        if (root != null) { 
            System.out.print(root.key + " "); 
            preOrder(root.left); 
            preOrder(root.right); 
        } 
    } 

    public static void main(String[] args) { 
        Node root = null; 
         
        root = insert(root, 13); //tree is sorted after each insertion
        
        System.out.println("Preorder traversal : "); 
        preOrder(root); 
    } 
}
