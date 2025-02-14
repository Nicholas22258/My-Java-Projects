/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package my.rsq;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import javax.swing.JOptionPane;

/**
 *
 * @author FamilyLaptop
 */
public class recursionstacksqueues extends javax.swing.JFrame {
    public String toDisplay = "";
    
    /**
     * Creates new form recursionstacksqueues
     */
    public recursionstacksqueues() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtDisplay = new javax.swing.JTextArea();
        btnFibonacci = new javax.swing.JToggleButton();
        btnStack = new javax.swing.JToggleButton();
        txtNumber = new javax.swing.JTextField();
        btnFactorial = new javax.swing.JToggleButton();
        btnQueue = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtDisplay.setColumns(20);
        txtDisplay.setRows(5);
        txtDisplay.setName("txtDisplay"); // NOI18N
        jScrollPane1.setViewportView(txtDisplay);

        btnFibonacci.setText("Fibonacci");
        btnFibonacci.setMaximumSize(new java.awt.Dimension(61, 25));
        btnFibonacci.setMinimumSize(new java.awt.Dimension(61, 25));
        btnFibonacci.setName("btnFibonacci"); // NOI18N
        btnFibonacci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFibonacciActionPerformed(evt);
            }
        });

        btnStack.setText("Stack");
        btnStack.setName("btnStack"); // NOI18N
        btnStack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStackActionPerformed(evt);
            }
        });

        btnFactorial.setText("Factorial");
        btnFactorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFactorialActionPerformed(evt);
            }
        });

        btnQueue.setText("Queue");
        btnQueue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQueueActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnFactorial, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFibonacci, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnStack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnQueue, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFibonacci, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnStack, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFactorial, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQueue, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //////////////Fibonacci/////////////////////
    
    private void btnFibonacciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFibonacciActionPerformed
//        System.out.println("Enter nth: ");
//        int num = scanner.nextInt();
//        
//        System.out.println("Fibonacci until " + num + ":");

        int num = Integer.parseInt(txtNumber.getText());
        
        String nums = "";
        for (int i = 0; i < num; i++){
            nums += fibonacci(i) + " ";            
        }
        String display = "Fibonacci series until " + nums + "th number: \n" + nums;
        txtDisplay.setText(display);
    }//GEN-LAST:event_btnFibonacciActionPerformed
    public static int fibonacci(int num) throws IllegalArgumentException{
            if (num == 0){
                return 0;
            }

            if (num == 1 || num == 2){
                return 1;
            }

            return fibonacci(num - 1) + fibonacci(num - 2);
        }
    
    //////////////Stack/////////////////////
    
    private void btnStackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStackActionPerformed
        Stack<Integer> stack = new Stack<Integer>();
        
        stack_push(stack);
        stack_pop(stack);
        stack_push(stack);
        stack_peek(stack);
        stack_search(stack);
        
        txtDisplay.setText(toDisplay);
    }//GEN-LAST:event_btnStackActionPerformed

    public void stack_push(Stack<Integer> stack){
        try{
            stack.push(25);
            stack.push(69);
            stack.push(18);
            stack.push(33);
            stack.push(74);
            
            toDisplay += "Push Successful\n";
        }catch(Exception e){
            
        }
    }
    
    public void stack_pop(Stack<Integer> stack){
        toDisplay += "Pop Operation\n";
        while (!stack.isEmpty()){
            toDisplay += stack.pop() + " ";
        }
    }
    
    public void stack_peek(Stack<Integer> stack){
        toDisplay += "\nPeek Operation\n" + stack.peek();
    }
    
    public void stack_search(Stack<Integer> stack){
        String search = JOptionPane.showInputDialog(this, "Enter a number to search(25, 69, 18, 33, 74):");
        
        toDisplay += "\nSearch Operation: \n" + search + " is at " + stack.search(search);
    }

    //////////////Factorial/////////////////////
    
    private void btnFactorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFactorialActionPerformed
        int num = Integer.parseInt(txtNumber.getText());
        
        System.out.println("Factorial: ");
        System.out.println(factorial(num));
    }//GEN-LAST:event_btnFactorialActionPerformed

    public int factorial(int num){
        if (num == 0 || num == 1){
            return 1;
        }else{
            return num * fibonacci(num-1);
        }
    }
    
    //////////////Queue/////////////////////
    
    private void btnQueueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQueueActionPerformed
        toDisplay = "";
        front = -1;
        rear = -1;
        
        recursionstacksqueues q = new recursionstacksqueues();
//        Queue<Integer> q = new LinkedList<>();
        
        q.deQueue();
        
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);
        q.enQueue(4);
        q.enQueue(5);
        
//        q.enQueue(6);
        
        q.display();
        
//        q.deQueue();
        
//        q.display();
    }//GEN-LAST:event_btnQueueActionPerformed

        public int size = 5;
        public int items[] = new int[size];
        public static int front, rear;
        
        public boolean isFull(){
            if (front == 0 && rear == size - 1){
                return true;
            }else{
                return false;
            }
        }
        
        public boolean isEmpty(){
            if(front == -1){
                return true;
            }else{
                return false;
            }
        }

        public void enQueue(int element){
            if (isFull()){
                JOptionPane.showMessageDialog(this, "Queue is full");
            }else{
//                if(front == -1 && front < 5){
                    front = 0;
                    rear++;
                    items[rear] = element;
                    System.out.println("Inserted " + element);
//                }
            }
        }
        
        public int deQueue(){
            int element;
            if (isEmpty()){
                JOptionPane.showMessageDialog(this, "Queue is empty");
                return -1;
            }else{
                element = items[rear];
                if (front >= rear){
                    front = -1;
                    rear = -1;
                }else{
                    front++;
                }
                
                JOptionPane.showMessageDialog(this, "Deleted -> " + element);
                return element;
            }
        }
        
        public void display(){
            int i;
            if (isEmpty()){
                JOptionPane.showMessageDialog(this, "Queue is empty");
            }else{
                toDisplay = "Front index = " + front;
                toDisplay += "\nItems: ";
                for (i = front; i <= rear; i++){
                    toDisplay += items[i];
                }
                txtDisplay.setText(toDisplay);
                JOptionPane.showMessageDialog(this, toDisplay);
            }
        }
        
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(recursionstacksqueues.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(recursionstacksqueues.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(recursionstacksqueues.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(recursionstacksqueues.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new recursionstacksqueues().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnFactorial;
    private javax.swing.JToggleButton btnFibonacci;
    private javax.swing.JToggleButton btnQueue;
    private javax.swing.JToggleButton btnStack;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtDisplay;
    private javax.swing.JTextField txtNumber;
    // End of variables declaration//GEN-END:variables
}
