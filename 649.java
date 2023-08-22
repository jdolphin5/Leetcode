class Solution {
    public String predictPartyVictory(String senate) {
        String[] res = new String[] {"Radiant", "Dire"};
        LinkedList<Integer> rQ = new LinkedList<>();
        LinkedList<Integer> dQ = new LinkedList<>();

        for (int i = 0; i < senate.length(); i++) {
            char c = senate.charAt(i);

            if (c == 'R') {
                rQ.offer(1);
            }
            else {
                dQ.offer(1);
            }
        }

        String check = senate;
        while (true) {
            for (int i = 0; i < check.length(); i++) {
                char c = check.charAt(i);

                if (c == 'R') {
                    dQ.poll();
                    if (check.substring(i, check.length()).contains("D"))
                        check = check.substring(0, i) + check.substring(i, check.length()).replaceFirst("D", "X");
                    else
                        check = check.replaceFirst("D", "X");
                }
                else if (c == 'D'){
                    rQ.poll();
                    if (check.substring(i, check.length()).contains("R"))
                        check = check.substring(0, i) + check.substring(i, check.length()).replaceFirst("R", "X");
                    else
                        check = check.replaceFirst("R", "X");
                }

                if (dQ.isEmpty()) {
                    return res[0];
                }
                else if (rQ.isEmpty()) {
                    return res[1];
                }
            }
            //System.out.println(check);
        }
    }
}