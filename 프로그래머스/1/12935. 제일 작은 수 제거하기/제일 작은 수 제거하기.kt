class Solution {
    fun solution(arr: IntArray): IntArray {
        var answer = intArrayOf()
        var min=arr[0]
        if(arr.size==1){
            answer+=-1
        }
        else{
            for(i:Int in 0..arr.size-1){
                if(arr[i]<min){
                    min=arr[i]
                }
            }
            for(i:Int in 0..arr.size-1){
                if(arr[i]!=min){
                    answer+=arr[i]
                }
            }
        }
        return answer
    }
}