/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.red_blacktree;

/**
 *
 * @author FamilyLaptop
 */

enum Colour{
        RED, BLACK
    }
    
class Node<T extends Comparable<T>>{
    T data;
    Node<T> left;
    Node<T> right;
    Node<T> parent;
    Colour Colour;

    //constructor to create a new node
    Node(T data){
        this.data = data;
        //new nodes are always red when inserted
        this.Colour = Colour.RED;
        this.left = this.right = this.parent = null;
    }
} 

public class Red_BlackTree<T extends Comparable<T>> {
    private Node<T> root;
    private final Node<T> TNULL; //Sentinal node for null reference
    
    //constructor to initialise tree
    public Red_BlackTree(){
        TNULL = new Node<>(null);
        TNULL.Colour = Colour.BLACK;
        root = TNULL;
    }
    
    //preorder traversal
    private void preOrderRec(Node<T> node){
        if (node != TNULL){
            System.out.println(node.data + " ");
            preOrderRec(node.left);
            preOrderRec(node.right);
        }
    }
    public void preOrder(){
        preOrderRec(this.root);
    }
    
    private void inOrderRec(Node<T> node){
        if (node != TNULL){
            inOrderRec(node.left);
            System.out.println(node.data + " ");
            inOrderRec(node.right);
        }
    }
    public void inOrder(){
        inOrderRec(this.root);
    }
    
    private void postOrderRec(Node<T> node){
        if (node != TNULL){
            postOrderRec(node.left);
            postOrderRec(node.right);
            System.out.println(node.data + " ");
        }
    }
    public void postOrder(){
        postOrderRec(this.root);
    }
        
    private void leftRotate(Node<T> x){
        Node<T> y = x.right;
        x.right = y.left;
        if (y.left != TNULL){
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null){
            this.root = y;
        }else if (x == x.parent.left){
            x.parent.left = y;
        }else{
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }
    
    private void rightRotate(Node<T> x){
        Node<T> y = x.left;
        x.left = y.right;
        if (y.right != TNULL){
            y.right.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null){
            this.root = y;
        }else if (x == x.parent.right){
            x.parent.right = y;
        }else{
            x.parent.left = y;
        }
        y.right =x;
        x.parent = y;
    }
    
    //insert new node
    public void insert(T key){
        Node<T> node = new Node<>(key);
        node.parent = null;
        node.left = TNULL;
        node.right = TNULL;
        node.Colour = Colour.RED;//new node must be red
        
        Node<T> y = null;
        Node<T> x = this.root;
        
        //find correct position to insert the new node
        while (x != TNULL){
            y = x;
            if (node.data.compareTo(x.data) < 0){
                x = x.left;
            }else{
                x = x.right;
            }
        }
        
        node.parent = y;
        if (y == null){
            root = node;
        }else if (node.data.compareTo(y.data) < 0){
            y.left = node;
        }else{
            y.right = node;
        }
        
        //fix tree if properties are violated
        if (node.parent == null){
            node.Colour = Colour.BLACK;
            return;
        }
        
        if (node.parent.parent == null){
            return;
        }
        
        fixInsert(node);
    }
    
    //function to fix violations after insertion
    private void fixInsert(Node<T> k){
        Node<T> u;
        while (k.parent.Colour == Colour.RED){
            if (k.parent == k.parent.parent.right){
                u = k.parent.parent.left;
                if (u.Colour == Colour.RED){
                    u.Colour = Colour.BLACK;
                    k.parent.Colour = Colour.BLACK;
                    k.parent.parent.Colour = Colour.RED;
                    k = k.parent.parent;
                }else{
                    if (k == k.parent.left){
                        k = k.parent;
                        rightRotate(k);
                    }
                    k.parent.Colour = Colour.BLACK;
                    k.parent.parent.Colour = Colour.RED;
                    leftRotate(k.parent.parent);
                }
            }else{
                u = k.parent.parent.right;
                
                if (u.Colour == Colour.RED){
                    u.Colour = Colour.BLACK;
                    k.parent.Colour = Colour.BLACK;
                    k.parent.parent.Colour = Colour.RED;
                    k = k.parent.parent;
                }else{
                    if (k == k.parent.right){
                        k = k.parent;
                        leftRotate(k);
                    }
                    k.parent.Colour = Colour.BLACK;
                    k.parent.parent.Colour = Colour.RED;
                    rightRotate(k.parent.parent);
                }
            }
            if (k == root){
                break;
            }
        }
        root.Colour = Colour.BLACK;
    }
    
    public static void main(String[] args) {
        Red_BlackTree<Integer> tree = new Red_BlackTree<>();
        tree.insert(55);
        tree.insert(23);
        tree.insert(45);
        tree.insert(11);
        tree.insert(10);
        tree.insert(16);
        tree.insert(33);
        tree.insert(24);
        
        System.out.println("Preorder traversal:");
        tree.preOrder();

        System.out.println("\nInorder traversal:");
        tree.inOrder();

        System.out.println("\nPostorder traversal:");
        tree.postOrder();
    }
}
