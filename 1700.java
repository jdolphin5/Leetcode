class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> studentQueue = new LinkedList<>();
        Stack<Integer> sandwichStack = new Stack<>();

        for (int num : students) {
            studentQueue.offer(num);
        }

        for (int i = sandwiches.length - 1; i >= 0; i--) {
            sandwichStack.push(sandwiches[i]);
        }

        boolean continueBool = true;

        while (continueBool) {
            int startSize = studentQueue.size();
            continueBool = false;
            int i = 0;

            while (i < startSize) {
                if (studentQueue.peek() == sandwichStack.peek()) {
                    studentQueue.poll();
                    sandwichStack.pop();
                    continueBool = true;
                }
                else {
                    studentQueue.offer(studentQueue.poll());
                }

                i++;
            }
        }

        return studentQueue.size();
    }
}