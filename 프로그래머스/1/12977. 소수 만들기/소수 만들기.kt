class Solution {
    fun solution(nums: IntArray): Int {
        var answer = 0
        for(i:Int in 0..nums.size-3){
            for(j:Int in i+1..nums.size-2){
                for(k:Int in j+1..nums.size-1){
                    var tmp=nums[i]+nums[j]+nums[k]
                    if(prime(tmp)){
                        ++answer
                    }
                }
            }
        }
        return answer
    }
    
    fun prime(num:Int):Boolean{
        for(i:Int in 2..num-1){
            if(num%i==0){
                return false
            }
        }
        return true
    }
}