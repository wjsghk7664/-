class Solution {
    fun solution(citations: IntArray): Int {
        val arr=IntArray(10001){0} //인용횟수당 편수
        for(i in citations){
            arr[i]++
        }
        var sum=0
        for(i in 10000 downTo 0){
            sum+=arr[i]
            if(sum>=i) return i
        }
        return -1
    }
}