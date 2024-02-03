class Solution {
    public int numberOfPairs(int[][] points) {
        Arrays.sort(points, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        
        int ret = 0;
        
        /*
        for (int[] point : points) {
            System.out.println(Arrays.toString(point));
        }
        */
        
        for (int i = 0; i < points.length; i++) {
            int[] point1 = points[i];
            
            for (int j = i+1; j < points.length; j++) {
                int[] point2 = points[j];
                
                if (point1[0] <= point2[0] && point1[1] >= point2[1]) {
                    boolean good = true;
                    for (int k = 0; k < points.length; k++) {
                        if (k == i || k == j) continue;
                        int[] point3 = points[k];
                        if (point3[0] >= point1[0] && point3[0] <= point2[0] && point3[1] <= point1[1] && point3[1] >= point2[1]) {
                            good = false;
                            break;
                        }

                    }
                    
                    if (good) {
                        //System.out.println("point1: " + Arrays.toString(point1) + " point2: " + Arrays.toString(point2));
                        ret++;
                    }
                }
            }
        }
        
        return ret;
    }
}