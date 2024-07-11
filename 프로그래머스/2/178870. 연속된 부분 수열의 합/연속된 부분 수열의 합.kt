class Solution {
    fun solution(sequence: IntArray, k: Int): IntArray {
        var answer: IntArray = intArrayOf()
        var end=sequence.size-1
        var start=sequence.size-1
        var sum=sequence[end]
        while(true){
            while(sum<k){
                sum+=sequence[--start]
            }
            if(sum==k) break
            sum-=sequence[end--]  
        }
        while(start>=1&&end>=1&&sequence[end-1]==sequence[end]&&sequence[start-1]==sequence[start]&&sequence[end-1]==sequence[start-1]){
            start--
            end--
        }
        answer+=start
        answer+=end
        return answer
    }
}