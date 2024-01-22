package Graphs;
import java.io.*;
import java.util.*;

public class Main {
	
	  // making an edge class that stores the vertex and its neighbor along with the weight
	  static class Edge {
	    int source;
	    int nbr;
	    int weight;
	 
	    Edge(int source, int nbr, int weight) {
	      this.source = source;
	      this.nbr = nbr;
	      this.weight = weight;
	    }
	  }
	  
	  //making a pair class
	 static class Pair implements Comparable< Pair> {
	    int vertex;
	    int wsf; //weight so far
	 
	    Pair(int vertex, int wsf) {
	      this.vertex = vertex;
	      this.wsf = wsf;
	    }
	    // using CompareTo function so that priority queue arranges the element in terms of weight so far
	    public int compareTo(Pair o) {
	      return this.wsf - o.wsf;
	    }
	  }
	  
	  public static void main(String[] args) {
	    
	    // building the graph
		// the graph is an array of ArrayList (of Object,Edge)
		// length of array = the vertices present in graph.
		  
	    ArrayList<Edge> [] graph =  new ArrayList[7];
	    for(int i = 0; i < graph.length; i++){
	        graph[i] = new ArrayList<>();
	    }
	    
	    //creating a hashmap to store mapped values
	    HashMap<Integer, String> map= new HashMap<>();
	    
	    // if graph vertices consisted of strings rather than numbers
	    map.put(0, "India");
	    map.put(1, "China");
	    map.put(2, "France");
	    map.put(3, "England");
	    map.put(4, "Japan");
	    map.put(5, "America");
	    map.put(6, "Russia");
	    
	    // Adding all the vertices and its members along with weights
	    
	    graph[0].add(new Edge(0,1,14));
	    graph[0].add(new Edge(0,3,5));
	    
	    graph[1].add(new Edge(1,0,14));
	    graph[1].add(new Edge(1,4,2));
	    graph[1].add(new Edge(1,2,6));
	    
	    graph[2].add(new Edge(2,1,6));
	    graph[2].add(new Edge(2,5,1));
	    graph[2].add(new Edge(2,6,7));
	    
	    graph[3].add(new Edge(3,0,5));
	    graph[3].add(new Edge(3,4,3));
	    
	    graph[4].add(new Edge(4,3,3));
	    graph[4].add(new Edge(4,1,2));
	    
	    graph[5].add(new Edge(5,2,1));
	    graph[5].add(new Edge(5,6,8));
	    
	    graph[6].add(new Edge(6,2,7));
	    graph[6].add(new Edge(6,5,8));
	    
	    //taking 0 as source node
	    int src = 0;
	    
	    //creating a visited boolean array
	    boolean[] visited = new boolean[graph.length];
	    
	    //Initialising a priority Queue of object Pair
	    PriorityQueue< Pair> prioQue = new PriorityQueue<>();
	    prioQue.add(new Pair(src, 0));
	    
	    // while queue is not empty following the procedure remove,mark,print,add
	    
	    while (prioQue.size() > 0) {
	    	
	      // removing the topmost element and storing it in topEle
	      Pair topEle = prioQue.remove();
	      
	      //checking if vertex already visited
	      if (visited[topEle.vertex] == true) {
	        continue;
	      }
	      // marking true if  vertex not visited
	      visited[topEle.vertex] = true;
	      
	      //Printing the vertex and weight to reach that vertex
	      System.out.println("Vertex :" + " " +map.get(topEle.vertex) + " & " + "Weight so far :" + " " +topEle.wsf);
	      
	      //adding all the unvisited neighbor of vertex in queue
	      for (Edge edge : graph[topEle.vertex]) {
	        if (visited[edge.nbr] == false) {
	          prioQue.add(new Pair(edge.nbr, topEle.wsf + edge.weight ));
	        }
	      }
	    }
	  }
}