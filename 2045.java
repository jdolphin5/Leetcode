class Solution {
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

    public int secondMinimum(int n, int[][] edges, int time, int change) {
        ArrayList<Edge>[] graph =  new ArrayList[n+1];
	    for(int i = 0; i < graph.length; i++){
	        graph[i] = new ArrayList<>();
	    }

        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];

            graph[a].add(new Edge(a, b, time));
            graph[b].add(new Edge(b, a, time));
        }

        //taking 1 as source node
	    int src = 1;
	    
	    //creating a visited boolean array
	    int[] visited = new int[graph.length];
        int[] dist1 = new int[n + 1];
        int[] dist2 = new int[n + 1];
        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);
        dist1[src] = 0;
	    
	    //Initialising a priority Queue of object Pair
	    PriorityQueue< Pair> prioQue = new PriorityQueue<>();
	    prioQue.add(new Pair(src, 0));
	    
	    // while queue is not empty following the procedure remove,mark,print,add
	    
	    while (prioQue.size() > 0) {
	    	
	      // removing the topmost element and storing it in topEle
	      Pair topEle = prioQue.remove();
	      
	      //checking if vertex already visited
	      //if (visited[topEle.vertex] == true) {
	      //  continue;
	      //}
	      // marking true if  vertex not visited
	      visited[topEle.vertex]++;
	      
	      //Printing the vertex and weight to reach that vertex
	      //System.out.println("Vertex :" + " " + topEle.vertex + " & " + "Weight so far :" + " " + topEle.wsf);

            if (topEle.vertex == n && visited[n] == 2) {
                return topEle.wsf;
            }

            //6 / 3 == 2, 2 % 2 == 0
            //7 / 3 == 2, 2 % 2 == 0
            //8 ...
            //9 / 3 == 3, 3 % 2 == 1
            //topEle.wsf % change
            //10 / 3 == 3, 3 % 2 == 1, 10 % 3 == 1, 10 - 1 + time
            //11 / 3 == 3, 3 % 2 == 1, 11 % 3 == 2, 11 - 2 + time

            if ((topEle.wsf / change) % 2 == 1) {
                //topEle.wsf = topEle.wsf + time - (topEle.wsf % change);
                topEle.wsf = change * (topEle.wsf / change + 1) + time;
            }
            else {
                topEle.wsf += time;
            }

	      //adding all the unvisited neighbor of vertex in queue
	      for (Edge edge : graph[topEle.vertex]) {

            if (visited[edge.nbr] == 2) continue;

                if (dist1[edge.nbr] > topEle.wsf) {
                dist2[edge.nbr] = dist1[edge.nbr];
                dist1[edge.nbr] = topEle.wsf;
                prioQue.add(new Pair(edge.nbr, topEle.wsf ));
            }
            else if (dist2[edge.nbr] > topEle.wsf && dist1[edge.nbr] != topEle.wsf) {
                dist2[edge.nbr] = topEle.wsf;
                prioQue.add(new Pair(edge.nbr, topEle.wsf ));
            }
	    }
        }
        return -1;
    }
}