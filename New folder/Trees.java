/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.trees;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Vector;

/**
 *
 * @author FamilyLaptop
 */

class Node{
    int data;
    int key;
    Node left, right;
    
    public Node(int data){
        this.data = data;
        key = data;
        this.left = null;
        this.right = null;
    }
}

public class Trees {
    
    //======================Start N-ary tree====================================
    // <editor-fold defaultstate="collapsed" desc="N-Ary Tree">
    static class naNode{
        int key;
        Vector<naNode> child = new Vector<>();
    }
    
    static naNode newNode(int key){//creates new tree
        naNode temp = new naNode();
        temp.key = key;
        return temp;
    }
    
    static void LevelOrderTraversal(naNode root){//prints the n-ary tree level wise
        if (root == null){
            return;
        }
        
        //standard level order traversal using queue
        //USE QUEUE CODE
        Queue<naNode> q = new LinkedList<>();
        q.add(root);//endqueue root
        while (!q.isEmpty()){
            int n = q.size();
            
            //if node has children
            while (n > 0){
                //dequeue item from queue and print it
                naNode p = q.peek();
                q.remove();
                System.out.println(p.key + " ");
                
                //enqueue all children of dequeued item
                for (int i = 0; i < p.child.size(); i++){
                    q.add(p.child.get(i));
                }
                n--;
            }
            System.out.println();
        }
    }
    
    // </editor-fold>
    //======================End N-ary tree======================================
    //======================Start Balanced Tree=================================
    //height difference between two sub trees (left and right) is max 1
    // <editor-fold defaultstate="collapsed" desc="Balanced Tree">
    private static Node root;
    
    public static void createBalancedTree(int[] sortedArray){
        root = createBalancedTreeRec(sortedArray, 0, sortedArray.length - 1);
    }
    
    private static Node createBalancedTreeRec(int[] array, int start, int end){
        if (start > end){
            return null;
        }
        
        int mid = (start + end) / 2;
        Node node = new Node(array[mid]);
        node.left = createBalancedTreeRec(array, start, mid - 1);
        node.right = createBalancedTreeRec(array, mid + 1, end);
        
        return node;
    }
    
    //in order traversal
    public static void inOrderTraversal(){
        inOrderRec(root);
    }
    
    private static void inOrderRec(Node node){
        if (node != null){
            inOrderRec(node.left);
            System.out.println(node.data + " ");
            inOrderRec(node.right);
        }
    }
    
    public static void preOrderTraversal(){
        preOrderRec(root);
    }
    
    private static void preOrderRec(Node node){
        if (node != null){
            System.out.println(node.data + " ");
            preOrderRec(node.left);
            preOrderRec(node.right);
        }
    }
    
    public static void postOrderTraversal(){
        postOrderRec(root);
    }
    
    private static void postOrderRec(Node node){
        if (node != null){
            postOrderRec(node.left);
            postOrderRec(node.right);
            System.out.println(node.data + " ");
        }
    }
    // </editor-fold>
    //======================End Balanced Tree===================================
    //======================Start Binary Tree===================================
    //each element can have only two children
    // <editor-fold defaultstate="collapsed" desc="Binary Tree">
    private static Node binRoot;
    
    public static void insert_bin(int key) {
        root = insertRec_bin(root, key);
    }
    
    public static Node insertRec_bin(Node root, int key){
        if (root == null){//if empty, return new node
            root = new Node(key);
            return root;
        }
        
        //otherwise recur down tree
        if (key < root.key){
            root.left = insertRec_bin(root.left, key);
        }else{
            root.right = insertRec_bin(root.right, key);
        }
        
        return root;        
    }
    
    public static void inOrderRec_bin(Node root){
        if (root != null){
            inOrderRec(root.left);
            System.out.print(root.key + " ");
            inOrderRec(root.right);
        }
    }
    
    public int findMinRec_bin(Node root){
        if (root == null){
            System.out.println("Tree is empty");
        }
        
        if (root.left == null){
            return root.key;
        }
        
        return findMinRec_bin(root.left);
    }
    
    public static int findMaxRec_bin(Node Root){
        if (root == null){
            System.out.println("Tree is empty");
        }
        
        if (root.right == null){
            return root.key;
        }
        
        return findMaxRec_bin(root.right);
    }
    // </editor-fold>
    //======================End Binary Tree=====================================
    //======================Start Balanced Binary Tree==========================
    //binary tree, but left node is always smaller than the right node
    //same as balanced tree
    // <editor-fold defaultstate="collapsed" desc="Start BBT">
    
    // </editor-fold>
    //======================End Balanced Binary Tree============================
    //======================Start Binary Search Tree============================
    //efficient search, insert, delete
    // <editor-fold defaultstate="collapsed" desc="Binary Search Tree">
    static Node bstRoot = null;

    static void insertBST(int key){
        bstRoot = insertRec_BST(bstRoot, key);
    }
    
    static Node insertRec_BST(Node root, int key){
        if (root == null){
            root = new Node(key);
            return root;
        }
        
        if (key < root.key){
            root.left = insertRec_BST(root.left, key);
        }else if (key > root.key){
            root.right = insertRec_BST(root.right, key);
        }
        
        return root;
    }
    
    static void deleteBST(int key){
        bstRoot = deleteRec_BST(root, key);
    }
    
    static Node deleteRec_BST(Node root, int key){
        if (root == null){
            return root;
        }
        
        if (key < root.key){
            root.left = deleteRec_BST(root.left, key);
        }else if (key > root.key){
            root.right = deleteRec_BST(root.right, key);
        }else{
            if (root.left == null){
                return root.right;
            }else if (root.right == null){
                return root.left;
            }
            
            Node successor = getSuccessor(root);
            root.key = successor.key;
            root.right = deleteRec_BST(root.right, successor.key);
        }
        
        return root;
    }
    
    public static Node getSuccessor(Node current){
        current = current.right;
        while (current != null && current.left != null){
            current = current.left;
        }
        return current;
    }
    
    static int minValue_BST(Node root){
        int minv = root.key;
        while (root.left != null){
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }
    
    static boolean seaarch_BST(int key){
        return searchRec_BST(root, key);
    }
    
    static boolean searchRec_BST(Node root, int key){
        if (root == null){
            return false;
        }
        if (root.key == key){
            return true;
        }
        if (root.key < key){
            return searchRec_BST(root.right, key);
        }
        return searchRec_BST(root.left, key);
    }
    
    static void inOrder(){
        inOrderRec_BST(root);
        System.out.println("\n");
    }
    
    static void inOrderRec_BST(Node root){
        if (root != null){
            inOrderRec_BST(root.left);
            System.out.println(root.key + " ");
            inOrderRec(root.right);
        }
    }
    
    static void preOrder_BST(){
        preOrderRec_BST(bstRoot);
        System.out.println("\n");
    }
    
    static void preOrderRec_BST(Node root){
        if (root != null){
            System.out.println(root.key + " ");
            inOrderRec_BST(root.left);
            inOrderRec_BST(root.right);
        }
    }
    
    static void postOrder_BST(){
        postOrderRec_BST(bstRoot);
        System.out.println("\n");
    }
    
    static void postOrderRec_BST(Node root){
        if (root != null){
            System.out.println(root.key + " ");
            postOrderRec_BST(root.left);
            postOrderRec_BST(root.right);
        }
    }
    // </editor-fold>
    //======================End Binary Search Tree==============================
    //======================Start AVL Tree======================================
    //Self-balancing binary search tree.
    //height of two child subtrees of any nodes differs by no more than one
    // <editor-fold defaultstate="collapsed" desc="AVL tree">
    static class AVLNode{
        int key, height;
        AVLNode left, right;
        
        AVLNode(int data){
            key = data;
            height = 1;
        }
    }
    
    static AVLNode AVLRoot;
    
    static int height(AVLNode n){
        if (n == null){
            return 0;
        }
        return n.height;
    }
    
    static int getMax(int a, int b){
        return (a > b) ? a : b;
    }
    
    static AVLNode rightRotateAVL(AVLNode y){
        AVLNode x = y.left;
        AVLNode T2 = x.right;
        
        //perform rotation
        x.right = y;
        y.left = T2;
        
        //update heights
        y.height = getMax(height(y.left), height(y.right)) + 1;
        x.height = getMax(height(x.left), height(x.right)) + 1;
        
        return x;        
    }
    
    static AVLNode leftRotateAVL(AVLNode x){
        AVLNode y = x.right;
        AVLNode T2 = y.left;
        
        y.left = x;
        x.right = T2;
        
        x.height = getMax(height(x.left), height(x.right)) + 1;
        y.height = getMax(height(y.left), height(y.right)) + 1;
        
        return y;        
    }
    
    static int getBalance(AVLNode n){
        if (n == null){
            return 0;
        }
        return height(n.left) - height(n.right);
    }
    
    //insert key into subtree rooted with node and returns new root of the subtree
    static AVLNode insertAVL(AVLNode node, int key){
        //perform normal BST insertion
        if (node == null){
            return (new AVLNode(key));
        }
        
        if (key < node.key){
            node.left = insertAVL(node.left, key);
        }else if (key > node.key){
            node.right = insertAVL(node.right, key);
        }else{//no duplicate keys allowed
            return node;
        }
        
        //update height of ancester node
        node.height = 1 + getMax(height(node.left), height(node.right));
        
        //get balance factor of this ancestor node to check whether this node became unbalanced
        int balance = getBalance(node);
        
        //left left case
        if (balance > 1 && key < node.left.key){
            return rightRotateAVL(node);
        }
        //right right case
        if (balance < -1 && key > node.right.key){
            return leftRotateAVL(node);
        }
        //left right case
        if (balance > 1 && key > node.left.key){
            node.left = leftRotateAVL(node.left);
            return rightRotateAVL(node);
        }
        //right left case
        if (balance < -1 && key < node.right.key){
            node.right = rightRotateAVL(node.right);
            return leftRotateAVL(node);
        }
        
        //return unchanged node pointer
        return node;
    }
    
    static void preOrderAVL(AVLNode node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrderAVL(node.left);
            preOrderAVL(node.right);
        }
    }

    // Utility function to print inorder traversal of the tree
    static void inOrderAVL(AVLNode node) {
        if (node != null) {
            inOrderAVL(node.left);
            System.out.print(node.key + " ");
            inOrderAVL(node.right);
        }
    }

    // Utility function to print postorder traversal of the tree
    static void postOrderAVL(AVLNode node) {
        if (node != null) {
            postOrderAVL(node.left);
            postOrderAVL(node.right);
            System.out.print(node.key + " ");
        }
    }
    // </editor-fold>
    //======================End AVL Tree========================================
    //======================Start Red-Black Tree================================
    //bst where each node has colour: red or black - maintain
    //balance during insertions and deletions = efficient data retrieval
    //and manipulation
    // <editor-fold defaultstate="collapsed" desc="Red-Black Tree">
    
    
    
    
    
    // </editor-fold>
    //======================End Red-Black Tree==================================
    /*                      2-3-4 Trees
        A self- balancing tree where each node can have 2, 3, or 4
        children
    
    */
    
    public static void main(String[] args) {
        //n-ary tree
//        naNode naRoot = newNode(10);
//        (naRoot.child).add(newNode(2));
//        (naRoot.child).add(newNode(34));
//        (naRoot.child).add(newNode(56));
//        (naRoot.child).add(newNode(100));
//        (naRoot.child.get(0).child).add(newNode(77));
//        (naRoot.child.get(0).child).add(newNode(88));
//        (naRoot.child.get(2).child).add(newNode(1));
//        (naRoot.child.get(3).child).add(newNode(7));
//        (naRoot.child.get(3).child).add(newNode(8));
//        (naRoot.child.get(3).child).add(newNode(9));
//        System.out.println("Level order traversal befor mirroring");
//        LevelOrderTraversal(naRoot);
        
        //balanced tree
//        int[] sortedArray = {10, 20, 30, 40, 50, 60, 70, 80, 90};
//        createBalancedTree(sortedArray);
//        System.out.println("In-order traversal of the balanced binary tree:");
//        inOrderTraversal();
//
//        System.out.println("\n\nPre-order traversal of the balanced binary tree:");
//        preOrderTraversal();
//
//        System.out.println("\n\nPost-order traversal of the balanced binary tree:");
//        postOrderTraversal();
        
        //binary tree
//        insert_bin(50);
//        insert_bin(30);
//        insert_bin(20);
//        insert_bin(40);
//        insert_bin(70);
//        insert_bin(60);
//        insert_bin(80);
//        
//        System.out.println("In order traversal: ");
//        inOrderRec_bin(root);
        
        //binary balanced tree
        
        
        //binary search tree
//        insertBST(50);
//        insertBST(30);
//        insertBST(20);
//        insertBST(40);
//        insertBST(70);
//        insertBST(60);
//        insertBST(80);
//        
//        System.out.println("In order traversal: ");
//        inOrderRec_BST(bstRoot);
        
        //AVL tree
        AVLRoot = insertAVL(AVLRoot, 10);
        AVLRoot = insertAVL(AVLRoot, 20);
        AVLRoot = insertAVL(AVLRoot, 50);
        AVLRoot = insertAVL(AVLRoot, 15);
        AVLRoot = insertAVL(AVLRoot, 30);
        AVLRoot = insertAVL(AVLRoot, 35);
        AVLRoot = insertAVL(AVLRoot, 25);
        AVLRoot = insertAVL(AVLRoot, 11);
        
        // Print preorder traversal of the tree
        System.out.println("Preorder traversal of constructed AVL tree is : ");
        preOrderAVL(AVLRoot);
        System.out.println();

        // Print inorder traversal of the tree
        System.out.println("Inorder traversal of constructed AVL tree is : ");
        inOrderAVL(AVLRoot);
        System.out.println();

        // Print postorder traversal of the tree
        System.out.println("Postorder traversal of constructed AVL tree is : ");
        postOrderAVL(AVLRoot);
        System.out.println();
        
        //red-black tree
//        insertRB(10);
//        insertRB(50);
//        insertRB(20);
//        insertRB(12);
//        insertRB(30);
//        insertRB(34);
//        insertRB(13);
//        System.out.println("Inorder Traversal: \n");
//        inOrderRB();
//        System.out.println("Search for 50: " + searchRB(50));
                
    }
}
