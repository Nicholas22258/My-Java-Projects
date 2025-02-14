/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.busroutes;

import java.util.LinkedList;

/**
 *
 * @author Nicholas Leong EDUV4551823
 * 
 * The information for the bus routes and bus stops was collected from Google
 * Maps, however bus routes were not always provided for some routed, so taxi
 * routes were used instead due to their similarity to bus routes. 
 * There were also no specific destinations in the question paper, so I chose a 
 * popular landmark as a specific destination to input into Google Maps. These 
 * will also serve as the specific destination for the next league of the 
 * journey:
 * Johannesburg CBD - 50 -54 Marshell street and, Ferreira St, Johannesburg, 2000
 * Park Station - A 41, Park Station, Rissik St, CBD, Johannesburg, 2001 
 * Midrand - Magwa Cres, Waterval 5-Ir, Midrand, 1686 (Mall of Africa)
 * Centurion -  1269 Gordon Hood Rd, Centurion Central, Pretoria, 0046 (Centurion Mall)
 * Pretoria CBD - Boom St, Daspoort 319-Jr, Pretoria
 * 
 * Graph:
 *                  Pretoria CBD
 *                    /
 *              Centurion
 *                  |
 *              Midrand
 *                /
 *          Park Station
 *              / 
 * Johannesburg CBD
 */
public class BusRoutes {
    private static LinkedList<BusRouteInfo> busRouteInfoList = new LinkedList<>();
    private static LinkedList<LinkedList<Integer>> busRouteInfo = new LinkedList<>();
    /*
    The idea is to have a linked list of the bus route information, where the 
    index (which is the same as the vertex) will be fed to the graph.
    When displaying, a condition will be used to locate the relevant information
    */
    
    //recursive function that will DFS traverse the graph
    public static void DFSRec(LinkedList<LinkedList<Integer>> adj, boolean[] visited, int s){
        String toDisplay = "";//will allow for neat displaying
        
        //Current vertex is marked as selected
        visited[s] = true;
        //Print current vertex (current location along bus route)
        for (int i = 0; i < busRouteInfoList.size(); i++){
            if (s == busRouteInfoList.get(i).getVertex()){
                toDisplay += "Current Location: " + busRouteInfoList.get(i).getStartLoc();
                toDisplay += "\nRoute Information: \n" + busRouteInfoList.get(i).getRouteDescr();
                toDisplay += "Next Location: " + busRouteInfoList.get(i).getEndLoc();
                toDisplay += "\nEstimated Travel Time: " + busRouteInfoList.get(i).getEstimatedTravelTime();
                break;
            }
        }
            System.out.println(toDisplay + "\n-------------------------------------------------------------");
        //Recursively visit any adjacent, unvisited vertices
        for (int i = 0; i < adj.size(); i++){
            if (!visited[i]){
                DFSRec(adj, visited, i);
            }
        }
    }
    
    //Function that will be called to initialise array and traverse the graph
    public static void DFS(LinkedList<LinkedList<Integer>> adj, int s){
        boolean[] visited = new boolean[adj.size()];
        DFSRec(adj, visited, s);
    }
    
    //Adds an edge to the the adjacency list
    public static void addEdge(LinkedList<LinkedList<Integer>> adj, int s, int t){
        adj.get(s).add(t);//creates an edge between s and t
        adj.get(t).add(s);
    }
    
    public static void main(String[] args) {
        //Data for graph
        final String johannesburg = """
                     50-54 Marshell street and, Ferreira St, Johannesburg, 2000 (Walk From)
                     45 Albertina Sisulu Rd, Johannesburg, 2000 (End Walk & Start Bus)
                     Library Gardens East (Bus Stop)
                     Rissik Street (Bus Stop)
                     Braamfontein, Johannesburg, 2017 (End Bus & Start Walk)
                     A 41, Park Station, Rissik St, CBD, Johannesburg, 2001 (End Walk)
                     """;                           //index = vertex
        BusRouteInfo Johannesburg = new BusRouteInfo(0, "Johannesburg CBD", johannesburg, "Parktown", "+- 15 Minutes");
        
        final String parkStation = """
                     A 41, Park Station, Rissik St, CBD, Johannesburg, 2001 (Start Walk)
                     Joubert Street Taxi Rank & Rissik Str (End Taxi & Start Taxi)
                     Wanderers St, CBD, Johannesburg, 2001 (End Taxi & Start Walk)
                     MTN Taxi Rank, Plein Str (End Walk & Start Taxi)
                     Magwa Cres, Waterval 5-Ir, Midrand, 1686 (End Taxi)
                     """;
        BusRouteInfo ParkStation = new BusRouteInfo(1, "Park Station", parkStation, "Midrand (Mall of Africa)", "+- 1 Hour");
        
        final String midrand = """
                     Magwa Cres, Waterval 5-Ir, Midrand, 1686 (Start Walk)
                     Mall of Africa, Karkloof Crescent, Magwa Crescent (End Walk & Start Taxi)
                     BP Garage, Waterfall Drv (Taxi Stop)
                     Kyalami Estate, Midrand, 1684 (End Taxi & Start Walk)
                     Crowthorne AH, Midrand, 1684 (End Walk & Start Taxi)
                     Rowthorne Shopping Centre, Main Rd (Taxi Stop)
                     Olievenhuisenbosch Taxi Rank, Main Rd (Taxi Stop)
                     Philena Primary School, Imbongolo Ave (Taxi Stop)
                     Olievenhoutbosch Pretoria Taxi Rank, Bohlale Str (End Taxi & Start Walk)
                     Olievenhoutbosch Taxi Rank, Naledi Str (End Walk & Start Taxi)
                     Centurion Central, Centurion, 0046 (End Taxi & Start Walk)
                     1269 Gordon Hood Rd, Centurion Central, Pretoria, 0046 (End Walk)
                     """;
        BusRouteInfo Midrand = new BusRouteInfo(2, "Midrand (Mall of Africa)", midrand, "Centurion (Centurion Mall)", "+- 1 Hour 36 Minutes");
        
        final String centurion = """
                     Lenchen Ave & Embankment Rd - Centurion Terminus (Start Bus)
                     Lenchen Ave & West Ave (Bus Stop)
                     Von Willich Ave & Lenchen Ave (Bus Stop)
                     Von Willich Ave -Opposite Bateleur Complex (Bus Stop)
                     Jean Ave & Gerhard Street (Bus Stop)
                     Clifton Ave - Opposite Hoerskool Centurion (Bus Stop)
                     Clifton Ave & North St (Bus Stop)
                     Snake Valley Rd - Opposite SAAF 68 Air School 1 (Bus Stop)
                     Snake Valley Rd - Opposite SAAF 68 Air School 2 (Bus Stop)
                     Snake Valley Rd - Opposite Dod Technical Unit (Bus Stop)
                     Snake Valley Rd - Centurion Shooting Club (Bus Stop)
                     Snake Valley Rd & Old Johannesburg Rd (Bus Stop)
                     Trichardt Rd - Voortekker Monument Gate Two (Bus Stop)
                     Kgosi Mampuru St & Klawer St - Kgosi Mampuru Prison (Bus Stop)
                     Kgosi Mampuru St & Dequar Rd (Bus Stop)
                     Kgosi Mampuru St & Minaar St (Bus Stop)
                     Francis Baard St & Kgosi Mampuru St (Bus Stop)
                     Francis Baard St & Sophie de Bruyn St (Bus Stop)
                     Bosman St & Pretorius St (End Bus & Start Gautrain)
                     Bosman St & Madiba St (End Gautrain & Start Walk)
                     153 M18, Pretoria Central, Pretoria, 0002 (End Walk)
                     """;
        BusRouteInfo Centurion = new BusRouteInfo(3, "Centurion (Centurion Mall)", centurion, "Pretoria CBD", "+- 1 Hour 40 Minutes");
        
        //no traversal data for Pretoria as it is the end location
        BusRouteInfo Pretoria = new BusRouteInfo(4, "Pretoria CBD", "N/A", "Pretoria CBD", "0 Minutes");
        
        busRouteInfoList.add(Johannesburg); //JHB - abbreviations
        busRouteInfoList.add(ParkStation);  //PKS
        busRouteInfoList.add(Midrand);      //MID
        busRouteInfoList.add(Centurion);    //CEN
        busRouteInfoList.add(Pretoria);     //PTA
        
        int numVertices = 5;//number of vertices in the graph
        
        for (int i = 0; i < numVertices; i++){
            busRouteInfo.add(new LinkedList<>());
        }
        
        int vertexJHB = Johannesburg.getVertex();//vertex = 0
        int vertexPKS = ParkStation.getVertex();//vertex = 1
        int vertexMID = Midrand.getVertex();//vertex = 2
        int vertexCEN = Centurion.getVertex();//vertex = 3
        int vertexPTA = Pretoria.getVertex();//vertex = 4
        
        //create edge locations
        int[][] edges = {{vertexJHB, vertexPKS}, {vertexPKS, vertexMID}, 
                         {vertexMID, vertexCEN}, {vertexCEN, vertexPTA}};
        
        for (int[] e : edges){
            addEdge(busRouteInfo, e[0], e[1]);
        }//creates the edges for the graph
        
        int source = 0;//start vertex
//        System.out.println("Start journey: " + source);
        DFS(busRouteInfo, source);
    }
}
