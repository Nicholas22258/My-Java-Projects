/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.hashing;

import java.util.LinkedList;

/**
 *
 * @author FamilyLaptop
 */
public class Hashing<K, V> {
    
    public static final int SIZE = 16;//default capacity
    private LinkedList<Entry<K, V>>[] table;
    public Hashing(){
        table = new LinkedList[SIZE];
    }
    public Hashing(int initialCapacity){
        table = new LinkedList[initialCapacity];
    }
    
    //Nested class to represent key-value pairs
    //Contains fiels for key and associated value
    private static class Entry<K, V>{
        K key;
        V value;
        Entry(K key, V value){
            this.key = key;
            this.value = value;
        }
    }
    
    //Converts key into hash code
    private int hash(K key){
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % table.length;
    }
    
    //Insert key-value pair into hash table
    public void put(K key, V value){
        int index = hash(key);
        if (table[index] == null){
            table[index] = new LinkedList<>();
        }
        
        //Check if the key already exists, and update value if true
        for (Entry<K, V> entry : table[index]){
            if (entry.key.equals(key)){
                entry.value = value;
                return;
            }
        }
        table[index].add(new Entry<>(key, value));
    }
    
    //Retrieve the value associated with given key
    public V get(K key){
        int index = hash(key);
        if (table[index] != null){
            for (Entry<K, V> entry : table[index]){
                if (entry.key.equals(key)){
                    return entry.value;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Hashing<Integer, String> ht = new Hashing<>();
        
        ht.put(1, "Agh Nee");
        ht.put(2, "Eish");
        ht.put(3, "Yoh");
        ht.put(4, "Hey Wena");
        ht.put(5, "Mampara");
        ht.put(6, "Agh Shame");
        ht.put(7, "Agh Siestog");
        ht.put(8, "My Fok");
        
        System.out.println("At 4: " + ht.get(4));
    }
}
