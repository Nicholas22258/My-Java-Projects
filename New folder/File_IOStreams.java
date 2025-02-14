/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.file_io.streams;

import java.io.*;


/**
 *
 * @author FamilyLaptop
 */
public class File_IOStreams {

    public static void main(String[] args) {
//        try {
//            FileWriter fileWriter = new FileWriter("C:\\Users\\FamilyLaptop\\Documents\\NetBeansProjects\\File_IO-Streams\\New_File.txt");
//            fileWriter.write("Execute order 69\n");
//            fileWriter.write("Find Ttub Gulp!\n");
//            fileWriter.write("Get ready!\n");
//            fileWriter.close();
//            System.out.println("Text written successfully");
//        }catch (IOException e){
//            System.out.println("Error: " + e);
//        }

        try {
            FileReader fileReader = new FileReader("C:\\Users\\FamilyLaptop\\Documents\\NetBeansProjects\\File_IO-Streams\\New_File.txt");
            BufferedReader br = new BufferedReader(fileReader);
            String s;
            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }
            fileReader.close();
        } catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }

    }
}
