class Solution {
    fun solution(numbers: IntArray, target: Int): Int {
        var answer = 0
        
        val arr=numbers.mapTo(ArrayList<Int>()){it}
        
        return find(arr,target)
    }
    
    fun find(nums:ArrayList<Int>, target:Int):Int{
        var result=0
        if(nums.isEmpty()){
            if(target==0) return 1
            else return 0
        }
        val tmps=nums.clone() as ArrayList<Int>
        val tmp=tmps[0]
        tmps.removeAt(0)
        result+=find(tmps,target+tmp)+find(tmps,target-tmp)
        return result
        
    }
}