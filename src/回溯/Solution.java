package 回溯;

import java.util.ArrayList;
import java.util.List;

//78. 子集
class Subsets {

    private List<List<Integer>> result = new ArrayList<>();

    private List<Integer> currentList = new ArrayList();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums,0);
        return result;
    }

    private void dfs(int[] nums, int cur) {
        if(cur == nums.length){
            result.add(new ArrayList<>(currentList));
            return;
        }
        currentList.add(nums[cur]);
        dfs(nums,cur + 1);
        currentList.remove(currentList.size() - 1);
        dfs(nums,cur + 1);
    }
}