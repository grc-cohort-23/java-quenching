import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.*;

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
        if (nums == null) return 0;
        for (int num : nums) {
            if(num % 2 != 0) {
                sum += num;
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
        String best = null; 
        if(words.isEmpty()) throw new IllegalArgumentException();
        for (String word : words) {
            if(best == null) {
                best = word;

            }
            if(best.length() > word.length()) {
                best = word;
            } else if(best.length() == word.length()) {
                if(best.compareTo(word) > 0) {
                best = word;
                }
            }
            
        }
        return best;
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
        Set<String> adults = new HashSet<>();
        for(String name : ages.keySet()) {
            int age = ages.get(name);

            if(age >=18) {
                adults.add(name);
            }
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
        if (head == null) throw new IllegalArgumentException();
        ListNode<Integer> current = head;
        int biggest = head.data;
        
        while(current != null) {
            if(current.data > biggest) {
                biggest = current.data;
            }
            current = current.next;
        }
        return biggest;
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
        Map<T, Integer> frequencies = new HashMap<>();
        ListNode<T> current = head;
        if (head == null) return frequencies;
        while (current != null) {
            if(frequencies.containsKey(current.data)) {
                frequencies.put(current.data, frequencies.get(current.data) + 1);
            } else {
                frequencies.put(current.data,1 );
            }
            current = current.next;


        }
        
        return frequencies;
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
        if (root == null) {
            return 0;
        }
        int leftLevels = levelCount(root.left);;
        int rightLevels = levelCount(root.right);
        
        if (leftLevels > rightLevels) {
        return 1 + leftLevels;
        } else {
            return 1 + rightLevels;
        }
 
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
        
        if (root == null) {
            return 0;
        } 
        if (level == 1) {
            return root.data;
        }
        

        return sumAtLevel(root.left, level - 1) 
            + sumAtLevel(root.right, level - 1);
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
        
        int listSum = 0;
        
        while (head != null) {
            listSum += head.data;
            head = head.next;
        }
        int treeTotal = treeSum(root);
        return treeTotal == listSum;
    }
     private static int treeSum(BinaryTreeNode<Integer> root) {
            if (root == null) {
                return 0;
            } else {
                return root.data
                 + treeSum(root.left)
                 + treeSum(root.right);
            }
        }
}