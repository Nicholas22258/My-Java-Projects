/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.binarytrees;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author FamilyLaptop
 */

class Node {
    int data;
    Node left, right;
    
    Node(int d){
        data = d;
        left = right = null;
    }
}

public class BinaryTrees {

    //insert new node into tree
    static Node insertNode(Node root, int key){
        if (root == null){
            return new Node(key);
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()){
            Node temp = q.poll();

            //if left child is empty, insert new node there
            if (temp.left == null){
                temp.left = new Node(key);
                break;
            }else{
                q.add(temp.left);
            }

            //if right child is empty, insert new node there
            if (temp.right == null){
                temp.right = new Node(key);
                break;
            }else{
                q.add(temp.right);
            }                
        }

        return root;
    }
        
    //In order traversal
    static void inOrder(Node root){
        if (root == null){
            return;
        }
        inOrder(root.left);
        System.out.println(root.data + " ");
        inOrder(root.right);
    }
    
    public static void main(String[] args) {
        Node root = new Node(2);
        root.left = new Node(3);
        root.right = new Node(4);
        root.left.left = new Node(5);
        root.left.right = new Node(6);
        
        System.out.println("Inorder traversal befor insertion: ");
        inOrder(root);
        
        int key = 7;
        insertNode(root, key);
        
        System.out.print("Inorder traversal after insertion: ");
        inOrder(root);
        
    }
}
