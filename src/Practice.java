import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

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
        if (nums == null) return 0;
        int sum = 0;
        for (int num : nums) {
            if (num % 2 != 0) sum += num;
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
        if (words == null) throw new NullPointerException("Words is null");
        if (words.isEmpty()) throw new IllegalArgumentException("Words is empty");

        // Create an iterator to grab the first word in the list
        Iterator<String> iterator = words.iterator();
        String shortest = iterator.next();
        // For each word in words
        while (iterator.hasNext()) {
            String word = iterator.next();
            if (word.length() < shortest.length()) shortest = word;
            else if (word.length() == shortest.length() && word.compareTo(shortest) < 0) shortest = word;
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
        if (ages == null) throw new NullPointerException("Ages is null");
        // Create a set adults
        Set<String> adults = new HashSet<>();
        // For each entry in ages,
        for (Map.Entry<String,Integer> person : ages.entrySet())
            // If entry's age is >= 18, add entry's name to set. 
            if (person.getValue() >= 18) adults.add(person.getKey());
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
        if (head == null) throw new IllegalArgumentException();
        int greatest = head.data;

        while (head.next != null) {
            head = head.next;
            if (head.data > greatest) greatest = head.data;
        }

        return greatest;
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
        Map<T,Integer> frequencyMap = new HashMap<>();

        // Move, then check
        while (head != null) {
            // If I'm correct, then this takes the given key and runs it through the provided function.
            // In this case, the function returns 1 if the value is null, otherwise it will add 1 to the value.
            // I believe this function is a "lambda", in other words, it has no name and immediately returns a value.
            frequencyMap.compute(head.data, (k,v) -> (v == null) ? 1 : v + 1 );
            head = head.next;
        }

        return frequencyMap;
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
        // // Stack to decide the next Node to process
        // Stack<BinaryTreeNode<?>> stack = new Stack<>();
        // BinaryTreeNode<?> head = root;
        // // Per leaf or double branch, subtract 1.
        // int deepestLevel = 0;
        // stack.add(head);
        
        // while (!stack.isEmpty()) {
        //     // Add one per node
        //     BinaryTreeNode<?> current = stack.pop();
        //     deepestLevel++;
            
        //     // Add any child nodes to the stack.
        //     if (current.left != null) stack.add(current.left);
        //     if (current.right != null) stack.add(current.right);
        //     // If this is a Full Node or Leaf Node, subtract 1
        //     if (current.left == null && current.right == null) deepestLevel--;
        //     if (current.left != null && current.right != null) deepestLevel--;
        // }

        // return deepestLevel;
        // I don't know the stupid algorithm
        return levelRecursive(root);
    }

    private static int levelRecursive(BinaryTreeNode<?> root) {
        if (root == null) return 0;
        return Math.max(levelRecursive(root.left),levelRecursive(root.right)) + 1;
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
        return 0;
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
        return false;
    }
}