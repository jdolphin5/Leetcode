class Solution {
    public int compareVersion(String version1, String version2) {
        //double \ to regex escape .
        String[] split1 = version1.split("\\.", 0);
        String[] split2 = version2.split("\\.", 0);

        for (int i = 0; i < Math.max(split1.length, split2.length); i++) {
            int a = 0;
            int b = 0;

            if (i < split1.length) {
                a = Integer.parseInt(split1[i]);
            }

            if (i < split2.length) {
                b = Integer.parseInt(split2[i]);
            }

            if (a < b) return -1;
            if (a > b) return 1;
        }

        return 0;
    }
}