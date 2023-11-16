class Solution {
    private int countWords(String message) {
        int wordCount = 0;
        boolean spaceFound = true;

        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);

            if (c == ' ') {
                spaceFound = true;
            }
            else if (spaceFound) {
                spaceFound = false;
                wordCount++;
            }
        }

        return wordCount;
    }

    public String largestWordCount(String[] messages, String[] senders) {
        Map<String, Integer> senderWordCountMap = new HashMap<>();

        for (int i = 0; i < messages.length; i++) {
            int cur = senderWordCountMap.getOrDefault(senders[i], 0);
            senderWordCountMap.put(senders[i], cur + countWords(messages[i]));
        }

        int max = 0;
        String topSender = "";

        for (Map.Entry<String, Integer> entry : senderWordCountMap.entrySet()) {
            String sender = entry.getKey();
            int wordCount = entry.getValue();

            if (wordCount > max) {
                max = wordCount;
                topSender = sender;
            }
            else if (wordCount == max) {
                if (topSender.compareTo(sender) < 0) {
                    topSender = sender;
                }
            }
        }

        return topSender;
    }
}