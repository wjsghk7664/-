class Solution {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
        var answer = arrayOf<IntArray>()
        
        for(i in arr1.indices){
            var arr=intArrayOf()
            for(j in arr2[0].indices){
                var tmp=0
                for(k in arr1[i].indices){
                    tmp+=arr1[i][k]*arr2[k][j]
                }
                arr+=tmp
            }
            answer+=arr
        }
        return answer
    }
}