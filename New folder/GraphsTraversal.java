/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.graphstraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author FamilyLaptop
 * 
 * 0 - 1 - 3
 *     |   |
 *     2   4
 * 
 * https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/ 
 */

//public class vertex{
//    
//}

public class GraphsTraversal {
    public static LinkedList<LinkedList<Integer>> list = new LinkedList<>();
    
    //recursive function for DFS traversal
    public static void DFSRec(LinkedList<LinkedList<Integer>> adj, boolean[] visited, int s){
        visited[s] = true;//mark current vertex as visisted
        
        System.out.println("Current Vertex: " + s + " ");//prints current vertex
    
        //recursively visit all adjacent vertices that are not visited yet
        for (int i : adj.get(s)){
            if(!visited[i]){
                DFSRec(adj, visited, i);
            }
        }
    }
    
    //main dfs function that initialises the visited array
    public static void DFS(LinkedList<LinkedList<Integer>> adj, int s){
        boolean[] visited = new boolean[adj.size()];
        DFSRec(adj, visited, s);
    }
    
    public static void BFS(LinkedList<LinkedList<Integer>> adj, int sourceNode){
        Queue<Integer> q = new LinkedList<>();//create queue for bfs
        
        //initially mark all vertices as not visited, when push a vertex into q, will mark as visted
        boolean[] visited = new boolean[adj.size()];
        
        ///markthe source node as visited
        visited[sourceNode] = true;
        q.add(sourceNode);
        
        //iterate ove the queue
        while (!q.isEmpty()){
            //dequeue a vertex and print it
            int current = q.poll();
            System.out.println(current + " ");
            
            //get all adjacent vertices of dequeued vertex
            //if an adjacent vertex has not been visisted, mark it visited and enqueue it
            for (int x : adj.get(current)){
                if (!visited[x]){
                    visited[x] = true;
                    q.add(x);
                }
            }
        }
    }
    
    //add edge to adjacency list
    public static void addEdge(LinkedList<LinkedList<Integer>> adj, int s, int t){
        adj.get(s).add(t);//add edge from vertex s to t
        adj.get(t).add(s);//due to undirected graph
    }
    
    public static void main(String[] args) {
        int V = 5;//num vertices
        
        for (int i = 0; i < V; i++){
            list.add(new LinkedList<>());
        }
        
        //define edges of the graph
        int[][] edges = {{0, 1}, {1, 2}, {1, 3}, {3, 4}};
        
        
        //populate adjacency list with edges
        for (int[] e : edges){
            addEdge(list, e[0], e[1]);
        }
        
        int source = 0;
//        System.out.println("DFS from source: " + source);
//        DFS(list, source);
        System.out.println("BFS from source: " + source);
        BFS(list, 0);
        
        System.out.println("DFS from source: " + source);
        DFS(list, 0);
    }
}
