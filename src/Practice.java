import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

    // check null
    int sum = 0;
    if (nums == null) {
        return 0;
    }

    for (int i = 0; i < nums.length; i++) {
        if (nums[i] % 2 != 0) {
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

        // check words
        if (words == null) throw new NullPointerException();
        if (words.isEmpty()) throw new IllegalArgumentException();

        String shortest = null;

        for (String word : words) {
            if (shortest == null) shortest = word;

            if (word.length() < shortest.length())
                shortest = word;

            if (word.length() == shortest.length()
                    && word.compareTo(shortest) < 0)
                shortest = word;
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

         // check ages
        if (ages == null) throw new NullPointerException();

        Set<String> result = new HashSet<>();

        for (String name : ages.keySet()) {
            if (ages.get(name) >= 18) {
                result.add(name);
            }
        }

        return result;
    }

    /**
     * Returns the biggest number in a linked list.
     * 
     * @param head the head of the linked list
     * @return the biggest number in the list
     * @throws IllegalArgumentException if head is null
     */
    public static int biggestNumber(ListNode<Integer> head) {

     // check list
        if (head == null) throw new IllegalArgumentException();

        int max = head.data;
        ListNode<Integer> current = head.next;

        while (current != null) {
            if (current.data > max) {
                max = current.data;
            }

            current = current.next;
        }

        return max;
    
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
           Map<T, Integer> frequency = new HashMap<>();

    // make map

        if (head == null) 
            return frequency;

        ListNode<T> current = head;

        while (current != null) {
            T data = current.data;

            if (!frequency.containsKey(data)) {
                frequency.put(data, 1);
            } else {
                frequency.put(data, frequency.get(data) + 1);
            }

            current = current.next;
        }

        return frequency;
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

        // check tree

        if (root == null) 
            return 0;

        int left = levelCount(root.left);
        int right = levelCount(root.right);

        return 1 + Math.max(left, right);
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
        
    // check level
    if (root == null) 
        return 0;

    if (level == 1) 
        return root.data;

    int sum =
     sumAtLevel(root.left, level - 1)
    + sumAtLevel(root.right, level - 1);

    return sum;
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
        
       // sum list
    int listTotal = 0;
    ListNode<Integer> current = head;

    while (current != null) {
        listTotal += current.data;
        current = current.next;
    }
    // compare sums
    return treeSum(root) == listTotal;
}

private static int treeSum(BinaryTreeNode<Integer> root) {

   // empty tree
    if (root == null) return 0;

    // add tree values
    return root.data + treeSum(root.left) + treeSum(root.right);
}

}