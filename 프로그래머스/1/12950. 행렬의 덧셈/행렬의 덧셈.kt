class Solution {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
        var answer = arrayOf<IntArray>()
        for(i:Int in 0..arr1.size-1){
            var tmp=IntArray(arr1[i].size,{0})
            for(j:Int in 0..arr1[i].size-1){
                tmp[j]=arr1[i][j]+arr2[i][j]
            }
            answer+=tmp
        }
        return answer
    }
}