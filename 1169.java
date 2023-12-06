class Solution {
    public class Transaction {
        String name;
        int time;
        int amount;
        String city;
        int index;

        public Transaction(String name, int time, int amt, String city, int i) {
            this.name = name;
            this.time = time;
            this.amount = amt;
            this.city = city;
            this.index = i;
        }
    }

    public List<String> invalidTransactions(String[] transactions) {
        Transaction[] transArr = new Transaction[transactions.length];
        boolean[] added = new boolean[transactions.length];

        for (int i = 0; i < transactions.length; i++) {
            String t = transactions[i];
            String[] tSplit = t.split(",", 0);

            String name = tSplit[0];
            int time = Integer.parseInt(tSplit[1]);
            int amount = Integer.parseInt(tSplit[2]);
            String city = tSplit[3];

            transArr[i] = new Transaction(name, time, amount, city, i);
        }

        Arrays.sort(transArr, (a, b) -> a.name.compareTo(b.name));

        List<String> ret = new ArrayList<>();

        for (int i = 0; i < transArr.length; i++) {
            String name = transArr[i].name;
            int time = transArr[i].time;
            int amt = transArr[i].amount;
            String city = transArr[i].city;

            if (amt > 1000 && !added[i]) {
              ret.add(transactions[transArr[i].index]);
              added[i] = true;
            }

            for (int j = i+1; j < transArr.length; j++) { 
              String name2 = transArr[j].name;
              int time2 = transArr[j].time;
              String city2 = transArr[j].city;

              if (!name.equals(name2)) {
                break;
              }

              if (Math.abs(time2 - time) <= 60 && !city.equals(city2)) {
                if (!added[i]) {
                  ret.add(transactions[transArr[i].index]);
                  added[i] = true;
                }

                if (!added[j]) {
                  ret.add(transactions[transArr[j].index]);
                  added[j] = true;
                }
              }
            }
        }

        return ret;
    }
}