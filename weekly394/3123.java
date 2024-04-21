class Solution {
    class Edge {
       int source;
       int nbr;
       int weight;
        int index;
    
       Edge(int source, int nbr, int weight, int index) {
         this.source = source;
         this.nbr = nbr;
         this.weight = weight;
           this.index = index;
       }
        
        public String toString() {
           return "src: " + this.source + " nbr: " + this.nbr + " weight: " + this.weight + " i: " + this.index;   
        }
     }
     
     //making a pair class
     class Pair implements Comparable< Pair> {
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
   
   private void traverse (boolean[] isInShortestPaths, List<Edge>[] prevArr, int i, boolean[] visited) {
       if (visited[i] || i == 0) return;
       visited[i] = true;
       
       for (Edge e : prevArr[i]) {
           isInShortestPaths[e.index] = true;
           traverse(isInShortestPaths, prevArr, e.source, visited);
       }
   }
   
   public boolean[] findAnswer(int n, int[][] edges) {
       ArrayList<Edge> [] graph =  new ArrayList[n];
       for(int i = 0; i < graph.length; i++){
           graph[i] = new ArrayList<>();
       }
       
       for (int i = 0; i < edges.length; i++) {
           graph[edges[i][0]].add(new Edge(edges[i][0], edges[i][1], edges[i][2], i));
           graph[edges[i][1]].add(new Edge(edges[i][1],edges[i][0],edges[i][2], i));
       }
       
       int src = 0;
       
       //creating a visited boolean array
       boolean[] visited = new boolean[graph.length];
       List<Edge>[] prevArr = new ArrayList[n];
       for(int i = 0; i < prevArr.length; i++){
           prevArr[i] = new ArrayList<>();
       }
       
       int[] distArr = new int[n];
       Arrays.fill(distArr, Integer.MAX_VALUE);
       
       
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
         //System.out.println("Vertex :" + " " +map.get(topEle.vertex) + " & " + "Weight so far :" + " " +topEle.wsf);
         
         //adding all the unvisited neighbor of vertex in queue
         for (Edge edge : graph[topEle.vertex]) {
           //if (visited[edge.nbr] == false) {
             if (distArr[edge.nbr] > topEle.wsf + edge.weight) {
                 distArr[edge.nbr] = topEle.wsf + edge.weight;
                 prevArr[edge.nbr] = new ArrayList<>();
                 prevArr[edge.nbr].add(edge);
                 prioQue.add(new Pair(edge.nbr, topEle.wsf + edge.weight ));
             }
             else if (distArr[edge.nbr] == topEle.wsf + edge.weight) {
                 prevArr[edge.nbr].add(edge);
                 prioQue.add(new Pair(edge.nbr, topEle.wsf + edge.weight ));
             }
           //}
         }
       }
       
       //System.out.println(prevArr[0].toString());
       
       boolean[] isInShortestPaths = new boolean[edges.length];
       
       traverse(isInShortestPaths, prevArr, n-1, new boolean[n]);
       
       return isInShortestPaths;
       
   }
}