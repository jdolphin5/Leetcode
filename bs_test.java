public class bs_test {

    private static int binarySearch(int[] input, int value, int point) {
        int i = point / 2;
        if (value == input[i]) {
            return i;
        }
        else if (value < input[i]) {
            return binarySearch(input, value, point - 1);
        }
        else {
            return binarySearch(input, value, point + 1);
        }
    }

	public static void main(String[] args) {
        int[] testCase = { 1,2,3,4,5,6,7,50,55 };
        int valueToSearchFor = 3;

        int bsIndex = binarySearch(testCase, valueToSearchFor, testCase.length);
		System.out.println("The value " + valueToSearchFor + " is located at index: " + bsIndex);
	
	}
}