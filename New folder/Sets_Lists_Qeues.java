/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sets_lists_qeues;
import java.util.*;

/**
 *
 * @author FamilyLaptop
 */
public class Sets_Lists_Qeues {
    
    enum locations {
        Petropavlovsk_Kamchatskiy, Tweebuffelsmeteenskootmorsdoodgeskietfontein, Cochobamba,
        Llanfairpwllgwyngyllgogerychwyrndrobwllllantysili, Gao
    }

    public static void main(String[] args) {
        
        //////////////////////Sets//////////////////////  //ignores repeats
        //Hash set
        System.out.println("\n//Hash Set//\n");
        Set<String> plants = new HashSet<>();
        
        plants.add("Garlic");
        plants.add("Carrot");
        plants.add("Beetroot");
        plants.add("Garlic");
        plants.add("Sweet Potato");
        
        boolean containsCarrot = plants.contains("Carrot");
        System.out.println("Contains carrot? " + containsCarrot);
        
        for (String iLoop : plants){
            System.out.println(iLoop);
        }
        
        //Enumerated List
        System.out.println("\n//Enum Set//\n");
        
        EnumSet<locations> locList = EnumSet.of(locations.Gao, 
                locations.Tweebuffelsmeteenskootmorsdoodgeskietfontein,
                locations.Cochobamba);
        locList.add(locations. Petropavlovsk_Kamchatskiy);
        
        for (locations loc : locList){
            System.out.println(loc);
        }
        
        boolean containsGao = locList.contains(locations.Gao);
        System.out.println("Contains Gao? " + containsGao);
        
        locList.remove(locations.Cochobamba);
        
        int size = locList.size();
        System.out.println("Size: " + size);
        
        locList.clear();
        
        boolean is_Empty = locList.isEmpty();
        System.out.println("Is empty? " + is_Empty);
        
        //////////////////////Sets end//////////////////////
        
        System.out.println("\n//List//\n");
        
        //////////////////////Lists//////////////////////
        
        List<Integer> nums = new ArrayList<>();
        
        nums.add(69);
        nums.add(420);
        nums.add(69);
        nums.add(33);
        nums.add(15);
        
        int firstNumber = nums.get(0);
        System.out.println("First number: " + firstNumber);
        System.out.println("Size of array list: " + nums.size());
        
        for (int iLoop2 : nums){
            System.out.println(iLoop2);
        }
        
        //////////////////////Lists end//////////////////////
        
        System.out.println("\n//Queue//\n");
        
        //////////////////////Queue//////////////////////
        
        Queue<String> what = new LinkedList<>();
        
        what.add("Key");
        what.add("Card");
        what.add("Facial Recognition");
        what.add("Fingerprint");
        what.add("Unlocked");
        
        System.out.println(what);
        
        //////////////////////Queue end//////////////////////
        
        
    }
}
