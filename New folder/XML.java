/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.xml;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author FamilyLaptop
 */
public class XML {

    public static void main(String[] args) {
        try{
            SAXParserFactory newFactory = SAXParserFactory.newInstance();
            SAXParser newSAXParser = newFactory.newSAXParser();
            
            DefaultHandler handler = new DefaultHandler(){
                boolean bName = false;
                boolean bYear = false;
                boolean bLeader = false;
                
                @Override
                public void startElement(String url, String localName, 
                        String qName, Attributes attributes) throws SAXException{
                    
//                    System.out.println("Start Element: " + qName);
                    
                    if (qName.equalsIgnoreCase("NAME")){
                        bName = true;
                    }
                    if (qName.equalsIgnoreCase("YEAR")){
                        bYear = true;
                    }
                    if (qName.equalsIgnoreCase("LEADER")){
                        bLeader = true;
                    }                 
                }
                
                @Override
                public void endElement(String url, String localName, 
                        String qName) throws SAXException {
//                    System.out.println("End Element: " + qName);
                }
                
                @Override
                public void characters(char ch[], int start, int length) throws SAXException{
                    if (bName){
                        System.out.println("Name: " + new String(ch,start,length));
                        bName = false;
                    }
                    if (bYear){
                        System.out.println("Year entered: " + new String(ch,start,length));
                        bYear = false;
                    }
                    if (bLeader){
                        System.out.println("Leader: " + new String(ch,start,length) + "\n");
                        bLeader = false;
                    }
                    
                }
            };
            
            newSAXParser.parse("C:\\Users\\FamilyLaptop\\Documents\\NetBeansProjects\\XML\\WW2 Allies.xml", handler);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
