class SORTracker {
    public class Location {
        String name;
        int score;

        public Location(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    List<Location> myList;
    int i;

    public SORTracker() {
        myList = new ArrayList<>();
        i = 0;
    }
    
    public void add(String name, int score) {
        int x = 0;

        while (x < myList.size()) {
            if (myList.get(x).score > score || (myList.get(x).score == score && myList.get(x).name.compareTo(name) < 0)) {
                x++;
            }
            else {
                break;
            }
        }

        myList.add(x, new Location(name, score));
    }
    
    public String get() {
        String ret = myList.get(i).name;
        i++;

        return ret;
    }
}

/**
 * Your SORTracker object will be instantiated and called as such:
 * SORTracker obj = new SORTracker();
 * obj.add(name,score);
 * String param_2 = obj.get();
 */