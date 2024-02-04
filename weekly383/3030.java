class Solution {
    private boolean isRegion(int[][] image, int threshold, int i, int j) {
        
        if (Math.abs(image[i][j] - image[i+1][j]) > threshold) return false;
        if (Math.abs(image[i][j] - image[i][j+1]) > threshold) return false;
        
        if (Math.abs(image[i][j+2] - image[i][j+1]) > threshold) return false;
        if (Math.abs(image[i][j+2] - image[i+1][j+2]) > threshold) return false;
        
        if (Math.abs(image[i+2][j] - image[i+2][j+1]) > threshold) return false;
        if (Math.abs(image[i+2][j] - image[i+1][j]) > threshold) return false;

        if (Math.abs(image[i+2][j+2] - image[i+2][j+1]) > threshold) return false;
        if (Math.abs(image[i+2][j+2] - image[i+1][j+2]) > threshold) return false;
        
        if (Math.abs(image[i+1][j+1] - image[i+1][j+2]) > threshold) return false;
        if (Math.abs(image[i+1][j+1] - image[i+2][j+1]) > threshold) return false;
        if (Math.abs(image[i+1][j+1] - image[i+1][j]) > threshold) return false;
        if (Math.abs(image[i+1][j+1] - image[i][j+1]) > threshold) return false;
        
        return true;
    }
    
    private int getAvg(int[][] image, int i, int j) {
        int ret = 0;
        
        for (int x = i; x < i+3; x++) {
            for (int y = j; y < j + 3; y++) {
                ret += image[x][y];
            }
        }
        
        ret /= 9;
        
        //System.out.println(ret);
        
        return ret;
    }
    
    public int[][] resultGrid(int[][] image, int threshold) {
        List<Integer>[][] regionListArr = new ArrayList[image.length][image[0].length];
        
        
        Integer[][] regionNumber = new Integer[image.length-2][image[0].length-2];
        int regionCt = 0;
        int[] regionAvg = new int[250001];
        
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                regionListArr[i][j] = new ArrayList<>();
            }
        }
        
        for (int i = 0; i < image.length - 2; i++) {
            for (int j = 0; j < image[0].length - 2; j++) {
                
                if (isRegion(image, threshold, i, j)) {
                    //System.out.println("i: " +i + " j: "+ j);
                    
                    for (int x = i; x < i+3; x++) {
                        for (int y = j; y < j+3; y++) {
                            regionListArr[x][y].add(regionCt);
                        }
                    }
                    regionAvg[regionCt] = getAvg(image, i, j);
                    regionNumber[i][j] = regionCt++;
                }
            }
        }
        
        int[][] ret = new int[image.length][image[0].length];
        
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                if (regionListArr[i][j].size() == 0) {
                    ret[i][j] = image[i][j];
                }
                else {
                    double sum = 0.0;
                    for (int x = 0; x < regionListArr[i][j].size(); x++) {
                        sum += regionAvg[regionListArr[i][j].get(x)];
                    }
                    
                    ret[i][j] = (int)(sum / regionListArr[i][j].size());
                }
            }
        }
        
        return ret;
    }
}