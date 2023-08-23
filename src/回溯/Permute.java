package 回溯;

import java.util.*;

//46. 全排列
class Permute {

    /**
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     * @param nums
     * @return
     */

    //the main function of this set is storing the different index of arr for preventing the repetitive value;
    private Set<Integer> set = new HashSet();

    //this list which includs the result
    private List<List<Integer>> result = new ArrayList<>();

    //this list will store a complete result
    private List<Integer> separateResult = new ArrayList();


    public static void main(String[] args) {
        System.out.println((new Permute().permute(new int[]{1, 2, 3})));
    }
    public List<List<Integer>> permute(int[] nums) {
        // this function called "回溯" in chinese;
        pernute(nums);
        return result;
    }

    private void pernute(int[] nums) {
        if(separateResult.size() == nums.length){
            result.add(new ArrayList<>(separateResult));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(!set.contains(i)){
                set.add(i);
                separateResult.add(num);
                pernute(nums);
                set.remove(i);
                separateResult.remove(separateResult.size() - 1);
            }
        }
    }
}