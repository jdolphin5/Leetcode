class Solution {
    // making an edge class that stores the vertex and its neighbor along with the weight
    static class Edge {
      int source;
      int nbr;
      double weight;
   
      Edge(int source, int nbr, double weight) {
        this.source = source;
        this.nbr = nbr;
        this.weight = weight;
      }
    }
    
    //making a pair class
   static class Pair implements Comparable< Pair> {
      int vertex;
      double wsf; //weight so far
   
      Pair(int vertex, double wsf) {
        this.vertex = vertex;
        this.wsf = wsf;
      }
      // using CompareTo function so that priority queue arranges the element in terms of weight so far
      public int compareTo(Pair o) {
        return 0;
      }
    }



  public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
      ArrayList<Edge>[] graph = new ArrayList[n];

      for (int i = 0; i < graph.length; i++) {
          graph[i] = new ArrayList<>();
      }

      for (int i = 0; i < edges.length; i++) {
          int a = edges[i][0];
          int b = edges[i][1];
          double successProb = succProb[i];

          graph[a].add(new Edge(a, b, successProb));
          graph[b].add(new Edge(b, a, successProb));
      }

      double ret = Double.MIN_VALUE;

      //taking 0 as source node
      int src = start_node;
      
      //creating a visited boolean array
      boolean[] visited = new boolean[graph.length];
      
      //Initialising a priority Queue of object Pair
      PriorityQueue<Pair> prioQue = new PriorityQueue<>((a, b) -> Double.compare(b.wsf, a.wsf));
      prioQue.add(new Pair(src, 1));
      
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
        //System.out.println("Vertex :" + " " + topEle.vertex + " & " + "Weight so far :" + " " +topEle.wsf);

        if (topEle.vertex == end_node) {
          ret = Math.max(ret, topEle.wsf);
        }
        
        //adding all the unvisited neighbor of vertex in queue
        for (Edge edge : graph[topEle.vertex]) {
          if (visited[edge.nbr] == false) {
            prioQue.add(new Pair(edge.nbr, topEle.wsf * edge.weight ));
          }
        }
      }

      return ret == Double.MIN_VALUE ? 0 : ret;
  }
}