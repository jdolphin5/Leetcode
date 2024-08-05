class Solution {
    private static class Edge {
	    int source;
	    int nbr;
	    int weight;
	 
        Edge(int source, int nbr, int weight) {
            this.source = source;
            this.nbr = nbr;
            this.weight = weight;
        }
	}

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

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        ArrayList<Edge>[] graph =  new ArrayList[n];

        graph[0] = new ArrayList<>();
        
	    for(int i = 0; i < graph.length-1; i++){
	        graph[i+1] = new ArrayList<>();
            graph[i].add(new Edge(i, i+1, 1));
            //graph[i+1].add(new Edge(i+1, i, 1));
	    }

        int[] ret = new int[queries.length];

        for (int x = 0; x < queries.length; x++) {
            graph[queries[x][0]].add(new Edge(queries[x][0], queries[x][1], 1));
            //graph[queries[x][1]].add(new Edge(queries[x][1], queries[x][0], 1));

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
            //System.out.println("Vertex :" + " " + topEle.vertex + " & " + "Weight so far :" + " " +topEle.wsf);
            if (topEle.vertex == n-1) {
                ret[x] = topEle.wsf;
                break;
            }
            
            //adding all the unvisited neighbor of vertex in queue
            for (Edge edge : graph[topEle.vertex]) {
                if (visited[edge.nbr] == false) {
                    prioQue.add(new Pair(edge.nbr, topEle.wsf + edge.weight ));
                }
            }
            }
        }

        return ret;
    }
}