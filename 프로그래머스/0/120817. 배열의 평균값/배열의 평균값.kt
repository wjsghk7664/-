class Solution {
    fun solution(numbers: IntArray): Double {
        var answer: Double = 0.0
        for(item in numbers){
            answer+=item
        }
        answer/=numbers.size
        return answer
    }
}