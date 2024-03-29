1. What are the different way of reversing a string
Using StringBuilder or StringBuffer:
	String original = "hello";
	StringBuilder reversed = new StringBuilder(original).reverse();
	String reversedString = reversed.toString();
	System.out.println(reversedString); // Output: "olleh"
Using character array:
	String original = "hello";
	char[] charArray = original.toCharArray();
	int start = 0;
	int end = original.length() - 1;
	while (start < end) {
		// Swap characters
		char temp = charArray[start];
		charArray[start] = charArray[end];
		charArray[end] = temp;
		// Move to the next pair of characters
		start++;
		end--;
	}
Using recursion:
	public static String reverseString(String str) {
		// Base case: if the input string is empty or has only one character, return the string itself
		if (str.isEmpty() || str.length() == 1) {
			return str;
		}

		// Reverse the substring starting from the second character, then append the first character at the end
		return reverseString(str.substring(1)) + str.charAt(0);
	}


	// Usage:
	String original = "hello";
	String reversedString = reverseString(original);
	System.out.println(reversedString); // Output: "olleh"
	String reversedString = new String(charArray);
	System.out.println(reversedString); // Output: "olleh"

2. Balancing parenthesis

class Solution {
    // Function to check if brackets are balanced or not.
    static boolean ispar(String x) {
        Stack<Character> stack = new Stack<>(); // Creating a stack to store opening brackets
        // Iterating through the input string
        for (int i = 0; i < x.length(); i++) {
            char c = x.charAt(i); // Getting the current character
            if (c == '{') { // If current character is an opening curly bracket
                stack.push('}'); // Push the corresponding closing curly bracket to the stack
            } else if (c == '[') { // If current character is an opening square bracket
                stack.push(']'); // Push the corresponding closing square bracket to the stack
            } else if (c == '(') { // If current character is an opening parenthesis
                stack.push(')'); // Push the corresponding closing parenthesis to the stack
            } else if (stack.isEmpty() || stack.pop() != c) { // If current character is a closing bracket
                return false; // If stack is empty or the top of stack doesn't match with current character, brackets are not balanced
            }
        }
        // If stack is empty after processing all characters, brackets are balanced
        return stack.isEmpty();
    }
}


3. Sort an array of 0s, 1s and 2s
class Solution {
    public static void sort012(int a[], int n) {
        // Initialize three pointers: low, mid, and high
        int low = 0; // Pointer for 0s
        int mid = 0; // Pointer for 1s
        int high = n - 1; // Pointer for 2s
        
        // Iterate through the array until mid pointer crosses the high pointer
        while (mid <= high) {
            if (a[mid] == 0) { // If current element is 0
                // Swap current element with element at low pointer
                int temp = a[mid];
                a[mid] = a[low];
                a[low] = temp;
                
                // Increment low and mid pointers
                low++;
                mid++;
            } else if (a[mid] == 1) { // If current element is 1
                // Just move mid pointer to the next element
                mid++;
            } else { // If current element is 2
                // Swap current element with element at high pointer
                int temp = a[mid];
                a[mid] = a[high];
                a[high] = temp;
                
                // Decrement high pointer
                high--;
            }
        }
    }
}

4. Find next greater element.

public static long[] nextLargerElement(long[] arr, int n) {
	Stack<Long> stack = new Stack<Long>(); // Creating a stack to store elements from array
	
	long[] ans = new long[n]; // Array to store the next larger element for each element in the input array
	
	// Iterating through the input array in reverse order
	for (int i = n - 1; i >= 0; i--) {
		while (!stack.isEmpty() && stack.peek() <= arr[i]) { // While stack is not empty and top element of stack is smaller than or equal to current element
			stack.pop(); // Pop elements from stack until the top element is greater than current element
		}
		if (stack.isEmpty()) { // If stack becomes empty after popping elements
			ans[i] = -1; // Set the next larger element as -1
		} else {
			ans[i] = stack.peek(); // Set the next larger element as the top element of stack
		}
		stack.push(arr[i]); // Push current element to stack for comparison with next elements
	}
	return ans; // Return the array containing next larger elements
}
==========================================================================================================================
Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
Output: [-1,3,-1]
Explanation: The next greater element for each value of nums1 is as follows:
- 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
- 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
- 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.

public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    // Create a stack to store elements from nums2
    Stack<Integer> st = new Stack<>();
    // Create a map to store the next greater element for each element in nums2
    Map<Integer, Integer> map = new HashMap<>();
    // Create an array to store the next greater elements for elements in nums1
    int[] ans = new int[nums1.length];
    
    // Iterate over nums2 in reverse order
    for(int i = nums2.length-1; i >= 0; i--) {
        // Pop elements from the stack while they are smaller than or equal to nums2[i]
        while(!st.isEmpty() && st.peek() <= nums2[i]) {
            st.pop();
        }
        // If the stack is not empty, store the next greater element for nums2[i] in the map
        if(!st.isEmpty()) {
            map.put(nums2[i], st.peek());
        }
        // Push nums2[i] onto the stack
        st.push(nums2[i]);
    }
    
    // Iterate over nums1 to find the next greater element for each element
    for(int i = 0; i < nums1.length; i++) {
        // Store the next greater element for nums1[i] in the ans array
        // If nums1[i] is not found in the map, set its next greater element as -1
        ans[i] = map.getOrDefault(nums1[i], -1);
    }
    
    // Return the ans array containing the next greater elements for elements in nums1
    return ans;
}
==========================================================================================================================
Next Greater Element II
Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.

public int[] nextGreaterElements(int[] nums) {
    // Initialize a stack to keep track of elements
    Stack<Integer> st = new Stack<>();
    int n = nums.length; // Get the length of the input array
    int[] ans = new int[n]; // Initialize an array to store the next greater elements

    // Iterate over the circular array formed by appending nums to itself
    for (int i = 2 * n - 1; i >= 0; i--) {
        // Remove all elements from the stack that are less than or equal to nums[i % n]
        while (!st.isEmpty() && st.peek() <= nums[i % n]) {
            st.pop();
        }
        // If i is less than n (i.e., we are iterating over the original array)
        if (i < n) {
            // If the stack is not empty, the next greater element is at the top of the stack
            // Otherwise, there is no next greater element, so we set it to -1
            ans[i] = !st.empty() ? st.peek() : -1;
        }
        // Push nums[i % n] onto the stack
        st.push(nums[i % n]);
    }
    return ans; // Return the array containing the next greater elements
}

5. Remove adjacent duplicates

public static int[] removeAdjacentDuplicates(int[] arr) {
    Stack<Integer> stack = new Stack<>(); // Create a stack to store unique elements
    
    // Iterate through the input array
    for (int i = 0; i < arr.length; i++) {
        if (!stack.isEmpty() && stack.peek() == arr[i]) { // If stack is not empty and top element of stack is equal to current element
            stack.pop(); // Remove the top element of stack as it is a duplicate
        } else {
            stack.push(arr[i]); // Push the current element onto the stack
        }
    }
    
    // Convert the stack to an array
    int[] result = new int[stack.size()];
    for (int i = stack.size() - 1; i >= 0; i--) {
        result[i] = stack.pop();
    }
    
    return result; // Return the array with removed adjacent duplicates
}
==========================================================================================================================
public String removeDuplicates(String s) {
	Stack<Character> st = new Stack<>();
	for(int i = 0; i < s.length(); i++) {
		if(!st.empty() && s.charAt(i) == st.peek()) {
			st.pop();
		} else {
			st.push(s.charAt(i));
		}
	}
	StringBuilder result = new StringBuilder();
	while(!st.empty()) {
		result.append(st.pop());
	}
	return result.reverse().toString();
}
	
6. Generate binary numbers 1 to n

public class GenerateBinaryNumbers {
    
    // Function to generate binary numbers from 1 to n
    public static List<String> generateBinaryNumbers(int n) {
        List<String> result = new ArrayList<>(); // List to store generated binary numbers
        Queue<String> queue = new LinkedList<>(); // Queue to store binary numbers
        
        queue.offer("1"); // Initially add "1" to the queue
        
        // Loop to generate binary numbers
        for (int i = 0; i < n; i++) {
            String binary = queue.poll(); // Retrieve the binary number from the front of the queue
            result.add(binary); // Add the binary number to the result list
            
            // Append "0" and "1" to the retrieved binary number and add them to the queue
            queue.offer(binary + "0");
            queue.offer(binary + "1");
        }
        
        return result; // Return the list of generated binary numbers
    }

    public static void main(String[] args) {
        int n = 5; // Number up to which binary numbers need to be generated
        List<String> binaryNumbers = generateBinaryNumbers(n); // Generate binary numbers
        System.out.println("Binary numbers from 1 to " + n + ": " + binaryNumbers); // Print the generated binary numbers
    }
}
==========================================================================================================================
Binary String With Substrings Representing 1 To N
Given a binary string s and a positive integer n, return true if the binary representation of all the integers in the range [1, n] are substrings of s, or false otherwise.

public boolean queryString(String s, int n) {

	String ans = "";
	Queue<String> q = new LinkedList<>();
	q.add("1");
	while(n-- > 0) {
		ans = q.remove();
		if(!s.contains(ans)) {
			return false;
		}           
		q.add(ans + "0");
		q.add(ans + "1");
	}
	return true;
	// for(int i=1;i<=n;i++){
	//     if(!s.contains(Integer.toBinaryString(i))){
	//         return false;
	//     }
	// }
	// return true;
}


7. Segregate 0s and 1s in an array

public class SegregateZerosAndOnes {
    
    // Function to segregate zeros and ones in an array
    public static void segregate(int[] nums) {
        int left = 0; // Pointer for left side of the array
        int right = nums.length - 1; // Pointer for right side of the array

        // Loop until left pointer is less than right pointer
        while (left < right) {
            // Move left pointer to the right until it points to 1
            while (nums[left] == 0 && left < right) {
                left++;
            }
            // Move right pointer to the left until it points to 0
            while (nums[right] == 1 && left < right) {
                right--;
            }
            // Swap 0s and 1s if left pointer is less than right pointer
            if (left < right) {
                nums[left] = 0;
                nums[right] = 1;
                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 1, 1, 0, 1, 0}; // Input array
        segregate(nums); // Call the segregate function
        System.out.println("Segregated array: " + Arrays.toString(nums)); // Print the segregated array
    }
}

	
8. Find the repeating number in an array of 0 to n.
use the pigeonhole principle
public class FindRepeatingNumber {
	public static int findRepeating(int[] nums) {
		int n = nums.length;
		// Calculate the sum of all elements in the array
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		// Calculate the sum of numbers from 0 to n-1
		int expectedSum = (n - 1) * n / 2;
		// The difference between the expected sum and the actual sum is the repeating number
		return sum - expectedSum;
	}

	public static void main(String[] args) {
		int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 11};
		int repeatingNumber = findRepeating(nums);
		System.out.println("Repeating number: " + repeatingNumber);
	}
}
==========================================================================================================================
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
There is only one repeated number in nums, return this repeated number.

public int findDuplicate(int[] nums) {
	int slow = 0;
	int fast = 0;
	do {
		slow  = nums[slow];
		fast = nums[nums[fast]];
	} while(slow != fast);
	slow = 0;
	while(slow != fast) {
		slow = nums[slow];
		fast = nums[fast];
	}
	return slow;
}

9. Detect any 1 local minima in the array. You can call a number local minima if it's adjacent numbers are greater than the number itself. The solution is expected is better than O(n) solution
-> To find any local minima in the array with better than O(n) complexity, you can use a binary search approach

public class LocalMinima {
    
    // Function to find any local minima in the array
    public static int findLocalMinima(int[] arr) {
        int n = arr.length;
        int low = 0; // Initialize low pointer
        int high = n - 1; // Initialize high pointer
        
        while (low <= high) {
            int mid = low + (high - low) / 2; // Calculate middle index
            
            // Check if mid is a local minima
            if ((mid == 0 || arr[mid - 1] > arr[mid]) && (mid == n - 1 || arr[mid + 1] > arr[mid])) {
                return arr[mid]; // Return the local minima value
            } 
            // If the element to the left of mid is smaller, go left
            else if (mid > 0 && arr[mid - 1] < arr[mid]) {
                high = mid - 1;
            }
            // If the element to the right of mid is smaller, go right
            else {
                low = mid + 1;
            }
        }
        
        return -1; // If no local minima is found
    }

    public static void main(String[] args) {
        int[] arr = {9, 6, 3, 7, 8, 5, 6}; // Input array
        int localMinima = findLocalMinima(arr); // Find any local minima
        if (localMinima != -1) {
            System.out.println("Local minima found: " + localMinima);
        } else {
            System.out.println("No local minima found in the array.");
        }
    }
}
==========================================================================================================================
Find Peak Element: A peak element is an element that is strictly greater than its neighbors.
Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.

public int findPeakElement(int[] nums) {
	int left = 0;
	int right = nums.length-1;
	
	while(left <= right) {
		int mid = left+(right-left)/2;
		if((mid == 0 || nums[mid-1] < nums[mid]) 
		&& (mid == nums.length-1 || nums[mid+1] < nums[mid])) {
			return mid;
		}
		if(mid > 0 && nums[mid - 1] > nums[mid]) {
			right = mid - 1; 
		} else {
			left = mid + 1;
		}
	}
	return 0;
}
	

****10. You have been given a string and signature string. Signature string can contain only characters either a or b. For example string is ballballplayball. Multiple signatures can be possible for this string: aaba a, b, ab.
You have been given a signature. You need to tell whether signature is valid or not.

public class SignatureValidator {
    public static boolean isValidSignature(String input, String signature) {
        int i = 0; // Pointer for the input string
        int j = 0; // Pointer for the signature string
        
        while (i < input.length() && j < signature.length()) {
            char inputChar = input.charAt(i);
            char signatureChar = signature.charAt(j);
            
            // If characters match, move to the next character in both strings
            if (inputChar == signatureChar) {
                i++;
                j++;
            } else {
                // If signature character is 'a' and input character doesn't match, signature is invalid
                if (signatureChar == 'a') {
                    return false;
                }
                // If signature character is 'b' and input character doesn't match, ignore this mismatch and move to the next character in the input string
                i++;
            }
        }
        
        // If we reached the end of the input string, but not the end of the signature string, signature is invalid
        return j == signature.length();
    }
    
    public static void main(String[] args) {
        String input = "ballballplayball";
        String signature = "aaba";
        System.out.println(isValidSignature(input, signature)); // Output: true
    }
}

11. Print spiral matrix.

public class Solution {
    
    // Function to return a list of integers denoting spiral traversal of matrix.
    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c) {
        ArrayList<Integer> matList = new ArrayList<Integer>(); // List to store spiral traversal
        
        // Initialize pointers for the boundaries of the matrix
        int top = 0;
        int bottom = r - 1;
        int left = 0;
        int right = c - 1;

        // Traverse the matrix in a spiral manner
        while (top <= bottom && left <= right) {
            // Traverse top row from left to right
            for (int i = left; i <= right; i++) {
                matList.add(matrix[top][i]);
            }
            top++; // Move the top boundary down

            // Traverse rightmost column from top to bottom
            for (int i = top; i <= bottom; i++) {
                matList.add(matrix[i][right]);
            }
            right--; // Move the right boundary leftwards

            // Traverse bottom row from right to left (if applicable)
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    matList.add(matrix[bottom][i]);
                }
                bottom--; // Move the bottom boundary up
            }

            // Traverse leftmost column from bottom to top (if applicable)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    matList.add(matrix[i][left]);
                }
                left++; // Move the left boundary rightwards
            }
        }
        
        return matList; // Return the spiral traversal list
    }
}


12. Two Sum

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        // Create a HashMap to store the mapping of each number to its index
        Map<Integer, Integer> map = new HashMap<>();
        
        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; // Calculate the complement needed to reach the target
            
            // If the complement is already in the map, return the indices of the two numbers
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }
            
            // Otherwise, put the current number and its index into the map
            map.put(nums[i], i);
        }
        
        // If no such pair is found, return an empty array
        return new int[] {};
    }
}


13. Buy and Sell Stock

public class Solution {
    // Function to find the days of buying and selling stock for max profit.
    public ArrayList<ArrayList<Integer>> stockBuySell(int A[], int n) {
        ArrayList<ArrayList<Integer>> segments = new ArrayList<>();
        int sell = 0;
        int buy = 0;
        
        // Iterate through the stock prices array
        for (int i = 0; i < n - 1; i++) {
            // If the next day's price is higher than the current day's price, increase the sell day
            if (A[i + 1] > A[i]) {
                sell++;
            } else {
                // If there is a potential profit (sell day is after buy day), add the segment to the list
                if (sell > buy) {
                    ArrayList<Integer> segment = new ArrayList<>();
                    segment.add(buy);
                    segment.add(sell);
                    segments.add(segment);
                }
                // Reset the buy and sell days
                buy = i + 1;
                sell = i + 1;
            }
        }
        
        // Check for the last segment if there is a potential profit
        if (sell > buy) {
            ArrayList<Integer> segment = new ArrayList<>();
            segment.add(buy);
            segment.add(sell);
            segments.add(segment);
        }
        
        return segments;
    }
}

	
14. Best Time to Buy and Sell Stock III
In comparison to the easy version where we can do only one transaction here, we can do at most two transactions. which means either one transaction or two transactions in such a way that gives maximum profit.
prices = [3,3,5,0,0,3,1,4]
First transaction: Buy on day 4 (cost price = 0) sell on day 6 (selling price = 3) profit = 3-0 = 3.
Second transaction: buy on day 7(cost price = price-profit=(1-3)=-2) sell on day 8 (price = 4) profit = 4-(-2) = 6(Net profit).

public class Tutorialcup {
    // Function to calculate the maximum profit from buying and selling stocks
    public static int maxProfit(int[] prices) {
        // Initialize variables to track the minimum price, first profit, and second profit
        int minPrice1 = Integer.MAX_VALUE;
        int profit1 = 0;
        int minPrice2 = Integer.MAX_VALUE;
        int profit2 = 0;
        
        // Iterate through the prices array
        for (int i = 0; i < prices.length; i++) {
            int p = prices[i];
            
            // Update the minimum price and first profit
            minPrice1 = Math.min(minPrice1, p);
            profit1 = Math.max(profit1, p - minPrice1);
            
            // Update the minimum price considering the first profit and update the second profit
            minPrice2 = Math.min(minPrice2, p - profit1);
            profit2 = Math.max(profit2, p - minPrice2);
        }
        
        // Return the second profit as the maximum profit
        return profit2;
    }
    
    public static void main(String[] args) {
        // Test case
        int[] arr = {1, 2, 3, 4, 5}; 
        int ans = maxProfit(arr);
        System.out.println(ans);
    }
}


15. Longest Same Character Substring

public class LongestSameCharacterSubstring {
    public static int[] findLongestSameCharacterSubstring(String str) {
        int start = 0;          // Starting index of the current substring
        int maxLength = 0;      // Length of the longest substring
        int currentLength = 1;  // Current length of the substring

        // Iterate through the string starting from the second character
        for (int i = 1; i < str.length(); i++) {
            // If the current character is the same as the previous character
            if (str.charAt(i) == str.charAt(i - 1)) {
                currentLength++;  // Increment the length of the current substring
            } else {
                // If the current substring length is longer than the previous maximum length
                if (currentLength > maxLength) {
                    maxLength = currentLength;  // Update the maximum length
                    start = i - maxLength;      // Update the starting index
                }
                currentLength = 1;  // Reset the current substring length
            }
        }

        // Check if the last substring is the longest
        if (currentLength > maxLength) {
            maxLength = currentLength;  // Update the maximum length
            start = str.length() - maxLength;  // Update the starting index
        }

        return new int[]{start, maxLength};
    }
==========================================================================================================================
Longest Substring Without Repeating Characters
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

public int lengthOfLongestSubstring(String s) {
    // Check if the input string is empty
    if(s.isEmpty()) {
        return 0; // If it's empty, there are no substrings, so return 0
    }

    // HashSet to store characters in the current substring
    HashSet<Character> hs = new HashSet<>();
    int start = 0; // Start of the current substring
    int end = 0;   // End of the current substring
    int maxLength = 1; // Maximum length of the substring without repeating characters (initialized to 1 as minimum)

    // Loop until the end pointer reaches the end of the string
    while(end < s.length()) {
        char c = s.charAt(end); // Get the character at the end pointer
        while(hs.contains(c)) {
            // If the character at the end pointer is already in the set,
            // remove characters from the start of the substring until there are no repeating characters
            hs.remove(s.charAt(start)); // Remove the character at the start pointer from the set
            start++; // Move the start pointer forward
        }
        hs.add(c); // Add the character at the end pointer to the set
        maxLength = Math.max(maxLength, end - start + 1); // Update the maximum length of the substring if necessary
        end++; // Move the end pointer forward to expand the substring
    }
    return maxLength; // Return the maximum length of the substring without repeating characters
}

16. Some string manipulation and maximum average calculation problem. In this round, all the given test cases should pass.
Input:
[{“Bob”,”87″}, {“Mike”, “35”},{“Bob”, “52”}, {“Jason”,”35″},
{“Mike”, “55”}, {“Jessica”, “99”}]
Output: 99
Given a 2-D String array of student marks, find the student with the highest average score?

public class Main {
    // Function to find the name with the maximum average score
    public static String findMaxAverage(String[][] scores) {
        // Create two HashMaps to store the sum and count of scores for each name
        Map<String, Integer> sumMap = new HashMap<>();
        Map<String, Integer> countMap = new HashMap<>();
        
        // Calculate sum and count of scores for each name
        for (String[] score : scores) {
            String name = score[0];
            int value = Integer.parseInt(score[1]);
            
            // Update sum and count maps
            sumMap.put(name, sumMap.getOrDefault(name, 0) + value);
            countMap.put(name, countMap.getOrDefault(name, 0) + 1);
        }
        
        double maxAverage = Double.MIN_VALUE;
        String maxName = "";
        
        // Calculate average and find the maximum average
        for (String name : sumMap.keySet()) {
            // Calculate average score for the current name
            double average = (double) sumMap.get(name) / countMap.get(name);
            
            // Update maxAverage and maxName if the current average is greater
            if (average > maxAverage) {
                maxAverage = average;
                maxName = name;
            }
        }
        
        // Return the name with the maximum average score
        return maxName;
    }

    public static void main(String[] args) {
        // Test scores array
        String[][] scores = {
            {"Bob", "87"}, {"Mike", "35"}, {"Bob", "52"},
            {"Jason", "35"}, {"Mike", "55"}, {"Jessica", "99"}
        };
        
        // Call the function and print the result
        System.out.println(findMaxAverage(scores));  // Output: Jessica
    }
}


17. Minimum Platforms

public class MinimumPlatforms {

    static int findMinPlatforms(int[] arrival, int[] departure) {
        // Sort the arrival and departure arrays
        Arrays.sort(arrival);
        Arrays.sort(departure);

        int platformsNeeded = 1;  // At least one platform is needed
        int result = 1;
        int i = 1, j = 0;

        // Similar to the merge step of merge sort
        while (i < arrival.length && j < departure.length) {
            // If a train arrives before the departure of the previous train,
            // increment the number of platforms needed
            if (arrival[i] <= departure[j]) {
                platformsNeeded++;
                i++;
            }
            // If a train departs before the arrival of the next train,
            // decrement the number of platforms needed
            else {
                platformsNeeded--;
                j++;
            }

            // Update the result with the maximum platforms needed
            result = Math.max(result, platformsNeeded);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arrival = {900, 940, 950, 1100, 1500, 1800};
        int[] departure = {910, 1200, 1120, 1130, 1900, 2000};

        int minPlatforms = findMinPlatforms(arrival, departure);

        System.out.println("Minimum number of platforms required: " + minPlatforms);
    }
}
	
18. Loop in linked list
class Solution {
    // Function to check if the linked list has a loop.
    public static boolean detectLoop(Node head){
        // Initialize two pointers slow and fast to the head of the linked list.
        Node slow = head;
        Node fast = head;
        
        // Iterate through the linked list until either slow or fast becomes null.
        // Also, check if fast.next is null to avoid NullPointerException.
        while(slow != null && fast != null && fast.next != null) {
            // Move slow pointer one step forward.
            slow = slow.next;
            // Move fast pointer two steps forward.
            fast = fast.next.next;
            // If slow and fast pointers meet at any point, it indicates the presence of a loop.
            if(slow == fast) {
                return true;
            }
        }
        // If the loop exits, it means there is no loop in the linked list.
        return false;
    }
}

19. Remove loop in linked list

// Function to detect and remove loop in the linked list
void detectAndRemoveLoop() {
	Node slow = head;
	Node fast = head;

	// Traverse the linked list using two pointers: slow and fast
	while (slow != null && fast != null && fast.next != null) {
		slow = slow.next; // Move slow pointer by one step
		fast = fast.next.next; // Move fast pointer by two steps

		// If slow and fast pointers meet, there is a loop
		if (slow == fast) {
			break;
		}
	}

	// If loop is detected, reset slow pointer to head
	if (slow == fast) {
		slow = head;

		// Move slow and fast pointers at same speed until they meet at the start of the loop
		while (slow.next != fast.next) {
			slow = slow.next;
			fast = fast.next;
		}

		// Now fast points to the last node of the loop
		fast.next = null; // Remove the loop by pointing the next of last node to null
	}
}


20. reverseList

Iterative:
class Solution {
    // Function to reverse a linked list.
    Node reverseList(Node head) {
        // Initialize three pointers: curr, prev, and next.
        Node curr = head;  // Current node
        Node prev = null;  // Previous node (initially null)
        Node next = null;  // Next node (temporary variable)
        
        // Iterate through the linked list until curr becomes null.
        while(curr != null) {
            // Store the next node of curr in the next variable.
            next = curr.next;
            // Reverse the link of curr node to point to the previous node (prev).
            curr.next = prev;
            // Move prev pointer to curr node.
            prev = curr;
            // Move curr pointer to the next node.
            curr = next;
        }
        
        // Update the head of the reversed linked list to be the last node (prev).
        head = prev;
        
        // Return the head of the reversed linked list.
        return head;
    }
}

Recursive:
class Solution {
    // Function to reverse a linked list recursively.
    Node reverseList(Node head) {
        // Base case: if the head is null or the list has only one node, return head.
        if (head == null || head.next == null) {
            return head;
        }
        
        // Recursive call to reverse the rest of the linked list.
        Node reversedListHead = reverseList(head.next);
        
        // Reverse the link of the current node.
        head.next.next = head;
        head.next = null;
        
        // Return the head of the reversed list.
        return reversedListHead;
    }
}

21. Reverse a Linked List in k- groups of given size

class Solution {
    // Function to reverse every k nodes of a linked list.
    public static Node reverse(Node node, int k) {
        // Base case: if the node is null or the list has fewer than k nodes, return the node.
        if (node == null || node.next == null) {
            return node;
        }
		
		int count = 0;
        ListNode temp = head;
        while(temp != null) {
            count++;
            temp = temp.next;
        }
        if(count < k) {
            return head; 
        } 
        
        // Initialize pointers for current, previous, and next nodes, and a count variable.
        Node curr = node;
        Node prev = null;
        Node next = null;
        count = 0;
        
        // Reverse the first k nodes of the list.
        while (count < k && curr != null) {
            next = curr.next;   // Save the next node.
            curr.next = prev;   // Reverse the link of the current node.
            prev = curr;        // Move prev to current node.
            curr = next;        // Move curr to next node.
            count++;            // Increment count.
        }
        
        // Recursively reverse the next k nodes and link the reversed list to the current node.
        if (next != null) {
            node.next = reverse(next, k);
        }
        
        // Return the head of the reversed k-node sublist.
        return prev;
    }
}

22. Add two numbers which are represented by the Linked List

public class AddTwoNumbersLinkedList {
    // Function to add two numbers represented by linked lists
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Create a dummy head for the result linked list
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead; // Pointer to the current node in result list
        int carry = 0; // Variable to store the carry during addition

        // Traverse both input lists until both are exhausted
        while (l1 != null || l2 != null) {
            // Extract values from each input list, or 0 if list is exhausted
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            // Calculate sum of current digits and carry
            int sum = x + y + carry;
            carry = sum / 10; // Update carry for the next addition
            current.next = new ListNode(sum % 10); // Create a new node with the least significant digit
            current = current.next; // Move current pointer to the newly created node

            // Move to the next node in both input lists if available
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // If carry is still remaining after traversing both lists, add it as a new node
        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        // Return the next node of dummyHead, which is the head of the resulting linked list
        return dummyHead.next;
    }

    // Helper method to print the linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example usage
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        // Add two numbers represented by linked lists
        ListNode result = addTwoNumbers(l1, l2);

        // Print the result
        printList(result); // Output: 7 0 8
    }
}

**23. Subtract two nos using linked list

class ListNode {
    int val;
    ListNode next;
    
    public ListNode(int val) {
        this.val = val;
    }
}

public class SubtractLinkedList {
    // Method to subtract one linked list from another
    public ListNode subtract(ListNode l1, ListNode l2) {
        // Reverse both lists to simplify subtraction
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int borrow = 0;

        // Iterate through both lists and perform subtraction
        while (l1 != null || l2 != null || borrow != 0) {
            // Get the values at the current positions in both lists
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;

            // Calculate the difference and apply borrow if necessary
            int diff = val1 - val2 - borrow;
            if (diff < 0) {
                diff += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }

            // Create a new node with the difference and add it to the result list
            current.next = new ListNode(diff);
            current = current.next;

            // Move to the next nodes in both lists
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // Reverse the result list before returning
        return reverseList(dummy.next);
    }

    // Helper method to reverse a linked list
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    // Utility method to print a linked list
    private void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Main method for testing
    public static void main(String[] args) {
        SubtractLinkedList subtractLinkedList = new SubtractLinkedList();

        // Create first linked list: 1234
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);

        // Create second linked list: 230
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(0);

        // Print original lists
        System.out.println("Original Lists:");
        subtractLinkedList.printList(l1);
        subtractLinkedList.printList(l2);

        // Subtract l2 from l1
        ListNode result = subtractLinkedList.subtract(l1, l2);

        // Print the result
        System.out.println("Result:");
        subtractLinkedList.printList(result);
    }
}


24. A linked list is given.we need to arrange the linked list in such a way that nodes having odd values will come before nodes having even values.
ex: I/P: 1->2->4->5->7->6
    O/P : 1->5->7->2->4->6
// Define a class representing a node in the linked list
class ListNode {
    int val; // Value of the node
    ListNode next; // Reference to the next node
    
    // Constructor to initialize the node with a given value
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class LinkedListOddEven {
    // Method to rearrange the linked list such that nodes with odd values appear before nodes with even values
    public ListNode rearrangeLinkedList(ListNode head) {
        // Check if the linked list is empty or has only one node
        if (head == null || head.next == null) {
            return head; // Return the head as it is
        }
        
        // Create dummy nodes for odd and even l ists
        ListNode oddDummy = new ListNode(0);
        ListNode evenDummy = new ListNode(0);
        ListNode oddTail = oddDummy; // Pointer to the tail of the odd list
        ListNode evenTail = evenDummy; // Pointer to the tail of the even list
        
        // Traverse the original list
        ListNode current = head;
        while (current != null) {
            // Check if the current node's value is odd
            if (current.val % 2 == 1) {
                // Append the current node to the odd list
                oddTail.next = current;
                oddTail = oddTail.next; // Update the tail of the odd list
            } else {
                // Append the current node to the even list
                evenTail.next = current;
                evenTail = evenTail.next; // Update the tail of the even list
            }
            current = current.next; // Move to the next node in the original list
        }
        
        // Connect the tail of the odd list to the head of the even list
        oddTail.next = evenDummy.next;
        // Set the next of the tail of the even list to null to terminate the list
        evenTail.next = null;
        
        // Return the head of the rearranged list
        return oddDummy.next;
    }
    
    // Method to print the elements of the linked list
    public void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " "); // Print the value of the current node
            current = current.next; // Move to the next node
        }
        System.out.println(); // Move to the next line after printing all elements
    }
    
    // Main method to test the implementation
    public static void main(String[] args) {
        LinkedListOddEven solution = new LinkedListOddEven();
        
        // Create the linked list: 1->2->4->5->7->6
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next = new ListNode(6);
        
        System.out.println("Input:");
        solution.printLinkedList(head);
        
        // Rearrange the linked list
        ListNode rearrangedHead = solution.rearrangeLinkedList(head);
        
        System.out.println("Output:");
        solution.printLinkedList(rearrangedHead);
    }
}

25. ZigZag Tree Traversal

// Function to perform level order traversal in a spiral form
ArrayList<Integer> findSpiral(Node root) {
	// Initialize an ArrayList to store the nodes in spiral order
	ArrayList<Integer> ans = new ArrayList<>();
	// If the root is null, return an empty ArrayList
	if(root == null) {
		return ans;
	}
	// Initialize a deque to perform level order traversal
	Deque<Node> q = new LinkedList<>();
	// Add the root node to the deque to start traversal
	q.addLast(root);
	// Initialize a boolean variable to track the direction of traversal
	boolean reverse = true;
	
	// Loop until the deque is empty
	while(!q.isEmpty()) {
		// Get the number of nodes at the current level
		int size = q.size();
		// Iterate through the nodes at the current level
		for(int i = 0; i < size; i++) {
			// If traversal direction is reverse
			if(reverse) {
				// Remove the last node from the deque
				Node temp = q.removeLast();
				// Add the node's data to the result ArrayList
				ans.add(temp.data);
				// If the removed node has a right child, add it to the front of the deque
				if(temp.right != null) {
					q.addFirst(temp.right);
				}
				// If the removed node has a left child, add it to the front of the deque
				if(temp.left != null) {
					q.addFirst(temp.left);
				}
			} 
			// If traversal direction is not reverse
			else {
				// Remove the first node from the deque
				Node temp = q.removeFirst();
				// Add the node's data to the result ArrayList
				ans.add(temp.data);
				// If the removed node has a left child, add it to the end of the deque
				if(temp.left != null) {
					q.addLast(temp.left);
				}
				// If the removed node has a right child, add it to the end of the deque
				if(temp.right != null) {
					q.addLast(temp.right);
				}
			}
		}
		// Toggle the direction of traversal for the next level
		reverse = !reverse;
	}
	// Return the result ArrayList containing nodes in spiral order
	return ans;
}

26. Given a preorder traversal of a binary tree,you have to determine whether a BST is possible for that traversal or not

boolean canRepresentBST(int pre[], int n) { 
	// Create an empty stack 
	Stack<Integer> s = new Stack<Integer>(); 

	// Initialize current root as minimum possible 
	// value 
	int root = Integer.MIN_VALUE; 

	// Traverse given array 
	for (int i = 0; i < n; i++) { 
		// If we find a node who is on right side 
		// and smaller than root, return false 
		if (pre[i] < root) { 
			return false; 
		} 

		// If pre[i] is in right subtree of stack top, 
		// Keep removing items smaller than pre[i] 
		// and make the last removed item as new 
		// root. 
		while (!s.empty() && s.peek() < pre[i]) { 
			root = s.peek(); 
			s.pop(); 
		} 

		// At this point either stack is empty or 
		// pre[i] is smaller than root, push pre[i] 
		s.push(pre[i]); 
	} 
	return true; 
}
	
27. Maximum path sum between two leaves of a binary tree
Time Complexity: O(N) where n is the number of nodes
Auxiliary Space: O(N)

// An object of Res is passed around so that the same value can be used by multiple recursive calls.
class Res {
	int val;
}

class BinaryTree {
	static Node root;

	// A utility function to find the maximum sum between any
	// two leaves.This function calculates two values:
	// 1) Maximum path sum between two leaves which is stored
	// in res.
	// 2) The maximum root to leaf path sum which is returned.
	int maxPathSumUtil(Node node, Res res) {

		// Base cases
		if (node == null)
			return 0;
		if (node.left == null && node.right == null)
			return node.data;

		// Find maximum sum in left and right subtree. Also
		// find maximum root to leaf sums in left and right
		// subtrees and store them in ls and rs
		int ls = maxPathSumUtil(node.left, res);
		int rs = maxPathSumUtil(node.right, res);

		// If both left and right children exist
		if (node.left != null && node.right != null) {

			// Update result if needed
			res.val = Math.max(res.val, ls + rs + node.data);

			// Return maximum possible value for root being
			// on one side
			return Math.max(ls, rs) + node.data;
		}

		// If any of the two children is empty, return
		// root sum for root being on one side
		return (node.left == null) ? rs + node.data : ls + node.data;
	}

	// The main function which returns sum of the maximum
	// sum path between two leaves. This function mainly
	// uses maxPathSumUtil()
	int maxPathSum() {
		Res res = new Res();
		res.val = Integer.MIN_VALUE;

		int val = maxPathSumUtil(root, res);
	
		if (root.left != null && root.right != null)
			return res.val;
		else {
			//--- for test case ---
			//		 7				 
			//	 / \			 
				// Null -3				 
			// value of res will be INT_MIN but the answer is 4, 
			// which is returned by the function maxPathSumUtil()
			return Math.max(res.val,val);
		}
	}
}

28. Find the lowest common ancestor in a tree.

public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: If the root is null or matches any of the nodes p or q, return root
        if (root == null || root == p || root == q) {
            return root;
        }

        // Recursively search for the LCA in the left and right subtrees
        TreeNode leftLCA = lowestCommonAncestor(root.left, p, q);
        TreeNode rightLCA = lowestCommonAncestor(root.right, p, q);

        // If both nodes p and q are found in different subtrees, then root is the LCA
        if (leftLCA != null && rightLCA != null) {
            return root;
        }

        // If one of the nodes is found, return it (either from left or right subtree)
        return (leftLCA != null) ? leftLCA : rightLCA;
    }

29. Given a tree, check if the tree is a Binary search tree or not

class GFG {
 
  /* A binary tree node has data, pointer to left child
        and a pointer to right child */
  static class node {
    int data;
    node left, right;
  }
 
  /* Helper function that allocates a new node with the
        given data and NULL left and right pointers. */
  static node newNode(int data)
  {
    node Node = new node();
    Node.data = data;
    Node.left = Node.right = null;
 
    return Node;
  }
 
  static int maxValue(node Node)
  {
    if (Node == null) {
      return Integer.MIN_VALUE;
    }
    int value = Node.data;
    int leftMax = maxValue(Node.left);
    int rightMax = maxValue(Node.right);
 
    return Math.max(value, Math.max(leftMax, rightMax));
  }
 
  static int minValue(node Node)
  {
    if (Node == null) {
      return Integer.MAX_VALUE;
    }
    int value = Node.data;
    int leftMax = minValue(Node.left);
    int rightMax = minValue(Node.right);
 
    return Math.min(value, Math.min(leftMax, rightMax));
  }
 
  /* Returns true if a binary tree is a binary search tree
     */
  static int isBST(node Node)
  {
    if (Node == null) {
      return 1;
    }
     
    /* false if the max of the left is > than us */
    if (Node.left != null
        && maxValue(Node.left) > Node.data) {
      return 0;
    }
     
    /* false if the min of the right is <= than us */
    if (Node.right != null
        && minValue(Node.right) < Node.data) {
      return 0;
    }
     
    /* false if, recursively, the left or right is not a
         * BST*/
    if (isBST(Node.left) != 1
        || isBST(Node.right) != 1) {
      return 0;
    }
     
    /* passing all that, it's a BST */
    return 1;
  }
 
  public static void main(String[] args)
  {
    node root = newNode(4);
    root.left = newNode(2);
    root.right = newNode(5);
     
    // root->right->left = newNode(7);
    root.left.left = newNode(1);
    root.left.right = newNode(3);
 
    // Function call
    if (isBST(root) == 1) {
      System.out.print("Is BST");
    }
    else {
      System.out.print("Not a BST");
    }
  }
}

30. Right View of Binary Tree
Time Complexity: O(N), The function does a simple traversal of the tree, so the complexity is O(n). 
Auxiliary Space: O(h), due to the stack space during recursive call. ‘h’ here is the height of the binary tree.

Method-1: Recursion Approach
//Function to return list containing elements of right view of binary tree.
ArrayList<Integer> rightView(Node root)
{
	ArrayList<Integer> rView = new ArrayList<Integer>();
	rightViewBT(root, rView, 0);
	return rView;
}

void rightViewBT(Node root, ArrayList<Integer> rView, int level) {
	if(root == null) {
		return;
	}
	if(level == rView.size()) {
		rView.add(root.data);
	}
	rightViewBT(root.right, rView, level+1);
	rightViewBT(root.left, rView, level+1);
}

Method-2: Level Order Traversal
// function to print right view of binary tree
ArrayList<Integer> printRightView(Node root)
{
	if (root == null)
		return null;

	ArrayList<Integer> rView = new ArrayList<Integer>();
	Queue<Node> queue = new LinkedList<>();
	queue.add(root);

	while (!queue.isEmpty()) {
		// number of nodes at current level
		int n = queue.size();

		// Traverse all nodes of current level
		for (int i = 1; i <= n; i++) {
			Node temp = queue.poll();

			// Print the left most element at
			// the level
			if (i == 1)
				rView.add(temp.data);

			// Add right node to queue
			if (temp.right != null)
				queue.add(temp.right);
			
			// Add left node to queue
			if (temp.left != null)
				queue.add(temp.left);
		}
	}
	return rView;
}

31. Find the difference between maximum and minimum element such that the maximum element is always at higher index than the smaller element.

public class MaxMinDifference {
    public static int maxMinDifference(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            // If the array has less than 2 elements, return 0 as there's no valid difference
            return 0;
        }
        
        int maxDiff = Integer.MIN_VALUE;
        int minElement = nums[0]; // Initialize the minimum element as the first element
        
        // Iterate through the array from index 1 to n-1
        for (int i = 1; i < n; i++) {
            // Calculate the difference between the current element and the minimum element
            int diff = nums[i] - minElement;
            
            // Update the maximum difference if the current difference is greater
            maxDiff = Math.max(maxDiff, diff);
            
            // Update the minimum element if the current element is smaller
            minElement = Math.min(minElement, nums[i]);
        }
        
        return maxDiff >= 0 ? maxDiff : 0; // Return the maximum difference (or 0 if no valid difference)
    }

    public static void main(String[] args) {
        // Example usage:
        int[] nums = {7, 1, 5, 3, 6, 4}; // Sample array
        int maxMinDiff = maxMinDifference(nums);
        System.out.println("Maximum difference: " + maxMinDiff); // Output: 5
    }
}

32. There are n cities, numbered from 1 to n, and a path is there connecting them. There is a roads path between any two cities. Need to find out if city is reachable or not.

public class CityReachability {
    // Function to check if city `destination` is reachable from city `source`
    public static boolean isReachable(int[][] paths, int source, int destination) {
        // Number of cities
        int n = paths.length;
        
        // Create a visited array to keep track of visited cities
        boolean[] visited = new boolean[n];
        
        // Create a queue for BFS traversal
        Queue<Integer> queue = new LinkedList<>();
        
        // Add the source city to the queue and mark it as visited
        queue.offer(source);
        visited[source] = true;
        
        // Perform BFS traversal
        while (!queue.isEmpty()) {
            // Remove the front city from the queue
            int currentCity = queue.poll();
            
            // Check if the current city is the destination city
            if (currentCity == destination) {
                return true; // Destination is reachable
            }
            
            // Visit all the adjacent cities of the current city
            for (int i = 0; i < n; i++) {
                if (paths[currentCity][i] == 1 && !visited[i]) {
                    // If there is a path from the current city to city `i` and `i` is not visited yet,
                    // mark `i` as visited and add it to the queue
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
        
        // Destination is not reachable
        return false;
    }

    public static void main(String[] args) {
        // Example usage:
        int[][] paths = {
            {0, 1, 1, 0}, // Connections from city 1 (0-based indexing)
            {1, 0, 0, 1}, // Connections from city 2
            {1, 0, 0, 1}, // Connections from city 3
            {0, 1, 1, 0}  // Connections from city 4
        };
        
        int source = 0; // Source city (0-based indexing)
        int destination = 3; // Destination city (0-based indexing)
        
        boolean reachable = isReachable(paths, source, destination);
        if (reachable) {
            System.out.println("Destination city is reachable from the source city.");
        } else {
            System.out.println("Destination city is not reachable from the source city.");
        }
    }
}
	

Maximum sum sub sequence
Points on a straight line
Sorting and searching
Doubly LinkedList
Longest palindromic subsequence
Fibonacci series db approach
Subset sum problem
The next question was to print a pattern.
Pattern:

               1
          1   2   1
      1  2   3   2   1
 1   2  3   4   3   2   1
 
 Count ways to reach the nth stair
 https://leetcode.com/problems/intersection-of-two-linked-lists/
 maximum product triplet
 Change a Binary Tree so that every node stores sum of all nodes in left subtree
Print characters and their frequencies in order of occurrence
K-Primes (Numbers with k prime factors) in a range
Maximum sum of lengths of non-overlapping subarrays with k as the max element.
Given an array in which each value in the array represents the steps taken from that index.Find the minimum hops to reach end of array from start of array. I gave a DP approach and he was satisfied by that. Then he gave me DUTCH NATIONAL’S FLAG PROBLEM and i gave solution to it as well Then He asked me how to find the cycle in a Linked List.I gave three approches for this problem	
Merge k sorted arrays
Theifs and warehouses problem
Count ways to reach the n’th stair
Given an array of numbers, find the maximum product triplet. 
Find shortest unique prefix to represent each word in the list.
    Input: [zebra, dog, duck, dove]
    Output: {z, dog, du, dov}
	
For Given Number N find if its COLORFUL number or not
COLORFUL number: A number can be broken into different sub-sequence parts.
Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245.
And this number is a COLORFUL number, since product of every digit of a sub-sequence are different and other questions exactly I don’t remember but one was from graphs and other two was from DP

The graph and its different representation Adjacency List, Adjacency matrix, graph representation using edges and Longest path in a directed Acyclic graph.
Then,He asked me that if I was given a undirected graph,then how will I represent it?
I said that i will represent it in two ways either using adjacency Matrix or Adjacency List.
Then ,he asked me to write code to create above graph using adjacency list .
Then,he said that we need to find shortest distance between source and a destination.
I asked whether the graph is unweighted or not?
he said graph is weighted and the weights are distinct and positive.Then i changed the representation of each node in adjacency list and
Then I said we can apply Dijkstra’s Algorithm and then he told me to implement it in any language

About Data encapsulation and Abstraction and their importance
overflow and underflow conditions in deques.