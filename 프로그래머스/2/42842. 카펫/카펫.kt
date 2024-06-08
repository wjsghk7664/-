class Solution {
    fun solution(brown: Int, yellow: Int): IntArray {
        var answer = intArrayOf()
        answer+=(brown/2 -2 +Math.sqrt(((brown/2-2)*(brown/2-2)-4*yellow).toDouble()).toInt())/2 +2
        answer+=(brown/2 -2 -Math.sqrt(((brown/2-2)*(brown/2-2)-4*yellow).toDouble()).toInt())/2 +2
        return answer
    }
}