import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  public List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> res = new ArrayList<>();

    if (nums == null || nums.length == 0)
      return res;
    if (target == -294967296 || target == 294967296)
      return res;

    int n = nums.length;

    Arrays.sort(nums);

    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        int target2 = target - nums[i] - nums[j];

        int front = j + 1;
        int back = n - 1;

        while (front < back) {
          int twosum = nums[front] + nums[back];

          if (twosum < target2)
            front++;
          else if (twosum > target2)
            back--;
          else {
            List<Integer> quad = new ArrayList<>();
            quad.add(nums[i]);
            quad.add(nums[j]);
            quad.add(nums[front]);
            quad.add(nums[back]);
            res.add(quad);

            while (front < back && nums[front] == quad.get(2))
              ++front;
            while (front < back && nums[back] == quad.get(3))
              --back;
          }
        }
        while (j + 1 < n && nums[j + 1] == nums[j])
          ++j;
      }
      while (i + 1 < n && nums[i + 1] == nums[i])
        ++i;
    }

    return res;
  }
}