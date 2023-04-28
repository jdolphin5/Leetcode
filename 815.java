class Pair{
    int node,lev;
    Pair(int node,int lev)
    {
        this.node=node;
        this.lev=lev;
    }
}
class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source==target)
            return 0;
        HashMap<Integer,Set<Integer>> map = new HashMap<>();
        int res = 0;
        Queue<Pair> q = new LinkedList<>();
        Set<Integer> vis_stops = new HashSet<>();

        for(int i = 0;i < routes.length; i++)
        {
            Set<Integer> temp = new HashSet<>();
            for(int it : routes[i])
                temp.add(it);
            map.put(i, temp);
        }
        
        HashMap<Integer,Set<Integer>> stop_bus = new HashMap<>();

        for(int i = 0;i < routes.length; i++)
        {
            for(int it : routes[i])
            {
                if(stop_bus.containsKey(it)){
                    Set<Integer> temp  = new HashSet<>();
                    for(int itr : stop_bus.get(it))
                        temp.add(itr);
                    temp.add(i);
                    stop_bus.put(it,temp);
                }
                else{
                    Set<Integer> temp = new HashSet<>();
                    temp.add(i);
                    stop_bus.put(it, temp);
                }
            }
        }
        

        q.add(new Pair(source,1));
        while(!q.isEmpty())
        {
            int node = q.peek().node;
            int lev = q.peek().lev;
            q.remove();
            Set<Integer> vis_bus = new HashSet<>();

            for(int bus: stop_bus.get(node))
            {
                if((map.get(bus)).contains(target))
                    return lev;
            
                else
                {
                    if(!vis_stops.contains(bus))
                    
                    {
                        for(int it: map.get(bus))
                        {
                            if(!vis_bus.contains(it)){
                                vis_bus.add(it);
                                q.add(new Pair(it, lev + 1));
                            
                            }

                        }
                    }

                    vis_stops.add(bus);
                    
                }
            }

        }
        return -1;

    }
}