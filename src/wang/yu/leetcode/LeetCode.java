
package wang.yu.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Yu Wang
 */
public class LeetCode
{
   public LeetCode()
   {
      // TODO Auto-generated constructor stub
   }

   /**
    * https://leetcode.com/problems/keyboard-row/description/
    * 
    * @param words
    * @return
    */
   private String[] keyboardRow(String[] words)
   {
      String[] keyboards = new String[3];
      keyboards[0] = "qwertyuiop";
      keyboards[1] = "asdfghjkl";
      keyboards[2] = "zxcvbnm";
      List<String> result = new LinkedList<>();
      for (int i = 0; i < words.length; i++)
      {
         String str = words[i].toLowerCase();
         if (keyboards[0].indexOf(str.charAt(0)) >= 0)
         {
            if (checkWholeWord(str, keyboards[0]))
            {
               result.add(words[i]);
            }
         }
         else if (keyboards[1].indexOf(str.charAt(0)) >= 0)
         {
            if (checkWholeWord(str, keyboards[1]))
            {
               result.add(words[i]);
            }
         }
         else if (keyboards[2].indexOf(str.charAt(0)) >= 0)
         {
            if (checkWholeWord(str, keyboards[2]))
            {
               result.add(words[i]);
            }
         }
      }

      return result.toArray(new String[0]);
   }

   private boolean checkWholeWord(String str, String word)
   {
      boolean isValid = true;
      for (char c : str.toCharArray())
      {
         if (word.indexOf(c) < 0)
         {
            isValid = false;
         }
      }
      return isValid;
   }

   /**
    * https://leetcode.com/problems/distribute-candies/description/
    * 
    * @param candies
    * @return
    */
   private int distributeCandies(int[] candies)
   {
      Set<Integer> candySet = new TreeSet<>();
      for (int candy : candies)
      {
         candySet.add(candy);
      }
      int uniqueCandyCount = candySet.size();
      int candyCount = candies.length;
      if (uniqueCandyCount <= candyCount / 2)
      {
         return uniqueCandyCount;
      }
      return candyCount / 2;
   }

   /**
    * https://leetcode.com/problems/reshape-the-matrix/description/
    * 
    * @param nums
    * @param r
    * @param c
    * @return
    */
   private int[][] reshapeTheMatrix(int[][] nums, int r, int c)
   {
      if (nums.length * nums[0].length != r * c)
      {
         return nums;
      }
      int[][] res = new int[r][c];
      int rowCount = 0;
      int colCount = 0;
      for (int i = 0; i < nums.length; i++)
      {
         for (int j = 0; j < nums[0].length; j++)
         {
            res[rowCount][colCount] = nums[i][j];
            colCount++;
            if (colCount >= c)
            {
               rowCount++;
               colCount = 0;
            }
         }
      }
      return res;
   }

   /**
    * https://leetcode.com/problems/trim-a-binary-search-tree/description/
    * 
    * @param root
    * @param L
    * @param R
    * @return
    */
   private TreeNode trimBST(TreeNode root, int L, int R)
   {
      TreeNode res;
      if (root == null)
      {
         return null;
      }
      else if (L > root.val)
      {
         return trimBST(root.right, L, R);
      }
      else if (R < root.val)
      {
         return trimBST(root.left, L, R);
      }
      res = new TreeNode(root.val);
      res.left = trimBST(root.left, L, R);
      res.right = trimBST(root.right, L, R);
      return res;
   }

   /**
    * https://leetcode.com/problems/next-greater-element-i/description/
    * 
    * @param nums1
    * @param nums2
    * @return
    */
   private int[] nextGreaterElement(int[] nums1, int[] nums2)
   {
      HashMap<Integer, Integer> numbers = new HashMap<>();
      for (int i = 0; i < nums2.length; i++)
      {
         int counter = i;
         numbers.put(nums2[i], -1);
         while (counter < nums2.length)
         {
            if (nums2[i] < nums2[counter])
            {
               numbers.put(nums2[i], nums2[counter]);
               break;
            }
            counter++;
         }
      }
      for (int i = 0; i < nums1.length; i++)
      {
         nums1[i] = numbers.get(nums1[i]);
      }
      return nums1;
   }

   /**
    * https://leetcode.com/problems/longest-uncommon-subsequence-i/description/
    * 
    * @param a
    * @param b
    * @return
    */
   public int findLUSlength(String a, String b)
   {
      if (a.equals(b))
      {
         return -1;
      }

      return Math.max(a.length(), b.length());
   }

   /**
    * https://leetcode.com/problems/single-number/description/
    * 
    * @param nums
    * @return
    */
   public int singleNumber(int[] nums)
   {
      Set<Integer> numbers = new HashSet();
      for (int num : nums)
      {
         if (numbers.contains(num))
         {
            numbers.remove(num);
         }
         else
         {
            numbers.add(num);
         }
      }
      return numbers.iterator().next();
   }

   /**
    * https://leetcode.com/problems/jewels-and-stones/description/
    * 
    * @param J
    * @param S
    * @return
    */
   public int numJewelsInStones(String J, String S)
   {
      int count = 0;
      for (char j : J.toCharArray())
      {
         for (char s : S.toCharArray())
         {
            if (j == s)
               count++;
         }
      }

      return count;
   }
}
