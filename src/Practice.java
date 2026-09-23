import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Practice {
    /**
     * Returns the sum of the odd numbers in the array.
     * 
     * Returns 0 if the array is null or has no odd numbers.
     * 
     * @param nums an array of numbers
     * @return the sum of the odd numbers in the array
     */
    public static int oddSum(int[] nums) {
        int sum = 0;
        if(nums == null){
            return sum;
        }
        else
        {           
            for (int i : nums) {
                if(i%2 != 0){
                    sum += i; 
                }
            }
        }
        return sum;
    }

    /**
     * Returns the shortest word in the Set.
     * 
     * If multiple words are tied for shortest, returns the one that is smallest
     * lexicographically.
     * 
     * @param words a set of words
     * @return the shortest word in the set with a lexicographic tiebreaker
     * @throws IllegalArgumentException if words is empty
     * @throws NullPointerException if words is null
     */
    public static String shortestWord(Set<String> words) {
        String s = "";
        if(words.size() == 0){
            throw new IllegalArgumentException();
        }
        for(String st : words){
            if(s == "" ){
                s = st;
            }
            else
            {
                if(s.length() > st.length()){
                    s = st;
                }
                if (s.length() == st.length()) {
                    if (s.compareToIgnoreCase(st) > 0) {
                        s = st;
                    }
                }
            }
        }
        return s;
    }

    /**
     * Returns a set of all the names of people that are 18 years of age or older.
     * 
     * The input maps name to age in years.
     * 
     * @param ages mapping of name to age
     * @return the set of all names of people >= 18 years old
     * @throws NullPointerException if ages is null
     */
    public static Set<String> adults(Map<String, Integer> ages) {
        Set<String> answer = new HashSet<>();
        for (Map.Entry<String, Integer>  entries: ages.entrySet()) {
            if (entries.getValue() >= 18){
                answer.add((entries.getKey()));
            }
        }
        return answer;
    }

    /**
     * Returns the biggest number in a linked list.
     * 
     * @param head the head of the linked list
     * @return the biggest number in the list
     * @throws IllegalArgumentException if head is null
     */
    public static int biggestNumber(ListNode<Integer> head) {
        int curMax = Integer.MIN_VALUE;
        if(head == null){
            throw new IllegalArgumentException();
        }
        while(head != null){
            curMax = Math.max(curMax, head.data);
            head = head.next;
        }
        return curMax;
    }

    /**
     * Returns a frequency map counting how frequently items appear in a linked list.
     * 
     * Example:
     *   Input: a -> x -> a -> a -> x -> y
     *   Output: {a:3, x:2, y:1}
     * 
     * Returns an empty map if head is null
     * 
     * @param <T> the type of data held by the list
     * @param head the head of the list
     * @return a frequency map of values in the list
     */
    public static <T> Map<T, Integer> frequencies(ListNode<T> head) {

        Map<T, Integer> map = new HashMap<>();

        while(head != null){

            if(map.keySet().contains(head.data)){
                int x = map.get(head.data) + 1;
                map.put(head.data, x);
            }
            else{
                map.put(head.data, 1);
            }
            head = head.next;
        }
        return map;
    }


    /**
     * Returns the number of levels in the tree.
     * 
     * An empty tree has 0 levels, a tree with only a root has 1 level.
     * 
     * @param root the root of the tree
     * @return the number of levels in the tree
     */
    public static int levelCount(BinaryTreeNode<?> root) {

        if(root == null){
            return 0;
        }

        int leftMax = levelCount(root.left);
        int rightMax = levelCount(root.right);
        

        return 1 + Math.max(leftMax, rightMax);
    }
        /*
         *        8
         *      /   \
         *     3     10
         *    / \      \
         *   1   6      14
         */

        /*
         *   1
         *    \
         *     2
         *      \
         *       3
         *      /
         *     4
         */


    /**
     * Returns the sum at a specified level in a binary tree.
     * 
     * For example, if the given level was 3:
     *       5
     *     /   \
     *    8     4
     *   / \   / 
     *  7  9  2
     *    /
     *   1
     * 
     * Nodes at level 3: 7, 9, and 2
     * Sum of nodes at level 3: 18 
     * 
     * The root is considered to be at level 1.
     * 
     * Returns 0 if the tree is empty or if the level is not present in the tree.
     * 
     * @param root the root of the binary tree
     * @param level the level to sum
     * @return the sum of the nodes at the given level
     */
    public static int sumAtLevel(BinaryTreeNode<Integer> root, int level) {
        if(root == null){
            return 0;
        }
        
        if(level != 1 ){
            root.data = 0;
        }

        int sumL = sumAtLevel( root.left, level - 1);
        int sumR = sumAtLevel( root.right, level - 1);

        return root.data + sumL + sumR;

        /*
            if (root == null || level <= 0) {
                return 0;
            }

            if (level == 1) {
                return root.data;
            }

            int sumL = sumAtLevel(root.left, level - 1);
            int sumR = sumAtLevel(root.right, level - 1);

            return sumL + sumR;
        */
        
    }


    /**
     * Returns true if the sum of the values in a given tree is equal to the sum
     * of the values in the given list. 
     * 
     * An empty tree or list is considered to have a sum of 0.
     * 
     * @param root The root of the binary tree
     * @param head The head of the linked list
     * @return true if the sums are equal, false otherwise
     */
    public static boolean sumMatch(BinaryTreeNode<Integer> root, ListNode<Integer> head) {
        int treeSum = 0;
        int listSum = 0;

        Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
        BinaryTreeNode<Integer> current = root;

        //Stack traversal of BST - very cool
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            treeSum += current.data;

            current = current.right;
        }

        //Linked-List traversal 
        while(head != null){
            listSum += head.data;
            head = head.next;
        }

        return treeSum == listSum;
    }
}