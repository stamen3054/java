
package wang.yu.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sun.crypto.provider.RSACipher;
import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;

public class Array_LeetCode
{
   /**
    * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
    * 
    * @param nums
    * @return
    */
   public int removeDuplicates(int[] nums)
   {
      int loc = 2;
      for (int i = 2; i < nums.length; i++)
      {
         if (nums[i] != nums[loc - 2])
         {
            nums[loc] = nums[i];
            loc++;
         }
      }
      return loc;
   }

   /**
    * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
    * 
    * @param nums
    * @return
    */
   public int findMin(int[] nums)
   {
      for (int i = 1; i < nums.length; i++)
      {
         if (nums[i] < nums[i - 1])
            return nums[i];
      }
      return nums[0];
   }

   /**
    * https://leetcode.com/problems/container-with-most-water/
    * 
    * @param height
    * @return
    */
   public int maxArea(int[] height)
   {
      int left = 0;
      int right = height.length - 1;
      int max = Math.min(height[left], height[right]) * (right - left);
      while (left < right)
      {
         if (height[left] <= height[right])
         {
            left++;
            if (height[left] > height[left - 1])
            {
               max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            }
         }
         else
         {
            right--;
            if (height[right] > height[right + 1])
            {
               max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            }
         }
      }
      return max;
   }

   /**
    * https://leetcode.com/problems/first-missing-positive/
    * 
    * @param nums
    * @return
    */
   public int firstMissingPositive(int[] nums)
   {
      int res = 1;
      Arrays.sort(nums);
      for (int i = 0; i < nums.length; i++)
      {
         if (nums[i] > 0)
         {
            if (nums[i] == res)
               res++;
            else if (nums[i] > res)
               return res;
         }
      }
      return res;
   }

   /**
    * https://leetcode.com/problems/search-a-2d-matrix/
    * 
    * @param matrix
    * @param target
    * @return
    */
   public boolean searchMatrix(int[][] matrix, int target)
   {
      if (matrix.length == 0 || matrix[0].length == 0)
         return false;
      int row = 0;
      int colMax = matrix[0].length - 1;
      while (row < matrix.length)
      {
         if (matrix[row][colMax] < target)
         {
            row++;
         }
         else if (matrix[row][colMax] > target)
         {
            for (int col = 0; col < colMax; col++)
            {
               if (matrix[row][col] == target)
                  return true;
            }
            return false;
         }
         else
            return true;
      }
      return false;
   }

   /**
    * https://leetcode.com/problems/sort-colors/
    * 
    * @param nums
    */
   public void sortColors(int[] nums)
   {
      int index = 1;
      while (index < nums.length)
      {
         if (nums[index] < nums[index - 1])
         {
            int temp = nums[index];
            nums[index] = nums[index - 1];
            nums[index - 1] = temp;
            if (index > 1)
               index--;
         }
         else
         {
            index++;
         }
      }
   }

   public int findPairs(int[] nums, int k)
   {
      if (nums.length <= 1 || k < 0)
         return 0;
      int res = 0;
      Map<Integer, Integer> map = new HashMap<>();
      for (int i = 0; i < nums.length; i++)
      {
         map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
      }
      for (Map.Entry<Integer, Integer> entry : map.entrySet())
      {
         if (k == 0)
         {
            if (entry.getValue() > 1)
               res++;
         }
         else
         {
            if (map.containsKey(entry.getKey() + k))
               res++;
         }
      }
      return res;
   }

   /**
    * https://leetcode.com/problems/fibonacci-number/
    * 
    * @param N
    * @return
    */
   public int fib(int N)
   {
      if (N == 0)
         return 0;
      if (N == 1)
         return 1;
      return fib(N - 1) + fib(N - 2);
   }

   /**
    * https://leetcode.com/problems/sum-of-even-numbers-after-queries/
    * 
    * @param A
    * @param queries
    * @return
    */
   public int[] sumEvenAfterQueries(int[] A, int[][] queries)
   {
      int sum = 0;
      int[] res = new int[A.length];
      for (int num : A)
      {
         if (num % 2 == 0)
            sum += num;
      }
      for (int i = 0; i < A.length; i++)
      {
         int val = queries[i][0];
         int index = queries[i][1];
         if (A[index] % 2 == 0)
            sum -= A[index];
         A[index] += val;
         if (A[index] % 2 == 0)
            sum += A[index];
         res[i] = sum;
      }
      return res;
   }

   /**
    * https://leetcode.com/problems/insert-interval/
    * 
    * @param intervals
    * @param newInterval
    * @return
    */
   public List<Interval> insert(List<Interval> intervals, Interval newInterval)
   {

   }

   /**
    * https://leetcode.com/problems/target-sum/
    * 
    * @param nums
    * @param S
    * @return
    */
   public int findTargetSumWays(int[] nums, int S)
   {
      return findTargetSumWays(nums, S, 0);
   }

   private int findTargetSumWays(int[] nums, int S, int index)
   {
      int res = 0;
      if (index == nums.length - 1)
      {
         if (S == nums[index])
            res++;
         if (S == -1 * nums[index])
            res++;
      }
      else
      {
         res += findTargetSumWays(nums, S - nums[index], index + 1);
         res += findTargetSumWays(nums, S + nums[index], index + 1);
      }
      return res;
   }

   /**
    * https://leetcode.com/problems/word-search/
    * 
    * @param board
    * @param word
    * @return
    */
   public boolean exist(char[][] board, String word)
   {

   }

   /**
    * https://leetcode.com/problems/pascals-triangle/
    * 
    * @param numRows
    * @return
    */
   public List<List<Integer>> generate(int numRows)
   {
      if (numRows == 0)
         return new ArrayList<>();
      List<List<Integer>> res = new ArrayList<>();
      List<Integer> firstRow = new ArrayList<>();
      firstRow.add(1);
      List<Integer> secondRow = new ArrayList<>();
      secondRow.add(1);
      secondRow.add(1);
      res.add(firstRow);
      if (numRows == 1)
         return res;
      res.add(secondRow);
      for (int i = 1; i < numRows - 1; i++)
      {
         List<Integer> row = res.get(i);
         List<Integer> list = new ArrayList<>();
         for (int j = 0; j <= i + 1; j++)
         {
            if (j == 0 || j == i + 1)
            {
               list.add(1);
            }
            else
            {
               list.add(row.get(j) + row.get(j - 1));
            }
         }
         res.add(list);
      }
      return res;
   }

   /**
    * https://leetcode.com/problems/combination-sum-iii/
    * 
    * @param k
    * @param n
    * @return
    */
   public List<List<Integer>> combinationSum3(int k, int n)
   {
      
   }
}
