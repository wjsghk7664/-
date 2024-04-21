class Solution {
    fun solution(numbers: IntArray): Int {
        var answer: Int = 45
        numbers.forEach{
            answer-=it
        }
        return answer
    }
}