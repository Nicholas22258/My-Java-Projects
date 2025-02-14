/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.maps;
import java.util.*;

/**
 *
 * @author FamilyLaptop
 */
public class Maps {

    public static void main(String[] args) {
        /////////////////////////////Hash Map///////////////////////////////////
                //index  //value
        HashMap<Integer, String> newHashMap = new HashMap<>();
        
        newHashMap.put(1, "Garlic");
        newHashMap.put(2, "Onion");
        newHashMap.put(3, "Carrot");
        newHashMap.put(4, "Turnip");
        
        System.out.println("Size of Hash Map = " + newHashMap.size());
        System.out.println(newHashMap);
        
//        if (newHashMap.containsKey(3)){
//            Integer i = newHashMap.get(3);
//            System.out.println("Value for 3 = " + i);
//        }  //.get only works for string keys
        
        /////////////////////////////Hash Map End///////////////////////////////
        
        /////////////////////////////Linked Hash Map////////////////////////////
        System.out.println("\n");
        LinkedHashMap<Integer, String> newLinkedHashMap = new LinkedHashMap<Integer, String>();
        
        newLinkedHashMap.put(1, "Earth");
        newLinkedHashMap.put(2, "Air");
        newLinkedHashMap.put(3, "Fire");
        newLinkedHashMap.put(4, "Water");        
        
        System.out.println("Size of Linked Hash Map = " + newLinkedHashMap.size());
        System.out.println("Value of key 2 = " + newLinkedHashMap.get(2));
        System.out.println("Does map conatain key 4? = " + newHashMap.containsKey(4));
        
        /////////////////////////////Linked Hash Map End////////////////////////
        
        /////////////////////////////Tree Map///////////////////////////////////
        System.out.println("\n");
        TreeMap<Integer, String> newTreeMap = new TreeMap<>();
        
        newTreeMap.put(1, "Unu");
        newTreeMap.put(2, "Du");
        newTreeMap.put(3, "Tri");
        newTreeMap.put(4, "Kvar");
        
        for (Map.Entry m: newTreeMap.entrySet()){
            System.out.println(m.getKey() + " : " + m.getValue() + " | ");
        }
        System.out.println("\n");
        newTreeMap.remove(3);
        for (Map.Entry m: newTreeMap.entrySet()){
            System.out.println(m.getKey() + " : " + m.getValue() + " | ");
        }
        
        
        /////////////////////////////Tree Map End///////////////////////////////
        ////////////////////////////////////////////////////////////////////////
        /////////////////////////////Array List/////////////////////////////////
        System.out.println("\n");
        List<Integer> newArrayList = new ArrayList<>();
        
        System.out.println("List Before");
        newArrayList.add(1);
        newArrayList.add(2);
        newArrayList.add(3);
        newArrayList.add(4);
        newArrayList.add(5);
        newArrayList.add(6);
        newArrayList.add(7);
        newArrayList.add(8);
        newArrayList.add(9);
        System.out.println(newArrayList);
        System.out.println("List After");
        newArrayList.add(0, 10);
        newArrayList.add(3, 30);
        System.out.println(newArrayList);
        
        /////////////////////////////Linked List
        
        LinkedList<Object> newLinkedList = new LinkedList<>(newArrayList);
        
        newLinkedList.add(1, "Tweebuffelsmeteenskootmorsdoodgeskietfontein");
        newLinkedList.removeLast();
        newLinkedList.addFirst("Timbuktu");
        
        System.out.println("Display linked list forwards: ");
        ListIterator<Object> newListIterator = newLinkedList.listIterator();
        while (newListIterator.hasNext()){
            System.out.println(newListIterator.next() + " ");
        }
        
        System.out.println("Display linked list backwards: ");
        //newListIterator = newLinkedList.newListIterator(newLinkedList.size());
        while (newListIterator.hasPrevious()){
            System.out.println(newListIterator.previous()+ " ");
        }
        
        /////////////////////////////Linked List End
        
        /////////////////////////////Array List End/////////////////////////////
        
        /////////////////////////////Linked List////////////////////////////////
        System.out.println("\n");
        LinkedList < String > mylist = new LinkedList < > ();

 

        // Adding elements to the linked list 

        mylist.add("Java");

        mylist.add("C#");

        mylist.add("C++");

        mylist.add("Python");

 

        //printing out elements in the LinkedList

        System.out.println("Elements in the LinkedList are: " + mylist);

        mylist.remove("Python");

        //printing LinkedList after removing elements

        System.out.println("Elements in the LinkedList after removing are: " + mylist);
        
        /////////////////////////////Linked List End////////////////////////////
    }
}
