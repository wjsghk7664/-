class Solution {
    fun solution(k: Int, m: Int, score: IntArray): Int {
        var answer: Int = 0
        var sortScore=score.sortedArray()
        
        for(i:Int in 0..score.size/m-1){
            answer+=m*sortScore[score.size%m + m*i]
        }
        
        
        return answer
    }
    
}