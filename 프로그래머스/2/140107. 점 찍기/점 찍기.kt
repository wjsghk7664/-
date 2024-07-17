class Solution {
    fun solution(k: Int, d: Int): Long {
        var answer: Long = 0
        for(x in 0L..d.toLong() step k.toLong()){
            val y= Math.sqrt((d.toLong()*d.toLong() - x*x).toDouble()).toLong()
            answer+=y/k.toLong() + 1L
        }
        return answer
    }
}