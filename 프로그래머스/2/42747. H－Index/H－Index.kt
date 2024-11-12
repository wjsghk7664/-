class Solution {
    fun solution(citations: IntArray): Int {
        citations.sortDescending()
        for(i in citations.indices){
            if(i>=citations[i]) return i
        }
        return citations.size
    }
}