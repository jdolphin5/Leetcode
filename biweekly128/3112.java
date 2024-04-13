class Solution {
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
    
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {        
        ArrayList<Edge> [] graph =  new ArrayList[n];
	    for(int i = 0; i < graph.length; i++){
	        graph[i] = new ArrayList<>();
	    }
        
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            int len = edge[2];
            
            graph[a].add(new Edge(a, b, len));
            graph[b].add(new Edge(b, a, len));
        }
        
            int[] ret = new int[disappear.length];
        
        Arrays.fill(ret, Integer.MAX_VALUE);
        
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
                
            if (topEle.wsf >= disappear[topEle.vertex]) {
                continue;    
            }
                ret[topEle.vertex] = Math.min(ret[topEle.vertex], topEle.wsf);

              //Printing the vertex and weight to reach that vertex
              //System.out.println("Vertex :" + " " +map.get(topEle.vertex) + " & " + "Weight so far :" + " " +topEle.wsf);
                

              //adding all the unvisited neighbor of vertex in queue
              for (Edge edge : graph[topEle.vertex]) {
                if (visited[edge.nbr] == false) {
                  prioQue.add(new Pair(edge.nbr, topEle.wsf + edge.weight ));
                }
              }
            }
        
        
        for (int i = 0; i < ret.length; i++) {
            if (ret[i] == Integer.MAX_VALUE) {
                ret[i] = -1;
            }
        }
        
        return ret;
    }
}