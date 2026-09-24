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
        if(nums == null) return 0;
        
        int sum = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] %2 != 0){
                sum += nums[i];
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
        if(words == null){
            throw new NullPointerException("No Set Exists");
        }

        if(words.size() == 0){
            throw new IllegalArgumentException("No Words Exist");
        }


        String shortest = words.iterator().next();

        for(String word : words){
            if(word.length() < shortest.length() ||
              (word.length() == shortest.length() && word.compareTo(shortest) < 0)){
                shortest = word;
            }
        }
        return shortest;
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
        if(ages == null){
            throw new NullPointerException("Map doesn't exist");
        }

        Set<String> adults = new HashSet<>();

        for(Map.Entry<String,Integer> person : ages.entrySet()){
            if(person.getValue() >= 18) adults.add(person.getKey());
        }

        return adults;

    }

    /**
     * Returns the biggest number in a linked list.
     * 
     * @param head the head of the linked list
     * @return the biggest number in the list
     * @throws IllegalArgumentException if head is null
     */
    public static int biggestNumber(ListNode<Integer> head) {
        if(head == null){
            throw new IllegalArgumentException("No ListNode Exists");
        }

        int biggestNumber = head.data;
        while(head != null){
            if(head.data > biggestNumber){
                biggestNumber = head.data;
            }
            head = head.next;
        }
        return biggestNumber;
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

        Map<T,Integer> map = new HashMap<>();

        while(head != null){

            map.put(head.data, map.getOrDefault(head.data, 0)+1);
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
        if(root == null)return 0;
        
        return Math.max(levelCount(root.left), levelCount(root.right)) +1;       
    }


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

        if(root == null)return 0;

        if(level == 1){
            return root.data;
        }

        return sumAtLevel(root.left, level-1) + sumAtLevel(root.right, level-1);
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

        Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
        int treeSum = 0;

        stack.push(root);
        while(stack.size() > 0){
            BinaryTreeNode<Integer> current = stack.pop();
            if(current == null) continue;
            stack.push(current.right);
            stack.push(current.left);

            treeSum += current.data;
        }


        int listSum = 0;
        ListNode<Integer> current = head;
        while(current != null){

            listSum += current.data;
            current = current.next;
        }


        return treeSum == listSum;
    }
}